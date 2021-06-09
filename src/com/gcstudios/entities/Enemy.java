package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Enemy extends Entity {

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		y += speed;

		if (y > Game.HEIGHT) {
			Game.entities.remove(this);
			return;
		}
	}
}
