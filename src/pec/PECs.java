package pec;

/**
 * 
 * Interface class that describes a PEC - pending event container
 * 
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */


public interface PECs {
	
	/**
    * Adds an evente to the priority queue of events
    * @param ev is the event to add to the queue
    */
	
	public void addEvPEC(Event ev);
	
	/**
    * Gets the next event to be performed (the one with higher priority)
    * @return an <code> Event </code> 
    */
	public Event nextEvPEC();
	
	/**
    * Gets the length of the queue of events
    * @return an <code> int </code> specifying
    * the size of the queue
    */
	public int sizePEC();
}
