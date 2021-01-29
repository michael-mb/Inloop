package mike_class;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

	protected String name ;
	protected String description;
	protected Task mainTask ;
	
	public Project(String name , String description , double rate)
	{
		if(name==null || description == null)
			throw new NullPointerException();
		if(name.isEmpty() || description.isEmpty())
			throw new IllegalArgumentException();
		if(rate <= 0)
			throw new IllegalArgumentException();
		
		this.name = name ;
		this.description = description ;
	}
	public String getName()
	{
		return this.name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setTask (Task newTask)
	{
		if(newTask==null)
			throw new NullPointerException();
		mainTask = newTask ;
	}
	public double getDuration()
	{
		return mainTask.getTimeRequired();
	}
	public long getTotalCost()
	{
		return mainTask.getCostEstimate();
	}
	
	
	
	public Map<LocalDate , List<Deliverable>> allDeliverables()
	{
		Map<LocalDate , List<Deliverable>> all = new HashMap<LocalDate , List<Deliverable>>();
		
		for (Deliverable p : mainTask.projectItem)
		{
		    if(!all.containsKey(p.getDate()))
		    {
		    	all.put(p.getDate(), new ArrayList());
		    	all.get(p.getDate()).add(p);
		    }
		    else
		    {
		    	if(!all.get(p.getDate()).contains(p))
		    	{
		    	  	all.get(p.getDate()).add(p);
		    	}
		    }
		}
		return all ;
	}
}
