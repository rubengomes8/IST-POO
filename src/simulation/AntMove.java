package simulation;

import graph.Node;
import pec.Event;


public class AntMove extends Event{
	
	Ant ant;
	Node next;
	private static float alpha;
	private static float beta;
	private static float delta;

	public AntMove(double timestamp, Ant ant, Node move) {
		super(timestamp);
		this.ant = ant;
		this.next = move;
	}
	
	public void executeEvent() {
		
		ant.path.insertWaypoint(next);
	}

	public static float getAlpha() {
		return alpha;
	}

	public static void setAlpha(float alpha) {
		AntMove.alpha = alpha;
	}

	public static float getBeta() {
		return beta;
	}

	public static void setBeta(float beta) {
		AntMove.beta = beta;
	}

	public static float getDelta() {
		return delta;
	}

	public static void setDelta(float delta) {
		AntMove.delta = delta;
	}
	
	

}