package parsing;
import java.io.FileReader;
import java.util.Arrays;

import javax.xml.parsers.*; // SAX and DOM parsers
import org.xml.sax.*; // Generic API for SAX
import org.xml.sax.helpers.*; // Handlers

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import graph.Graph;
import simulation.AntMove;
import simulation.Evaporate;
import simulation.Simulation;
public class SimulationParser {

	
	public void getSimulationParams(Document doc, Simulation sim)
	{
		
		NodeList nList = doc.getElementsByTagName("simulation");
		Element eElement = (Element) nList.item(0);
		sim.setFinalInst(Float.valueOf(eElement.getAttribute("finalinst")));
		sim.setAntColSize(Integer.valueOf(eElement.getAttribute("antcolsize")));
		sim.setpLevel(Float.valueOf(eElement.getAttribute("plevel")));
		System.out.println("finalinst: " + sim.getFinalInst());
		System.out.println("antcolsize: " + sim.getAntColSize());
		System.out.println("plevel: " + sim.getpLevel());
		
		nList = doc.getElementsByTagName("graph");
		eElement = (Element) nList.item(0);
		Graph graph = new Graph(Integer.valueOf(eElement.getAttribute("nbnodes")), Integer.valueOf(eElement.getAttribute("nestnode")));
		
		//fazer um ciclo para criar os nNodes nós.
		System.out.println("OLA");
		nList = doc.getElementsByTagName("node");
		for(int i = 0; i< nList.getLength(); i++)
		{
			eElement = (Element) nList.item(i);
			int nodeidx = Integer.valueOf(eElement.getAttribute("nodeidx"));
			System.out.println("nodeidx: " + nodeidx);
			NodeList targetNodeList = eElement.getElementsByTagName("weight");
			for(int j = 0; j < targetNodeList.getLength(); j++)		
			{
				Element tn = (Element) targetNodeList.item(j);
				int dest = Integer.parseInt(tn.getAttribute("targetnode"));
				int weight = Integer.parseInt(tn.getTextContent());
				System.out.println("dest: " + dest);
				System.out.println("weight: " + weight);
				
				graph.addEdge(nodeidx, dest, weight);
			}
			System.out.println("\n");
		}
		
		nList = doc.getElementsByTagName("move");
		eElement = (Element) nList.item(0);
		AntMove.setAlpha(Float.valueOf(eElement.getAttribute("alpha")));
		AntMove.setBeta(Float.valueOf(eElement.getAttribute("beta")));
		AntMove.setDelta(Float.valueOf(eElement.getAttribute("delta")));
		System.out.println("alpha: " + AntMove.getAlpha());
		System.out.println("beta: " + AntMove.getBeta());
		System.out.println("delta: " + AntMove.getDelta());
		
		nList = doc.getElementsByTagName("evaporation");
		eElement = (Element) nList.item(0);
		Evaporate.setRho(Float.valueOf(eElement.getAttribute("rho")));
		Evaporate.setEta(Float.valueOf(eElement.getAttribute("eta")));
		System.out.println("rho: " + Evaporate.getRho());
		System.out.println("eta: " + Evaporate.getEta());

		System.out.println(Arrays.toString(graph.getGraphEdges().toArray()));
		
		graph.buildGraph();
		System.out.println(Arrays.toString(graph.getGraph()));
		
		sim.setGraph(graph);
		
	}
}