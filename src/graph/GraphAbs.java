package graph;


/**
* 
* This is an abstract class that holds the generic information about a Graph (nNodes, graphWeight)
* and implements the interface Graphs.java
* @author John Mendonça, Manuel Domingues, Rúben Gomes
*/

public abstract class GraphAbs implements Graphs{

	/**
	 * number of nodes in the graph
	 */
	protected int nNodes;
	/**
	 * total weight of the graph
	 */
	protected double graphWeight;
	
	/**
    * GraphAbs constructor. 
    * @param nNodes is the of nodes of the graph
    */
	public GraphAbs(int nNodes) {
		this.nNodes = nNodes;
	}
	
	
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
	
	
}
