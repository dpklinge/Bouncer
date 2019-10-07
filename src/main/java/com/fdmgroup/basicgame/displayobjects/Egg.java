package com.fdmgroup.basicgame.displayobjects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;

@Service
@Scope("prototype")
public class Egg implements Renderable, Collideable{
	public static double eggSize;
	private Shape shape;
	private double x;
	private double y;
	private double width;
	private double height;
	private Color color = Color.BLUE;
	private double renderPriority;
	private static Queue<Egg> eggCount = new LinkedList<>();
	private String type = this.getClass().getName();

	public String getType() {
		return type;
	}


	public Egg(){
		
		eggCount.add(this);
		Game.renderables.add(this);
		width = eggSize;
		height = eggSize;
		x=Game.player.getX()+Game.player.getWidth()/2-eggSize/2;
		y= Game.player.getY()+Game.player.getHeight()/2-eggSize/2;

		renderPriority=2;

	}
	
	
	public void setWidth(double width) {
		this.width = width;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public Shape getShape() {
		return new Ellipse2D.Double(x,y, width, height);
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public static Queue<Egg> getCount(){
		return eggCount;
		
	}
	@Override
	public double getRenderPriority() {
		return renderPriority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(renderPriority);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Egg other = (Egg) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(renderPriority) != Double.doubleToLongBits(other.renderPriority))
			return false;
		if (shape == null) {
			if (other.shape != null)
				return false;
		} else if (!shape.equals(other.shape))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	
	
	
}
