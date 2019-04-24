package simulation;

import graph.Path;
import graph.Paths;

public class Ant {
	
	private int id;
	Paths path;
	
	public Ant(int id, int nest) {
		super();
		this.id = id;
		this.path = new Path();
		path.insertWaypoint(nest);
	}
	
	public int returnID() {
		return id;
	}
		
}
