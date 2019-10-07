package com.fdmgroup.basicgame.levels.environments;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentMapper {
	@Autowired 
	private Map<String, Environment> environments;

	public Map<String, Environment> getEnvironments() {
		return environments;
	}

}
