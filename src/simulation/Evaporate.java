package simulation;

import static utilities.Utilities.expRandom;

import graph.NoEdgeException;
import pec.Event;

/**
 * This is a subclass of Event representing a evaporation of pheromones of an Edge.
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */


public class Evaporate extends Event{

	/**
	 * node that defines an extreme of the edge to be evaporated
	 */
	private int node1;
	/**
	 * node that defines an extreme of the edge to be evaporated
	 */
	private int node2;
	/**
	 * simulation associated to the program
	 */
	private Simulation sim;
	/**
	 * parameter that defines the amount of pheromones evaporated
	 */
	protected static float rho;
	/**
	 * parameter that defines the time of the next evaporation
	 */
	protected static float eta;

	/**
	    * Evaporation constructor. 
	    * @param node1 is one extreme of the edge to be evaporated
	    * @param node2 is another extreme of the edge to be evaporated
	    * @param sim is the Simulation Object
	    * @param time is the time at which the evaporation has occured 
	    */

	
	public Evaporate(int node1,int node2, Simulation sim, double time) {
		super(time);
		this.sim = sim;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	
	/* *Execution of the Event Evaporate. Decreases the pheromone level of the Edge by rho units.
	    * @return timestamp is the time at which this Event was triggered
	    */
	@Override
	public double executeEvent() {
		
		try {
			if ( sim.getGraph().getEdgePayload(node1, node2) <= rho) {
				sim.getGraph().addEdgePayload(node1, node2, -1 * sim.getGraph().getEdgePayload(node1, node2));
			}
			else
			{
				sim.getGraph().addEdgePayload(node1, node2, -rho);
				double time = this.timestamp + expRandom(Evaporate.getEta());
				if (time <= sim.getFinalInst())
					sim.getPec().addEvPEC(new Evaporate(node1, node2, sim, time));	
			}
				
		} catch (NoEdgeException e) {
			System.exit(-1);
		}
		sim.incrementEvapCounter();
		
		return this.timestamp;
	}

	/**
    * Gets the rho parameter that defines the decrease size of the pheromone level in each evaporation.
    * @return a <code> float </code> specifying
    * the rho parameter
    */
	
	public static float getRho() {
		return rho;
	}

	/**
    * Sets the rho parameter
    * @param rho is the rho parameter to be set
    */
	public static void setRho(float rho) {
		Evaporate.rho = rho;
	}
	
	/**
    * Gets the eta parameter that defines the time between evaporations.
    * @return a <code> float </code> specifying
    * the rho parameter
    */
	
	public static float getEta() {
		return eta;
	}

	/**
    * Sets the eta parameter
    * @param eta is the eta parameter to be set
    */
	public static void setEta(float eta) {
		Evaporate.eta = eta;
	}
}
