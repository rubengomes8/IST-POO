package graph;

import java.util.LinkedList;

public class Node<T> {
	
	LinkedList<Edge> adjacent;
	int id;
	int size;
	T payload;
	
	Node(int id, T payload) {
		super();
		this.id = id;
		this.payload = payload;
	}
	
	void insert_edge(Edge edge) {
		adjacent.add(edge);
		size++;
	}
	
	Edge remove_edge(int edge) {
		// TODO: Stub, need to iterate until finding id
		if (size == 0)
			return null;
		size--;
		return adjacent.remove(edge);
	}
	
	
	void insert_payload(T load) {
		this.payload = load;
	}
	
	int (){
		return size;
	}

}
