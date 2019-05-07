package graph;

import java.util.LinkedList;

/**
 * 
 * Class that implements the extends the abstract class PathAbs
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public class Path extends PathAbs{
	/**
	 * Linked list of integers that defines a sequence of nodes (a path)
	 */
	private LinkedList<Integer> path2 = new LinkedList<Integer>();
	/**
	 * Graph where Path belongs to.
	 */
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
	
	@Override
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
	@Override
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
	@Override
	public int getStart() {
		return path2.peekFirst();
	}
	
	/**
    * Gets the last node of the path
    * @return a <code> integer </code> specifying
    * the last node
    */
	@Override
	public int getLast() {
		return path2.peekLast();
	}
	
	/**
    * Checks if a waypoint is present in the path
    * @param waypoint is the node to be checked
    * @return a <code> boolean </code> specifying
    * the if the waypoint exists in the path
    */
	@Override
	public boolean findWaypoint(int waypoint) {
		return path2.contains(waypoint);
	}
	
	/**
    * Gets the length of the path
    * @return a <code> integer </code> specifying
    * the path size
    */
	@Override
	public int getLength() {
		return path2.size();
	}
	

	
	/**
    * Gets the path description in <code> String </code> format if its length is greater than zero
    * @return a <code> String </code> specifying
    * the path
    */
	@Override
	public String getPath() {
		if (path2.size() > 0)
			
			return path2.toString();
		else return "\0";
	}
	
	/**
    * Clears the existing path and inserts a single waypoint to it
    * @param waypoint is the node inserted in the path after it is cleared
    */
	@Override
	public void resetPath(int waypoint) {
		
		path2.clear();
		path2.add(waypoint);
		cost = 0;
	}

	
}
