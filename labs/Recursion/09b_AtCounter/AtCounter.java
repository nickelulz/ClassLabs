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

	public void countAts(int r, int c) {

		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]

		if (r >= 0 && r < at_mat.length && c >= 0 && c < at_mat.length && at_mat[r][c] == '@') {
			at_count++;
			at_mat[r][c] = 'f';
			countAts(r+1,c);
			countAts(r-1,c);
			countAts(r,c+1);
			countAts(r,c-1);
		}
	}



	public String toString() {
		String output = "";
		output += at_count + " @s connected.";
		return output;
	}
}