package com.gcstudios.entities;

import java.awt.image.BufferedImage;

public class Meteor1 extends Enemy{

	public Meteor1(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		life = 3;
		type = 1;
	}

}