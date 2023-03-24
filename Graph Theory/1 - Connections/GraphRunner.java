import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class GraphRunner
{
	private static void
	evaluate_test_case (String edges, String[] test)
	{
		Graph graph = new Graph(edges);
		System.out.printf("%s connects to %s == %s\n", test[0], test[1], 
			graph.connected(test[0], test[1]) ? "yes" : "no");
	}

	private static void
	run_file (File file)
	{
		try {
			Scanner in = new Scanner(file);
			final int test_cases = in.nextInt();
			in.nextLine();
			for (int i = 0; i < test_cases; ++i)
				evaluate_test_case(in.nextLine(), in.nextLine().split(""));
			in.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void
	main (final String[] args) throws IOException
	{
		final String[] files = { "graph1.dat", "graph2.dat" };
		Arrays.stream(files)
			.map(path -> new File(path))
			.forEach(GraphRunner::run_file);
	}
}