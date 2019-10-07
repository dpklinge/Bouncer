package com.fdmgroup.basicgame.levels;

import java.awt.Color;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.Player;
import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;

@Service
public abstract class Level {
	public abstract void loadLevel();
	private BigInteger timeElpased;
	private String levelName;
	
	
	public void setTimeElpased(BigInteger timeElpased) {
		this.timeElpased = timeElpased;
	}

	public BigInteger getTimeElpased() {
		return timeElpased;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	void clearObjects(){
		Game.renderables = new PriorityQueue<>(10, Comparator.comparingDouble(Renderable::getRenderPriority));
		Game.moveables = new CopyOnWriteArrayList<>();
		Game.collideables =new CopyOnWriteArrayList<>();
	}
	
	void activate(Object object) {
		if(object instanceof Renderable){
			Game.renderables.add((Renderable)object);
		}
		if(object instanceof Moveable){
			Game.moveables.add((Moveable)object);
		}
		if(object instanceof Collideable){
			Game.collideables.add((Collideable)object);
		}
		
	}
	void setPlayer(double x, double y, double width, double height, Color color, double acceleration, boolean isFrictionable ){
		Game.player = new Player(x, y, width, height, color, acceleration, isFrictionable);
		activate(Game.player);
		
	}
	
}
