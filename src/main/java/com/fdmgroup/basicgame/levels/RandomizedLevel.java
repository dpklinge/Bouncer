package com.fdmgroup.basicgame.levels;

import java.awt.Color;
import java.awt.geom.Area;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.BouncyObject;
import com.fdmgroup.basicgame.displayobjects.Dimensions;
import com.fdmgroup.basicgame.displayobjects.Pillar;
import com.fdmgroup.basicgame.displayobjects.interfaces.DisplayObject;
import com.fdmgroup.basicgame.levels.environments.EnvironmentMapper;
import com.fdmgroup.basicgame.levels.environments.Environment;

@Service("RandomizedLevel")
public class RandomizedLevel extends Level {
	@Autowired
	private Dimensions window;
	@Autowired 
	private EnvironmentMapper mapper;
	private Map<Integer, DisplayObject> objects;
	private Random random = new Random();

	@Override
	public void loadLevel() {
		clearObjects();
		setPlayer(random.nextInt(window.getWindowWidth()), random.nextInt(window.getWindowHeight()), 60, 60, Color.white,
				.8, true);
		Map<String, Environment> environmentMap = mapper.getEnvironments();
		List<String> keys = new ArrayList<String>(environmentMap.keySet());
		Environment environment = environmentMap.get(keys.get(random.nextInt(environmentMap.entrySet().size())));
		environment.loadEnvironment(Game.getPlayWindow());
		objects = new HashMap<>();
		System.out.println("Loading randomized level");
		
		
		try {
			randomAdd(Pillar.class, 20, 10, 200, 50, false);
			randomAddNoOverlap(BouncyObject.class, 5, 10, 50, 20, true);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Level load failure.");
			e.printStackTrace();
		}
		System.out.println("Finished loading level");

	}

	private <T extends DisplayObject> void randomAddNoOverlap(Class<T> objectClass, int minimumNumberOfObjects,
			int variationInObjectNumber, int minimumSize, int sizeVariation, boolean squareProportions)
					throws InstantiationException, IllegalAccessException, IllegalArgumentException,
					InvocationTargetException, NoSuchMethodException, SecurityException {
		int currentObjectCount = objects.size();
		int objectNumber = random.nextInt(variationInObjectNumber) + minimumNumberOfObjects
		+ currentObjectCount;
		for (int i = currentObjectCount; i < objectNumber ; i++) {
			T object = generateObject(objectClass, minimumSize, sizeVariation, squareProportions);
			
			if (!checkOverlap(new AbstractMap.SimpleEntry<Integer, DisplayObject>(i, object))&&!overlapsWithPlayer(object)) {
				objects.put(i, object);
				activate(object);
			}else{
				i--;
			}
		}

	}

	private <T extends DisplayObject> void randomAdd(Class<T> class1, int minimumNumberOfObjects,
			int variationInObjectNumber, int minimumSize, int sizeVariation, boolean squareProportions)
					throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException {

		int currentObjectCount = objects.size();
		int objectNumber = random.nextInt(variationInObjectNumber) + minimumNumberOfObjects
				+ currentObjectCount;
		for (int i = currentObjectCount; i < objectNumber; i++) {
			T object = generateObject(class1, minimumSize, sizeVariation, squareProportions);
			
			if (!overlapsWithPlayer(object)) {
				objects.put(i, object);
				activate(object);
				
			} else {
				i--;
			}
		}

	}

	private <T extends Entry<Integer, DisplayObject>> boolean checkOverlap(T integerObjectEntry) {

		for (Entry<Integer, DisplayObject> entry : objects.entrySet()) {
			if (entry.getKey() != integerObjectEntry.getKey()) {
				Area area = new Area(integerObjectEntry.getValue().getShape());
				area.intersect(new Area(entry.getValue().getShape()));
				if (!area.isEmpty()) {
					return true;
				}

			}
		}
		return false;

	}

	private <T extends DisplayObject> T generateObject(Class<T> class1, int minimumSize, int sizeVariation,
			boolean squareProportions) throws NoSuchMethodException, SecurityException, InstantiationException,
					IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Constructor<T> constructor = class1.getConstructor(double.class, double.class, double.class, double.class);
		T object;
		if (squareProportions) {
			int size = random.nextInt(minimumSize) + sizeVariation;
			object = constructor.newInstance(random.nextInt(window.getWindowWidth()),
					random.nextInt(window.getWindowHeight()), size, size);

		} else {
			object = constructor.newInstance(random.nextInt(window.getWindowWidth()),
					random.nextInt(window.getWindowHeight()), random.nextInt(minimumSize) + sizeVariation,
					random.nextInt(minimumSize) + sizeVariation);
		}
		return object;

	}

	private boolean overlapsWithPlayer(DisplayObject object) {
		Area area = new Area(object.getShape());
		area.intersect(new Area(Game.player.getShape()));
		if (!area.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
