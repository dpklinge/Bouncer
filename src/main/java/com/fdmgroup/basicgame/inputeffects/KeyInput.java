package com.fdmgroup.basicgame.inputeffects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SpringAppConfig;
import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.physics.Forces;
@Service

public class KeyInput implements KeyListener {
	private Set<Integer> keyPress = new HashSet<>();
	
	
	@Autowired
	private EggController controller;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	public KeyInput(){
		System.out.println("Initializing KeyInput");
	}
	public Set<Integer> getKeyPress() {
		return keyPress;
	}

	public void setKeyPress(Set<Integer> keyPress) {
		this.keyPress = keyPress;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Keypressed event");
		if (e.getKeyCode() == KeyEvent.VK_SPACE && !keyPress.contains(KeyEvent.VK_SPACE)) {
			controller.eggSizeTimer(this);
		}
		keyPress.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyPress.remove(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			controller.layEgg();
		} else if (e.getKeyCode() == KeyEvent.VK_T) {
			Teleport teleport = SpringAppConfig.getContext().getBean(Teleport.class);
			teleport.teleport(Game.player);
		} else if (e.getKeyCode() == KeyEvent.VK_G) {
			if (Forces.isGravityIsEnabled()) {
				Forces.setGravityIsEnabled(false);
			} else {
				Forces.setGravityIsEnabled(true);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			if (Forces.getIsFrictionIsEnabled()) {
				Forces.setFrictionIsEnabled(false);
			} else {
				Forces.setFrictionIsEnabled(true);
			}
		}else if (e.getKeyCode() == KeyEvent.VK_F5) {
			System.out.println("Attempting to load level");
			SpringAppConfig.getContext().getBean(Game.class).getCurrentLevel().loadLevel();
		}

	}

	@Override
	public String toString() {
		return "KeyInput [keyPress=" + keyPress + ", controller=" + controller + "]";
	}
	
	
	
	

}