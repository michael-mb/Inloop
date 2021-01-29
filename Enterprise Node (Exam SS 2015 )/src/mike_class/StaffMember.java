package mike_class;

import java.util.Set;
import java.util.TreeSet;

public class StaffMember implements EnterpriseNode , Comparable <StaffMember> {

	private String name ;
	private String job ;
	private Set<StaffMember> directSubordinates ;
	
	public StaffMember (String name , String job)
	{
		if(name == null || job == null)
			throw new NullPointerException();
		if(name.isEmpty() || job.isEmpty())
			throw new IllegalArgumentException();
		
		this.name = name ;
		this.job = job ;
		
		this.directSubordinates = new TreeSet<StaffMember>();
		
	}
	
	public String getJob()
	{
		return job;
	}
	@Override
	public String getName() 
	{
		return name;
	}
	
	public boolean addDirectSubordinate(StaffMember subordinate)
	{
		if(subordinate == null)
			throw new NullPointerException();
			
		if(directSubordinates.contains(subordinate))
			return false ;
		else
			return directSubordinates.add(subordinate);
	}
	
	public boolean removeDirectSubordinate(StaffMember subordinate)
	{
		if(subordinate == null)
			throw new NullPointerException();
		
		return directSubordinates.remove(subordinate);
	}
	
	public Set<StaffMember> getDirectSubordinates()
	{
		return directSubordinates;
	}

	@Override
	public int compareTo(StaffMember s) {
		// TODO Auto-generated method stub
		return this.toString().compareTo(s.toString());
	}
	
	public String toString()
	{
		return name ;
	}
	
	
}
