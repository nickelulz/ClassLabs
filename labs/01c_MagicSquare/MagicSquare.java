import static java.lang.System.*;
import java.util.Arrays;

public class MagicSquare
{
	private int[][] msq;

	public MagicSquare()
	{
		setSize(0);
	}

	public MagicSquare(int size)
	{
		setSize(size);
	}
	
	public void setSize(int size)
	{
		msq = new int[size][size];
		createMagic();
	}

	private int bounds_check(int current) {
		if (current >= msq.length)
			return 0;
		else if (current < 0)
			return msq.length-1;
		else
			return current;
	}



	public void createMagic()
	{
		int num = 1, row = 0, col = msq.length/2;
		msq[row][col] = num;

		for (int a = 0; a < msq.length; a++) {
			for (int b = 0; b < msq.length; b++) {
				row--;
				col++;
				num += 1;

				row = bounds_check(row);
				col = bounds_check(col);

				if (msq[row][col] != 0) {
					row++;
					col--;
			
					row = bounds_check(row);
					col = bounds_check(col);
					
					row++;
				}

				if (!(row >= msq.length || row < 0 || col >= msq.length || col < 0))
					msq[row][col] = num;
			}
		}
	}

	public String toString( )
	{
		String output="";
		for (int row = 0; row < msq.length; row++) {
			for (int col = 0; col < msq[row].length; col++)
				output += msq[row][col] + " ";
			output += "\n";
		}
		return output;
	}
}