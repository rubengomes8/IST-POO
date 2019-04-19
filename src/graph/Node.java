package graph;


public class Node {
	
	private Edge[] adjacent;
	private int id;
	private int nAdj;

	
	public Node(int id) {
		super();	
		this.id = id;
	}
	
	public double getPayload(int adj) {
		for (int i = 0; i < nAdj ; i++) {
			if (adjacent[i].isEnd(adj))
				return adjacent[i].getPayload();
		}
		return -1;
	}
	
	public void updateEdgePayload(int adj, double payload) {
		for (int i = 0; i < nAdj ; i++) {
			if (adjacent[i].isEnd(adj))
				adjacent[i].updatePaylod(payload);
		}
		System.out.println("Edge doesn't exist!");
		System.exit(-1);
	}
	
	public int getID() {
		return id;
	}
	
	public void addAdjacency(Edge[] adj) {
		this.adjacent = adj;
	}
	
	public Edge[] getAdjacents() {
		
		return adjacent;
	}
	
	public double getWeight(int adjacent) {
		
		for (int i = 0; i < nAdj ; i++) {
			if (this.adjacent[i].isEnd(adjacent))
					return this.adjacent[i].getWeight();
		}
		return -1;
	}
	
}

