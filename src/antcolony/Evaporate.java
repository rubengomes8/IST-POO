package antcolony;

import graph.Edge;
import pec.Event;

public class Evaporate extends Event{

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

}
