package graph;

import java.util.LinkedList;

/**
 * 
 * Path.java
 * Class that implements the interface Paths
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class Path implements Paths{
	
	private LinkedList<Integer> path2 = new LinkedList<Integer>();
	private double cost;
	private Graphs graph;
	
	// Deep copy constructor 
	
	/**
    * Path deep copy constructor
    * @param source is another instance of Path that we use to copy
    */
	
	public Path(Path source) {
		this.cost = source.getCost();
		this.graph = source.graph;
		for (Integer sourcePath : source.path2) {
			path2.add(sourcePath);
		}
	}
	
	/**
    * Path constructor
    * @param graph is a graph
    */
	
	public Path(Graphs graph) {
		this.graph = graph;
	}

	/**
    * Inserts a node to the path and increases the total cost of the path by the weight of the respective edge
    * @param waypoint is an integer that identifies the node that we will add to the Path
    */
	
	public void insertWaypoint(int waypoint) {
		
		// Empty path
		if (path2 == null || path2.size() == 0) {
			path2.add(waypoint);
			cost = 0;
			return;
		}
		// not adjacent
		try {
			cost += graph.getEdgeWeight(path2.getLast(), waypoint);
		} catch (NoEdgeException e) {
			System.exit(-1);
		}
		path2.add(waypoint);
	}
	
	
	/**
    * Removes the last node in the path and decreases the total cost of the path by the weight of the respective edge
    * @return a <code> integer </code> specifying
    * the node to be removed
    */
	
	public int rollBack() {
		
		int aux = path2.removeLast();
	
		try {
			cost = cost - graph.getEdgeWeight(aux, path2.getLast());
		} catch (NoEdgeException e) {
			System.exit(-1);
		}
		return aux;
	}
	
	/**
    * Gets the first node of the path
    * @return a <code> integer </code> specifying
    * the first node
    */
	
	public int getStart() {
		return path2.peekFirst();
	}
	
	/**
    * Gets the last node of the path
    * @return a <code> integer </code> specifying
    * the last node
    */
	
	public int getLast() {
		return path2.peekLast();
	}
	
	/**
    * Checks if a waypoint is present in the path
    * @param waypoint is the node to be checked
    * @return a <code> boolean </code> specifying
    * the if the waypoint exists in the path
    */
	
	public boolean findWaypoint(int waypoint) {
		return path2.contains(waypoint);
	}
	
	/**
    * Gets the length of the path
    * @return a <code> integer </code> specifying
    * the path size
    */
	
	public int getLength() {
		return path2.size();
	}
	
	/**
    * Gets the total cost of the path
    * @return a <code> double </code> specifying
    * the path cost
    */
	
	public double getCost() {
		return cost;
	}
	
	/**
    * Sets the cost of the path
    * @param cost is the cost to be set
    */

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
    * Gets the path description in <code> String </code> format if its length is greater than zero
    * @return a <code> String </code> specifying
    * the path
    */
	
	public String getPath() {
		if (path2.size() > 0)
			
			return path2.toString();
		else return "\0";
	}
	
	/**
    * Clears the existing path and inserts a single waypoint to it
    * @param waypoint is the node inserted in the path after it is cleared
    */
	
	public void resetPath(int waypoint) {
		
		path2.clear();
		path2.add(waypoint);
		cost = 0;
	}

	
}
