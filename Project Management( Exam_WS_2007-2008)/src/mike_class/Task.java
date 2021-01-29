package mike_class;

import java.util.ArrayList;
import java.util.List;

public class Task extends ProjectItem{

	List <Deliverable> projectItem ;
	
	public Task(String name, String details, double rate) {
		super(name, details, rate);
		// TODO Auto-generated constructor stub
		
		projectItem = new ArrayList<Deliverable>();
	}

	@Override
	public double getTimeRequired() {
		// TODO Auto-generated method stub
		double x = 0 ;
		for (ProjectItem p : projectItem)
		{
			x+= p.getTimeRequired();
		}
		return x;
	}

	@Override
	public long getMaterialCost() {
		// TODO Auto-generated method stub
		long x = 0 ;
		for (ProjectItem p : projectItem)
		{
			x+= p.getMaterialCost();
		}
		return x;
	}
	
	public void addProjectItem(ProjectItem pi )
	{
		if(pi == null)
			throw new NullPointerException();
		
		if(pi instanceof Deliverable)
		projectItem.add((Deliverable)pi);
		else
		{
			Task t = (Task) pi ;
			
			for (ProjectItem p : t.allDeliverables())
			{
				 projectItem.add((Deliverable)p);
			}
		}
	}
	public void removeProjectItem(ProjectItem pi)
	{
		if(pi == null)
			throw new NullPointerException();
		projectItem.remove(pi);
	}

	public List<Deliverable> allDeliverables()
	{
		List all = new ArrayList();
		for(ProjectItem pi : projectItem)
		{
			if(pi instanceof Deliverable)
			{
				all.add(pi);
			}
		}
		
		return all ;
	}
}
