package pec;

public abstract class Event {
	
	double timestamp;
	
	public Event(double timestamp) {
		super();
		this.timestamp = timestamp;
	}
	
	public abstract void executeEvent();
	
	
}
