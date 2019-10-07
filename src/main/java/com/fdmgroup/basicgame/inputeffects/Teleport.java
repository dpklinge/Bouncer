package com.fdmgroup.basicgame.inputeffects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SpringAppConfig;
import com.fdmgroup.basicgame.Game;
import com.fdmgroup.basicgame.displayobjects.Dimensions;
import com.fdmgroup.basicgame.displayobjects.TeleportBubble;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;

@Service
public class Teleport {
	@Autowired
	private Dimensions window;

	public void teleport(Moveable subject) {
		teleportBubble(subject);
		
		Random random = new Random();
		int x = random.nextInt((int) (window.getWindowWidth()-subject.getWidth()));
		int y = random.nextInt((int) (window.getWindowHeight()-subject.getHeight()));
		
		Game.player.setX(x);
		Game.player.setY(y);
		
	}
	
	private void teleportBubble(Moveable subject) {
		TeleportBubble bubble = SpringAppConfig.getContext().getBean(TeleportBubble.class);
		Timer bubbleTimer = new Timer();
		TimerTask task = new TimerTask() {
			double baseSize = subject.getWidth() * 1.2;
			int time = 0;
			int bubbleShrinkDuration = 12;
			double x;
			double y;
			{
				x = bubble.getX();
				y = bubble.getY();
			}

			public void run() {
				bubble.setX(x - time * 2);
				bubble.setY( y - time * 2);
				bubble.setWidth(baseSize - time * 6);
				bubble.setHeight(baseSize - time * 6);
				time++;
				if (time > bubbleShrinkDuration) {
					Game.renderables.remove(bubble);

					this.cancel();
					bubbleTimer.cancel();
				}
			}
		};
		bubbleTimer.scheduleAtFixedRate(task, 20, 20);

	}

}
