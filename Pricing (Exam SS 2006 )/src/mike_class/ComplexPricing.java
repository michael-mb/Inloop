package mike_class;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplexPricing implements ISalePricing{

	private List<ISalePricing> pricings ;
	
	public ComplexPricing(ISalePricing pricing )
	{
		if(pricing ==null)
			throw new NullPointerException();
		this.pricings= new ArrayList<ISalePricing>();
		this.pricings.add(pricing);
	}
	public ComplexPricing()
	{
		this.pricings= new ArrayList<ISalePricing>();
	}
	
	public void add (ISalePricing pricing)
	{
		if(pricing == null)
			throw new NullPointerException();
		this.pricings.add(pricing);
	}
	public List<ISalePricing> getPricings()
	{
		return pricings ;
	}
	
}
