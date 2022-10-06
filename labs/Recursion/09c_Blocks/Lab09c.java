import java.io.IOException;

public class Lab09c {
	public static void main(String args[]) throws IOException {
		for (int i = 0; i < 10; i++)
			new Grid(10, 10, new String[]{ "A", "B", "C", "D" });
	}
}