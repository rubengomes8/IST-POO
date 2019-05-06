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

}
