package pec;

public abstract class PECAbs implements PECs{
	
	public abstract void addEvPEC(Event ev);
	
	public abstract Event nextEvPEC();
	
	public abstract int sizePEC();
}
