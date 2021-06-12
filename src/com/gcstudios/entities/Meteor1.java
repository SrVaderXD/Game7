package com.gcstudios.entities;

import java.awt.image.BufferedImage;

public class Meteor1 extends Enemy{
	
	private final static double SPEED = 1;

	public Meteor1(Double x, Double y, Integer width, Integer height, BufferedImage sprite) {
		super(x, y, width, height, SPEED, sprite);
		type = 1;
	}
}
