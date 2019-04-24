package graph;

public interface Paths {
	
	public void insertWaypoint(int waypoint);
	
	public int rollBack();
	
	public int getStart();
	
	public int getLast();
	
	public boolean findWaypoint(int waypoint);
	
	public int getLength();
	
	public double getCost();
	
	public void setCost(double cost);
	
	public Integer[] getPath();
	
	public void resetPath(int waypoint);
	
	public boolean isHamiltonian();
	
	

}
