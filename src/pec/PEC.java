package pec;

import java.util.PriorityQueue;

public class PEC {
	
	PriorityQueue<Event> eventqueue;
	double stop;
	
	public void addEvPEC(Event ev) {
		eventqueue.add(ev);
	}
	
	public Event nextEvPEC() {
		return eventqueue.poll();
	}
	
	public int queuePEC() {
		return eventqueue.size();
	}

	public PEC() {
		super();
		this.eventqueue = new PriorityQueue<Event>(new TimestampCompare());
	}
	
}
