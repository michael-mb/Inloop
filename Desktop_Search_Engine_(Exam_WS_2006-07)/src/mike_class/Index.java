package mike_class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Index {
	protected Map <String , List<Resource>> index ; 
	
	public Index() {
		index = new TreeMap<>();
	}
	public void add (Resource res)
	{
		if(res==null)
			throw new NullPointerException();
	       
	   if(res.getType().getCollector() instanceof PlainTextCollector )
	      {
	  for (String str : res.getType().getCollector().getKeywords(res))
	  {
     	 if(!index.containsKey(str))
     	 {
     		index.put(str, new ArrayList<Resource>());
     	 }
    	 if(!index.get(str).contains(res))
    		index.get(str).add(res);
		   
	  }  
	        }
	        else
	        {
	        	String str="";
	        	str=res.getName();
	        	 if(!index.containsKey(str))
	        	 {
	        		index.put(str, new ArrayList<Resource>());
	        	 }
	        	 if(!index.get(str).contains(res))
	         		index.get(str).add(res);
	        }
	         
	}
	public List<Resource> getResources(String keyword)
	{
		if(keyword == null)
			throw new NullPointerException();
		if(!index.containsKey(keyword))
			return new ArrayList<Resource>();
		
		return index.get(keyword) ;
	}
}
