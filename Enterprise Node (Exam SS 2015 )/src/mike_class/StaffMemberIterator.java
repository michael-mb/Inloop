package mike_class;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StaffMemberIterator implements EnterpriseNodeIterator{

	private Set<StaffMember> allMembers ;
	private Iterator<StaffMember> iter ;
	private Set<StaffMember> directSubordinates ;
	
	public StaffMemberIterator(Set<StaffMember> directSubordinates)
	{
		if( directSubordinates== null)
			throw new NullPointerException();
		
		for(Object o : directSubordinates)
		{
			if(o == null)
				throw new NullPointerException();
		}
		
		allMembers = new TreeSet<StaffMember>();
		
		this.directSubordinates = directSubordinates ;
		
		
		for(StaffMember m : this.directSubordinates)
		{
			findSubordinatesRecursively(m);
		}
		
		System.out.println("All members  : "+allMembers);
		iter = allMembers.iterator();
	}

	private void findSubordinatesRecursively(StaffMember m )
	{
		if(m == null)
			throw new NullPointerException();
		
		allMembers.add(m);
		
	    if(m.getDirectSubordinates().size()!=0)
	    {
	    	Set<StaffMember> subMembers = m.getDirectSubordinates();
	    	
	       for(StaffMember s : subMembers)	
	       {
	    	   findSubordinatesRecursively(s);  
	       }
	    }
	    
		
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return iter.hasNext();
	}

	@Override
	public EnterpriseNode next() {
		// TODO Auto-generated method stub
		return iter.next();
	}
	
}
