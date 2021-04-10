package main;

import processing.core.PApplet;

public class Avatar extends PApplet{

	private int x, y, r, g, b;
	private String msg;
	//private PApplet app;


	public Avatar (int x, int y, int r, int g, int b, String msg/*, PApplet app*/) {

		this.x = x;
		this.y = y;
		this.r = r;
		this.g = g;
		this.b = b;
		this.msg = msg;
		//this.app = app;

	}

	/*public void pintarEllipse() {

		fill(r,g,b);
		ellipse( x, y, 50, 50);
		move();

	}*/

	public void move () {
		if (msg.equals("UPYES")) {
			if(y > 25) {
				y -=5;
			}
			else {
				y += 5;
			}
		} else if (msg.equals("UPNO")) {
			y = y;
		}

		if (msg.equals("DOWNYES")) {
			if(y < 575) {
				y +=5;
			}
			else {
				y -= 5;
			}
			
		} else if (msg.equals("DOWNNO")) {
			y = y;
		}
		
		if (msg.equals("RIGHTYES")) {
			if(x < 775) {
				x +=5;
			}
			else {
				x -= 5;
			}
			
		} else if (msg.equals("RIGHTNO")) {
			x = x;
		}
		if (msg.equals("LEFTYES")) {
			if(x > 25) {
				x -=5;
			}
			else {
				x += 5;
			}
			
		} else if (msg.equals("LEFTNO")) {
			x = x;
		}

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	/*public void setApp(PApplet app) {
		this.app = app;
	}*/


}
