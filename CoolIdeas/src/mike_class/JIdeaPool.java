package mike_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JIdeaPool {

	private Map<JTopic , Set<JIdea>> pool ;
	public JIdeaPool()
	{
		pool = new HashMap<>();
	}
	
	
	public void add (JTopic topic)
	{
		if(topic==null)
			throw new NullPointerException();
		
		boolean b = true ;
		
		for(JTopic t : pool.keySet())
		{
			if(t.getTitle().equals(topic.getTitle()))
			{
			   b = false ;	
			}
		}
		if(b)
		pool.put(topic, new HashSet<JIdea>());
	}
	
	
	public void add (JIdea idea , JTopic topic)
	{
		boolean b = true ;
		boolean c = true ;
		
		if(topic==null || idea == null)
			throw new NullPointerException();
		
		if(!pool.containsKey(topic))
		{
			add(topic);
				for(JTopic t : pool.keySet())
				{
					for(JIdea i : pool.get(t))
					{
						if(i.getTitle().equals(idea.getTitle()) && !(i.equals(idea)))
						{
							b=false;
						}
					}
				}
				
				if(b==true)
				{
					pool.get(topic).add(idea);
				}
		}
		else
		{
			if(!pool.containsValue(idea))
			{
				for(JTopic t : pool.keySet())
				{
					for(JIdea i : pool.get(t))
					{
						
						if(i.getTitle().equals(idea.getTitle()) && !(i.equals(idea)))
						{
							c=false;
						}
					}
				}
					
				if(c==true)
				{
					pool.get(topic).add(idea);
					
				}
			}
		}
		if(b==false )
		{
			pool.remove(topic);
		}		
	}
	
	
	public boolean remove(JTopic topic)
	{
		if(topic==null)
			throw new NullPointerException();
		if(pool.containsKey(topic)) 
		{
			pool.remove(topic);
			 return true ;
		}
		return false ;
	}
	
	
	public boolean remove (JIdea idea)
	{
		boolean b = false ;
		if(idea==null)
			throw new NullPointerException();

			for(JTopic t : pool.keySet())
			{
				if(pool.get(t).contains(idea))
				{
				   pool.get(t).remove(idea);
				   b=true;
				} 
			}
		return b ;
	}
	
	public JIdea getIdea(String title)
	{
		if(title==null)
			throw new NullPointerException();
		if(title.isEmpty())
			throw new IllegalArgumentException();
		
		for(JTopic t : pool.keySet())
		{
			for(JIdea i : pool.get(t))
			{
				if(i.getTitle().equals(title))
					return i ;
			}
		}
		return null ;
	}
	
	public int numberOfTopics()
	{
		return pool.keySet().size();
	}
	
	
	public int numberOfIdeas()
	{
		int nbr =0 ;
		List<JIdea> idee = new  ArrayList<JIdea>();
		
		for(JTopic t : pool.keySet())
		{
			for(JIdea i :pool.get(t))
			{
				idee.add(i);
			}
		}
		
		Set<JIdea> mySet = new HashSet<JIdea>(idee);
		List<JIdea> idee2 = new  ArrayList<JIdea>(mySet); // Cast um alle 2 elementes rauszunehmen !!! 
		
		return idee2.size() ;
	}
	
	public void removeDeclined()
	{
		List<JIdea> declined = new ArrayList<>();
		for(JTopic t : pool.keySet())
		{	
			for(JIdea i : pool.get(t))
			{
				if(i.isDeclined())
				{	
					declined.add(i);
				}
			}
		}
		
		for(JIdea i : declined)
		{
			remove(i);
		}
	}
	
	public void removeReleased()
	{
		List<JIdea> released = new ArrayList<>();
		
		for(JTopic t : pool.keySet())
		{
			for(JIdea i :pool.get(t))
			{
				if(i.isReleased())
				{
					released.add(i);
				}
			}
		}
		
		for(JIdea i : released)
		{
			remove(i);
		}
	}
	
	
}
