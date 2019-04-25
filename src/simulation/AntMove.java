package simulation;

import pec.Event;

import static utilities.Utilities.*;


public class AntMove extends Event{
	
	Ant ant;
	Simulation sim;
	private int next;
	
	private static float delta;

	public AntMove(Ant ant, int move, Simulation sim, double time) {
		super(time);
		this.ant = ant;
		this.next = move;
		this.sim = sim;
	}
	
	public double executeEvent() {
		
		double time;
		
		if(next == sim.getNest() && ant.getPath().getLength() == sim.getGraph().getSizeNodes()) {
			// path is an Hamiltonian cycle
			sim.incrementMoveCounter();
			ant.getPath().insertWaypoint(next);
			//update best cycle
			double cost = ant.getPath().getCost();
			if (sim.getBestCost() > cost) {
				sim.replaceCycle(ant.getPath());
			}
			// insert pheromones
			int aux1;
			int aux2;
			
			do {
				aux1 = ant.getPath().rollBack();
				aux2 = ant.getPath().getLast();
				sim.getGraph().addEdgePayload(aux1, aux2, sim.getpLevel() * sim.getGraph().getGraphWeight() / ( cost )  );
				time = this.timestamp + expRandom(Evaporate.getEta());
				if (time <= sim.getFinalInst())
					sim.getPec().addEvPEC(new Evaporate(aux1, aux2, sim, time));					
			} while(ant.getPath().getLast() != next);
				
			ant.getPath().resetPath(next);
		}
		else if (ant.getPath().findWaypoint(next) ) {
			//inner cycle found, roll-back
			while(ant.getPath().getLast() != next) {
				ant.getPath().rollBack();
			}
			sim.incrementMoveCounter();
		}
		else {
			ant.getPath().insertWaypoint(next);
			sim.incrementMoveCounter();
		}
		// Schedule next move
		int move = ant.chooseNext(ant.getPath(), sim.getGraph());
		time = getTime(move);	
		
		if (time <= sim.getFinalInst()) 
			sim.getPec().addEvPEC(new AntMove(ant,move, sim, time));
		
		return this.timestamp;
	}
	
	public double getTime(int move) {
		
		return this.timestamp + expRandom(delta *sim.getGraph().getEdgeWeight(ant.getPath().getLast(), move));
	}
	
	public static float getDelta() {
		return delta;
	}

	public static void setDelta(float delta) {
		AntMove.delta = delta;
	}

}