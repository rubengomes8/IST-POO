package simulation;

import parsing.SimulationParser;

/**
 * Run.java
 * This is the main class.
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class Run {

	/**
    	* Verifies if the xml is given as an input argument. Begins the parsing of the xml and the simulation.
   	*/
	
	public static void main(String[] args) {
			
		if(args.length == 0)
		{
			System.out.println("Missing xml file... Exiting...");
			System.exit(0);
		}
		
		Simulation sim = new Simulation();
		SimulationParser simPars = new SimulationParser(args[0],sim);		
		sim.beginSimulation();

		System.exit(1);
	}

}
