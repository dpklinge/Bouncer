package com.fdmgroup.basicgame.displayobjects.interfaces;

import com.fdmgroup.basicgame.physics.CollisionType;

public interface Moveable extends Collideable, DisplayObject {
	public CollisionType getCollisionType();

	public double getXVelocity();

	public void setXVelocity(double velocity);

	public double getYVelocity();

	public void setYVelocity(double velocity);

	public boolean isFrictionable();

	public void setFrictionable(boolean frictionable);

	public boolean equals(Object object);

}
