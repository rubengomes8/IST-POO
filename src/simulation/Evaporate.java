package simulation;

import graph.Graphs;
import pec.Event;

import static utilities.Utilities.*;

public class Evaporate extends Event{

	protected static float eta;
	protected static float rho;
	
	int node1;
	int node2;
	double pheromone;
	Simulation sim;
	Graphs graph;

	public Evaporate(Graphs graph, int node1,int node2, Simulation sim) {
		super(sim.getInst() + expRandom(eta));
		this.graph = graph;
		this.sim = sim;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	@Override
	public void executeEvent() {
		
		if ( graph.getEdgePayload(node1, node2) < rho) {
			graph.addEdgePayload(node1, node2, -1 * graph.getEdgePayload(node1, node2));
		}
		else
			graph.addEdgePayload(node1, node2,-rho);
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
