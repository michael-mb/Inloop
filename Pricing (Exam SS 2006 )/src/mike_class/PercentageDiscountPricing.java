package mike_class;



public class PercentageDiscountPricing implements ISalePricing{

	private double percentage ;
	
	public  PercentageDiscountPricing(double percentage)
	{
		if(percentage < 0 || percentage >100)
			throw new IllegalArgumentException(); 
		this.percentage = percentage ;
	}
	@Override
	public long getTotal(Sale sale) {
		// TODO Auto-generated method stub
		return (long) (sale.getPreDiscountTotal()- (sale.getPreDiscountTotal()* (percentage/100))) ;
	}

}
