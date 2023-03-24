import java.util.*;
import java.io.*;

public class GraphRunner
{
   public static void
   execute_file(File file)
   {
      try 
      {
         System.out.println(file.getName());
         Scanner in = new Scanner(file);
         while (in.hasNextLine()) {
            String input_graph = in.nextLine(),
               start = in.nextLine();
   
            GraphDFS graph = new GraphDFS(input_graph);
   
            System.out.println("Input: " + input_graph);
            System.out.println("Parsed Graph: " + graph.toString());

            System.out.printf("r-dfs(%s): ", start);
            graph.dfs_recursive(start, System.out::print);
            System.out.println();

            System.out.printf("i-dfs(%s): ", start);
            graph.dfs_iterative(start, System.out::print);
            System.out.println();

            System.out.printf("i-bfs(%s): ", start);
            graph.bfs_iterative(start, System.out::print);
            System.out.println("\n");
         }
         System.out.println();
      }
      catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      }
   }

   public static void 
   main(String[] args) throws IOException
   {
      Arrays.stream (new File(".").listFiles())
         .filter(File::isFile)
         .filter(e -> e.getName().endsWith(".dat"))
         .forEach(GraphRunner::execute_file);
   }
}