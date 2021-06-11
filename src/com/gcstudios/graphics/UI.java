package com.gcstudios.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.gcstudios.entities.Player;
import com.gcstudios.main.Game;

public class UI {

	private int frames = 0;
	public static int seconds = 0, minutes = 0;
	private BufferedImage LIFE = Game.spritesheet.getSprite(48, 0, 16, 16);

	public void tick() {
		frames++;

		if (frames == 60) {
			frames = 0;
			seconds++;

			if (seconds == 60) {
				seconds = 0;
				minutes++;
			}
		}
	}

	public void render(Graphics g) {
		drawScore(g);
		drawLife(g);
		drawTimer(g);
	}

	private void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 23));
		g.drawString("Score: "+Game.score, 10, 30);
	}
	
	private void drawLife(Graphics g) {
		g.drawImage(LIFE, 395, 8, 32, 32, null);
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 23));
		g.drawString("x"+Player.life, 430, 30);
	}

	private void drawTimer(Graphics g) {
		String timerFormat = "";

		if (minutes < 10) {
			timerFormat += "0" + minutes + ":";
		} else {
			timerFormat += minutes + ":";
		}

		if (seconds < 10) {
			timerFormat += "0" + seconds;
		} else {
			timerFormat += seconds;
		}

		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 23));
		g.drawString(timerFormat, 220, 30);
	}
}
