package pec;

public abstract class Event {
	
	protected double timestamp;
	
	public Event(double timestamp) {
		super();
		this.timestamp = timestamp;
	}
	
	public abstract double executeEvent();
	
	
}
