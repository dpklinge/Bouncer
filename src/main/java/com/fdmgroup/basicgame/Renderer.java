package com.fdmgroup.basicgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.Dimensions;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Renderable;
import com.fdmgroup.basicgame.inputeffects.KeyInput;
import com.fdmgroup.basicgame.physics.Forces;

@Service
public class Renderer extends JPanel {
	@Autowired 
	private Dimensions window;
	@Autowired
	private KeyInput input;
	private Image bgImage;
	public Renderer() {
		System.out.println("Initializing renderer");
		this.setBackground(Color.BLACK);
	}
	
	public Image getBgImage() {
		return bgImage;
	}

	public void setBgImage(Image bgImage) {
		this.bgImage = bgImage;
	}



	private static final long serialVersionUID = -2446614842520294459L;

	private void doDrawing(Graphics g) {
		if(bgImage!=null){
			g.drawImage(bgImage, 0, 0, window.getWindowWidth(),window.getWindowHeight()-60, null);
		}	
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.WHITE);
		g2d.drawString("keysPressed = "+ input.getKeyPress().toString(), 500, 20);
		g2d.drawString("Press space to drop an explosive egg!", 500, 40);
		g2d.drawString("Hold space to charge a bigger egg.", 500, 60);
		if(Forces.getIsFrictionIsEnabled()){
			g2d.setPaint(Color.green);
			g2d.drawString("Friction=on", 1000, 20);
		}else{
			g2d.setPaint(Color.red);
			g2d.drawString("Friction=off", 1000, 20);
		}
		if(Forces.isGravityIsEnabled()){
			g2d.setPaint(Color.green);
			g2d.drawString("Gravity=on", 1000, 40);
		}else{
			g2d.setPaint(Color.red);
			g2d.drawString("Gravity=off", 1000, 40);
		}
		
		for (Renderable renderable : Game.renderables) {
			g2d.setPaint(renderable.getColor());
//			g2d.drawString("X = " + renderable.getX() + ", Y = " + renderable.getY() , (int)renderable.getX(), (int)renderable.getY() - 50);
			if (renderable instanceof Moveable) {
//				g2d.drawString("X speed = " + ((Moveable) renderable).getXVelocity() + ", Y speed = "
//						+ ((Moveable) renderable).getYVelocity(), (int)renderable.getX(), (int)renderable.getY() - 100);
			}
			g2d.setPaint(renderable.getColor());
			g2d.fill(renderable.getShape());
		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}

}
