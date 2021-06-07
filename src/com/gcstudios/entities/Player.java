package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Player extends Entity {

	public boolean right, left;
	private int dir = 0;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {

		if (right) {
			x += speed;
			dir = 1;
		} else if (left) {
			x -= speed;
			dir = -1;
		} else {
			dir = 0;
		}

		if (x >= Game.WIDTH) {
			x = -16;
		} else if (x + 16 < 0) {
			x = Game.WIDTH;
		}

	}

	public void render(Graphics g) {

		if (dir == 1) {
			sprite = Entity.RIGHT_SHIP;
		} else if (dir == -1) {
			sprite = Entity.LEFT_SHIP;
		} else {
			sprite = Entity.SHIP;
		}
		super.render(g);
	}

}
