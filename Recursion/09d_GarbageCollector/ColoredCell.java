import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class ColoredCell extends Cell
{
	private boolean filled;
	private Color color;
	
	public ColoredCell() {
		this(false);
	}

	public ColoredCell(boolean fill) {
		this(5, 5, fill);
	}

	public ColoredCell(int x, int y, boolean fill) {
		this(x, y, 5, 5, fill);
	}

	public ColoredCell(int x, int y, int w, int h, boolean fill) {
		this(x, y, w, h, fill, Color.BLUE);
	}

	public ColoredCell(int x, int y, int w, int h, boolean fill, Color c) {
		super(x, y, w, h);
		setFilled(fill);
		setColor(c);
	}

	public void setFilled(boolean fill) {
		this.filled = fill;
	}

	public void setColor(Color c) {
		this.color = c;
	}
	
	public boolean getFilled()
	{
		return filled;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void draw(Graphics window) {
		window.setFont(new Font("TAHOMA",Font.BOLD,28));
		window.setColor(getColor());
		window.drawRect(getX(),getY(),getWidth(),getHeight());
		if (filled) {
			window.setColor(Color.GREEN);
			window.drawRect(getX()+2,getY()+2,getWidth()-3,getHeight()-3);
			window.fillRect(getX()+2, getY()+2, getWidth()-3, getHeight()-3);
		}
	}
	
	public String toString()
	{
		return super.toString() + " " + getFilled() + " " + getColor();
	}
}