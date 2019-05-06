package graph;

/**
 * Interface class that describes path containing waypoints identified by integers
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public interface Paths {
	
	/**
    * Inserts a node to the path and increases the total cost of the path by the weight of the respective edge
    * @param waypoint is an integer that identifies the node that we will add to the Path
    */
	public void insertWaypoint(int waypoint);
	
	/**
    * Removes the last node in the path and decreases the total cost of the path by the weight of the respective edge
    * @return a <code> integer </code> specifying
    * the node to be removed
    */
	public int rollBack();
	
	
	/**
    * Gets the first node of the path
    * @return a <code> integer </code> specifying
    * the first node
    */
	public int getStart();
	
	/**
    * Gets the last node of the path
    * @return a <code> integer </code> specifying
    * the last node
    */
	public int getLast();
	
	/**
    * Checks if a waypoint is present in the path
    * @param waypoint is the node to be checked
    * @return a <code> boolean </code> specifying
    * the if the waypoint exists in the path
    */
	public boolean findWaypoint(int waypoint);
	
	/**
    * Gets the length of the path
    * @return a <code> integer </code> specifying
    * the path size
    */
	public int getLength();
	
	/**
    * Gets the total cost of the path
    * @return a <code> double </code> specifying
    * the path cost
    */
	public double getCost();
	
	/**
    * Sets the cost of the path
    * @param cost is the cost to be set
    */
	public void setCost(double cost);
	
	/**
    * Gets the path description in <code> String </code> format if its length is greater than zero
    * @return a <code> String </code> specifying
    * the path
    */
	public String getPath();
	
	/**
    * Clears the existing path and inserts a single waypoint to it
    * @param waypoint is the node inserted in the path after it is cleared
    */
	public void resetPath(int waypoint);	

}
