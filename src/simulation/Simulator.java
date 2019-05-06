package simulation;

import pec.PECs;

/**
 * 
 * Interface class that describes a simulator 
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public interface Simulator {
	
	/**
	 * Begins the simulation.
	 */
	public void beginSimulation();
	
	
	/**
    * Gets the PEC of the simulator
    * @return a <code> PECs </code> that represents
    * the PEC
    */
	public PECs getPec();
	
	
	/**
    * Sets the PEC of the simulator
    * @param pec is the PEC to be set
    */
	public void setPec(PECs pec);
	
	/**
    * Gets the current instant of the simulation.
    * @return a <code> double </code> that represents
    * the current instant
    */
	public double getInst();

	/**
    * Sets the current instant of the simulation
    * @param instant is the current instant to be set
    */
	public void setInst(double instant);
	
	/**
    * Gets the final instant of the simulation.
    * @return a <code> double </code> that represents
    * the final instant
    */
	public double getFinalInst();
	
	
	/**
    * Sets the current instant of the simulation
    * @param finalInst is the current instant to be set
    */
	public void setFinalInst(double finalInst);
	
}
