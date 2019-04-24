package simulation;

import graph.Graphs;
import graph.Paths;
import pec.Event;
import static utilities.Utilities.*;


public class AntMove extends Event{
	
	Ant ant;
	int next;
	Paths path;
	Graphs graph;
	Simulation sim;
	private static float alpha;
	private static float beta;
	private static float delta;

	public AntMove(Ant ant, int move, Graphs graph, Simulation sim) {
		super(sim.getInst() + expRandom( delta * graph.getEdgePayload(ant.path.getLast(), move)) );
		this.ant = ant;
		this.next = move;
		this.graph = graph;
		this.sim = sim;
	}
	
	public void executeEvent() {
		
		if(next == ant.path.getStart()) {
			// path is an Hamiltonian cycle
			if ( ant.path.isHamiltonian() ){
				sim.incrementMoveCounter();
				ant.path.insertWaypoint(next);
				//update best cycle
				double cost = ant.path.getCost();
				if (sim.getBestCost() > cost ) {
					sim.replaceCycle(ant.path);
				}
				// insert pheromones
				int aux1;
				int aux2;
				
				do {
					aux1 = ant.path.rollBack();
					aux2 = ant.path.getLast();
					graph.addEdgePayload(aux1, aux2, sim.getpLevel() * graph.getGraphWeight() / ( cost )  );
					
					new Evaporate(graph, aux1,aux2, sim);
					
				} while(ant.path.getLast() != next);
				
				ant.path.resetPath(next);
			}
		}
		else if (ant.path.findWaypoint(next) ) {
			//inner cycle found, roll-back
			while(ant.path.getLast() != next) {
				ant.path.rollBack();
			}
			sim.incrementMoveCounter();
		}
		else {
			ant.path.insertWaypoint(next);
			sim.incrementMoveCounter();
		}
		
		//TODO: change 1 with appropriate first move
		sim.pec.addEvPEC(new AntMove(ant, 1 ,graph, sim) );
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