package pec;

import java.util.PriorityQueue;

public class PEC {
	
	PriorityQueue<Event> eventqueue;
	
	public void addEvPEC(Event ev) {
		eventqueue.add(ev);
		
	}
	
	public Event nextEvPEC() {
		return eventqueue.poll();
	}

	public PEC() {
		super();
		this.eventqueue = new PriorityQueue<Event>(new TimestampCompare());
	}
	
	
}
