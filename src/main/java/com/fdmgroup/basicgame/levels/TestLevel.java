package com.fdmgroup.basicgame.levels;

import java.awt.Color;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.BouncyObject;
import com.fdmgroup.basicgame.displayobjects.Pillar;

@Service
public class TestLevel extends Level {

	@Override
	public void loadLevel() {
		System.out.println("Loading testLevel");
		clearObjects();
		setPlayer(500,500,60,60,Color.white,.8,true);
		Pillar pillar= new Pillar(700,700,200,200);
		activate(pillar);
		BouncyObject bouncy = new BouncyObject(1000,500,70,70);
		activate(bouncy);
		BouncyObject bouncy2 = new BouncyObject(1000,100,50,50);
		activate(bouncy2);
		BouncyObject bouncy3 = new BouncyObject(100,500,100,100);
		activate(bouncy3);
		BouncyObject bouncyBig = new BouncyObject(100,100,200,200);
		activate(bouncyBig);

	}
	

}
