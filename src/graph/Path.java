package graph;

import java.util.LinkedList;

public class Path {
	
	private LinkedList<Node> path;
	private int cost;
	private int length;
	
	
	public void insertWaypoint(Node waypoint) {
		
		// Empty path
		if (path == null) {
			path = new LinkedList<Node>();
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
		return path.removeLast();
	}
	
	public Node getStart() {
		return path.peekFirst();
	}
	
	public Node getPrevious() {
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
	
	public Node[] getPath() {
		
		return (Node[]) path.toArray();
	}
	
	public boolean isHamiltonian(Graph graph) {
		
		if (length == 0)
			return false;
		
		if (path.peekFirst() != path.peekLast())
			return false;
		
		if (length < graph.getSizeNodes() + 1)
			return false;
		
		for (int i = 0; i< graph.getSizeNodes(); i++) {
			if (!path.contains(graph.getNode(i)))
				return false;
		}
		return true;
		
	}

}
