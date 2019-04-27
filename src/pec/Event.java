package pec;


/**
 * Event.java
 * This is an abstract class that holds the triggered time information about an Event
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public abstract class Event {
	
	protected double timestamp;
	
	/**
    * Event constructor
    * @param timestamp is the time at which this Event was triggered 
    */
	
	public Event(double timestamp) {
		this.timestamp = timestamp;
	}
	
	public abstract double executeEvent();
	
	
}
