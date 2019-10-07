package com.fdmgroup.basicgame.displayobjects;

import java.awt.Color;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;
import com.fdmgroup.basicgame.physics.CollisionType;
@Service 
@Scope("prototype")
public class BouncyObject implements Collideable, Renderable, Moveable {
	private double x;
	private double y;
	private double width;
	private double height;
	private double xVelocity = 0;
	private double yVelocity = 0;
	private boolean isFrictionable = true;
	private Color color = Color.magenta;
	private double renderPriority = 9;
	private CollisionType collisionType = CollisionType.MOBILE;
	private String type = this.getClass().getName();

	public String getType() {
		return type;
	}



	public BouncyObject() {
		super();
	}



	public BouncyObject(double x, double y, double width, double height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public double getXVelocity() {
		return xVelocity;
	}

	@Override
	public void setXVelocity(double velocity) {
		this.xVelocity = velocity;

	}

	@Override
	public double getYVelocity() {
		return yVelocity;
	}

	@Override
	public void setYVelocity(double velocity) {
		this.yVelocity = velocity;
	}

	@Override
	public boolean isFrictionable() {
		return isFrictionable;
	}

	@Override
	public void setFrictionable(boolean frictionable) {
		isFrictionable = frictionable;

	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;

	}

	@Override
	public double getRenderPriority() {
		return renderPriority;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public Shape getShape() {
		return new Ellipse2D.Double(x, y, width, height);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public CollisionType getCollisionType() {
		return collisionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collisionType == null) ? 0 : collisionType.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (isFrictionable ? 1231 : 1237);
		temp = Double.doubleToLongBits(renderPriority);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(xVelocity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yVelocity);
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
		BouncyObject other = (BouncyObject) obj;
		if (collisionType != other.collisionType)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (isFrictionable != other.isFrictionable)
			return false;
		if (Double.doubleToLongBits(renderPriority) != Double.doubleToLongBits(other.renderPriority))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(xVelocity) != Double.doubleToLongBits(other.xVelocity))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(yVelocity) != Double.doubleToLongBits(other.yVelocity))
			return false;
		return true;
	}

}
