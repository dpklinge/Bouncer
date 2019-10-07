package com.fdmgroup.basicgame.displayobjects.interfaces;

import java.awt.Color;

public interface Renderable extends DisplayObject {
	public Color getColor();

	public void setColor(Color color);

	public double getRenderPriority();

	public boolean equals(Object object);

}
