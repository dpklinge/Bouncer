package com.fdmgroup.basicgame.inputeffects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SpringAppConfig;
import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.ChargeBar;
import com.fdmgroup.basicgame.displayobjects.Egg;

@Service
public class EggController {
	@Autowired
	private  ChargeBar chargeBar;

	public  void eggSizeTimer(KeyInput inputs) {
		Set<Integer> input =  inputs.getKeyPress();
		Egg.eggSize = 10;
		Timer eggSizeTimer = new Timer();
		TimerTask task = new TimerTask() {
			private int time = 0;

			public void run() {
				time++;
				if (input.contains(KeyEvent.VK_SPACE)) {
					if (Egg.eggSize < Game.player.getWidth()*1.5 ) {
						chargeBar.setWidth(10 + 20 * time);
						Egg.eggSize += 1;
					} else if (Egg.eggSize >= Game.player.getWidth()*1.5) {
						chargeBar.setColor(Color.white);
						eggSizeTimer.cancel();
						this.cancel();
					}
				} else {
					System.out.println("Charge premature cancel");
					this.cancel();
					eggSizeTimer.cancel();
				}
			}
		};
		eggSizeTimer.scheduleAtFixedRate(task, 20, 20);

	}

	public void layEgg() {
		Game.renderables.remove(chargeBar);
		int maxEggNumber = 10;
		Egg egg = SpringAppConfig.getContext().getBean(Egg.class);
		Egg.eggSize = 0;
		Timer eggTimer = new Timer();
		TimerTask task = new TimerTask() {

			public void run() {
				
				if(egg.getHeight()>= Game.player.getWidth()*1.5){
					egg.setColor(Color.white);
				}else{
					egg.setColor(Color.RED);
				}
				if (Game.player.getShape().intersects(egg.getShape().getBounds2D())) {
					egg.setX(egg.getX() + Game.player.getWidth() / 2 + egg.getWidth() / 2);
					
				}
				Game.collideables.add(egg);

				eggTimer.cancel();
				this.cancel();
			}

		};
		eggTimer.schedule(task, 1000);
		if (Egg.getCount().size() > maxEggNumber) {

			Egg oldEgg = Egg.getCount().poll();
			explodeEgg(oldEgg);
		}

	}

	private void explodeEgg(Egg oldEgg) {
		
		oldEgg.setColor(Color.ORANGE);
		Timer eggTimer = new Timer();
		TimerTask task = new TimerTask() {
			double baseSize = oldEgg.getHeight();
			int time = 0;
			int explosionSize = 25;
			double x;
			double y;
			{
				if(oldEgg.getHeight()>= Game.player.getWidth()*1.5){
					explosionSize=55;
					oldEgg.setColor(Color.cyan);
				}
				Game.collideables.remove(oldEgg);
				x = oldEgg.getX();
				y = oldEgg.getY();
			}

			public void run() {
				oldEgg.setX(x - time * 4);
				oldEgg.setY( y - time * 4);
				oldEgg.setWidth(baseSize + time * 6);
				oldEgg.setHeight(baseSize + time * 6);
				time++;
				if (time > explosionSize) {
					Game.renderables.remove(oldEgg);

					this.cancel();
					eggTimer.cancel();
				}
			}
		};

		eggTimer.scheduleAtFixedRate(task, 30, 30);

	}

}
