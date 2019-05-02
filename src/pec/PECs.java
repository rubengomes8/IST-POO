package pec;

public interface PECs {

	public void addEvPEC(Event ev);
	
	//faz o poll
	public Event nextEvPEC();
	
	public int sizePEC();
}
