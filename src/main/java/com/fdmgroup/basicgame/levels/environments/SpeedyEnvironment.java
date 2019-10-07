package com.fdmgroup.basicgame.levels.environments;

import java.awt.Color;
import java.awt.Toolkit;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.PlayWindow;
import com.fdmgroup.basicgame.physics.Forces;

@Service
public class SpeedyEnvironment extends Environment {
	@Override
	public void loadEnvironment(PlayWindow window) {
		System.out.println("Is window null in speedyenvironment "+(window==null));
		window.getActionController().getRenderer().setBackground(getColor());
		window.getActionController().getRenderer().setBgImage(Toolkit.getDefaultToolkit().createImage("src/main/resources/sun.jpg"));
	
		Forces.setFriction(0.05);
		Forces.setGravity(.5);
		Forces.setMaxSpeed(10);
		Game.player.setAcceleration(1.0);


	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.getHSBColor(.072f,.95f,.66f);
	}

}
