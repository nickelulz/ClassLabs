import static java.lang.System.*;

public class Lab15e
{
	public static void main(String[] args)
	{
		Object[][] tests = {
			"ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF".split(""),
			"11 22 33 44 55 66 33 44 22 11 11 11 11 22 11 11 11".split(" "),
			"1.1 2.2 3.3 4.4 5.5 6.6 3.3 4.4 2.2 1.1 1.1 1.1 1.1 2.2 1.1".split(" "),
			"dog 33 3.4".split(" ")
		};

		for (Object[] testArray: tests)
			test(testArray);
	}

	public static void test(Object[] test) {
		HistoList list = new HistoList();
		for (Object obj: test)
			list.add(obj);
		System.out.println(list);
	}
}