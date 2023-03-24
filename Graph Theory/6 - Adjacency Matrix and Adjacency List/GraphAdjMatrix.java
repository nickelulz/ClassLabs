import java.util.*;
import java.io.*;

/** A class that implements a directed graph.
 * The graph may have self-loops, parallel edges.
 * Vertices are labeled by integers 0 .. n-1
 * and may also have String labels.
 * The edges of the graph are not labeled.
 * Representation of edges via an adjacency matrix.

 */
public class GraphAdjMatrix extends Graph {

	private final static int DEFAULT_NUM_VERTICIES = 5;
	private int[][] adjMatrix;

	/** Create a new empty Graph */
	public 
	GraphAdjMatrix () 
	{
		adjMatrix = new int[ DEFAULT_NUM_VERTICIES ][ DEFAULT_NUM_VERTICIES ];
	}

	/**
	 * Implement the abstract method for adding a vertex.
	 * If need to increase dimensions of matrix, double them
	 * to amortize cost.
	 */
	public void 
	implementAddVertex () 
	{

	}

	/**
	 * Implement the abstract method for adding an edge.
	 * Allows for multiple edges between two points:
	 * the entry at row v, column w stores the number of such edges.
	 * @param v the index of the start point for the edge.
	 * @param w the index of the end point for the edge.
	 */
	public void 
	implementAddEdge (int v, int w) 
	{

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
	public List<Integer> 
	getNeighbors (int v)
	{
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
	public List<Integer> 
	getInNeighbors (int v)
	{
		return null;
	}

	/**
	 * Implement the abstract method for finding all
	 * vertices reachable by two hops from v.
	 * Use matrix multiplication or you may utilize the getNeighbors method
	 *
	 * @param v the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */
	public List<Integer> 
	getDistance2 (int v) 
	{
		return null;
	}

	/**
	 * Generate string representation of adjacency matrix
	 * @return the String
	 */
	public String 
	adjacencyString () 
	{
		int rows = adjMatrix.length;

		StringBuilder output = new StringBuilder(
			String.format("Adjacency Matrix (size %d x %d = %d integers):", 
			rows, rows, rows * rows));

		for (int i = 0; i < rows; i ++) {
			output.append("\n\t" + i + ": ");
			for (int j = 0; j < adjMatrix[i].length; j++)
				output.append(adjMatrix[i][j] + ", ");
		}

		return output.toString();
	}


}
