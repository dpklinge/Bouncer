package com.fdmgroup.basicgame.displayobjects;

import java.awt.Color;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;
import com.fdmgroup.basicgame.physics.CollisionType;

@Service
public class Player implements Renderable, Moveable, Collideable {
	private double x;
	private double y;
	private double direction;
	private double width;
	private double height;
	private Color color;
	private double xVelocity;
	private double yVelocity;
	private double acceleration;
	private boolean frictionable;
	private double renderPriority;
	private CollisionType collisionType = CollisionType.MOBILE;
	private String type = this.getClass().getName();

	public String getType() {
		return type;
	}
	
	{
	
		direction =180;
		xVelocity = 0;
		yVelocity = 0;
		acceleration = .8;
		frictionable = true;
		color=Color.WHITE;
		renderPriority=10;
	}
	public Player(){
		
	}
	
	
	public Player(double x, double y, double width, double height, Color color, double acceleration,
			boolean frictionable) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.acceleration = acceleration;
		this.frictionable = frictionable;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public double getXVelocity() {
		return xVelocity;
	}

	public void setXVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getYVelocity() {
		return yVelocity;
	}

	public void setYVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	public Color getColor() {
		Random random = new Random();
		return Color.getHSBColor(random.nextFloat()/18+.50f,random.nextFloat()/4+.5f,random.nextFloat()/1.5f);
	}

	public void setColor(Color color) {
		this.color = color;
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

	public Shape getShape() {
		return new Ellipse2D.Double(x, y, width, height);
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
	public double getDirection() {
		return direction;
	}
	public void setDirection(double direction) {
		this.direction = direction;
	}
	

	@Override
	public boolean isFrictionable() {
		return frictionable;
	}

	@Override
	public void setFrictionable(boolean frictionable) {
		this.frictionable = frictionable;
		
	}

	@Override
	public double getRenderPriority() {
		return renderPriority;		
	}

	@Override
	public CollisionType getCollisionType() {
		return collisionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(acceleration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((collisionType == null) ? 0 : collisionType.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		temp = Double.doubleToLongBits(direction);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (frictionable ? 1231 : 1237);
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Player other = (Player) obj;
		if (Double.doubleToLongBits(acceleration) != Double.doubleToLongBits(other.acceleration))
			return false;
		if (collisionType != other.collisionType)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(direction) != Double.doubleToLongBits(other.direction))
			return false;
		if (frictionable != other.frictionable)
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
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
