import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class MazeRunner
{
	private static void
	test_case(int[][] grid)
	{
		Maze maze = new Maze(grid);
		System.out.println(maze);
		System.out.println(maze.checkForExitPath(0, 0) ? "exit found" : "exit not found");
		System.out.println(maze);
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