package com.fdmgroup.basicgame.displayobjects;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.springframework.stereotype.Component;
@Component
public class Dimensions {
	private int windowWidth;
	private int windowHeight;
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		windowWidth=(int) screenSize.getWidth();
		windowHeight=(int) screenSize.getHeight();
	}
	public int getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}
	public int getWindowHeight() {
		return windowHeight;
	}
	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}
	
	

}
