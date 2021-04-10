package main;

import processing.core.PApplet;

public class Bullet {
	
	private PApplet app;
	private int x,y;
	private boolean moveToRight;
	
	public Bullet (PApplet app, int x, int y, boolean moveToRight) {
		this.app=app;
		this.x=x;
		this.y=y;
		this.moveToRight=moveToRight;
	}

	public void pintar () {
		app.fill(255);
		app.ellipse(x, y, 10, 10);
		
		if(moveToRight) {
			x+=5;
		} else {
			x-=5;
		}
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

	public boolean isMoveToRight() {
		return moveToRight;
	}

	public void setMoveToRight(boolean moveToRight) {
		this.moveToRight = moveToRight;
	}
	
	

}
