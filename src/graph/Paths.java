package graph;

/**
 * 
 * Paths.java
 * Interface class that describes path containing waypoints
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public interface Paths {
	
	public void insertWaypoint(int waypoint);
	
	public int rollBack();
	
	public int getStart();
	
	public int getLast();
	
	public boolean findWaypoint(int waypoint);
	
	public int getLength();
	
	public double getCost();
	
	public void setCost(double cost);
	
	public String getPath();
	
	public void resetPath(int waypoint);	

}
