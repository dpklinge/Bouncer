package com.fdmgroup.basicgame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.displayobjects.Dimensions;
import com.fdmgroup.basicgame.inputeffects.KeyInput;

@Service
public class PlayWindow extends JFrame {
	private Dimensions window;
	private Renderer renderer;
	@Autowired
	private ActionsPerTick gameTicks;
	
	public PlayWindow(){
		System.out.println("Initializing PlayWindow");
	}
	
	@Autowired
	public PlayWindow(Renderer renderer, Dimensions window){
		this.renderer=renderer;
		this.window=window;
		System.out.println("Initializing PlayWindow");
		System.out.println("Is renderer null in playwindow constructor? "+(renderer==null));
	}

	private static final long serialVersionUID = 2792380546071441007L;
	
	public ActionsPerTick getActionController(){
		return gameTicks;
	}
	
	 public void initUI(KeyInput input) {  
	        System.out.println("Is renderer null in playwindow? "+(renderer==null));
	        add(renderer);
	        System.out.println("Input in playWindow is null?"+(input==null));
	        addKeyListener(input);
	        System.out.println("KeyListeners: "+getKeyListeners()[0]);
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                gameTicks.getTimer().stop();
	            }
	        });

	        setTitle("Points");
	        setSize(new Double(window.getWindowWidth()).intValue(), new Double(window.getWindowHeight()-60).intValue());
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
}
