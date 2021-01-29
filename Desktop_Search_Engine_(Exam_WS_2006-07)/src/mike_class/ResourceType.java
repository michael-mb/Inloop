package mike_class;

public class ResourceType {
	
	private String description ;
	private KeywordCollector collector ;
	
	public ResourceType (String desc , KeywordCollector collector)
	{
		if(collector==null || desc == null)
			throw new NullPointerException();
		
		if(desc.isEmpty())
		throw new IllegalArgumentException();
		this.description=desc ;
		this.collector = collector ;
	}
	public String getDescription()
	{
		return this.description;
	}
	public KeywordCollector getCollector() 
	{
		return this.collector ;
	}

}
