package mike_class;

import java.util.ArrayList;
import java.util.List;

public class BestForCustomerPricing extends ComplexPricing {

	public BestForCustomerPricing(ISalePricing pricing) {
		super(pricing);
		// TODO Auto-generated constructor stub
	}
	@Override
	public long getTotal(Sale sale) {
		// TODO Auto-generated method stub
		if(sale == null)
			throw new NullPointerException();

		long dis = 1000000000;
		
		List<ISalePricing> pricings = new ArrayList<ISalePricing>() ;
		pricings =super.getPricings();
		for (ISalePricing i : pricings)
		{
			if(dis > i.getTotal(sale))
			{
				dis = i.getTotal(sale);
			}
		}
		return dis;
	}


}
