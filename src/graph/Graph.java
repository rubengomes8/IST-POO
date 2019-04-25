package graph;

public class Graph implements Graphs {
	
	private Edge[][] adj;
	private int nNodes;
	private int[] nEdge;
	private double graphWeight;
	
	
	public Graph(int size) {
		super();	
		adj = new Edge[size][size];
		this.nNodes = size;
		this.nEdge = new int[size+1];
	}
	
	public void addEdge(int node1, int node2, double weight) {
		
		adj[node1-1][node2-1] = new Edge(node1, node2, weight);
		adj[node2-1][node1-1] = adj[node1-1][node2-1] ;
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
		
		if (adj[node1-1][node2-1] == null ) {
			//TODO: throw exception
			System.out.println("adjacency doesn't exist");
			return -1;
		}
		else 
			return adj[node1-1][node2-1].getWeight();
	}
	
	public double getEdgePayload(int node1, int node2) {
		if (adj[node1-1][node2-1] == null) {
			//TODO: throw exception
			System.out.println("adjacency doesn't exist");
			return -1;
		}
		else
			return adj[node1-1][node2-1].getPayload();
	}
	
	public void addEdgePayload(int node1, int node2, double payload) {
		adj[node1-1][node2-1].addPayload(payload);
	}
	
	public String printEdges(int node) {
		
		StringBuilder txt = new StringBuilder();
		for (int i = 0; i < nNodes; i++) {
			if (adj[node][i] == null) continue;
			txt.append((adj[node][i]) + " ");
		}
		return txt.toString();
	}
	
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

