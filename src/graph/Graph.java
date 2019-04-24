package graph;

public class Graph implements Graphs {
	
	private Edge[][] adj;
	private int nNodes;
	private int[] nEdge;
	private double graphWeight;
	
	
	public Graph(int size) {
		super();	
		adj = new Edge[nNodes][nNodes];
		this.nNodes = size;
		this.nEdge = new int[size+1];
	}
	
	public void addEdge(int node1, int node2, double weight) {
		
		adj[node1][node2] = new Edge(node1, node2, weight);
		adj[node2][node1] = adj[node1][node2] ;
		// updates edge counter
		nEdge[node1]++;
		nEdge[node2]++;
		nEdge[0]++;
		graphWeight+=weight;
	}
	
	public double getGraphWeight() {
		return graphWeight;
	}

	public int getSizeNodes() {

		return nNodes;
	}
	
	public int getSizeEdges() {
		return nEdge[0];
	}

	public int getnNodes() {
		return nNodes;
	}

	public void setnNodes(int nNodes) {
		this.nNodes = nNodes;
	}
	
	public double getEdgeWeight(int node1, int node2) {
		
		if (adj[node1][node2] == null ) {
			//TODO: throw exception
			return -1;
		}
		else 
			return adj[node1][node2].getWeight();
	}
	
	public double getEdgePayload(int node1, int node2) {
		if (adj[node1][node2] == null) {
			//TODO: throw exception
			return -1;
		}
		else
			return adj[node1][node2].getPayload();
	}
	
	public void addEdgePayload(int node1, int node2, double payload) {
		adj[node1][node2].addPayload(payload);
	}
	
	public String printEdges(int node) {
		
		StringBuilder txt = new StringBuilder();
		for (int i = 0; i < nNodes; i++) {
			 txt.append((adj[node][i]));
		}
		return txt.toString();
	}
}

