package simulation;

import graph.Edge;
import pec.Event;

import static utilities.Utilities.*;

public class Evaporate extends Event{

	protected static float eta;
	protected static float rho;
	
	Edge edge;
	double pheromone;
	Simulation sim;

	public Evaporate(Edge edge, Simulation sim) {
		super(sim.getInst() + expRandom(eta));
		this.edge = edge;
		this.sim = sim;
	}
	
	@Override
	public void executeEvent() {
		
		edge.updatePaylod(-rho);
		sim.incrementEvapCounter();
		
	}

	public static float getEta() {
		return eta;
	}

	public static void setEta(float eta) {
		Evaporate.eta = eta;
	}

	public static float getRho() {
		return rho;
	}

	public static void setRho(float rho) {
		Evaporate.rho = rho;
	}
}
