package graph;

/**
 *
 * Exception to be thrown when a edge selected does not exist.
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class NoEdgeException extends Exception{


	private static final long serialVersionUID = 1L;

	
	/**
    * Prints to the terminal a message that indicates that the edge selecteddoes not exist.
    */
	public NoEdgeException()
	{
		super("Edge selected does not exist. Exiting...");
	}
	
	/**
    * Prints to the terminal a given message.
    * @param message to be printed
    */
	public NoEdgeException(String message)
	{
		super(message);
	}
}
