package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Enemy extends Entity {

	public int life = 3, type;
	private int initialFrames = 0, maxFrames = 25, curIndex = 0, maxIndex = 2;
	private BufferedImage[] animationMeteor1, animationMeteor2, animationMeteor3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		animationMeteor1 = new BufferedImage[3];
		animationMeteor2 = new BufferedImage[3];
		animationMeteor3 = new BufferedImage[3];
		
		for (int i = 0; i < 3; i++) {
			animationMeteor1[i] = Game.spritesheet.getSprite(0, 16 + i * 16, 16, 16);
			animationMeteor2[i] = Game.spritesheet.getSprite(16, 16 + i * 16, 16, 16);
			animationMeteor3[i] = Game.spritesheet.getSprite(32, 16 + i * 16, 16, 16);
		}
	}

	public void tick() {
		y += speed;

		if (y > Game.HEIGHT) {
			Game.entities.remove(this);
			Player.life--;
			return;
		}

		destroy();
		animate();
	}
	
	public void render(Graphics g) {
		if(type == 1)
			g.drawImage(animationMeteor1[curIndex], getX(), getY(), null);
		if(type == 2)
			g.drawImage(animationMeteor2[curIndex], getX(), getY(), null);
		if(type == 3)
			g.drawImage(animationMeteor3[curIndex], getX(), getY(), null);
	}
	
	public void animate() {
		initialFrames++;
		if (initialFrames == maxFrames) {
			initialFrames = 0;
			curIndex++;
			if (curIndex >= maxIndex) {
				curIndex = maxIndex;
			}
		}
	}

	private void destroy() {

		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);

			if (e instanceof Bullet) {
				if (isColliding(e, this)) {
					life--;
					Game.entities.remove(e);
					if (life == 0) {
						Explosion explosion = new Explosion(x, y, 16, 16, 0, null, type);
						Game.entities.add(explosion);
						Game.entities.remove(this);
						
						if(type == 1) {
							Game.score+=10;
						} else if(type == 2) {
							Game.score+=50;
						} else if(type == 3) {
							Game.score+=100;
						}
						return;
					}
					break;
				}
			}
		}
	}
}
