package graph;

import java.util.LinkedList;

public class Path implements Paths{
	
	private LinkedList<Integer> path2 = new LinkedList<Integer>();
	private double cost;
	private Graphs graph;
	
	
	public Path(Graphs graph) {
		super();
		this.graph = graph;
	}

	public void insertWaypoint(int waypoint) {
		
		// Empty path
		if (path2 == null || path2.size() == 0) {
			path2.add(waypoint);
			cost = 0;
			return;
		}
		// not adjacent
		cost += graph.getEdgeWeight(path2.getLast(), waypoint);
		path2.add(waypoint);
	}
	
	public int rollBack() {
		
		int aux = path2.removeLast();
	
		cost = cost - graph.getEdgeWeight(aux, path2.getLast());
		return aux;
	}
	
	public int getStart() {
		return path2.peekFirst();
	}
	
	public int getLast() {
		return path2.peekLast();
	}
	
	public boolean findWaypoint(int waypoint) {
		return path2.contains(waypoint);
	}
	
	public int getLength() {
		return path2.size();
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getPath() {
		if (path2.size() > 0)
			return path2.toString();
		else return "\0";
	}
	
	public void resetPath(int waypoint) {
		
		path2.clear();
		path2.add(waypoint);
		cost = 0;
	}
	
	// Verifies if the path including the last waypoint as nest is Hamiltonian

}
