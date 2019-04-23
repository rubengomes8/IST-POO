package simulation;

import graph.Edge;
import graph.Graph;
import graph.Node;
import pec.Event;
import static utilities.Utilities.*;


public class AntMove extends Event{
	
	Ant ant;
	Node next;
	Graph graph;
	Simulation sim;
	private static float alpha;
	private static float beta;
	private static float delta;

	public AntMove(Ant ant, Node move, Graph graph, Simulation sim) {
		super(sim.getInst() + expRandom(delta * ant.path.getLast().getPayload(move.getID())) );
		this.ant = ant;
		this.next = move;
		this.graph = graph;
		this.sim = sim;
	}
	
	public void executeEvent() {
		
		if(next == ant.path.getStart()) {
			// path is an Hamiltonian cycle
			if (ant.path.isHamiltonian(graph)) {
				sim.incrementMoveCounter();
				ant.path.insertWaypoint(next);
				//update best cycle
				double cost = ant.path.getCost();
				if (sim.getBestCost() > cost ) {
					sim.replaceCycle(ant.path);
				}
				// insert pheromones
				Node aux;
				Edge eaux;
				
				do {
					aux = ant.path.rollBack();
					//TODO: change denominator with actual formula
					eaux = ant.path.getLast().getAdjacents(aux.getID());
					eaux.updatePaylod( (sim.getpLevel() * cost) / ( 1 )  );
					
					new Evaporate(eaux, sim);
					
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
		
		//TODO: change null with appropriate first move
		sim.pec.addEvPEC(new AntMove(ant, null ,graph, sim) );
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