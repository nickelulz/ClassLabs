import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class ShortestPathGraphRunner
{
	private static void
	execute_test_case (String edges, String[] path)
	{
		ShortestPathGraph graph = new ShortestPathGraph(edges);
		graph.check(path[0], path[1]);
		System.out.printf("%s connects to %s == %s\n", path[0], path[1], 
			graph.connected ? "yes in " + graph.steps + " steps" : "no");
	}

	public static void 
	main (String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("data.dat"));
		final int test_cases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < test_cases; ++i)
			execute_test_case(in.nextLine(), in.nextLine().split(""));
	}
}