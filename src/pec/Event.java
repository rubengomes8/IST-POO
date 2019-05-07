package pec;


/**
 * Event.java
 * This is an abstract class that holds the triggered time information about an Event
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public abstract class Event {
	/**
	 * time at which the event is triggered (removed from the pending event container)
	 */
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
