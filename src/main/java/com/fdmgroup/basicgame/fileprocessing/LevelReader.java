package com.fdmgroup.basicgame.fileprocessing;

import org.springframework.stereotype.Service;

import com.fdmgroup.basicgame.levels.Level;

@Service
public interface LevelReader {
	public Level readLevel(String levelName);

}
