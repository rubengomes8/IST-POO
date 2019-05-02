package pec;

/**
* This is an abstract class that holds the generic information about a PEC 
* and implements the interface PECs.java
* @author John Mendonça, Manuel Domingues, Rúben Gomes
* @since 04-26-2019
*/

public abstract class PECAbs implements PECs{
	
	/**
    * Adds an evente to the priority queue of events
    * @param event is the event to add to the queue
    */
	public abstract void addEvPEC(Event ev);
	
	
	/**
    * Gets the next event to be performed (the one with higher priority)
    * @return an <code> Event </code> 
    */
	public abstract Event nextEvPEC();
	
	
	/**
    * Gets the length of the queue of events
    * @return an <code> int </code> specifying
    * the size of the queue
    */
	public abstract int sizePEC();
}
