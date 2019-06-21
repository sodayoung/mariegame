package com.marie.game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.marie.game.MyGameFrame.PaintThread;




public class MyGameFrame extends Frame{
	Image bg = GameUtil.getImage("imgs/bg.jpg");
	Image marieImg = GameUtil.getImage("imgs/marie.jpg");
	Image musImage = GameUtil.getImage("imgs/mushroom.png");
	Marie marie = new Marie(marieImg, 0, 305);
	Mushroom mushroom = new Mushroom(musImage);
	@Override //画窗口内容
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg, 0, 0, null);
		marie.drawMyself(g);
		mushroom.drawMyself(g);
		boolean peng = mushroom.getRect().intersects(marie.getRect());
		if (peng) {
			System.out.println("peng");
		}
		
		
		
		
	} 

	/* 重画窗口 */
	class PaintThread extends Thread{//内部类可以使用外部类的方法,线程
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				repaint();//重画
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/* 初始化窗口 */
	public void launchFrame() {
		this.setTitle("超级玛丽");
		this.setVisible(true);
		this.setSize(800,400);
		this.setLocation(300,200);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		
		new PaintThread().start();//启动重画窗口线程
		addKeyListener(new KeyMonitor());
	}
	
	/* 定义键盘监听 */
	class KeyMonitor extends KeyAdapter{

		@Override//按键按下
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			marie.addDirection(e);
		}

		@Override//按键抬起
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			marie.cancelDirection(e);
		}
		
		
	}
	
	/* 双缓冲，避免窗口闪烁 */
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(800,400);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}
