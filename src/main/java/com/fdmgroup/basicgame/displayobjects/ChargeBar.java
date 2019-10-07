package com.fdmgroup.basicgame.displayobjects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;
@Service 

public class ChargeBar implements Renderable{
	
	private double x;
	private double y;
	private double width =10;
	private double height = 10;
	private Color color = Color.YELLOW;
	private double renderPriority=9;
	private String type = this.getClass().getName();

	public String getType() {
		return type;
	}
	
	@Autowired
	public ChargeBar(Dimensions window){
		x=0;
		y=(double) (window.getWindowHeight()-5);
		synchronized(Game.renderables){
		Game.renderables.add(this);
		}
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	@Override
	public double getX() {
		
		return x;
	}

	@Override
	public void setX(double x) {
		
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y=y;
		
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x,y,width, height);
	}


	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color=color;
		
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
		ChargeBar other = (ChargeBar) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(renderPriority) != Double.doubleToLongBits(other.renderPriority))
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
