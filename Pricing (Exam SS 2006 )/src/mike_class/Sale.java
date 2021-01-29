package mike_class;


public class Sale {
	
	private long preDiscountTotal ;
	private ISalePricing pricing ;
	
	public Sale (long preDiscountTotal , ISalePricing pricing)
	{
		if(pricing == null)
			throw new NullPointerException();
		if(preDiscountTotal < 0)
			throw new IllegalArgumentException();
		this.preDiscountTotal = preDiscountTotal ;
		this.pricing = pricing ;
	}
	
	
	public long getPreDiscountTotal ()
	{
		return this.preDiscountTotal ;
	}
	
	
	public void setPricing(ISalePricing pricing)
	{
		if(pricing == null)
			throw new NullPointerException();
		
		this.pricing = pricing ;
	}
	
	public long getTotal ()
	{
		return this.pricing.getTotal(this);
	}
	
	public static ISalePricing createPricing (DiscountType discountType , double percentage , long discount , long threshold )
	{
		if(discountType ==null)
			throw new NullPointerException();
		
		ISalePricing i =null;
		if(discountType==DiscountType.ABSOLUTEDISCOUNT)
		{
			 i = new AbsoluteDiscountPricing(discount,threshold);
		}
		if(discountType==DiscountType.PERCENTAGEDISCOUNT)
		{
			 i = new PercentageDiscountPricing(percentage);
		}
		
		
		return i ;
	}

}
