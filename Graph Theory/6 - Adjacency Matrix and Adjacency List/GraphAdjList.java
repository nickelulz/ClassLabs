import java.io.*;
import java.util.*;

/** A class that implements a directed graph.
 * The graph may have self-loops, parallel edges.
 * Vertices are labeled by integers 0 .. n-1
 * and may also have String labels.
 * The edges of the graph are not labeled.
 * Representation of edges via adjacency lists.
 */
public class GraphAdjList extends Graph {


   private Map<Integer,ArrayList<Integer>> adjListsMap;

   public GraphAdjList () {
      adjListsMap = new HashMap<Integer,ArrayList<Integer>>();
   }

	/**
	 * Implement the abstract method for adding a vertex.
	 */
   public void implementAddVertex() {
   
   }

	/**
	 * Implement the abstract method for adding an edge.
	 * @param v the index of the start point for the edge.
	 * @param w the index of the end point for the edge.
	 */
   public void implementAddEdge(int v, int w) {
   
   }

	/**
	 * Implement the abstract method for finding all
	 * out-neighbors of a vertex.
	 * If there are multiple edges between the vertex
	 * and one of its out-neighbors, this neighbor
	 * appears once in the list for each of these edges.
	 *
	 * @param v the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */
   public List<Integer> getNeighbors(int v) {
      return null;
   }

	/**
	 * Implement the abstract method for finding all
	 * in-neighbors of a vertex.
	 * If there are multiple edges from another vertex
	 * to this one, the neighbor
	 * appears once in the list for each of these edges.
	 *
	 * @param v the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */
   public List<Integer> getInNeighbors(int v) {
   
      return null;
   }


	/**
	 * Implement the abstract method for finding all
	 * vertices reachable by two hops from v.
	 * @param v the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */
   public List<Integer> getDistance2(int v) {
   	// Implement this method
   
   
   
   
   
   
   
      return null;
   }

	/**
	 * Generate string representation of adjacency list
	 * @return the String
	 */
   public String adjacencyString() {
      String s = "Adjacency list";
      s += " (size " + getNumVertices() + "+" + getNumEdges() + " integers):";
   
      for (int v : adjListsMap.keySet()) {
         s += "\n\t"+v+": ";
         for (int w : adjListsMap.get(v)) {
            s += w+", ";
         }
      }
      return s;
   }
}
