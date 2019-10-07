package com.fdmgroup.basicgame.displayobjects;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;
@Service 
@Scope("prototype")
public class TeleportBubble implements Renderable {
	private double x;
	private double y;
	private double width = Game.player.getWidth();
	private double height = Game.player.getHeight();
	private Color color = Color.cyan;
	private double renderPriority;
	private String type = this.getClass().getName();

	public String getType() {
		return type;
	}
	
	{
		x=Game.player.getX()+Game.player.getWidth()/4;
		y= Game.player.getY()+Game.player.getHeight()/4;
		renderPriority=12;
	}
	public TeleportBubble(){
		Game.renderables.add(this);
	}
	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x=x;

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
		return  new Ellipse2D.Double(x,y, width, height);
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
	

}
