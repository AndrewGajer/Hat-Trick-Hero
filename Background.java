package Package;

import java.awt.Image;
import java.awt.Toolkit; 

public class Background {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10; 
	private Image img; 
	
	public Background () {
		setxCoord(10);
		setyCoord(10);
		setWidth(30); 
		setHeight(30); 
		setImg("Files/background.png");
	}

	public Background(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
			
	}
	
/*	public void moveIt(int direction, int w, int h) {
		System.out.println(direction);
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		if (direction == 39) {
			x = x + speed; 
			if (x > w) { x = x - speed * 3; } 
			setxCoord(x);
			setImg("Files/right.png");
		} else if (direction == 37) {
			if (x < 0) { x = x + speed * 3; }
			x = x - speed;
			setxCoord(x);
			setImg("Files/right.png");
		} else if(direction == 40) {
			if (y > h - 10) { y = y + speed * 3; }
			y = y + speed; 
			setyCoord(y);
			setImg("Files/right.png");
		} else if(direction == 38) {
			if (x < 0) { y = y + speed * 3; }
			y = y - speed;
			setyCoord(y);
			setImg("Files/right.png");
		
		}
	}*/
	
	public void setImg(Image img) {
		this.img = img;
	}

	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

}