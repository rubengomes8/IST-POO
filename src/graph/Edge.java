package graph;

public class Edge {
	
    private int node1;
    private int node2;
    private double weight;
    private double payload;
    
	public Edge(int node1, int node2, double weight) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
		this.payload = 0;
	}	
	
	public int[] getNodes() {
		int[] aux = new int[2];		
		aux[0] = node1;
		aux[1] = node2;
		return aux;
	}
	
	public boolean isEnd(int id) {
		
		return ((id == node1 || id == node2) ? true : false);
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getPayload() {
		return payload;
	}
	
	public void updatePaylod(double payload) {
		this.payload+= payload;
	}

	@Override
	public String toString() {
		return "Edge [node1=" + node1 + ", node2=" + node2 + ", weight=" + weight + ", payload=" + payload + "]";
	}
	
	

}
