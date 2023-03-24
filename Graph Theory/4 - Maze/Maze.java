import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Maze
{
	private int[][] maze;

	public 
	Maze (int[][] matrix)
	{
		maze = matrix;
	}

	private static final int
		VISITED = -1;

	public boolean 
	checkForExitPath (int r, int c)
	{
		if (r < 0 || r >= maze.length || 
			c < 0 || c >= maze[0].length ||
			maze[r][c] == 0 || maze[r][c] == VISITED)
			return false;

		if (c == maze[0].length-1)
			return true;

		maze[r][c] = VISITED;

		return
			checkForExitPath(r+1, c) ||
			checkForExitPath(r-1, c) ||
			checkForExitPath(r, c+1) ||
			checkForExitPath(r, c-1);
	}

	public String 
	toString ()
	{
		return Arrays.deepToString(maze)
			.replaceAll("\\], ","\n")
			.replaceAll("[\\[\\],]","")
			.replaceAll("" + VISITED, Color.RED + "V" + Color.RESET);
	}
}