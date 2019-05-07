package simulation;

/**
 * Exception that should be raised when the next node to go is not found in a graph.
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public class NextMoveNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	
	/**
    * Prints to the terminal a message that indicates that the next node was not found.
    */
	
	public NextMoveNotFoundException()
	{
		super("Next node was not found. Exiting...");
	}
	
	
	/**
    * Prints to the terminal a given message.
    * @param message to be printed
    */
	public NextMoveNotFoundException(String message)
	{
		super(message);
	}
}
