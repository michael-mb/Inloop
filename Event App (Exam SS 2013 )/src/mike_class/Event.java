package mike_class;

public class Event implements Comparable<Event> {

	private String title ;
	private EventCategory category ;
	
	public Event(String title , EventCategory category )
	{
		if(category==null || title==null)
			throw new NullPointerException();
		if(title.isEmpty())
			throw new IllegalArgumentException();
		
		this.title = title ;
		this.category = category ;
		
	}
	
	public String getTitle()
	{
		return this.title;
	}
	public EventCategory getCategory()
	{
		return this.category ;
	}

	@Override
	public int compareTo(Event e) {
		// TODO Auto-generated method stub
		if(e == null)
			throw new NullPointerException();
		
		if(this.title == e.title)
		{
			
			return this.category.compareTo(e.category) ;
		}
		else
		{
			return this.title.compareTo(e.title) ;
		}
		
	}
	
	}
