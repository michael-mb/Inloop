package mike_class;

import java.util.ArrayList;
import java.util.List;

public class Item {

	private List<Bid> allBids ;
	private Bid highestBid ;
	
	private String name ;
	private String description ;
	private long minPrice ;
	
	public Item(String name , String description , long minPrice)
	{
		if(name == null || description == null )
			throw  new NullPointerException();
		if(name.isEmpty() || description.isEmpty() )
			throw new IllegalArgumentException();
		if(minPrice <=0)
			throw new IllegalArgumentException();
		
		this.name = name ;
		this.description = description ;
		this.minPrice = minPrice ;
		
		allBids = new ArrayList<>();
	}
	
	public void addBid(Person bidder , long price)
	{
		if(bidder == null)
			throw new NullPointerException();
		if(price <= 0)
			throw new IllegalArgumentException();
		
		if(price >= minPrice)
		{
			Bid myBid = new Bid(bidder , price);
			
			if(highestBid == null)
			{
				highestBid = myBid ;
				allBids.add(myBid);	
			}
			else 
				if(price > highestBid.getPrice())
			{
				highestBid = myBid ;
				allBids.add(myBid);	
			}
			

		}
		
	}
	
	public List<Bid> getAllBids()
	{
		return allBids ;
	};
	
	public String getName()
	{
		return name ;
	};
	
	public String getDescription()
	{
		return description;
	};
	
	public Bid getHighestBid()
	{
		return highestBid;
	};
	
	public String toString()
	{
		return name+": "+description+" (minimum bidding price: "+minPrice+" EUR)" ;
	};
}
