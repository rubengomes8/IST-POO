package parsing;


import java.io.IOException;
 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import graph.Graph;
import graph.Graphs;
import simulation.Ant;
import simulation.AntMove;
import simulation.Evaporate;
import simulation.Simulation;

/**
 * This is a class to get the parameters of the simulation from the input xml file
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public class SimulationParser extends DefaultHandler {
	String xmlFileName;
	Simulation sim = new Simulation();
	int nodeidx;
	int target;
	double weight;
	Graphs graph;
	String tmpValue;
	
	public SimulationParser(String xmlFileName, Simulation sim) 
	{
		this.xmlFileName = xmlFileName;
		this.sim = sim;	
		parseDocument();	
		sim.setGraph(graph);
	}

	private void parseDocument()
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
	}
	
	@Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
 
        if (elementName.equalsIgnoreCase("simulation")) {
            sim.setFinalInst(Float.valueOf(attributes.getValue("finalinst")));
            sim.setAntColSize(Integer.valueOf(attributes.getValue("antcolsize")));
            sim.setpLevel(Float.valueOf(attributes.getValue("plevel")));
            System.out.println("finalinst: " + sim.getFinalInst());
    		System.out.println("antcolsize: " + sim.getAntColSize());
    		System.out.println("plevel: " + sim.getpLevel());
    		
        }
        
        if (elementName.equalsIgnoreCase("move")) {
    		Ant.setAlpha(Float.valueOf(attributes.getValue("alpha")));
    		Ant.setBeta(Float.valueOf(attributes.getValue("beta")));
    		AntMove.setDelta(Float.valueOf(attributes.getValue("delta")));
    		System.out.println("alpha: " + Ant.getAlpha());
    		System.out.println("beta: " + Ant.getBeta());
    		System.out.println("delta: " + AntMove.getDelta());
    		
        }
        
        if (elementName.equalsIgnoreCase("evaporation")) {
    		Evaporate.setEta(Float.valueOf(attributes.getValue("eta")));
    		Evaporate.setRho(Float.valueOf(attributes.getValue("rho")));
    		System.out.println("eta: " + Evaporate.getEta());
    		System.out.println("rho: " + Evaporate.getRho());
    		
        }
        
        if(elementName.equalsIgnoreCase("graph"))
        {
        	int nbnodes = Integer.valueOf(attributes.getValue("nbnodes"));
        	int nestnode = Integer.valueOf(attributes.getValue("nestnode"));
        	graph = new Graph(nbnodes);
        	sim.setNest(nestnode);
        	System.out.println("nbnodes: " + nbnodes);
        	System.out.println("nestnode: " + nestnode);
        }	
        
        if (elementName.equalsIgnoreCase("node")) {
        	nodeidx = Integer.valueOf(attributes.getValue("nodeidx"));			
			System.out.println("nodeidx: " + nodeidx);
		
        }
        
        if(elementName.equalsIgnoreCase("weight"))
        {
        	target = Integer.valueOf(attributes.getValue("targetnode"));			
        }
    }
	
	@Override
    public void endElement(String s, String s1, String element) throws SAXException {
        // if end of book element add to list
        if (element.equals("weight")) {
        	weight = Double.parseDouble(tmpValue);
        	System.out.println("New edge: " + nodeidx + "---" + weight + "---" + target);
            graph.addEdge(nodeidx, target, weight);
        }
    }
	
	@Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
	
}
