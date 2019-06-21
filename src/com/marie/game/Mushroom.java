package com.marie.game;

import java.awt.Graphics;
import java.awt.Image;

public class Mushroom extends GameObject{
	Image img;
	public Mushroom(Image img) {
		this.img = img;
		x = 280;
		y = 304;
		width = 40;
		height = 40;
	}
	public void drawMyself(Graphics g) {
		g.drawImage(img, 280, 304, 40, 40, null);
	}
}
