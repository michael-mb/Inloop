package mike_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class JContent extends Observable {
	private String title ;
	private String description;
	private List<Observer> observers ;
	
	public JContent(String title , String description)
	{
		if(title.isEmpty() || description.isEmpty())
			throw new IllegalArgumentException();
		if(title == null || description == null)
			throw new NullPointerException();
		
		this.title = title ;
		this.description = description;
		observers = new ArrayList<>();
	}
	
	public String getDescription()
	{		
		return description;
	}
	public void setDescription(String description)
	{
		if( description.isEmpty())
			throw new IllegalArgumentException();
		if( description == null)
			throw new NullPointerException();
		
		this.description=description;
			
		this.setChanged();
		notifyObservers(this);
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		if(title.isEmpty())
			throw new IllegalArgumentException();
		if(title == null)
			throw new NullPointerException();
		
		this.title=title;
		this.setChanged();
		notifyObservers(this);
	}
	public void notifyObservers(Object o)
	{
		
		for (Observer v : observers)
		{
			v.update(this, o);
		}
	}
	
	public void addObs(Observer o)
	{
		observers.add(o);
	}
	public void removeObs(Observer o)
	{
		observers.remove(o);
	}
	
	public abstract String toString();
	
	

}
