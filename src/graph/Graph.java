package graph;


/**
 * Graph.java
 * This is a model class to hold graph information
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class Graph extends GraphAbs {
	
	private Edge[][] adj;
	private int[] nEdge;
	
	/**
    * Graph constructor. 
    * @param size is the number of nodes of the graph
    */
	public Graph(int size) {
		super(size);
		adj = new Edge[size][size];
		this.nEdge = new int[size+1];
	}
	
	/**
    * Adds an edge to the graph between two nodes with a given weight
    * @param node1 is one of the nodes
    * @param node2 is the other node
    * @param weight is the weight of the edge
    */
	
	@Override
	public void addEdge(int node1, int node2, double weight) {
		if(adj[node1-1][node2-1] == null)
		{
			adj[node1-1][node2-1] = new Edge(node1, node2, weight);
			adj[node2-1][node1-1] = adj[node1-1][node2-1] ;
			// updates edge counter
			nEdge[node1]++;
			nEdge[node2]++;
			nEdge[0]++;
			graphWeight+=weight;
		}	
	}
	
	
	/**
    * Gets the number of edges of the graph
    * @return an <code> int </code> specifying
    * the number of edges of the graph
    */
	
	@Override
	public int getSizeEdges() {
		return nEdge[0];
	}
	
	
	/**
    * Gets the number of adjacents of a given node
    * @return an <code> int </code> specifying
    * the number of adjacents of a given node
    */
	@Override
	public int getSizeEdges(int node) {
		return nEdge[node];
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
    * Gets the weight of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @return the value returned is a <code> double </code> specifying
    * the weight of the edge
    */
	@Override
	public double getEdgeWeight(int node1, int node2) throws NoEdgeException{
		
		if (adj[node1-1][node2-1] == null ) throw new NoEdgeException();
		return adj[node1-1][node2-1].getWeight();
	}
	
	/**
    * Gets the level of pheromones of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @return the value returned is a <code> double </code> specifying
    * the level of pheromones of the edge
    */
	@Override
	public double getEdgePayload(int node1, int node2) throws NoEdgeException{
		
	
		if (adj[node1-1][node2-1] == null) throw new NoEdgeException();
		return adj[node1-1][node2-1].getPayload();
		
	}
	
	/**
    * Adds the level of pheromones of an edge between two nodes of the graph
    * @param node1 is one of the two nodes
    * @param node2 is the other node
    * @param payload is the level of pheromones
    */
	@Override
	public void addEdgePayload(int node1, int node2, double payload) throws NoEdgeException{
		
		if(adj[node1-1][node2-1] == null) throw new NoEdgeException();
		adj[node1-1][node2-1].addPayload(payload);
	}
	
	/**
    * Prints the edges linked to one node
    * @param node is the node whose edges will be printed
    * @return a String to be printed with the information of the edges.
    */
	@Override
	public String printEdges(int node) {
		
		StringBuilder txt = new StringBuilder();
		for (int i = 0; i < nNodes; i++) {
			if (adj[node][i] == null) continue;
			txt.append((adj[node][i]) + " ");
		}
		return txt.toString();
	}
	
	/**
    * Gets the nodes that are adjacent to a given node
    * @param node is the node of whose adjacent nodes will be returned
    * @return an array of int with the nodes that are adjacent to the given node
    */
	@Override
	public int[] returnEdges(int node) {
		
		int[] ends;
		int[] adjacents = new int[nEdge[node]];
		int cnt = 0;
		
		for (int i = 0 ; i < nNodes;i++) {
			if (adj[node-1][i] == null) continue;
			
			ends = adj[node-1][i].getNodes();
			// one of the ends of the Edge is *node* !
			adjacents[cnt] = (ends[0] == node ? ends[1]:ends[0]);
			cnt++;
		}
		
		return adjacents;
	}
}

