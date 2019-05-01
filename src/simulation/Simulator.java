package simulation;

import pec.PEC;

/**
 * 
 * Simulator.java
 * Interface class that describes a simultor 
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public interface Simulator {

	public void beginSimulation();
	
	public PEC getPec();
	
	public void setPec(PEC pec);
	
	public double getInst();

	public void setInst(float instant);
	
	public double getFinalInst();
	
	public void setFinalInst(float finalInst);
	
}
