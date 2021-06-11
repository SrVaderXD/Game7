package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.gcstudios.main.Game;

public class Player extends Entity {

	public boolean right, left;
	private int dir = 0;
	public boolean shoot = false;
	private int lastAtkTimer = 0, atkCD = 10;
	public static int life = 5;
	private int tempScore = 0;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		movement();
		shoot();
		increaseLife();
		restartGame();
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

	private void movement() {
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

	private void shoot() {

		lastAtkTimer++;

		if (lastAtkTimer < atkCD)
			return;

		if (shoot) {
			shoot = false;

			int bullet1_x = getX() + 4;
			int bullet1_y = getY();
			int bullet2_x = getX() + 11;
			int bullet2_y = getY();

			Bullet bullet1 = new Bullet(bullet1_x, bullet1_y, 1, 3, 4, null);
			Game.entities.add(bullet1);

			Bullet bullet2 = new Bullet(bullet2_x, bullet2_y, 1, 3, 4, null);
			Game.entities.add(bullet2);

			lastAtkTimer = 0;
		}
	}

	private void increaseLife() {
		if (Game.score - tempScore >= 1000) {
			tempScore = Game.score;
			life++;
		}
	}
	
	private void restartGame() {
		if(life <= 0)
			System.exit(1);
	}
}
