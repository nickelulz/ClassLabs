import java.io.*;
public class Lab04c
{
	public static void main( String args[] ) throws IOException
	{
		char[][] characters = {
				{ 'a', 'b', 'c'      },
				{ 'd', 'e', 'a'      },
				{ 'x', 'a', 'r', 'g' }
		};

		String[] files = {
				"lab04c1.dat",
				"lab04c2.dat",
				"lab04c3.dat"
		};

		for (int i = 0; i < 3; i++)
			test(characters[i], files[i]);
	}

	static void test(char[] chars, String filename) throws IOException {
		Histogram test = new Histogram(chars, filename);
		test.loadAndAnalyzeFile();
		System.out.println("Letter occurring most : "+test.mostFrequent());
		System.out.println("Letter occurring least : "+test.leastFrequent());
		System.out.println("\n");
		System.out.println(test);
	}
}