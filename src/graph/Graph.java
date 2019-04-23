package graph;

import java.util.LinkedList;

public class Graph {
	
	private Node[] graph;
	private int nNodes;
	private LinkedList<Edge> graphEdges;
	private int[] nEdge;
	
	
	public Graph(int size) {
		super();
		this.graph = new Node[size];
		
		for (int i = 0; i< size;i++) {
			graph[i] = new Node(i+1);
		}
		
		this.nNodes = size;
		this.graphEdges = new LinkedList<Edge>();
		this.nEdge = new int[size+1];
	}

	public void buildGraph() {

		int i;
		// will store for each edge in the list the nodes corresponding to it
		int[] aux;
		// auxiliary iterator for the insertion of the edges in the adjacency array
		int[] it = new int[nNodes];
		Edge[][] adj= new Edge[nNodes][];
		// creates adjacency arrays to insert inside nodes
		for (i = 0; i < nNodes; i++) {
			adj[i] = new Edge[nEdge[i]];
		}
		// builds adjacency array
		for(Edge edge : graphEdges)
	        {
		    aux = edge.getNodes();
		    adj[aux[0]-1][it[aux[0]-1]] = edge;
		    adj[aux[1]-1][it[aux[1]-1]] = edge;
			it[aux[0]-1]++;
			it[aux[1]-1]++;

	        }
		// insert inside all nodes
		for (i = 0; i < nNodes ; i++) {
			
			graph[i].addAdjacency(adj[i]);
		}
	}
	
	public void addEdge(int node1, int node2, double weight) {
		
		graphEdges.add(new Edge(node1, node2, weight));
		// updates edge counter
		nEdge[node1]++;
		nEdge[node2]++;
		nEdge[0]++;
	}
	
	public int getSizeNodes() {

		return nNodes;
	}
	
	public int getSizeEdges() {
		return nEdge[0];
	}
	
	public Node getNode(int id) {

		return graph[id-1];
	}
	@Override
	public String toString() {
		return "Graph [graph=" + graph + "]";
	}
	
}

