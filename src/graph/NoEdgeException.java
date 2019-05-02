package graph;

/**
 * NoEdgeExcemption.java
 * Exception to be thrown when a edge selected does not exist.
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class NoEdgeException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoEdgeException()
	{
		super("Edge selected does not exist. Exiting...");
	}
	
	public NoEdgeException(String message)
	{
		super(message);
	}
}
