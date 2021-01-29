package mike_class;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EventCatalogImpl extends TreeMap<Event, Set<Time>> implements EventCatalog{

	@Override
	public boolean addCatalogEntry(Event e, Set<Time> tSet) {
		// TODO Auto-generated method stub
		
		if(e==null || tSet==null || tSet.contains(null))
		throw new NullPointerException();
		
		if(!this.containsKey(e))
		{
			this.put(e, tSet);
			return true;
		}

		return false ;
		
	}

	@Override
	public boolean addTimeToEvent(Event e, Time t) {
		// TODO Auto-generated method stub
		if(e==null || t==null)
		throw new NullPointerException();
		
		if(this.containsKey(e))
		{
			if(!this.get(e).contains(t))
			{
				this.get(e).add(t);
				return true;
			}
			return false ;		
		}
		return false;
	}

	@Override
	public Set<Event> getAllEvents() {
		// TODO Auto-generated method stub
		
		return this.keySet();
	}

	@Override
	public Set<Time> getTimesOfEvent(Event e) {
		// TODO Auto-generated method stub
		if(e==null)
		throw new NullPointerException();
		
		return this.get(e);
	}

	@Override
	public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
		// TODO Auto-generated method stub
		if(category==null)
			throw new NullPointerException();
		
		Map<Event, Set<Time>> map = new TreeMap<Event, Set<Time>>();
		
		for(Event e : this.keySet())
		{
			if(e.getCategory()==category)
			{
				map.put(e, this.get(e));
			}
		}
		return map;
	}

	@Override
	public Set<Time> deleteEvent(Event e) {
		// TODO Auto-generated method stub
		
		if(this.containsKey(e))
		{
			Set<Time> allTime = this.get(e);
			this.remove(e);
			return allTime;
			
		}
		else
		  return null;
	}

	@Override
	public boolean deleteTime(Event e, Time t) {
		// TODO Auto-generated method stub
		if(e==null || t==null)
		throw new NullPointerException();
		
		if(this.containsKey(e))
		{
             if(this.get(e).contains(t))
             {
            	 this.get(e).remove(t);
            	 return true ;
             }
             return false ;
		}
		
		return false;
	}

}
