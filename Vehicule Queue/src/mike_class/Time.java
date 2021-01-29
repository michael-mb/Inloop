package mike_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Time extends Observable {

	private List<Observer> observers ;
	private static Time instance = new Time();
	private int currentTime = 0;
	private int endOfTime = 100 ;
	
	private Time()
	{
		observers = new ArrayList<Observer>();
	}
	
	public static Time getInstance()
	{	
		
		return instance;
	}
	
	public void initEndOfTime(int seconds)
	{
		if(seconds < 0)
			throw new IllegalArgumentException();
		
		this.endOfTime = seconds ;
	}
	public int getCurrentTime()
	{
		return this.currentTime;
	}
	public void run()
	{
		this.currentTime = 0 ;
		
		while(this.currentTime < this.endOfTime)
		{
			this.currentTime += 1 ;
			notifyObservers();
		}
	}
	public void addObserver(Observer v )
	{
		observers.add(v);
	}
	
	public void notifyObservers()
	{
				
		for (Observer v : observers)
		{
			System.out.println("Update start x ! " +this.currentTime);
			v.update(this, this.getCurrentTime());
		}
	}
}
