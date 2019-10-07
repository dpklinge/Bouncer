package com.fdmgroup.basicgame.physics;

public class Forces {
	private static double friction = 0.1;
	private static double gravity = .3;
	private static boolean gravityIsEnabled = true;
	private static boolean frictionIsEnabled = true;
	private static double maxSpeed = 10;
	
	public static double getMaxSpeed() {
		return maxSpeed;
	}

	public static void setMaxSpeed(double maxSpeed) {
		Forces.maxSpeed = maxSpeed;
	}

	public static double getFriction() {
		return friction;
	}

	public static void setFriction(double friction) {
		Forces.friction = friction;
	}

	public static double getGravity() {
		return gravity;
	}

	public static void setGravity(double gravity) {
		Forces.gravity = gravity;
	}

	public static boolean isGravityIsEnabled() {
		return gravityIsEnabled;
	}

	public static void setGravityIsEnabled(boolean gravityIsEnabled) {
		Forces.gravityIsEnabled = gravityIsEnabled;
	}

	public static boolean getIsFrictionIsEnabled() {
		return frictionIsEnabled;
	}

	public static void setFrictionIsEnabled(boolean frictionIsEnabled) {
		Forces.frictionIsEnabled = frictionIsEnabled;
	}

	public static boolean gravityIsEnabled() {
		return gravityIsEnabled;
	}
	public static double getNetForces(){
		double net =0;
		if(gravityIsEnabled){
			net+=gravity;
		}
		if(frictionIsEnabled){
			net-=friction;
		}
		return net;
	}
}
