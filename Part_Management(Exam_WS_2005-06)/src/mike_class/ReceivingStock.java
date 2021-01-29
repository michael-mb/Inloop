package mike_class;

public class ReceivingStock extends Stock{

	private int minStockItems ;
	private int maxStockItems ;
	
	public ReceivingStock (int minStockItems , int maxStockItems)
	{
		if(minStockItems < 1)
			throw new IllegalArgumentException();
		if(maxStockItems <= minStockItems)
			throw new IllegalArgumentException();
		this.maxStockItems = maxStockItems ;
		this.minStockItems = minStockItems ;
	}
	public int getMinStockItems()
	{
		return this.minStockItems;
	}
	public int getMaxStockItems()
	{
		return this.maxStockItems;
	}
	public boolean insert(Part part , int amount)
	{
		if(part == null)
			throw new NullPointerException();
		if(amount < 1)
			throw new IllegalArgumentException();
		if(!parts.containsKey(part)) {
			 parts.put(part, amount);
			 return true ;
		}
		
		if(amount + parts.get(part) > this.maxStockItems)
			return false;
		
		super.insert(part, amount);
		
		return true ;
	}
	public boolean remove (Part part , int amount)
	{
		if(amount < 1)
			throw new IllegalArgumentException();
		
        if(part == null)
        	throw new NullPointerException();
        
		if(!parts.containsKey(part))
			return false ;

		if( parts.get(part) - amount  < 0)
			return false ;
		
		super.remove(part, amount);

		
		return true ;
	}
	
}
