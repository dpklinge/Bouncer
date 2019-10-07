package com.fdmgroup.basicgame.levels.environments;

import java.awt.Color;
import java.awt.Toolkit;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.PlayWindow;
import com.fdmgroup.basicgame.physics.Forces;

@Service
public class ForestEnvironment extends Environment {
	@Override
	public void loadEnvironment(PlayWindow window) {
		window.getActionController().getRenderer().setBackground(getColor());
		window.getActionController().getRenderer().setBgImage(Toolkit.getDefaultToolkit().createImage("src/main/resources/landscape.png"));
	
		Forces.setFriction(.4);
		Forces.setGravity(1.0);
		Forces.setMaxSpeed(10);
		Game.player.setAcceleration(.1);

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.getHSBColor(.413f,.95f,.40f);
	}

}
