package simulation;

import pec.PECs;

/**
 *
 * This is an abstract class that holds the generic information about a simulator implemented with a PEC (instant and PEC)
 * and implements the interface Simulator.java
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public abstract class SimulatorAbs implements Simulator {

	/**
	 * current instant of the simulation
	 */
	protected double instant;
	/**
	 * pending event container
	 */
	protected PECs pec;

}
