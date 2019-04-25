package simulation;


import graph.Graphs;
import graph.Paths;
import pec.PEC;

public class Simulation {
	
	protected float finalInst;
	protected int antColSize;
	protected float pLevel;
	protected float instant;
	protected int mevents;
	protected int eevents;
	protected int nest;

	protected Ant[] antColony;	
	protected Paths bestHamiltonianCycle;
	protected PEC pec;
	protected Graphs graph;
	

		
	public float getFinalInst() {
		return finalInst;
	}
	
	public void beginSimulation() {
		
		PEC pec = new PEC();
		
		// Schedules observer events
		for(int i = 1; i < 21;i++) {
			pec.addEvPEC(new Observation(i,this));
		}
		//Schedules first moves
		for(int i = 0 ; i < getAntColSize(); i++) {
			// create all ants, put them all in the nest and schedule move
			antColony[i] = new Ant(i, getNest());
			
			pec.addEvPEC(new AntMove(antColony[i],
					antColony[i].chooseNext(antColony[i].path, graph), graph, this));
		}
	}
	
	public float getInst() {
		return instant;
	}
	public void setInst(float instant) {
		this.instant = instant;
	}
	
	public float getMoveCounter() {
		return mevents;
	}
	
	public void incrementMoveCounter() {
		this.mevents++;;
	}
	
	public float getEvapCounter() {
		return eevents;
	}
	
	public void incrementEvapCounter() {
		this.eevents++;;
	}
	
	public void setFinalInst(float finalInst) {
		this.finalInst = finalInst;
	}
	
	public int getAntColSize() {
		return antColSize;
	}
	
	public void setAntColSize(int antColSize) {
		this.antColSize = antColSize;
	}
	
	public float getpLevel() {
		return pLevel;
	}
	
	public void setpLevel(float pLevel) {
		this.pLevel = pLevel;
	}	
	
	public String printBestCycle() {
		
		return this.bestHamiltonianCycle.toString();
	}
	
	public void replaceCycle(Paths path) {
		this.bestHamiltonianCycle = path;
	}
	
	public double getBestCost() {
		return this.bestHamiltonianCycle.getCost();
	}

	public Graphs getGraph() {
		return graph;
	}

	public void setGraph(Graphs graph2) {
		this.graph = graph2;
	}
	
	public int getNest() {
		return nest;
	}

	public void setNest(int nest) {
		this.nest = nest;
	}
}