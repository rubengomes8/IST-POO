package simulation;

import graph.Node;
import graph.Path;

public class Ant {
	
	private int id;
	Path path;
	
	public Ant(int id, Node nest) {
		super();
		this.id = id;
		this.path = new Path();
		path.insertWaypoint(nest);
	}
	
	public int returnID() {
		return id;
	}
		
}
