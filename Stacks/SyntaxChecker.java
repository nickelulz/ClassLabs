import java.util.*;
import java.util.stream.*;
import java.io.*;

public class SyntaxChecker {
	private static final String open = "[({<", close = "])}>";
	private static final HashMap<String, String> map;

	static {
		map = new HashMap<>();
		for (int i = 0; i < 4; i++)
			map.put(open.charAt(i)+"",close.charAt(i)+"");
	}

	public static boolean checkExpression(String exp) {
   		Stack<String> symbols = new Stack<>();
   		for (String token: exp.split("")) {
   			if (open.contains(token))
   				symbols.push(token);
   			else if (close.contains(token))
   				if (symbols.isEmpty() || !token.equals(map.get(symbols.pop())))
   					return false;
   		}
		return symbols.isEmpty();
	}
}