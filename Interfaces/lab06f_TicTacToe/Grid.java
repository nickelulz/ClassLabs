import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Grid
{
	private Drawable[][] grid;
	
	public Grid() {
		setSize(0,0);
	}

	public Grid(int rows, int cols) {
		setSize(rows, cols);
	}

	public void setSize(int rows, int cols) {
		grid = new Drawable[rows][cols];
	}

	public void setSpot(int row,int col, Drawable val) {
		grid[row][col] = val;
	}
	
	public Drawable getSpot(int row, int col) {
		return grid[row][col];
	}
	
	public int getNumRows() {
		return grid.length;
	}
	
	public int getNumCols() {
		return grid[0].length;
	}

	public boolean drawGrid(Graphics window)
	{
		boolean full=true;
		//for loop for row
			//for loop for col
				//get current Drawable
					//if it is null
					//else
		return full;
	}
	
	public String toString() {
		String output="";
		return output;
	}
}