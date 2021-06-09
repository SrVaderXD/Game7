package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Bullet extends Entity {

	public Bullet(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		y -= speed;
		
		if(y < -16) {
			Game.entities.remove(this);
		}
	}

	public void render(Graphics g) {
		g.setColor(new Color(205, 0, 0));
		g.fillRect(getX(), getY(), width, height);
	}
}
