package mike_class;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Auction {

	private List<Item> allItems ;
	private List<Person> bidders ;
	
	private boolean closed ;
	
	public Auction()
	{
		closed = false ;
		allItems = new ArrayList<>();
		bidders = new ArrayList<>();
	}
	
	public void addBid(String itemName , String nameOfBidder , long price)
	{
		boolean add = false ;
		if(closed)
			throw new IllegalStateException();
		if(itemName == null || nameOfBidder == null)
			throw new NullPointerException();
		if(itemName.isEmpty() || nameOfBidder.isEmpty() )
			throw new IllegalArgumentException();
		if(price <=0)
			throw new IllegalArgumentException();
		
		for (Item i : allItems)
		{
			if(i.getName().equals(itemName))
			{
				Person p = new Person(nameOfBidder);
		
				i.addBid(p, price);
				add=bidders.add(p);
				
			}
		}
		
		if(!add)
		{
			throw new NoSuchElementException();
		}
	}
	
	public String closeAuction()
	{
		if(closed)
			throw new  IllegalStateException();
		closed = true ;
		
		return generateItemListString();
	}
	
	public void registerItem(Item item)
	{
		if(closed)
			throw new  IllegalStateException();
		
		if(item == null)
			throw new NullPointerException();
		
		for(Item i : allItems)
		{
			if(i.getName().equals(item.getName() ) || i.getDescription().equals(item.getDescription()) )
			{
				throw new IllegalArgumentException();
			}
		}

			allItems.add(item);
		
	}
	
	public List<Item> getAllItems()
	{
		return allItems;
	}
	
	
	public String generateItemListString()
	{
		String str ="";
		
		for(Item i : allItems)
		{
			str=str+generateItemString(i)+"\n";
		}
		return str;
	}
	public String generateAllBidsString(Item item)
	{
		String str ="All bids:";
		
		for(Bid b : item.getAllBids())
		{
			str = str+"\n"+ b.getPrice()+" EUR by "+b.getBidder();
		}
		return str ;
	}
	public abstract String generateItemString(Item item);
	

	
	
	
}
