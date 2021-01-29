package mike_class;

public class Factory {

	protected Purchasing purchasing ;
	protected ReceivingStock receivingStock ;
	
	public Factory (Purchasing purchasing , ReceivingStock receivingStock)
	{
		if(purchasing==null || receivingStock==null )
			throw new NullPointerException();
		this.purchasing = purchasing ;
		this.receivingStock = receivingStock ;
	}
	
	public Purchasing getPurchasing()
	{
		return this.purchasing ;
	}
	
	public ReceivingStock getReceivingStock()
	{
		return this.receivingStock ;
	}
	
	public static Part createPart( PartType partype , String id , String name)
	{
		if(partype==null)
			throw new NullPointerException();
		Part p=null ;
		if(PartType.COMPONENTS.equals(partype))
		{
			p = new Components(id,name);
		}
		else if(PartType.RESOURCE.equals(partype))
		{
			p = new Resource(id,name);
		}
		else if(PartType.SINGLE_COMPONENT.equals(partype))
		{
			p = new SingleComponent(id,name);	
		}
		
		return p ;
	}
}
