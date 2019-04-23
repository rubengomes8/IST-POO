package pec;

import java.util.Comparator;

class TimestampCompare implements Comparator<Event> {
	

	@Override
	public int compare(Event arg0, Event arg1) {
		
		if (arg0.timestamp > arg1.timestamp)
			return 1;
		else if (arg0.timestamp < arg1.timestamp)
			return -1;
		else 
			return 0;
	} 
}