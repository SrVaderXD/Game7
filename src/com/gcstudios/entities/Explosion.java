package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Explosion extends Entity {

	private int initialFrames = 0, maxFrames = 4, curIndex = 0, maxIndex = 4;
	private BufferedImage[] explosionAnimation;

	public Explosion(double x, double y, int width, int height, double speed, BufferedImage sprite, int type) {
		super(x, y, width, height, speed, sprite);
		explosionAnimation = new BufferedImage[5];

		if (type == 1) {
			for (int i = 0; i < 5; i++) {
				explosionAnimation[i] = Game.spritesheet.getSprite(0, 64 + i * 16, 16, 16);
			}
		} else if (type == 2) {
			for (int i = 0; i < 5; i++) {
				explosionAnimation[i] = Game.spritesheet.getSprite(16, 64 + i * 16, 16, 16);
			}
		} else if (type == 3) {
			for (int i = 0; i < 5; i++) {
				explosionAnimation[i] = Game.spritesheet.getSprite(32, 64 + i * 16, 16, 16);
			}
		}
	}

	public void tick() {
		initialFrames++;
		if (initialFrames == maxFrames) {
			initialFrames = 0;
			curIndex++;
			if (curIndex == maxIndex) {
				Game.entities.remove(this);
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(explosionAnimation[curIndex], getX(), getY(), null);
	}

}
