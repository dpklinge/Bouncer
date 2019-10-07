package com.fdmgroup.basicgame.displayobjects.interfaces;

import java.awt.Shape;

public interface DisplayObject {
	public String getType();

	public void setX(double x);

	public double getX();

	public void setY(double y);

	public double getY();

	public Shape getShape();
}
