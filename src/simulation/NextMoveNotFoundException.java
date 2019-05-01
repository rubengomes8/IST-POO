package simulation;

public class NextMoveNotFoundException extends Exception{

	public NextMoveNotFoundException()
	{
		super("Next node was not found. Exiting...");
	}
	
	public NextMoveNotFoundException(String message)
	{
		super(message);
	}
}
