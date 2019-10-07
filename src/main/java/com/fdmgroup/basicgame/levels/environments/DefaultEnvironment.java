package com.fdmgroup.basicgame.levels.environments;

import java.awt.Color;
import java.awt.Toolkit;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.PlayWindow;
import com.fdmgroup.basicgame.physics.Forces;
@Service
public class DefaultEnvironment extends Environment {
	@Override
	public void loadEnvironment(PlayWindow window) {
		window.getActionController().getRenderer().setBackground(getColor());
		window.getActionController().getRenderer().setBgImage(Toolkit.getDefaultToolkit().createImage("src/main/resources/circuits.jpg"));
		Forces.setFriction(0.1);
		Forces.setGravity(0.3);
		Forces.setMaxSpeed(5);
		Game.player.setAcceleration(.6);

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLACK;
	}

}
