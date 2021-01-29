package mike_class;

public abstract class ProjectItem {

	protected String name ;
	protected String details ;
	protected double rate ;
	
	public ProjectItem(String name , String details , double rate )
	{
		if(name == null || details==null )
			throw new NullPointerException();
		if(name.isEmpty() || details.isEmpty())
			throw new IllegalArgumentException();
		if(rate <= 0)
			throw new IllegalArgumentException();
		
		this.name = name ;
		this.details = details ;
		this.rate = rate ;
	}
	
	public void setDetails(String newDetails)
	{
		this.details += newDetails ;
	}
	public  long getCostEstimate()
	{
		return (long) Math.round((getTimeRequired() * this.rate) + (long)getMaterialCost());
	}
	public abstract double getTimeRequired();
	public abstract long getMaterialCost();
}
