import java.util.*;
import java.util.function.*;
import static java.lang.System.*;

public class GraphDFS
{
   private final TreeMap<String, List<String>> 
      graph = new TreeMap<>();

   public 
   GraphDFS (String line) 
   {   
      Arrays.stream(line.split(" "))
         .map(e -> e.split("")) 
         .forEach(e -> {
            if (!graph.containsKey(e[0]))
               graph.put(e[0], new LinkedList<>());
            graph.get(e[0]).add(e[1]);
         });
   }
    
   /* Two options for keeping track of which nodes have been visited:
    * If using an array or list to store the graph, you can use a 
    * list or array of booleans that's the same size.  You'll set the
    * corresponding spot in the boolean array to true when it's visited.
    
    * If using a map to store the graph, just make an empty set to 
    * store the visited list.  You can add a node to the set AND check
    * where that node had previously been visited by putting the 
    * call to the add method as the IF's condition.
    */   
   public void 
   dfs_recursive (final String start, final Consumer<String> function)
   {
      if (!graph.containsKey (start))
         return;
      dfs_recursive (start, new TreeSet<String>(), function);
   }
      
   // The recursive helper method:
   private void 
   dfs_recursive (final String current, final Set<String> visited, 
      final Consumer<String> function)
   { 
      function.accept(current);
      visited.add (current);
      for (String neighbor: Objects.requireNonNull(graph.get (current))) 
         if (!visited.contains (neighbor))
            dfs_recursive (neighbor, visited, function);
   } 
   

   public void
   dfs_iterative (String start, final Consumer<String> function) 
   {
      iterative_search(start, new Stack<>(), new HashSet<>(), function);
   }

   public void
   bfs_iterative (String start, final Consumer<String> function) 
   {
      iterative_search(start, new LinkedList<>(), new HashSet<>(), function);
   }

   private void 
   iterative_search (String current, final Collection<String> to_visit, 
      final Set<String> visited, final Consumer<String> function)
   {
      to_visit.add(current);
      while (!to_visit.isEmpty()) {
         // have to do this instead of pop or poll because
         // there is no common class between queue and stack
         current = to_visit instanceof Stack ? ((Stack<String>) to_visit).pop() : ((Queue<String>) to_visit).poll();

         if (!visited.contains(current)) {
            visited.add(current);
            function.accept(current);

            if (!graph.containsKey(current))
               continue;

            List<String> list = graph.get(current);
            ListIterator<String> iterator = list.listIterator(list.size());
            while (iterator.hasPrevious())
               to_visit.add(iterator.previous());
         }
      }
   }
   
   @Override
   public String 
   toString ()
   {
      return graph.toString ();
   }
}