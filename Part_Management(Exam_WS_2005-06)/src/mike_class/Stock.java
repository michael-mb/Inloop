package mike_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
	
	Map<Part , Integer> parts = new HashMap<Part , Integer>();
	private List<StockObserver> observers = new ArrayList<StockObserver>();
	
	public int getCount(Part part )
	{
		if(part == null)
			throw new NullPointerException();
		
		if(!parts.containsKey(part))
		{		
			return -1 ;
		}

		return parts.get(part);
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
		
		int current_quantity = 0 ;
		current_quantity =parts.get(part) + amount;
        parts.put(part, current_quantity);
        System.out.println("Notify wird aufgerufen");
        notifyPartCountChanged(part);
		
        return true ;
	}
	public boolean remove (Part part , int amount)
	{
		if(amount < 1)
			throw new IllegalArgumentException();
		
		if(amount != (int)amount )
			throw new IllegalArgumentException();
        
		if(part == null)
        	throw new NullPointerException();
        
		if(!parts.containsKey(part))
			return false ;

		int current_quantity = parts.get(part);
		
		if(current_quantity<amount)
			return false ;	
		
		current_quantity=current_quantity-amount ;
		
		parts.put(part, current_quantity);
		
		System.out.println("Notify wird aufgerufen");
		notifyPartCountChanged(part);
		
		return true ;
	}
	
	public void addObserver(StockObserver observer)
	{
		if(observer == null)
			throw new NullPointerException();
		observers.add(observer);
	}
	
	private void notifyPartCountChanged(Part  part)
	{
		for (StockObserver obs : observers)
		{
			System.out.println("In Notify");
			obs.onPartCountChanged(part, parts.get(part));
		}
	}

}
