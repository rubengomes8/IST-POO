package simulation;


import graph.Graphs;
import graph.Path;
import graph.Paths;
import pec.PEC;
import static utilities.Utilities.*;

/**
 * Simulation.java
 * This is a model class that holds the information about the simulation (parameters, ant colony, pending event container, graph...)
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

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
			antColony[i] = new Ant(i, getNest(), graph);
			
			firstMove = antColony[i].chooseNext(antColony[i].getPath(), graph);
			
			times = expRandom(AntMove.getDelta() * graph.getEdgeWeight(antColony[i].getPath().getLast(), firstMove));
			
			pec.addEvPEC(new AntMove(antColony[i],firstMove, this, times));
		}
		
		while(pec.queuePEC() > 0)
			instant = pec.nextEvPEC().executeEvent();
		return;
	}
	
	/**
    * Gets the pending event container
    * @return a <code> PEC </code> specifying
    * the pec.
    */
	
	public PEC getPec() {
		return pec;
	}

	/**
    * Sets the pending event container parameter
    * @param pec is the pending event container to be set
    */
	public void setPec(PEC pec) {
		this.pec = pec;
	}

	/**
    * Gets the current instant of the simulation
    * @return a <code> double </code> specifying
    * the current instant.
    */
	public double getInst() {
		return instant;
	}
	
	/**
    * Sets the current instant of the simulation
    * @param instant is the current instant of the simulation to be set
    */
	public void setInst(float instant) {
		this.instant = instant;
	}
	
	/**
    * Gets the number of move events that have been occured
    * @return an <code> int </code> specifying
    * the number of move events.
    */
	public int getMoveCounter() {
		return mevents;
	}
	
	/**
    * Increments the number of move events that have been occured
    */
	public void incrementMoveCounter() {
		this.mevents++;;
	}
	
	/**
    * Gets the number of evaporation events that have been occured
    * @return an <code> int </code> specifying
    * the number of evaporation events.
    */
	public int getEvapCounter() {
		return eevents;
	}
	
	/**
    * Increments the number of evaporation events that have been occured
    */
	public void incrementEvapCounter() {
		this.eevents++;;
	}
	
	/**
    * Gets the final instant of the simulation
    * @return a <code> double </code> specifying
    * the final instant
    */
	public double getFinalInst() {
		return finalInst;
	}
	
	/**
    * Sets the final instant of the simulation
    * @param finalInst is the final instant of the simulation to be set
    */
	public void setFinalInst(float finalInst) {
		this.finalInst = finalInst;
	}
	
	/**
    * Gets the number of ants that belongs to the ant colony
    * @return a <code> int </code> specifying
    * the number of ants
    */
	public int getAntColSize() {
		return antColSize;
	}
	
	/**
    * Sets the number of ants that belongs to the ant colony
    * @param antColSize is the number of ants to be set
    */
	public void setAntColSize(int antColSize) {
		this.antColSize = antColSize;
	}
	
	/**
    * Gets the pheromone level.
    * @return a <code> double </code> specifying
    * the pheromone level
    */
	public double getpLevel() {
		return pLevel;
	}
	
	/**
    * Sets the pheromone level
    * @param pLevel is the pheromone level to be set
    */
	public void setpLevel(float pLevel) {
		this.pLevel = pLevel;
	}	
	
	/**
    * Prints the best hamiltonian cycle known so far.
    * @return a <code> String </code> specifying
    * the best hamiltonian cycle
    */
	public String printBestCycle() {
		return this.bestHamiltonianCycle.getPath();
	}
	
	/**
    * Replaces the best hamiltonian cycle by a given path.
    * @param path is the path that will replace the best hamiltonian cycle
    */
	public void replaceCycle(Paths path) {
		this.bestHamiltonianCycle =  new Path((Path) path);
	}
	
	/**
    * Gets the cost associated to the best hamiltonian cycle known so far
    * @return a <code> double </code> specifying
    * the cost.
    */
	public double getBestCost() {
		return this.bestHamiltonianCycle.getCost();
	}

	/**
    * Gets the graph of the simulation
    * @return a <code> Graphs </code> specifying
    * the graph.
    */
	public Graphs getGraph() {
		return graph;
	}

	/**
    * Sets the graph of the simulation
    * @param graph is the graph to be set
    */
	public void setGraph(Graphs graph) {
		this.graph = graph;
	}
	
	
	/**
    * Gets the nest node of the graph
    * @return a <code> int </code> that represents
    * the nest node identifier.
    */
	
	public int getNest() {
		return nest;
	}

	/**
    * Sets the nest node of the graph
    * @param nest is the nest node to be set
    */
	public void setNest(int nest) {
		this.nest = nest;
	}
}
