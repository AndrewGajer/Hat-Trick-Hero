package Package;

import javax.swing.JFrame;
public class Myscreen extends JFrame {
/** 
 * MyScreen basic window for game, inherits properties and methods from 
 * @author andrew.gajer
 * @since Oct. 9, 2018
 */
	
	/**
	 * MyScreen default constructor 
	 * @param non, default constructor
	 */
	public Myscreen() {
		// this is current instance, setters are mutator methods which
		this.setSize(1450,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
		// main method is required to run the program
	public static void main(String [] args) {
		Myscreen screen = new Myscreen();
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
	}
	
}
