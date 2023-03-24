import java.util.*;

public class Graph
{
	private final Map<String, List<String>> map;

	public 
	Graph (final String edges) 
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
	contains (final String letter) 
	{
		return map.containsKey(letter);
	}

	public boolean 
	connected (final String start, final String end)
	{
		return connected(start, end, new ArrayList<String>());
	}

	private boolean 
	connected (final String current, final String end, 
		final List<String> visited)
	{
		if (map.get(current).contains(end))
			return true;
		else {
			boolean check = false;
			for (String next: map.get(current)) {
				if (!visited.contains(next)) {
					visited.add(next);
					check = check || 
						connected(next, end, new ArrayList<String>(visited));
				}
			}
			return check;
		}
	}
	   
	@Override
	public String 
	toString ()
	{
		return map.toString();
	}
}