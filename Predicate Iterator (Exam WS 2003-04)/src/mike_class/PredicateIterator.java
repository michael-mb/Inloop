package mike_class;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class PredicateIterator <T>{
	
	private ListIterator<T> iter ;
	private Predicate<T> pred ;
	private T argument ;	
	private T elem ;

	public PredicateIterator( Iterator<T> iter , Predicate<T> pred , T argument){
		if(iter==null || pred==null || argument==null)
		throw new NullPointerException();
		
		this.iter = (ListIterator<T>) iter ;
		this.pred = pred ;
		this.argument = argument ;
	}
	
	public boolean hasNext()
	{
		while(iter.hasNext())
		{ 
			elem = iter.next();
			if(pred.predicate(elem, argument))
			{  
				elem = iter.previous();
				return true ;
			}
		}
		return false ;
	}
	
	public T next()
	{	
		T elem ;
		
		 while(iter.hasNext())
		{  
			 elem = iter.next();	 
			 if(pred.predicate(elem, argument))
			 {
				  return elem ;
			 }
		}

		throw new NoSuchElementException();
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
