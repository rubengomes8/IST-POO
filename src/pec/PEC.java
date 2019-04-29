package pec;

import java.util.PriorityQueue;


/**
 * PEC.java
 * This is a model class to hold the pending event container (PEC) information
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 * @since 04-26-2019
 */

public class PEC {
	
	PriorityQueue<Event> eventqueue;
	double stop;
	
	
	/**
    * Adds an evente to the priority queue of events
    * @param event is the event to add to the queue
    */
		
	public void addEvPEC(Event ev) {
		eventqueue.add(ev);
	}
	
	/**
    * Gets the next event to be performed (the one with higher priority)
    * @return an <code> Event </code> 
    */
	
	public Event nextEvPEC() {
		return eventqueue.poll();
	}
	
	/**
    * Gets the length of the queue of events
    * @return an <code> int </code> specifying
    * the size of the queue
    */
	public int queuePEC() {
		return eventqueue.size();
	}

	
	/**
    * PEC constructor
    */
	
	public PEC() {
		this.eventqueue = new PriorityQueue<Event>(new TimestampCompare());
	}
	
}
