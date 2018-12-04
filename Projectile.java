package Package;

import java.awt.Image;
import java.awt.Toolkit; 

public class Projectile {
	
	private double xCoord = 0;
	private double yCoord = 0;
	private int width = 10;
	private int height = 10; 
	private Image img; 
	
	
	public Projectile () {
		setxCoord(10);
		setyCoord(10);
		setWidth(30); 
		setHeight(30); 
		setImg("Files/left.png");
	}

	public Projectile(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
			
	}
	
	
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double d) {
		this.xCoord = d;
	}

	public double getyCoord() {
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

	public void add(Projectile pucks) {
		// TODO Auto-generated method stub
		
	}
}
	

