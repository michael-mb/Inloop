package mike_class;

import java.util.List;

public class Adapter extends Project implements IProject{

	protected String name ;
	protected String description;
	
	public Adapter(String name , String description , double rate )
	{
		super(name , description , rate);
		
	}
	
	public String getName()
	{
		return super.getName();
	}
	public String getDescription()
	{
		return super.getDescription();
	}
	
	@Override
	public void setTask(Task newTask) {
		// TODO Auto-generated method stub
		super.setTask(newTask);;
	}

	@Override
	public double getDuration() {
		// TODO Auto-generated method stub
		return super.getDuration();
	}

	@Override
	public long getTotalCost() {
		// TODO Auto-generated method stub
		return super.getTotalCost();
	}

	@Override
	public List<Deliverable> getDeliverables() {
		// TODO Auto-generated method stub

		return super.mainTask.allDeliverables();
	}

}
