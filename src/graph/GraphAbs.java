package graph;


/**
* This is an abstract class that holds the generic information about a Graph (nNodes, graphWeight)
* and implements the interface Graphs.java
* @author John Mendonça, Manuel Domingues, Rúben Gomes
* @since 04-26-2019
*/

public abstract class GraphAbs implements Graphs{

	protected int nNodes;
	protected double graphWeight;
	
	
	public GraphAbs(int nNodes) {
		this.nNodes = nNodes;
	}
	
	@Override
	public abstract void addEdge(int node1, int node2, double weight);
	
	/**
    * Gets the total weight of the graph 
    * @return a <code> double </code> specifying
    * the weight of the graph
    */
	
	@Override
	public double getGraphWeight() {
		return graphWeight;
	}

	/**
    * Gets the number of nodes of the graph
    * @return an <code> int </code> specifying
    * the number of nodes of the graph
    */
	
	@Override
	public int getSizeNodes()
	{
		return nNodes;
	}
	
	/**
    * Sets the number of nodes of the graph 
    * @param nNodes is the number of nodes to be set
    */
	@Override
	public void setnNodes(int nNodes) {
		this.nNodes = nNodes;
	}
	
	/**
    * Gets the number of edges of the graph
    * @return an <code> int </code> specifying
    * the number of edges of the graph
    */
	@Override
	public abstract int getSizeEdges();
	
	/**
    * Gets the number of adjacents of a given node
    * @return an <code> int </code> specifying
    * the number of adjacents of a given node
    */
	@Override
	public abstract int getSizeEdges(int node); 
	
	/**
    * Gets the weight of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @throws NoEdgeException
    * @return the value returned is a <code> double </code> specifying
    * the weight of the edge
    */
	@Override
	public abstract double getEdgeWeight(int node1, int node2) throws NoEdgeException;
	
	/**
    * Gets the level of pheromones of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @throws NoEdgeException
    * @return the value returned is a <code> double </code> specifying
    * the level of pheromones of the edge
    */
	@Override
	public abstract double getEdgePayload(int node1, int node2) throws NoEdgeException;
	
	
	/**
    * Adds the level of pheromones of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @param payload is the level of pheromones
    */
	@Override
	public abstract void addEdgePayload(int node1, int node2, double payload) throws NoEdgeException;
	
	/**
    * Prints the edges linked to one node
    * @param node is the node whose edges will be printed
    * @return a String to be printed with the information of the edges.
    */
	@Override
	public abstract String printEdges(int node);
	
	
	/**
    * Gets the nodes that are adjacent to a given node
    * @param node is the node of whose adjacent nodes will be returned
    * @return an array of int with the nodes that are adjacent to the given node
    */
	@Override
	public abstract int[] returnEdges(int node);
}
