import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public abstract class Drawable implements Locatable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	public Drawable() {
		setPos(5,5);
		setWidth(5);
		setHeight(5);
	}

	public Drawable(int x, int y) {
		this(x,y,5,5);
	}

	public Drawable(int x, int y, int w, int h) {
		this.xPos = x;
		this.yPos = y;
		this.width = w;
		this.height = h;
	}

	public void setPos(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setX(int x) {
		this.xPos = x;
	}
	
	public void setY(int y) {
		this.yPos = y;
	}

	public void setWidth(int w) {
		this.width = w;
	}
	
	public void setHeight(int h) {
		this.height = h;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}	

	public int getWidth() {
		return width;
	}	
	
	public int getHeight() {
		return height;
	}
	
	public abstract void draw(Graphics window);
	
	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}