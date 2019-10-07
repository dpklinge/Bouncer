package com.fdmgroup.basicgame.displayobjects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;

@Service 
@Scope("prototype")
public class Pillar implements Collideable, Renderable {
	private double x;
	private double y;
	private double width;
	private double height;
	private String type = this.getClass().getName();

	public String getType() {
		return type;
	}
	
	
	public Pillar(double x, double y, double width, double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

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
	public Color getColor() {
	
		return Color.GREEN;
	}

	@Override
	public void setColor(Color color) {
		

	}

	@Override
	public double getRenderPriority() {
		
		return 1;
	}

	@Override
	public void setX(double x) {
		this.x=x;

	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setY(double y) {
		this.y=y;

	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public Shape getShape() {
		
		return new Ellipse2D.Double(x,y, width,height);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
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
		Pillar other = (Pillar) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
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
