package simulation;

import pec.Event;

/**
 * This is a subclass of Event responsible for monitorizing the simulation evolution
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public class Observation extends Event{
	/**
	 * simulation associated to the program
	 */
	private Simulation sim;
	/**
	 * number of observation
	 */
	private int n;
	
	/**
    * Observation constructor
    * @param n is an integer that defines the timestamp of the Event
    * @param sim is the simulation Object
    */
	
	public Observation(int n, Simulation sim) {
		super(n * sim.getFinalInst()/20);
		this.n = n;
		this.sim = sim;
	}

	/**
    * Execution of the Event Observation. Prints the information obtained so far during the program execution
    * @return timestamp is the time at which this Event was triggered
    */
	
	@Override
	public double executeEvent() {
		
		System.out.println("Observation " + n + ":");
		System.out.println("	Present instant: " + sim.getInst() );
		System.out.println("	Number of move events: " + sim.getMoveCounter() );
		System.out.println("	Number of evaporation events: " + sim.getEvapCounter() );
		String aux = new String(sim.printBestCycle());
		if (aux.length() <= 1) {
			System.out.println("	{ }");
		}
		else {
			aux = "{" + aux.substring(1, aux.length()-1) + "}";
			System.out.println("	Hamiltonian cycle: " + aux + "\n");
		}
		return this.timestamp;
	}
}
