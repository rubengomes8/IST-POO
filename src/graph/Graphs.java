package graph;

public interface Graphs {

	public void addEdge(int node1, int node2, double weight);
	
	public double getGraphWeight();
	
	public int getSizeNodes();
	
	public int getSizeEdges();
	
	public int getnNodes();
	
	public void setnNodes(int nNodes);
	
	public double getEdgeWeight(int node1, int node2);
	
	public double getEdgePayload(int node1, int node2);
	
	public void addEdgePayload(int node1, int node2, double payload);
	
	public String printEdges(int node);
	
	
}
