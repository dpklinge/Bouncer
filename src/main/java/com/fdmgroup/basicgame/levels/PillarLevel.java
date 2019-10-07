package com.fdmgroup.basicgame.levels;

import java.awt.Color;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.BouncyObject;
import com.fdmgroup.basicgame.displayobjects.Pillar;

@Service
public class PillarLevel extends Level {

	@Override
	public void loadLevel() {
		clearObjects();
		System.out.println("Loading pillarLevel");
		setPlayer(500, 50, 100, 100, Color.white, .5, true);
		Pillar pillar = new Pillar(100, 150, 100,100);
		activate(pillar);
		Pillar pillar2 = new Pillar(300, 350, 100,100);
		activate(pillar2);
		Pillar pillar3 = new Pillar(500, 550, 100,100);
		activate(pillar3);
		Pillar pillar4 = new Pillar(700, 650, 100,100);
		activate(pillar4);
		Pillar pillar5 = new Pillar(900, 750, 100,100);
		activate(pillar5);
		Pillar pillar6 = new Pillar(1100, 650, 100,100);
		activate(pillar6);
		Pillar pillar7 = new Pillar(1300, 550, 100,100);
		activate(pillar7);
		Pillar pillar8 = new Pillar(1500, 350, 100,100);
		activate(pillar8);
		Pillar pillar9 = new Pillar(200, 250, 100,100);
		activate(pillar9);
		Pillar pillar10 = new Pillar(400, 450, 100,100);
		activate(pillar10);
		Pillar pillar11 = new Pillar(600, 600, 100,100);
		activate(pillar11);
		Pillar pillar12 = new Pillar(800, 700, 100,100);
		activate(pillar12);
		Pillar pillar13 = new Pillar(1000, 700, 100,100);
		activate(pillar13);
		Pillar pillar14 = new Pillar(1200, 650, 100,100);
		activate(pillar14);
		Pillar pillar15 = new Pillar(1400, 450, 100,100);
		activate(pillar15);
		Pillar pillar16 = new Pillar(1600, 250, 100,100);
		activate(pillar16);
		BouncyObject bouncy1 = new BouncyObject(400, 150, 30, 30);
		activate(bouncy1);
		BouncyObject bouncy2 = new BouncyObject(500, 150, 30, 30);
		activate(bouncy2);
		BouncyObject bouncy3 = new BouncyObject(600, 150, 30, 30);
		activate(bouncy3);
		BouncyObject bouncy4 = new BouncyObject(700, 150, 30, 30);
		activate(bouncy4);
		BouncyObject bouncy5 = new BouncyObject(800, 150, 30, 30);
		activate(bouncy5);
	}

}
