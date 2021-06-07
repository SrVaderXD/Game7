package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class EnemySpawn {

	private int maxTime = 60, curTime = 0;
	public static int enemyType;

	public void tick() {
		curTime++;

		if (curTime == maxTime) {
			curTime = 0;

			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);

			Enemy enemy = new Enemy(xx, yy, 16, 16, 1, chooseSprite());

			Game.entities.add(enemy);
		}
	}

	private BufferedImage chooseSprite() {

		int percentage = Entity.rand.nextInt(101);

		if (percentage >= 60) {
			enemyType = 1;
			return Entity.METEOR1;
		} else if (percentage >= 30) {
			enemyType = 2;
			return Entity.METEOR2;
		} else if (percentage < 30) {
			enemyType = 3;
			return Entity.METEOR3;
		} else {
			enemyType = 1;
			return Entity.METEOR1;
		}
	}

}
