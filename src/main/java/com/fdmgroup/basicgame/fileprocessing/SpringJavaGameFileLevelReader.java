package com.fdmgroup.basicgame.fileprocessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fdmgroup.basicgame.levels.Level;

@Component
@Lazy
public class SpringJavaGameFileLevelReader implements LevelReader {
	@Autowired
	private ApplicationContext context;
	
	public Level readLevel(String levelName) {	
			return context.getBean(levelName, Level.class);
	}

}
