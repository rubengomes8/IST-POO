package simulation;

import simulation.Ant;
import graph.Path;

public class Simulation {
	
	protected float finalInst;
	protected int antColSize;
	protected float pLevel;
	
	Ant[] antColony;	
	Path bestHamiltonianCycle;

		
	public float getFinalInst() {
		return finalInst;
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

}