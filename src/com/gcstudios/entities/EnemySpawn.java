package com.gcstudios.entities;

import com.gcstudios.main.Game;

public class EnemySpawn {

	private int maxTime = 60, curTime = 0;

	public void tick() {
		spawn();
	}	
	
	private void spawn() {
		curTime++;

		if (curTime == maxTime) {
			curTime = 0;

			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);
			int chosen = chooseType();
			
			if(chosen == 1) {
				Meteor1 meteor = new Meteor1(xx, yy, 16, 16, 1, null);
				Game.entities.add(meteor);
			} else if(chosen == 2) {
				Meteor2 meteor = new Meteor2(xx, yy, 16, 16, 1.2, null);
				Game.entities.add(meteor);
			} else if(chosen == 3) {
				Meteor3 meteor = new Meteor3(xx, yy, 16, 16, 1.5, null);
				Game.entities.add(meteor);
			}
			
		}
	}

	private int chooseType() {

		int percentage = Entity.rand.nextInt(101);

		if (percentage >= 60) {
			return 1;
		} else if (percentage >= 30) {
			return 2;
		} else if (percentage < 30) {
			return 3;
		} else {
			return 1;
		}
	}

}
