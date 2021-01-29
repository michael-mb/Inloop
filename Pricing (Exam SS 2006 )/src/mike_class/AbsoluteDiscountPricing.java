package mike_class;

public class AbsoluteDiscountPricing implements ISalePricing{

	private long discount ;
	private long threshold ;
	
	public  AbsoluteDiscountPricing (long discount, long threshold)
	{
		if(discount <0  || threshold < 0)
			throw new IllegalArgumentException();
		if(discount >= threshold)
			throw new IllegalArgumentException();
		this.discount = discount ;
		this.threshold = threshold ;
	}

	@Override
	public long getTotal(Sale sale) {
		// TODO Auto-generated method stub
		
		if(sale.getPreDiscountTotal() < threshold)
	        return sale.getPreDiscountTotal();
		else
		{
			if(sale.getPreDiscountTotal() - discount < threshold)
			{
				long newdiscount = sale.getPreDiscountTotal() - threshold ;
				return sale.getPreDiscountTotal() - newdiscount ;
			}
			else
			{
				return sale.getPreDiscountTotal() - discount;
			}
		}
		
			
	}
	
}
