package mike_class;

import java.util.ArrayList;
import java.util.List;

public class BestForStorePricing extends ComplexPricing {

	public BestForStorePricing(ISalePricing pricing) {
		super(pricing);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getTotal(Sale sale) {
		// TODO Auto-generated method stub
		if(sale == null)
			throw new NullPointerException();

		long dis = 0;
		
		List<ISalePricing> pricings = new ArrayList<ISalePricing>() ;
		pricings =super.getPricings();
		for (ISalePricing i : pricings)
		{
			System.out.println(i.getTotal(sale));
			if(dis < i.getTotal(sale))
			{
				dis = i.getTotal(sale);
			}
		}
		return dis;
	}

}
