package graph;

import java.util.LinkedList;

public class Path implements Paths{
	
	private LinkedList<Integer> path2 = new LinkedList<Integer>();
	private double cost;
	private Graph graph;
	
	
	public void insertWaypoint(int waypoint) {
		
		// Empty path
		if (path2 == null) {
			path2.add(waypoint);
			cost = 0;
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
	
	public Integer[] getPath() {
		
		return (Integer[]) path2.toArray();
	}
	
	public void resetPath(int waypoint) {
		
		path2.clear();
		path2.add(waypoint);
		cost = 0;
	}
	
	// Verifies if the path including the last waypoint as nest is Hamiltonian
	public boolean isHamiltonian() {
		
		// has not visited all nodes
		if (path2.size() < graph.getSizeNodes() )
			return false;
		
		for (int i = 0; i < graph.getSizeNodes(); i++) {
			if (!path2.contains(i))
				return false;
		}
		return true;
		
	}

}
