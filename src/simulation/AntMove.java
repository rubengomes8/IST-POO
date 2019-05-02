package simulation;

import pec.Event;

import static utilities.Utilities.*;

import graph.NoEdgeException;

/**
 * This is a subclass of Event representing an Ant transverse between two adjacent nodes
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */


public class AntMove extends Event{
	
	Ant ant;
	Simulation sim;
	private int next;
	
	private static float delta;

	/**
    * AntMove construtor
    * @param ant is the ant that will transverse the edge
    * @param move is the destination node
    * @param sim is the Simulation Object
    * @param time is the time at which the event AntMove has occured
    */
	
	public AntMove(Ant ant, int move, Simulation sim, double time) {
		super(time);
		this.ant = ant;
		this.next = move;
		this.sim = sim;
	}
	
	/**
    * Execution of the Event AntMove. Verifies if a hamiltonian cycle was found; 
    * if not, verifies if an inner cycle was found and makes the needed instructions. 
    * If not, inserts the node to the path.
    * @return timestamp is the time at which this Event was triggered
    */
	
	@Override
	public double executeEvent() {
		
		double time;
		//if path is an Hamiltonian cycle
		if(next == sim.getNest() && ant.getPath().getLength() == sim.getGraph().getSizeNodes()) {
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
				
				if(cost != 0)
				{
					try {
						if(sim.getGraph().getEdgePayload(aux1, aux2) == 0)
						{
							time = this.timestamp + expRandom(Evaporate.getEta());
							if (time <= sim.getFinalInst())
								sim.getPec().addEvPEC(new Evaporate(aux1, aux2, sim, time));		
						}
						sim.getGraph().addEdgePayload(aux1, aux2, sim.getpLevel() * sim.getGraph().getGraphWeight() / ( cost )  );
					} catch (NoEdgeException e) {
						System.out.println(e);
						System.exit(-1);
					}
				}
				else
				{
					System.out.println("Error: Divisor <Cost of cycle> is equal to zero");
					System.exit(-1);
				}
			
							
			} while(ant.getPath().getLast() != next);
				
			ant.getPath().resetPath(next);
		} //inner cycle found, roll-back
		else if (ant.getPath().findWaypoint(next) ) {
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
		int move;
		try {
			move = ant.chooseNext(ant.getPath(), sim.getGraph());
			time = getTime(move);	
			if (time <= sim.getFinalInst()) 
				sim.getPec().addEvPEC(new AntMove(ant, move, sim, time));
		} catch (NextMoveNotFoundException e) {
			System.out.println(e);
			System.exit(-1);
		}
	
		return this.timestamp;
	}
	
	/**
    * Gets the time that the ant takes to traverse an edge between the two nodes
    * @return a <code> double </code> specifying
    * the time
    */
	
	public double getTime(int move) {
		double time = 0;
		try {
			time = this.timestamp + expRandom(delta *sim.getGraph().getEdgeWeight(ant.getPath().getLast(), move));
		} catch (NoEdgeException e) {
			System.out.println(e);
			System.exit(-1);
		}
		 return time;
		
	}

	/**
    * Gets the delta parameter that defines how many time an ant takes to traverse an edge
    * @return a <code> float </code> specifying
    * the delta parameter
    */
	
	public static float getDelta() {
		return delta;
	}

	
	/**
    * Sets the delta parameter
    * @param delta is the delta parameter to be set
    */
	
	public static void setDelta(float delta) {
		AntMove.delta = delta;
	}

}
