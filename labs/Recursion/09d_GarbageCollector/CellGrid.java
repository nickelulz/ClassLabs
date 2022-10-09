import java.awt.Graphics;

public class CellGrid
{
	private Cell[][] grid;
	
	public CellGrid() {
		setSize(0,0);
	}

	public CellGrid(int rows, int cols) {
		setSize(rows, cols);
	}

	public void setSize(int rows, int cols)
	{
		grid = new Cell[rows][cols];
	}

	public void setSpot(int row, int col, Cell val) {
		grid[row][col] = val;
	}
	
	public Cell getSpot(int row, int col) {
		return grid[row][col];
	}
	
	public int getNumRows() {
		return grid.length;
	}
	
	public int getNumCols() {
		return grid[0].length;
	}

	public boolean drawGrid(Graphics window) {
		boolean full = true;
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				Cell spot = grid[r][c];
				if (spot != null)
					spot.draw(window);
				else
					full = false;
			}
		}
		return full;
	}
	
	public String toString() {
		String output="";
		for (Cell[] row: grid) {
			for (Cell c : row)
				output += c + " ";
			output += "\n";
		}
		return output;
	}

}