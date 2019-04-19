package antcolony;

import graph.Node;
import pec.Event;

public class Ant_move extends Event{
	
	Ant ant;
	Node next;

	public Ant_move(double timestamp, Ant ant, Node move) {
		super(timestamp);
		this.ant = ant;
		this.next = move;
	}
	
	public void executeEvent() {
		
		ant.path.insertWaypoint(next);
	}

}
