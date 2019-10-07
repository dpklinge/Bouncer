package com.fdmgroup.basicgame.physics;

import com.fdmgroup.basicgame.displayobjects.interfaces.Collideable;
import com.fdmgroup.basicgame.displayobjects.interfaces.Moveable;

public class Collision {

	public static void collide(Moveable moveable, Moveable target) {
		double moveableRatio = Math.pow(moveable.getHeight(), 2)
				/ (Math.pow(moveable.getHeight(), 2) + Math.pow(target.getHeight(), 2));
		double targetRatio = 1 - moveableRatio;

		VectorPath vector = vectorBetween(moveable, target);
		VectorPath unitVector = unitVector(vector);
		if (unitVector == null) {
			moveable.setX(target.getX() + target.getWidth() / 2 + moveable.getWidth() / 2);
			return;
		}
		double dotProduct = dotProduct(new VectorPath(moveable.getXVelocity(), moveable.getYVelocity()), unitVector);

		VectorPath vector2 = vectorBetween(target, moveable);
		VectorPath unitVector2 = unitVector(vector2);
		if (unitVector2 == null) {
			moveable.setX(target.getX() + target.getWidth() / 2 + moveable.getWidth() / 2);
			return;
		}
		double dotProduct2 = dotProduct(new VectorPath(target.getXVelocity(), target.getYVelocity()), unitVector2);

		moveable.setXVelocity(
				unitVector.getX() * (Math.abs(dotProduct * targetRatio) + Math.abs(dotProduct2 * moveableRatio)));
		moveable.setYVelocity(
				unitVector.getY() * (Math.abs(dotProduct * targetRatio) + Math.abs(dotProduct2 * moveableRatio)));
		target.setXVelocity(
				unitVector2.getX() * (Math.abs(dotProduct * moveableRatio) + Math.abs(dotProduct2 * targetRatio)));
		target.setYVelocity(
				unitVector2.getY() * (Math.abs(dotProduct * moveableRatio) + Math.abs(dotProduct2 * targetRatio)));

		moveable.setX((moveable.getX() + moveable.getXVelocity()));
		moveable.setY((moveable.getY() + moveable.getYVelocity()));
		target.setX((target.getX() + target.getXVelocity()));
		target.setY((target.getY() + target.getYVelocity()));

	}

	public static void collideWithStatic(Moveable moveable, Collideable target) {
		VectorPath vector = vectorBetween(moveable, target);
		VectorPath unitVector = unitVector(vector);
		if (unitVector == null) {
			moveable.setX(target.getX() + target.getWidth() / 2 + moveable.getWidth() / 2);
			return;
		}
		double dotProduct = dotProduct(new VectorPath(moveable.getXVelocity(), moveable.getYVelocity()), unitVector);
		moveable.setXVelocity((moveable.getXVelocity() - 2 * dotProduct * unitVector.getX()));
		moveable.setYVelocity((moveable.getYVelocity() - 2 * dotProduct * unitVector.getY()));
		moveable.setX((moveable.getX() + moveable.getXVelocity()));
		moveable.setY((moveable.getY() + moveable.getYVelocity()));

	}

	public static double magnitude(VectorPath vector) {
		return Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2));
	}

	public static VectorPath unitVector(VectorPath vector) {
		double magnitude = magnitude(vector);
		if (magnitude == 0) {
			return null;
		}
		double xline = vector.getX() / magnitude;
		double yline = vector.getY() / magnitude;
		return new VectorPath(xline, yline);
	}

	public static double dotProduct(VectorPath vector1, VectorPath vector2) {
		return (vector1.getX() * vector2.getX()) + (vector1.getY() * vector2.getY());

	}

	public static VectorPath vectorBetween(Collideable center1, Collideable center2) {

		double xline = ((center1.getX() + (center1.getWidth() / 2)) - (center2.getX() + (center2.getWidth() / 2)));
		double yline = ((center1.getY() + (center1.getHeight() / 2)) - (center2.getY() + (center2.getHeight() / 2)));
		return new VectorPath(xline, yline);
	}

}
