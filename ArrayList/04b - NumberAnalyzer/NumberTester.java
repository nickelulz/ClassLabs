//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class NumberTester {
	public static void main(String[] args) {
		test(7);
		test(496);
	}

	static void test(int n) {
		Number t = new Number(n);
		System.out.printf("%d\n%d isOdd == %b\n%d isPerfect == %b\n\n\n", n, n, t.isOdd(), n, t.isPerfect());
	}
}