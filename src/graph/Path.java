package graph;

import java.util.LinkedList;

public class Path {
	
	LinkedList<Integer> path;
	int cost;
	int length;
	
	public Path(int start) {
		super();
		this.path = new LinkedList<Integer>();
		this.path.add(start);
		this.cost = 0;;
	}
	
	public void insertWaypoint(int waypoint, int weight) {
		length++;
		cost +=weight;
		path.add(waypoint);
	}
	
	public int rollBack() {
		return path.removeLast();
	}
	
	public int getStart() {
		return path.peekFirst();
	}
	
	public int getPrevious() {
		return path.peekLast();
	}
	
	public boolean findWaypoint(int waypoint) {
		return path.contains(waypoint);
	}
	
	public boolean isHamiltonian(int nNodes) {
		
		if (length == 0)
			return false;
		
		if (path.peekFirst() != path.peekLast())
			return false;
		
		if (length < nNodes + 1)
			return false;
		
		for (int i = 0; i< nNodes;i++) {
			if (!path.contains(i)) 
				return false;
		}
		return true;
		
		
	}

}
