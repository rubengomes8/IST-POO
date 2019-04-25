package simulation;


import graph.Graphs;
import graph.Path;
import graph.Paths;
import pec.PEC;
import static utilities.Utilities.*;

public class Simulation {
	
	protected double finalInst;
	protected int antColSize;
	protected double pLevel;
	protected double instant;
	protected int mevents;
	protected int eevents;
	protected int nest;

	protected Ant[] antColony;	
	protected Paths bestHamiltonianCycle;
	protected PEC pec;
	protected Graphs graph;

	public double getFinalInst() {
		return finalInst;
	}
	
	public void beginSimulation() {
		
		antColony = new Ant[antColSize];	
		pec = new PEC();
		bestHamiltonianCycle = new Path(graph);
		bestHamiltonianCycle.setCost(Double.POSITIVE_INFINITY);
		
		double times;
		int firstMove;
		// Schedules observer events
		for(int i = 1; i < 21;i++) {
			pec.addEvPEC(new Observation(i,this));
		}
		//Schedules first moves
		for(int i = 0 ; i < getAntColSize(); i++) {
			// create all ants, put them all in the nest and schedule move
			antColony[i] = new Ant(i, getNest(),graph);
			
			firstMove = antColony[i].chooseNext(antColony[i].getPath(), graph);
			
			times = expRandom(AntMove.getDelta() * graph.getEdgeWeight(antColony[i].getPath().getLast(), firstMove));
			
			pec.addEvPEC(new AntMove(antColony[i],firstMove, this, times));
		}
		while(pec.queuePEC() > 0)
			instant = pec.nextEvPEC().executeEvent();
		return;
	}
	
	public PEC getPec() {
		return pec;
	}

	public void setPec(PEC pec) {
		this.pec = pec;
	}

	public double getInst() {
		return instant;
	}
	public void setInst(float instant) {
		this.instant = instant;
	}
	
	public int getMoveCounter() {
		return mevents;
	}
	
	public void incrementMoveCounter() {
		this.mevents++;;
	}
	
	public int getEvapCounter() {
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
	
	public double getpLevel() {
		return pLevel;
	}
	
	public void setpLevel(float pLevel) {
		this.pLevel = pLevel;
	}	
	
	public String printBestCycle() {
		return this.bestHamiltonianCycle.getPath();
	}
	
	public void replaceCycle(Paths path) {
		this.bestHamiltonianCycle =  new Path((Path) path);
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