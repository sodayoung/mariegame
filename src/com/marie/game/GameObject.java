package com.marie.game;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img;
	double x,y;
	int width,height;
	public  GameObject(Image img,double x,double y,int width,int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public  GameObject(Image img,double x,double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public  GameObject() {
		
	}
	/**
	* 返回物体对应矩形区域，便于后续在碰撞检测中使用
	* @return
	*/
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,width,height);
	}
}
