package graph;

import java.util.LinkedList;

public class Graph {
	
	private Node[] graph;
	private int nNodes;
	private int nestNode;
	private LinkedList<Edge> graphEdges;
	private int[] nEdge;
	
	
	public Graph(int size, int nested) {
		super();
		this.graph = new Node[size];
		
		for (int i = 0; i< size;i++) {
			graph[i] = new Node(i+1);
		}
		
		this.nNodes = size;
		this.nestNode = nested;
		this.graphEdges = new LinkedList<Edge>();
		this.nEdge = new int[size+1];
	}

	public void buildGraph() {

		// will store for each edge in the list the nodes corresponding to it
		int[] aux;
		// auxiliary iterator for the insertion of the edges in the adjacency array
		int[] it = new int[nNodes];
		Edge[][] adj= new Edge[nNodes][];
		// creates adjacency arrays to insert inside nodes
		for (int i = 0; i < nNodes; i++) {
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
		for (int i = 0; i < nNodes ; i++) {			
			graph[i].addAdjacency(adj[i]);
			graph[i].setnAdj(adj[i].length);
		}
	}
	
	public void addEdge(int node1, int node2, double weight) {
		
		graphEdges.add(new Edge(node1, node2, weight));
		// updates edge counter
		nEdge[node1-1]++;
		nEdge[node2-1]++;
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

	public int getnNodes() {
		return nNodes;
	}

	public void setnNodes(int nNodes) {
		this.nNodes = nNodes;
	}

	public int getNestNode() {
		return nestNode;
	}

	public void setNestNode(int nestNode) {
		this.nestNode = nestNode;
	}

	public LinkedList<Edge> getGraphEdges() {
		return graphEdges;
	}

	public void setGraphEdges(LinkedList<Edge> graphEdges) {
		this.graphEdges = graphEdges;
	}

	public Node[] getGraph() {
		return graph;
	}
	
	
	
	
}

