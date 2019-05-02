package simulation;

import pec.PECs;

/**
 *
 * This is an abstract class that holds the generic information about a simulator implemented with a PEC (instant and PEC)
 * and implements the interface Simulator.java
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public abstract class SimulatorAbs implements Simulator {

	protected double instant;
	protected PECs pec;
	
	/**
	 * Begins the simulation.
	 */
	@Override
	public abstract void beginSimulation();
	
	/**
    * Gets the PEC of the simulator
    * @return a <code> PECs </code> that represents
    * the PEC
    */
	@Override
	public abstract PECs getPec();
	
	/**
    * Sets the PEC of the simulator
    * @param pec is the PEC to be set
    */
	@Override
	public abstract void setPec(PECs pec);
	
	/**
    * Gets the current instant of the simulation.
    * @return a <code> double </code> that represents
    * the current instant
    */
	@Override
	public abstract double getInst();

	/**
    * Sets the current instant of the simulation
    * @param instant is the current instant to be set
    */
	@Override
	public abstract void setInst(double instant);
	
	/**
    * Gets the final instant of the simulation.
    * @return a <code> double </code> that represents
    * the final instant
    */
	@Override
	public abstract double getFinalInst();
	
	/**
    * Sets the current instant of the simulation
    * @param instant is the current instant to be set
    */
	
	@Override
	public abstract void setFinalInst(double finalInst);

}
