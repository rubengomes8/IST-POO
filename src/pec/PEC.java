package pec;

import java.util.PriorityQueue;


/**
 * 
 * This is a model class to hold the pending event container (PEC) information
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

public class PEC implements PECs{
	/**
	 * priority queue of events ordered by its timestamp
	 */
	protected PriorityQueue<Event> eventqueue;
	
	
	/**
    * Adds an event to the priority queue of events
    * @param ev is the event to add to the queue
    */
	@Override
	public void addEvPEC(Event ev) {
		eventqueue.add(ev);
	}
	
	/**
    * Gets the next event to be performed (the one with higher priority)
    * @return an <code> Event </code> 
    */
	@Override
	public Event nextEvPEC() {
		return eventqueue.poll();
	}
	
	/**
    * Gets the length of the queue of events
    * @return an <code> int </code> specifying
    * the size of the queue
    */
	@Override
	public int sizePEC() {
		return eventqueue.size();
	}

	
	/**
    * PEC constructor
    */
	
	public PEC() {
		this.eventqueue = new PriorityQueue<Event>(new TimestampCompare());
	}
	
}
