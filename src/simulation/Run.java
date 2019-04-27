package simulation;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import parsing.SimulationParser;

public class Run {

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
