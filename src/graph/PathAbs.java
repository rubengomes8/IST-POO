package graph;

/**
* This is an abstract class that holds the generic information about a Path (cost)
* and implements the interface Paths.java
* @author John Mendonça, Manuel Domingues, Rúben Gomes
* @since 04-26-2019
*/

public abstract class PathAbs implements Paths{

	protected double cost;
	
	
	/**
    * Inserts a node to the path and increases the total cost of the path by the weight of the respective edge
    * @param waypoint is an integer that identifies the node that we will add to the Path
    */
	
	@Override
	public abstract void insertWaypoint(int waypoint);
	
	
	/**
    * Removes the last node in the path and decreases the total cost of the path by the weight of the respective edge
    * @return a <code> integer </code> specifying
    * the node to be removed
    */
	@Override
	public abstract int rollBack();
	
	
	/**
    * Gets the first node of the path
    * @return a <code> integer </code> specifying
    * the first node
    */
	@Override
	public abstract int getStart();
	
	
	/**
    * Gets the last node of the path
    * @return a <code> integer </code> specifying
    * the last node
    */
	@Override
	public abstract int getLast();
	
	/**
    * Checks if a waypoint is present in the path
    * @param waypoint is the node to be checked
    * @return a <code> boolean </code> specifying
    * the if the waypoint exists in the path
    */
	@Override
	public abstract boolean findWaypoint(int waypoint);
	
	/**
    * Gets the length of the path
    * @return a <code> integer </code> specifying
    * the path size
    */
	@Override
	public abstract int getLength();
	
	/**
    * Gets the total cost of the path
    * @return a <code> double </code> specifying
    * the path cost
    */
	@Override
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
	public abstract String getPath();
	
	/**
    * Clears the existing path and inserts a single waypoint to it
    * @param waypoint is the node inserted in the path after it is cleared
    */
	public abstract void resetPath(int waypoint);	
}
