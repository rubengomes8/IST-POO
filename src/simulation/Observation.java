package simulation;

import pec.Event;

public class Observation extends Event{
	
	Simulation sim;
	private int n;

	public Observation(int n, Simulation sim) {
		super(n * sim.getFinalInst()/20);
		this.n = n;
		this.sim = sim;
	}

	@Override
	public double executeEvent() {
		
		System.out.println("Observation " + n);
		System.out.println("	Present instant: " + sim.getInst() );
		System.out.println("	Number of move events: " + sim.getMoveCounter() );
		System.out.println("	Number of evaporation events: " + sim.getEvapCounter() );
		System.out.println("	Hamiltonian cycle: " + sim.printBestCycle() + "\n");
		
		return this.timestamp;
	}
}
