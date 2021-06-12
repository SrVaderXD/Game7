package com.gcstudios.entities;

import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.gcstudios.main.Game;

public class EnemySpawn {

	private int maxTime = 60, curTime = 0;

	public void tick() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Class<? extends Enemy>> xD = Enemy.getEnemyType();
		Class<? extends Enemy> chosenEnemy = xD.get(Entity.rand.nextInt(xD.size()));
		spawn(chosenEnemy);
	}

	private void spawn(Class<? extends Enemy> enemyClass) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		curTime++;
		if (curTime >= maxTime) {
			curTime = 0;
			maxTime = Entity.rand.nextInt(70);

			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);
			// int chosen = chooseType();

//			if(chosen == 1) {
//				Meteor1 meteor = new Meteor1(xx, yy, 16, 16, null);
//				Game.entities.add(meteor);
//			} else if(chosen == 2) {
//				Meteor2 meteor = new Meteor2(xx, yy, 16, 16, 1.2, null);
//				Game.entities.add(meteor);
//			} else if(chosen == 3) {
//				Meteor3 meteor = new Meteor3(xx, yy, 16, 16, 1.5, null);
//				Game.entities.add(meteor);
//			}
			// Class cls[] = new Class[]
			// {Integer.class,Integer.class,Integer.class,Integer.class,BufferedImage.class};
			Game.entities.add(enemyClass
					.getConstructor(Double.class, Double.class, Integer.class, Integer.class, BufferedImage.class)
					.newInstance(new Double(xx), new Double(yy), new Integer(16), new Integer(16), null));
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
