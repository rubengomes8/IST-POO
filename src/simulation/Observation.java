package simulation;

import pec.Event;

public class Observation extends Event{
	
	Simulation sim;

	public Observation(int n, Simulation sim) {
		super(n * sim.getFinalInst()/20);
		this.sim = sim;
	}

	@Override
	public void executeEvent() {
		
		System.out.println("Observation " + timestamp + "\n");
		System.out.println("	Present instant: " + sim.getInst() );
		System.out.println("	Number of move events: " + sim.getMoveCounter() );
		System.out.println("	Number of evaporation events: " + sim.getEvapCounter() );
		System.out.println("	Hamiltonian cycle: " + sim.printBestCycle() );
	}
}
