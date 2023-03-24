import java.util.*;
import static java.lang.System.*;

public class ShortestPathMaze
{
	private int[][] maze;

	public 
	ShortestPathMaze (final int[][] m)
	{
		maze = m;
		checkForExitPath(0, 0, 0);
	}

	private int shortest;

	private static final int
		VISITED = -1;

	public void 
	checkForExitPath (int r, int c, int path)
	{
		if (r < 0 || r >= maze.length || 
			c < 0 || c >= maze[0].length ||
			maze[r][c] == 0 || maze[r][c] == VISITED)
			return;

		if (c == maze[0].length-1) {
			if (path < shortest)
				shortest = path;
			return;
		}

		maze[r][c] = VISITED;

		checkForExitPath(r+1, c, path + 1);
		checkForExitPath(r-1, c, path + 1);
		checkForExitPath(r, c+1, path + 1);
		checkForExitPath(r, c-1, path + 1);
	}
	
	public int 
	getShortestPath ()
	{
		return shortest;
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