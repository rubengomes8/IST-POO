package simulation;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

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
			System.out.println("Tem que ter o ficheiro xml de entrada");
			System.exit(0);
		}
		
		SimulationParser simPars = new SimulationParser();
		Simulation sim = new Simulation();
		try
		{
			File xmlFile = new File(args[0]);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			
			simPars.getSimulationParams(doc, sim);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		sim.beginSimulation();
		
		
		System.exit(1);
	}

}
