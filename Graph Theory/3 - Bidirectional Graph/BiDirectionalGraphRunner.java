import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class BiDirectionalGraphRunner
{
	private static void
	test_case (String graph_input, String check_input)
	{
		BiDirectionalGraph graph = new BiDirectionalGraph(graph_input);
		String[] check = check_input.split(" ");
		graph.check(check[0], check[1]);
		System.out.printf("%s CONNECTS TO %s == %s\n", 
			check[0], check[1], graph.connected ? "YAH" : "NAH");
	}

	public static void 
	main (String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("bigraph.dat"));
		int test_cases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < test_cases; ++i)
			test_case(in.nextLine(), in.nextLine());
	}
}