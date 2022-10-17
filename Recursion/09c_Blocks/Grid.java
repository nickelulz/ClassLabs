public class Grid {
   private String[][] grid;

	public Grid() {
		grid = new String[0][0];
	}

	public Grid(int rows, int cols, String[] vals) {
		grid = new String[rows][cols];
		setGrid(rows, cols, vals);
	}

	public void setGrid(int rows, int cols, String[] vals) {
		for (int r = 0; r < rows; r++){
			for (int c = 0; c < cols; c++){
				int num = (int)(Math.random() * vals.length);
				grid[r][c] = vals[num];
			}
		}
	}

	public int findMax(String val) {
		int count =- 1;
		for (int r = 0; r < grid.length; r++)
			for (int c = 0; c < grid[r].length; c++)
				if (grid[r][c].equals(val))
					count = Math.max(count_grouping(r, c, val), count);
		return count;
	}

	private boolean bounds_check(int r, int c) {
		return r < grid.length && r >= 0 && c < grid[r].length && r >= 0 && c >= 0;
	}

	private int count_grouping(int r, int c, String search) {
		if (bounds_check(r, c) && grid[r][c].equals(search)) {
			grid[r][c] = "#";
			return  count_grouping(r + 1, c, search) +
					count_grouping(r - 1, c, search) +
					count_grouping(r, c + 1, search) +
					count_grouping(r, c - 1, search) + 1;
		}
		return 0;
	}

	public String toString() {
		String output="";
		for (String[] row: grid) {
			for (String s : row)
				System.out.print(s + " ");
			System.out.println();
		}
		return output;
	}
}