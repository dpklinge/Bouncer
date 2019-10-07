package com.fdmgroup.basicgame;

import java.awt.EventQueue;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.Player;
import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;
import com.fdmgroup.basicgame.fileprocessing.LevelReader;
import com.fdmgroup.basicgame.inputeffects.KeyInput;
import com.fdmgroup.basicgame.levels.Level;

@Service
@Lazy
public class Game {
	public static Queue<Renderable> renderables = new PriorityQueue<>(10, Comparator.comparingDouble(Renderable::getRenderPriority));
	public static List<Moveable> moveables = new CopyOnWriteArrayList<>();
	public static List<Collideable> collideables =new CopyOnWriteArrayList<>();
	private static PlayWindow space;
	
	@Autowired
	public static Player player;
	
	@Autowired
	private LevelReader reader;
	
	@Autowired
	private KeyInput input;
	
	private Level currentLevel;
	
	@Autowired
	public Game(PlayWindow window){
		space=window;
	}
	
	public static PlayWindow getPlayWindow(){
		return space;
	}
	
	public void startGame() {
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	space.initUI(input);
            	space.setExtendedState(JFrame.MAXIMIZED_BOTH);
                space.setVisible(true);
                switchCurrentLevel(reader.readLevel("RandomizedLevel"));
                
            }
        });
		
	}
	
	public Level getCurrentLevel(){
		return currentLevel;
	}
	public void switchCurrentLevel(Level targetLevel){
		System.out.println("Switching to level: "+targetLevel);
		currentLevel=targetLevel;
		currentLevel.loadLevel();
	}


}
