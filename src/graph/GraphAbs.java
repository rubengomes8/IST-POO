package graph;

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
	
	@Override
	public abstract int getSizeEdges();
	
	@Override
	public abstract int getSizeEdges(int node); 
	
	/**
    * Sets the number of nodes of the graph 
    * @param nNodes is the number of nodes to be set
    */
	
	@Override
	public void setnNodes(int nNodes) {
		this.nNodes = nNodes;
	}
	
	@Override
	public abstract double getEdgeWeight(int node1, int node2) throws NoEdgeException;
	
	@Override
	public abstract double getEdgePayload(int node1, int node2) throws NoEdgeException;
	
	@Override
	public abstract void addEdgePayload(int node1, int node2, double payload) throws NoEdgeException;
	
	@Override
	public abstract String printEdges(int node);
	
	@Override
	public abstract int[] returnEdges(int node);
}
