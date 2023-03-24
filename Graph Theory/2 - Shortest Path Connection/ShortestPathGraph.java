import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class ShortestPathGraph
{
	private final TreeMap<String, List<String>> map;

	public 
	ShortestPathGraph (String edges)
	{
		map = new TreeMap<>();
		Arrays.stream(edges.split(" ")).forEach(e -> {
			String[] pair = e.split("");

			if (!map.containsKey(pair[0]))
				map.put(pair[0], new ArrayList<String>());
			if (!map.containsKey(pair[1]))
				map.put(pair[1], new ArrayList<String>());

			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		});
	}

	public boolean 
	contains (String letter)
	{
		return map.containsKey(letter);
	}

	public int steps;
	public List<String> shortest_path;
	public boolean connected;

	public void
	check (final String start, final String end)
	{
		steps = 0;
		shortest_path = null;
		connected = false;

		check(start, end, new ArrayList<>(), 0);
	}

	private void 
	check (final String current, final String end, 
		final List<String> path, final int steps)
	{
		if (current.equals(end)) {
			if (shortest_path == null || path.size() < shortest_path.size())
				shortest_path = path;
			connected = true;
			this.steps = steps; 
			return;
		}

		for (String next: map.get(current)) {
			if (!path.contains(next)) {
				List<String> sub_path = new ArrayList<>(path);
				sub_path.add(next);
				check(next, end, sub_path, steps+1);
			}
		}
	}

	public String 
	toString ()
	{
		return map.toString();
	}
}