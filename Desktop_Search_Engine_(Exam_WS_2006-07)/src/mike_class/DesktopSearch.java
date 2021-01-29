package mike_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesktopSearch {

	protected Map<String , ResourceType> types ;
	protected Index index;
	
	public DesktopSearch()
	{
		types = new TreeMap<>();
		index = new Index();
	}
	public void registerType(String extention , ResourceType type)
	{
	 if(extention == null || type == null)
		 throw new NullPointerException();
	  
   		types.put(extention, type);    
	}
	public ResourceType getType(String extention)
	{
		if(extention==null)
			return null;
		
		return types.get(extention);
	}
	public void unregisterType(String extention)
	{
		 if(extention == null)
			 throw new NullPointerException();
		 types.remove(extention);
	}
	public void registerResource(Resource res)
	{
		index.add(res);
	}
	public List<Resource> processRequest(String request)
	{		
		return index.getResources(request);
	}
}
