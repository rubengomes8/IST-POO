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
import graph.NodeWithoutTwoEdgesException;
import simulation.Ant;
import simulation.AntMove;
import simulation.Evaporate;
import simulation.Simulation;

/**
 * This is a class to get the parameters of the simulation from the input xml file.
 * This is a subclass of DefaultHandler
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class SimulationParser extends DefaultHandler {
	private String xmlFileName;
	private Simulation sim = new Simulation();
	private int nodeidx;
	private int target;
	private double weight;
	private Graphs graph;
	private String tmpValue;
	
	/**
	 * Parsing a xml file and store the information in variables. If it is detected that it is impossible to build a hamiltonian cycle, it aborts.
	 * @param xmlFileName is the name of the xml file to be parsed
	 * @param sim is the Simulation instance
	 */
	
	public SimulationParser(String xmlFileName, Simulation sim) 
	{
		this.xmlFileName = xmlFileName;
		this.sim = sim;	
		parseDocument();
		try {
			this.possibleHamiltonianCycle(graph);
		}catch(NodeWithoutTwoEdgesException e) {
			System.out.println(e);
			System.exit(-1);
		}
		sim.setGraph(graph);
	}
	
	/**
	 * Parsing the xml file if possible. Exit the program if some Exception occurs.
	 */
	private void parseDocument()
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error... Exiting...");
            System.exit(-1);
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed... Exiting...");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("IO error... Exiting...");
            System.exit(-1);
        }
	}
	
	
	/**
	 * Method invoked when the xml parser detects the beginning of an element. 
	 * Validates and stores the parameters and if any parameter has an unexpected value, exits the program.
	 */
	
	@Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
 
        if (elementName.equalsIgnoreCase("simulation")) {
        	float auxf = Float.valueOf(attributes.getValue("finalinst"));
        	if( auxf <= 0) {
        		System.out.println("Final instant must be greater than zero. Exiting...");
                System.exit(-1);
        	}
            sim.setFinalInst(auxf);
            
            int auxi = Integer.valueOf(attributes.getValue("antcolsize"));

            if( auxf <= 0) {
        		System.out.println("Ant colony size must be greater than zero. Exiting...");
                System.exit(-1);
        	}
            sim.setAntColSize(auxi);
            
            
            auxf = Float.valueOf(attributes.getValue("plevel"));
            if( auxf <= 0) {
        		System.out.println("Pheromone level must be greater than zero. Exiting...");
                System.exit(-1);
        	}
            sim.setpLevel(auxf);
            
            //System.out.println("finalinst: " + sim.getFinalInst());
    		//System.out.println("antcolsize: " + sim.getAntColSize());
    		//System.out.println("plevel: " + sim.getpLevel());
    		
        }
        
        if (elementName.equalsIgnoreCase("move")) {
        	Float auxf = Float.valueOf(attributes.getValue("alpha"));
    		Ant.setAlpha(auxf);
    		
    		if( auxf <= 0) {
        		System.out.println("Alpha must be greater than zero. Exiting...");
                System.exit(-1);
        	}
    		
    		auxf = Float.valueOf(attributes.getValue("beta"));
    		Ant.setBeta(auxf);
    		
    		if( auxf <= 0) {
        		System.out.println("Beta must be greater than zero. Exiting...");
                System.exit(-1);
        	}
    		
    		auxf = Float.valueOf(attributes.getValue("delta"));
    		AntMove.setDelta(auxf);
    		
    		if( auxf <= 0) {
        		System.out.println("Delta must be greater than zero. Exiting...");
                System.exit(-1);
        	}
    		
    		
    		
    		//System.out.println("alpha: " + Ant.getAlpha());
    		//System.out.println("beta: " + Ant.getBeta());
    		//System.out.println("delta: " + AntMove.getDelta());
    		
        }
        
        if (elementName.equalsIgnoreCase("evaporation")) {
        	
        	float auxf = Float.valueOf(attributes.getValue("eta"));
            		
    		if( auxf <= 0) {
        		System.out.println("Eta must be greater than zero. Exiting...");
                System.exit(-1);
    		}
    		
    		Evaporate.setEta(auxf);
    		
    		auxf = Float.valueOf(attributes.getValue("rho"));
    		
    		if( auxf <= 0) {
        		System.out.println("Rho must be greater than zero. Exiting...");
                System.exit(-1);
    		}
    		
    		Evaporate.setRho(auxf);
    		//System.out.println("eta: " + Evaporate.getEta());
    		//System.out.print2---3.0---ln("rho: " + Evaporate.getRho());
    		
        }
        
        if(elementName.equalsIgnoreCase("graph"))
        {
        	int nbnodes = Integer.valueOf(attributes.getValue("nbnodes"));
        	
        	if(nbnodes <= 1) {
        		System.out.println("Number of nodes must be greater than 1. Exiting...");
                System.exit(-1);
        	}

        	graph = new Graph(nbnodes);
        	
        	
        	int nestnode = Integer.valueOf(attributes.getValue("nestnode"));
        	
        	if(nestnode < 1 || nestnode > nbnodes)
        	{
        		System.out.println("Nest node must be between 1 and number of nodes. Exiting...");
                System.exit(-1);
        	}
        	sim.setNest(nestnode);
        	//System.out.println("nbnodes: " + nbnodes);
        	//System.out.println("nestnode: " + nestnode);
        }	
        
        if (elementName.equalsIgnoreCase("node")) {
        	
        	nodeidx = Integer.valueOf(attributes.getValue("nodeidx"));
        	
        	if(nodeidx < 1 || nodeidx > graph.getSizeNodes())
        	{
        		System.out.println("Node must be between 1 and number of nodes. Exiting...");
                System.exit(-1);
        	}
			//System.out.println("nodeidx: " + nodeidx);
		
        }
        
        if(elementName.equalsIgnoreCase("weight"))
        {
        	target = Integer.valueOf(attributes.getValue("targetnode"));
        	
        	if(target < 1 || target > graph.getSizeNodes())
        	{
        		System.out.println("Target node must be between 1 and number of nodes. Exiting...");
                System.exit(-1);
        	}
        }
    }
	
	/**
	 * Method invoked when the xml parser detects the end of an element. 
	 * Validates and stores the weight of an edge. Exits if the weight is not positive.
	 */
	
	@Override
    public void endElement(String s, String s1, String element) throws SAXException {
        // if end of book element add to list
        if (element.equals("weight")) {
        	weight = Double.parseDouble(tmpValue);
        	if(weight > 0)
        	{
        		//System.out.println("New edge: " + nodeidx + "---" + weight + "---" + target);
                graph.addEdge(nodeidx, target, weight);
        	}
        	else
        	{
        		System.out.println("All edge weights must be positive! Exiting...");
        		System.exit(-1);
        	}
        	
            
        }
    }
	
	/**
	 * Obtains the value of an element to the String tmpValue.
	 */
	@Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
	
	/**
	 * Checks within a graph if there is at least one node that contains less than 2 adjacent nodes.
	 * @param graph is the graph whose nodes are checked.
	 * @throws NodeWithoutTwoEdgesException thrown when a node of the graph contains less than 2 adjacent nodes
	 */
	public void possibleHamiltonianCycle(Graphs graph) throws NodeWithoutTwoEdgesException
	{
		
		for(int i = 1; i <= graph.getSizeNodes(); i++)
		{
			if(graph.getSizeEdges(i) <= 1 && graph.getSizeNodes() > 2)
				throw new NodeWithoutTwoEdgesException();
			
		}
	}
	
	
}
