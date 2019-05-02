package graph;

/**
 * 
 * Interface class that describes a graph composed by weighted edges and nodes
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public interface Graphs {

	/**
    * Adds an edge to the graph between two nodes with a given weight
    * @param node1 is one of the nodes
    * @param node2 is the other node
    * @param weight is the weight of the edge
    */
	public void addEdge(int node1, int node2, double weight);
	
	/**
    * Gets the total weight of the graph 
    * @return a <code> double </code> specifying
    * the weight of the graph
    */
	public double getGraphWeight();
	
	/**
    * Gets the number of nodes of the graph
    * @return an <code> int </code> specifying
    * the number of nodes of the graph
    */
	public int getSizeNodes();
	
	/**
    * Gets the number of edges of the graph
    * @return an <code> int </code> specifying
    * the number of edges of the graph
    */
	public int getSizeEdges();
	
	
	/**
    * Gets the number of adjacents of a given node
    * @return an <code> int </code> specifying
    * the number of adjacents of a given node
    */
	public int getSizeEdges(int node); 
	
	/**
    * Sets the number of nodes of the graph 
    * @param nNodes is the number of nodes to be set
    */
	
	public void setnNodes(int nNodes);
	
	/**
    * Gets the weight of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @throws NoEdgeException
    * @return the value returned is a <code> double </code> specifying
    * the weight of the edge
    */
	public double getEdgeWeight(int node1, int node2) throws NoEdgeException;
	
	
	/**
    * Gets the level of pheromones of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @throws NoEdgeException
    * @return the value returned is a <code> double </code> specifying
    * the level of pheromones of the edge
    */
	public double getEdgePayload(int node1, int node2) throws NoEdgeException;
	
	/**
    * Adds the level of pheromones of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @param payload is the level of pheromones
    */
	public void addEdgePayload(int node1, int node2, double payload) throws NoEdgeException;
	
	/**
    * Prints the edges linked to one node
    * @param node is the node whose edges will be printed
    * @return a String to be printed with the information of the edges.
    */
	public String printEdges(int node);
	
	
	/**
    * Gets the nodes that are adjacent to a given node
    * @param node is the node of whose adjacent nodes will be returned
    * @return an array of int with the nodes that are adjacent to the given node
    */
	public int[] returnEdges(int node);
	
	
}
