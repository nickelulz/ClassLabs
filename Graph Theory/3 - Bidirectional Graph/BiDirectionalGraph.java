import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class BiDirectionalGraph
{
	private final TreeMap<String, TreeSet<String>> map;

	public 
	BiDirectionalGraph (final String line)
	{
		map = new TreeMap<>();
		String[] pairs = line.split(" ");
		for (int i = 0; i < pairs.length-1; i += 2) {
			if (!map.containsKey(pairs[i]))
				map.put(pairs[i], new TreeSet<String>());
			if (!map.containsKey(pairs[i+1]))
				map.put(pairs[i+1], new TreeSet<String>());
			map.get(pairs[i]).add(pairs[i+1]);
			map.get(pairs[i+1]).add(pairs[i]);
		}
	}

	public boolean 
	contains (final String name)
	{
		return map.containsKey(name);
	}

	public boolean connected;

	public void
	check (final String start, final String end)
	{
		connected = false;
		check(start, end, new TreeSet<>());
	}

	public void 
	check (final String current, final String end, final TreeSet<String> visited)
	{
		if (!map.containsKey(current))
			return;

		if (map.get(current).contains(end)) {
			connected = true;
			return;
		}

		for (String next: map.get(current)) {
			if (!visited.contains(next)) {
				TreeSet<String> clone = new TreeSet<String>(visited);
				clone.add(next);
				check(next, end, clone);
			}
		}
	}

	public String 
	toString ()
	{
		return map.toString();
	}
}