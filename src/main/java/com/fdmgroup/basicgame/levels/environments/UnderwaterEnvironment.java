package com.fdmgroup.basicgame.levels.environments;

import java.awt.Color;
import java.awt.Toolkit;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.PlayWindow;
import com.fdmgroup.basicgame.physics.Forces;
@Service
public class UnderwaterEnvironment extends Environment {
	@Override
	public void loadEnvironment(PlayWindow window) {
		window.getActionController().getRenderer().setBackground(getColor());
		window.getActionController().getRenderer().setBgImage(Toolkit.getDefaultToolkit().createImage("src/main/resources/water.jpg"));
		Forces.setFriction(0.3);
		Forces.setGravity(0.2);
		Forces.setMaxSpeed(1);
		Game.player.setAcceleration(0.35);
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}

}
