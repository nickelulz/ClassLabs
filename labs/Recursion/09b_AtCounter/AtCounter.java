public class AtCounter {
   private char[][] at_mat;
   private int at_count;


	public AtCounter() {
		at_count = 0;
		at_mat = new char[][] {
			{ '@', '-', '@', '-', '-', '@', '-', '@', '@', '@' },
			{ '@', '@', '@', '-', '@', '@', '-', '@', '-', '@' },
			{ '-', '-', '-', '-', '-', '-', '-', '@', '@', '@' },
			{ '-', '@', '@', '@', '@', '@', '-', '@', '-', '@' },
			{ '-', '@', '-', '@', '-', '@', '-', '@', '-', '@' },
			{ '@', '@', '@', '@', '@', '@', '-', '@', '@', '@' },
			{ '-', '@', '-', '@', '-', '@', '-', '-', '-', '@' },
			{ '-', '@', '@', '@', '-', '@', '-', '-', '-', '-' },
			{ '-', '@', '-', '@', '-', '@', '-', '@', '@', '@' },
			{ '-', '@', '@', '@', '@', '@', '-', '@', '@', '@' }
		};
	}

	public int end_counter() {
		int count = at_count;
		at_count = 0;
		return count;
	}

	public void countAts(int r, int c) {
		if (r >= 0 && r < at_mat.length && c >= 0 && c < at_mat.length && at_mat[r][c] == '@') {
			at_count++;
			at_mat[r][c] = '#';
			countAts(r+1,c);
			countAts(r-1,c);
			countAts(r,c+1);
			countAts(r,c-1);
		}
	}



	public String toString() {
		String output = "";
		for (char[] row: at_mat) {
			for (char c: row)
				output += c + " ";
			output += "\n";
		}
		return output;
	}
}