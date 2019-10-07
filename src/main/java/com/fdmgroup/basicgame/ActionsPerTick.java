package com.fdmgroup.basicgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.Dimensions;
import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;
import com.fdmgroup.basicgame.inputeffects.KeyInput;
import com.fdmgroup.basicgame.physics.Collision;
import com.fdmgroup.basicgame.physics.CollisionType;
import com.fdmgroup.basicgame.physics.Forces;

@Service
public class ActionsPerTick implements ActionListener {
	@Autowired
	private Dimensions dimensions;
	@Autowired
	private KeyInput input;
	private final static int gameTickMilliseconds = 15;
	private Timer timer;
	private Renderer renderer;
	@Autowired
	public ActionsPerTick(Renderer renderer) {
		this.renderer = renderer;
		System.out.println("Initializing ActionsPerTick");
		initTimer();
	}
	public Renderer getRenderer(){
		return renderer;
	}

	private void initTimer() {

		timer = new Timer(gameTickMilliseconds, this);
		timer.start();
	}

	public Timer getTimer() {

		return timer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (input.getKeyPress().contains(KeyEvent.VK_W)) {
			Game.player.setYVelocity(Game.player.getYVelocity() - Game.player.getAcceleration());
		}

		if (input.getKeyPress().contains(KeyEvent.VK_S)) {
			Game.player.setYVelocity(Game.player.getYVelocity() + Game.player.getAcceleration());
		}

		if (input.getKeyPress().contains(KeyEvent.VK_D)) {
			Game.player.setXVelocity(Game.player.getXVelocity() + Game.player.getAcceleration());
		}

		if (input.getKeyPress().contains(KeyEvent.VK_A)) {
			Game.player.setXVelocity(Game.player.getXVelocity() - Game.player.getAcceleration());
		}

		for (Moveable moveable : Game.moveables) {
			applyForces(moveable);

			moveable.setX((moveable.getX() + moveable.getXVelocity()));
			if (moveable.getX() < 0 || moveable.getX() > dimensions.getWindowWidth() - moveable.getWidth()) {
				if(moveable.getXVelocity()!=0){
				moveable.setX((moveable.getX() - (moveable.getXVelocity() * 2)));
				moveable.setXVelocity(-moveable.getXVelocity());
				}else{
					if(moveable.getX()<0){
						moveable.setX(0);
					}else{
						moveable.setX(dimensions.getWindowWidth() - moveable.getWidth());
					}
				}
			}

			moveable.setY((moveable.getY() + moveable.getYVelocity()));
			if (moveable.getY() < 0 || moveable.getY() > dimensions.getWindowHeight() - moveable.getHeight()) {
				if(moveable.getYVelocity()!=0){
				moveable.setY((moveable.getY() - (moveable.getYVelocity() * 2)));
				moveable.setYVelocity(-moveable.getYVelocity());
				}else{
					if(moveable.getY()<0){
						moveable.setY(0);
					}else{
						moveable.setY(dimensions.getWindowHeight() - moveable.getHeight());
					}
				}
			}

			for (Collideable collideable : Game.collideables) {
				if (collideable != moveable) {
					if (moveable.getShape().intersects(collideable.getShape().getBounds2D())&&(moveable.getXVelocity()!=0||moveable.getYVelocity()!=0)) {
						moveable.setY((moveable.getY() - moveable.getYVelocity()));
						moveable.setX((moveable.getX() - moveable.getXVelocity()));
						if ((collideable instanceof Moveable)) {
							if (((Moveable) collideable).getCollisionType() == CollisionType.MOBILE) {
								Collision.collide(moveable, (Moveable) collideable);
							}
						} else {
							Collision.collideWithStatic(moveable, collideable);
						}
					}
				}

			}

		}

		renderer.repaint();

	}

	private void applyForces(Moveable moveable) {

		if (Forces.getIsFrictionIsEnabled() && moveable.isFrictionable()) {
			double xFriction = Forces.getFriction() * Math.abs(
					moveable.getXVelocity() / (Math.abs(moveable.getXVelocity()) + Math.abs(moveable.getYVelocity())));
			double yFriction = Forces.getFriction() * Math.abs(
					moveable.getYVelocity() / (Math.abs(moveable.getYVelocity()) + Math.abs(moveable.getXVelocity())));
			if (!Forces.isGravityIsEnabled() || moveable.getY() > dimensions.getWindowHeight() - moveable.getHeight() - 5) {
				if (moveable.getXVelocity() >= xFriction) {
					moveable.setXVelocity(moveable.getXVelocity() - xFriction);
				} else if (moveable.getXVelocity() <= -xFriction) {
					moveable.setXVelocity(moveable.getXVelocity() + xFriction);
				} else {
					moveable.setXVelocity(0);
				}
			}
			if (moveable.getYVelocity() >= yFriction) {
				moveable.setYVelocity(moveable.getYVelocity() - yFriction);
			} else if (moveable.getYVelocity() <= -yFriction) {
				moveable.setYVelocity(moveable.getYVelocity() + yFriction);
			} else {
				moveable.setYVelocity(0);
			}
			if(moveable.getXVelocity()>Forces.getMaxSpeed()){
				moveable.setXVelocity(Forces.getMaxSpeed());
			}else if(moveable.getXVelocity()<-Forces.getMaxSpeed()){
				moveable.setXVelocity(-Forces.getMaxSpeed());
			}
			if(moveable.getYVelocity()>Forces.getMaxSpeed()){
				moveable.setYVelocity(Forces.getMaxSpeed());
			}else if(moveable.getYVelocity()<-Forces.getMaxSpeed()){
				moveable.setYVelocity(-Forces.getMaxSpeed());
			}
		}

		if (Forces.gravityIsEnabled()) {
			// TODO remove jiggling on non bottom floor-surfaces
			if (moveable.getY() < dimensions.getWindowHeight() - moveable.getHeight() - 1) {
				moveable.setYVelocity(moveable.getYVelocity() + Forces.getGravity());
			}
		}

	}


}
