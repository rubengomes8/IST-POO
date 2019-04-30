package simulation;

import java.util.Random;

import graph.Graphs;
import graph.NoEdgeException;
import graph.Path;
import graph.Paths;


/**
 * Ant.java
 * This is a model class to hold ant information
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */


public class Ant {
	
	private static float alpha;
	private static float beta;
	private int id;
	Paths path;
	
	
  /**
    * Ant constructor
    * @param id is an integer that identifies the ant
    * @param nest is the first node of the Hamiltonian cycle
    * @param graph is the graph containing all the nodes and the edges
    */
	
	public Ant(int id, int nest, Graphs graph) {
		super();
		this.id = id;
		this.path = new Path(graph);
		path.insertWaypoint(nest);
	}
	
   /**
    * Gets the ant ID
    * @return a <code> integer </code> specifying
    * the ant ID
    */
	
	public int returnID() {
		return id;
	}
	
	/**
    * Gets the next node to be visited.
    * @param path is the path traveled by the ant until the present instant
    * @param graph is the graph that describes the connection between all nodes
    * @return a <code> int </code> specifying
    * the next node to be visited
    */
	
	public int chooseNext(Paths path, Graphs graph) throws NextMoveNotFoundException{
		
		Random r = new Random();
		double f = r.nextDouble();
		double comul = 0;
		
		int cur = path.getLast();
		boolean unvisited = false;
		// set of adjacent nodes
		int[] j = graph.returnEdges(cur);
		
		double[] p = new double[j.length];
		double ci = 0;
		boolean[] visited = new boolean[j.length];
		
		// find whether visited before or not
		for (int i = 0; i < j.length; i++) {
			if ( path.findWaypoint(j[i]) )
				visited[i] = true;
			else {
				visited[i] = false;
				unvisited = true;
			}
		}
		if (!unvisited) {
			//all adjacents have already been visited
			if(j.length != 0)
			{
				double uniformBinEdge = 1.0 / j.length;
				return j[(int)(f/uniformBinEdge)];	
			}
			else
			{
				System.out.println("One node has no adjacent nodes!");
				System.exit(-1);
				
				return 0;
			}
							
		}
		else {
			int i;
			for (i = 0 ; i < j.length ; i++) {
				if (!visited[i]) {
					// calculates cij and sums ci
					try {
						if((beta + graph.getEdgeWeight(cur, j[i])) != 0)
						{
							p[i] = (alpha + graph.getEdgePayload(cur,j[i]))/(beta + graph.getEdgeWeight(cur, j[i]));
							ci+= p[i];
						}
						else
						{
							System.out.println("Error: Divisor <Beta + EdgeWeight> is equal to zero");
							System.exit(-1);
						}
					} catch (NoEdgeException e) {
						System.out.println(e);
						System.exit(-1);
					}
				}
			}
			// calculates pij
			for (i = 0; i < p.length;i++) {
				p[i] = p[i] / ci;
			}
			// choose next node
			for ( i = 0; i < j.length; i++) {
				comul += p[i];
				if (f <= comul)
					return j[i];
			}
			// sum of p likely < 1: exception here
			//TODO: throw exception Next node not found!
			throw new NextMoveNotFoundException();
		}
	}
	
   /**
    * Gets the alpha parameter
    * @return a <code> float </code> specifying
    * the alpha parameter
    */
	
	public static float getAlpha() {
		return alpha;
	}
	
	/**
    * Sets the alpha parameter
    * @param beta is the alpha parameter to be set
    */

	public static void setAlpha(float alpha) {
		Ant.alpha = alpha;
	}

	/**
    * Gets the beta parameter
    * @return a <code> float </code> specifying
    * the beta parameter
    */
	
	public static float getBeta() {
		return beta;
	}

	/**
    * Sets the beta parameter
    * @param beta is the beta parameter to be set
    */
	
	public static void setBeta(float beta) {
		Ant.beta = beta;
	}

	/**
    * Gets the path
    * @return a <code> Paths </code> specifying
    * the path of the ant
    */
	
	public Paths getPath() {
		return path;
	}
	
	/**
    * Sets the path
    * @param path is the path to be set
    */
	
	public void setPath(Paths path) {
		this.path = path;
	}
	
	
		
}
