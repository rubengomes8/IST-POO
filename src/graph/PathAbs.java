package graph;

/**
* 
* This is an abstract class that holds the generic information about a Path (cost)
* and implements the interface Paths.java
* @author John Mendonça, Manuel Domingues, Rúben Gomes
*/

public abstract class PathAbs implements Paths{

	/**
	 * Cost of the path that is the sum of the weight of the edges belonging to the path.
	 */
	protected double cost;
	
	
	/**
    * Gets the total cost of the path
    * @return a <code> double </code> specifying
    * the path cost
    */
	@Override
	public double getCost() {
		return cost;
	}
	
	/**
    * Sets the cost of the path
    * @param cost is the cost to be set
    */

	public void setCost(double cost) {
		this.cost = cost;
	}

}
