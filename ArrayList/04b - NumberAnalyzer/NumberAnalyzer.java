import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer() {
		setList("");
	}

	public NumberAnalyzer(String numbers) {
		setList(numbers);
	}
	
	public void setList(String numbers) {
		list = (ArrayList<Number>)
				Arrays.stream(numbers.split(" "))
						.map(Integer::valueOf)
						.map(n -> new Number(n))
						.collect(Collectors.toList());
	}

	public int countOdds() {
		return (int) list.stream().filter(n -> n.isOdd()).count();
	}

	public int countEvens() {
		return list.size() - countOdds();
	}

	public int countPerfects() {
		return (int) list.stream().filter(n -> n.isPerfect()).count();
	}
	
	public String toString( ) {
		return list.toString();
	}
}