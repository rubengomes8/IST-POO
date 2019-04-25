package simulation;

import pec.Event;


public class Evaporate extends Event{

	
	int node1;
	int node2;
	double pheromone;
	Simulation sim;
	
	protected static float rho;
	protected static float eta;

	public Evaporate(int node1,int node2, Simulation sim, double time) {
		super(time);
		this.sim = sim;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	@Override
	public double executeEvent() {
		
		if ( sim.getGraph().getEdgePayload(node1, node2) < rho) {
			sim.getGraph().addEdgePayload(node1, node2, -1 * sim.getGraph().getEdgePayload(node1, node2));
		}
		else
			sim.getGraph().addEdgePayload(node1, node2,-rho);
		sim.incrementEvapCounter();
		
		return this.timestamp;
	}

	public static float getRho() {
		return rho;
	}

	public static void setRho(float rho) {
		Evaporate.rho = rho;
	}
	
	public static float getEta() {
		return eta;
	}

	public static void setEta(float eta) {
		Evaporate.eta = eta;
	}
}
