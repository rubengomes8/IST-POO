package simulation;

import pec.PECs;

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
	
	public PECs getPec();
	
	public void setPec(PECs pec);
	
	public double getInst();

	public void setInst(float instant);
	
	public double getFinalInst();
	
	public void setFinalInst(float finalInst);
	
}
