package simulation;

public class NextMoveNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NextMoveNotFoundException()
	{
		super("Next node was not found. Exiting...");
	}
	
	public NextMoveNotFoundException(String message)
	{
		super(message);
	}
}
