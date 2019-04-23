package graph;

import java.util.LinkedList;

public class Path {
	
	private LinkedList<Node> path = new LinkedList<Node>();
	private double cost;
	private int length;
	
	
	public void insertWaypoint(Node waypoint) {
		
		// Empty path
		if (path == null) {
			path.add(waypoint);
			cost = 0;
		}
				
		double weight;
		// not adjacent
		if ( (weight = path.getLast().getWeight(waypoint.getID())) < 0) {
			System.out.println("Attepting to move to non-adjacent Node!");
			System.exit(-1);
		}
		length++;
		cost += weight;
		path.add(waypoint);
	}
	
	public Node rollBack() {
		Node aux = path.removeLast();
	
		cost = cost - aux.getPayload(path.getLast().getID());
		
		return aux;
	}
	
	public Node getStart() {
		return path.peekFirst();
	}
	
	public Node getLast() {
		return path.peekLast();
	}
	
	public boolean findWaypoint(Node waypoint) {
		return path.contains(waypoint);
	}
	
	public int getLength() {
		return length;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Node[] getPath() {
		
		return (Node[]) path.toArray();
	}
	
	public void resetPath(Node waypoint) {
		
		path.clear();
		path.add(waypoint);
		cost = 0;
	}
	
	// Verifies if the path including the last waypoint as nest is Hamiltonian
	public boolean isHamiltonian(Graph graph) {
		
		if (length < graph.getSizeNodes() )
			return false;
		
		for (int i = 0; i< graph.getSizeNodes(); i++) {
			if (!path.contains(graph.getNode(i)))
				return false;
		}
		return true;
		
	}

}
