package mike_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Team extends AbstractEnterpriseUnit{

	private StaffMember teamLeader ;
	private StaffMemberIterator iter ;
	
	public Team(String name , StaffMember teamLeader) {
		super(name);
		if(teamLeader == null)
			throw new NullPointerException();
		
		this.teamLeader = teamLeader ;
		// TODO Auto-generated constructor stub
	}
	
	public StaffMember getTeamLeader()
	{
		return teamLeader ;
	}
	public List<StaffMember> getTeamMembers()
	{
		List<StaffMember> members = new ArrayList<>();
		iter = new StaffMemberIterator(teamLeader.getDirectSubordinates());
		while(iter.hasNext())
		{
		 members.add((StaffMember) iter.next());	
		}
		members.add(teamLeader);
		Collections.sort(members);
		System.out.println("My Array : "+members);
		return members ;
	}

}
