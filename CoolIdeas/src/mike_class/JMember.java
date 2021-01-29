package mike_class;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class JMember implements Observer{
	
	private Set<JTopic> topics ;
	
	public JMember ()
	{
		topics = new HashSet<>();
	}
	
	public void subscribe(JTopic topic)
	{
		if(topic==null)
			throw new NullPointerException();
		
		
		topics.add(topic);
		topic.addObs(this);
		topic.addObserver(this);
	}
	
	public void unsubscribe(JTopic topic)
	{
		if(topic==null)
			throw new NullPointerException();
		
		topics.remove(topic);
		topic.removeObs(this);
		topic.deleteObserver(this);
		
	}
	
	public void update(Observable ob , Object oj)
	{
		if(oj instanceof JTopic)
		{	
				System.out.println("The topic "+((JTopic) oj).getId()+" has been updated!");
		}
	}
	public Set<JTopic> getSubscribedTopics()
	{
		return topics;
	}
	
	

}
