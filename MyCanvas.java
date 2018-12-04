package Package;

import java.awt.Canvas;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;

import sun.audio.*;

public class MyCanvas extends Canvas implements KeyListener {
	
		
		Goodguy scooby = new Goodguy(50,200,50,50,"Files/right.png");
		Background back = new Background(10,10,50,50,"Files/background.png");
		Net net = new Net(10,10,50,50,"Files/net.png");
		Scoreboard score = new Scoreboard(10, 10, 50, 50, "Files/scoreboard.png");
		LinkedList badguys = new LinkedList();
		LinkedList pucks = new LinkedList();
		//int goals = 0;
		int goalscore = 0;
		
		public MyCanvas() {
		
			this.setSize(600,400);
			this.addKeyListener(this);
			playIt("Files/storm.wav");
			
			Random rand = new Random();
			int winwidth = 1300;
			int winheight = this.getHeight();
			for(int i = 0; i<10; i++) {
				Badguy bg = new Badguy(rand.nextInt(winwidth)+50, rand.nextInt(winheight)+100,60,60,"Files/left.png");
				
				badguys.add(bg);
			}
		}
			
		public void paint(Graphics g) {
			
			g.drawImage(back.getImg(), back.getxCoord(), 115, 1450, 800, this);

			g.drawImage(score.getImg(), 510, 0, 450, 155, this);
			g.drawImage(scooby.getImg(), scooby.getxCoord(), scooby.getyCoord(), scooby.getWidth(), scooby.getHeight(), this);	
			//g.drawRect(75, 170, 1330, 570);
			g.drawImage(net.getImg(), 1303, 415, 80, 100, this);
			
			g.drawString(Integer.toString(goalscore), 555, 45);
			for(int i = 0; i < badguys.size(); i++) {
				Badguy bg = (Badguy) badguys.get(i); 
				g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
				Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			
			
				for(int j = 0; j < pucks.size(); j++) {
					Projectile k = (Projectile) pucks.get(j);
					if (k.getxCoord() > this.getWidth()) { pucks.remove(j); }
					k.setxCoord(k.getxCoord() + .5);
					g.drawImage(k.getImg(),(int) k.getxCoord(),(int) k.getyCoord(), k.getWidth(), k.getHeight(), this);
					
					Rectangle kr = new Rectangle((int) k.getxCoord(),(int) k.getyCoord(),k.getWidth(),k.getHeight());
					if (kr.intersects(r)) {
						badguys.remove(i);
						pucks.remove(j);
					}
					if(k.getxCoord() == 1303 && k.getyCoord() > 400 && k.getyCoord() < 500) {
						goalscore = goalscore + 1;
						pucks.remove(j);
					}
					repaint();
	// this allows the score to go up by 1 after every intersection with the puck to the net
				}
			}
			
			// g.drawString(goals, 0, 0);
		}
		
		public void playIt(String filename) {
		
			try { 
				InputStream in = new FileInputStream(filename);
				AudioStream as = new AudioStream(in);
				AudioPlayer.player.start(as);
			} catch (IOException e) {
				System.out.println(e);
			}
		}

		
		public void keyTyped(KeyEvent e) {
			System.out.println(e);
	}

		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == 32) {
				Projectile puck = new Projectile(scooby.getxCoord(),scooby.getyCoord(),30,30,"files/puck.png");
				pucks.add(puck);
			}
			
			for(int i = 0; i < badguys.size(); i++) {
				Badguy bg = (Badguy) badguys.get(i);
				Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight()); 
				if (r.contains(scooby.getxCoord(),scooby.getyCoord())) {
					System.out.println("badguy hit by DeBrincat");
					badguys.remove(i);
				}
			}
			
			repaint();
			scooby.moveIt(e.getKeyCode(), this.getWidth(),this.getHeight());
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
	
			// TODO Auto-generated method stub
	
		}
}
