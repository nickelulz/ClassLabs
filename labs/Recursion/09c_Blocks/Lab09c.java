import java.io.IOException;

public class Lab09c {
	public static void main(String args[]) throws IOException {
		Grid grid = new Grid(10, 10, new String[]{"A", "B", "C"});
		System.out.println(grid + "\n");
		System.out.println("A count == " + grid.findMax("A"));
		System.out.println("B count == " + grid.findMax("B"));
		System.out.println("C count == " + grid.findMax("C"));
	}
}