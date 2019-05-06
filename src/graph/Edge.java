package graph;

/**
 * 
 * This is a model class to hold Edge information
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class Edge {
	
    private int node1;
    private int node2;
    private double weight;
    private double payload;
    
	/**
	* Edge constructor. Connects two nodes with a given weight.
	* @param node1 is one of the two nodes to be connected
	* @param node2 is the other node to be connected
	* @param weight is the weight of the edge
	*/

	public Edge(int node1, int node2, double weight) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
		this.payload = 0;
	}	
	
	/**
   	 * Gets the two nodes connected by the Edge.
   	 * @return an array of <code> int </code> with dimension 2
   	 * with the node identifier in each position
  	 */

	public int[] getNodes() {
		int[] aux = new int[2];		
		aux[0] = node1;
		aux[1] = node2;
		return aux;
	}
	
	/**
	* Checks if a given node is an extreme of this Edge.
	* @param id is the node identifier that we want to check
	* @return a <code> boolean </code> specifying
	* whether the node belongs or not to this Edge
	*/

	public boolean isEnd(int id) {
		
		return ((id == node1 || id == node2) ? true : false);
	}
	
	/**
   	 * Gets the weight of the Edge.
   	 * @return a <code> double </code> specifying
   	 * the weight of the edge.
  	 */
	
	public double getWeight() {
		return weight;
	}
	
	/**
   	 * Gets the payload of the Edge.
   	 * @return a <code> double </code> specifying
   	 * the payload of the edge.
  	 */
	
	public double getPayload() {
		return payload;
	}
	
	/**
   	 * Sets the payload of the Edge.
   	 * @param payload is the payload to be set
  	 */
	
	public void addPayload(double payload) {
		this.payload+= payload;
	}

	/**
   	 * Describes an Edge.
   	 * @return a <code> String </code> specifying
	 * information of the Edge.
  	 */
	
	@Override
	public String toString() {
		return "Edge [node1=" + node1 + ", node2=" + node2 + ", weight=" + weight + ", payload=" + payload + "]";
	}
	
	

}
