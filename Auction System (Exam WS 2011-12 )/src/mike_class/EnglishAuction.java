package mike_class;

public class EnglishAuction extends Auction{

	@Override
	public String generateItemString(Item item) {
		// TODO Auto-generated method stub
		
		if(item == null)
			throw new NullPointerException();
	
		String str ="";
		
		if(item.getHighestBid()==null)
		{
			str = item +"\nNo bids placed";	
		}
		else
		{
			str = item +"\nHighest bid: "+item.getHighestBid().getPrice()+" EUR by "+item.getHighestBid().getBidder();
			
		}
		System.out.println(str);
		return str;
	}

}
