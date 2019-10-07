package com.fdmgroup.basicgame.levels.environments;

import java.awt.Color;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.PlayWindow;

@Service
public abstract class Environment {
	public abstract Color getColor();
	public abstract void loadEnvironment(PlayWindow window);
	
	
	
}
