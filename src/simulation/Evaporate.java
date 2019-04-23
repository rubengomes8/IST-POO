package simulation;

import graph.Edge;
import pec.Event;

public class Evaporate extends Event{

	protected static float eta;
	protected static float rho;
	
	Edge edge;
	double pheromone;


	public Evaporate(double timestamp, Edge edge, double pheromone) {
		super(timestamp);
		this.edge = edge;
		this.pheromone = pheromone;
	}
	
	@Override
	public void executeEvent() {
		
		edge.updatePaylod(pheromone + edge.getPayload() );
		
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
