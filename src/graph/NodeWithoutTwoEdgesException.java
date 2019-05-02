package graph;

public class NodeWithoutTwoEdgesException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeWithoutTwoEdgesException()
	{
		super("There is one node without 2 adjacent edges at least. Hamiltonian Cycle is not possible! Exiting...");
	}
	
	public NodeWithoutTwoEdgesException(String message)
	{
		super(message);
	}
}
