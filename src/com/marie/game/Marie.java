package com.marie.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Marie extends GameObject {
	Image img;
	double x,y;//物体左右高
	int width,height;
	int speed = 3;
	boolean up,down,left,right;
	public  Marie(Image img,double x,double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	
	public void drawMyself(Graphics g) {
		g.drawImage(img, (int)x,(int)y, 40, 40, null);
		if (down) {
			y+=speed;
		}
		if (left) {
			x-=speed;
		}
		if (right) {
			x+=speed;
		}
		if (up) {
			y-=speed;
		}
		
	}
	
	//运动
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		default:
			break;
		}	 
	}
	
	public void cancelDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		default:
			break;
		}	
		
	}
}
