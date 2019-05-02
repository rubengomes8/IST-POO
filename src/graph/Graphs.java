package graph;

/**
 * 
 * Graphs.java
 * Interface class that describes a graph composed by weighted edges and nodes
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public interface Graphs {

	public void addEdge(int node1, int node2, double weight);
	
	public double getGraphWeight();
	
	public int getSizeNodes();
	
	public int getSizeEdges();
	
	public int getSizeEdges(int node); 
	
	public void setnNodes(int nNodes);
	
	public double getEdgeWeight(int node1, int node2) throws NoEdgeException;
	
	public double getEdgePayload(int node1, int node2) throws NoEdgeException;
	
	public void addEdgePayload(int node1, int node2, double payload) throws NoEdgeException;
	
	public String printEdges(int node);
	
	public int[] returnEdges(int node);
	
	
}
