package graph;

import java.util.LinkedList;

public class Graph<T> {
	
	
	LinkedList<Node<T>> graph;
	int size;


	public void add_node(int id, T payload) {
		graph.add(new Node<T>(id, payload));
		size++;
	}
	
	public Node<T> remove_node(int id) {
		// TODO: Stub, need to iterate until finding id
		if (size == 0)
			return null;
		return graph.remove(id);
	}

	
	@Override
	public String toString() {
		return "Graph [graph=" + graph + "]";
	}
	
}
