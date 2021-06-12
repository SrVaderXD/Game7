package com.gcstudios.entities;

import java.awt.image.BufferedImage;

public class Meteor2 extends Enemy{
	
	private final static double SPEED = 1.2;

	public Meteor2(Double x, Double y, Integer width, Integer height, BufferedImage sprite) {
		super(x, y, width, height, SPEED, sprite);
		type = 2;
	}

}
