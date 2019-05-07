package pec;

import java.util.Comparator;

/**
 * 
 * Class that implements the Comparator interface and redefines the method compare
 * 
 *
 * @author John Mendonça, Manuel Domingues, Rúben Gomes
 */

class TimestampCompare implements Comparator<Event> {
	
	/**
    * method that checks which event passed by argument has the greatest timestamp
    * @param arg0 is an event which timestamp will be compared
    * @param arg1 is the other event which timestamp will be compared
    * @return the value returned defines which event has the greatest timestamp
    */
	
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