package graph;

public abstract class PathAbs implements Paths{

	protected double cost;
	
	@Override
	public abstract void insertWaypoint(int waypoint);
	
	@Override
	public abstract int rollBack();
	
	@Override
	public abstract int getStart();
	
	@Override
	public abstract int getLast();
	
	@Override
	public abstract boolean findWaypoint(int waypoint);
	
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
	
	public abstract String getPath();
	
	public abstract void resetPath(int waypoint);	
}
