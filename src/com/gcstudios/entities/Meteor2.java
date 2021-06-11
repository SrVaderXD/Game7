package com.gcstudios.entities;

import java.awt.image.BufferedImage;

public class Meteor2 extends Enemy{

	public Meteor2(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		type = 2;
	}

}
