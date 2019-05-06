package graph;

/**
 * 
 * Exception that should be raised when there is at least one node without 2 adjacent nodes at least.
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */
public class NodeWithoutTwoEdgesException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
    * Prints to the terminal a message that indicates that there is one node without 2 adjacent nodes at least. So it is not possible to find an Hamiltonian cycle.
    */
	public NodeWithoutTwoEdgesException()
	{
		super("There is one node without 2 adjacent edges at least. Hamiltonian Cycle is not possible! Exiting...");
	}
	
	/**
    * Prints to the terminal a given message.
    * @param message to be printed
    */
	public NodeWithoutTwoEdgesException(String message)
	{
		super(message);
	}
}
