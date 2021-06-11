package com.gcstudios.entities;

import java.awt.image.BufferedImage;

public class Meteor3 extends Enemy{

	public Meteor3(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		type = 3;
	}

}
