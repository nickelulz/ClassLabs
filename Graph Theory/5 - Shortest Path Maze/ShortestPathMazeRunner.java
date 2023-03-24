import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathMazeRunner
{
	private static void
	test_case(int[][] grid)
	{
		ShortestPathMaze maze = new ShortestPathMaze(grid);
		System.out.println(maze);

		int shortest = maze.getShortestPath();
		System.out.println(shortest == 0 ? "no path found" : "shortest path of " + shortest);

		System.out.println();
	}

	private static void
	read_file(File file) throws IOException
	{
		Scanner in = new Scanner(file);
		while (in.hasNextLine()) {
			final int size = in.nextInt();
			int[][] maze_input = new int[size][size];
			for (int r = 0; r < size; ++r)
				for (int c = 0; c < size; ++c)
					maze_input[r][c] = in.nextInt();
			test_case(maze_input);
		}
	}

	public static void 
	main (final String args[]) throws IOException
	{
		String[] filenames = new String[] { "maze.dat", "maze2.dat" };
		for (String filename: filenames)
			read_file(new File(filename));
	}
}