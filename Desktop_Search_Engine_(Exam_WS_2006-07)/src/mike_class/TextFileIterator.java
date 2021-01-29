package mike_class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TextFileIterator implements Iterator <String>{

List<String> listString = new ArrayList<String>();
List<String> removedString = new ArrayList<String>();  
	
	public TextFileIterator(Resource res)
	{
		if(res==null)
			throw new NullPointerException();
		
		String str = this.getAsString(res);
		
		str = str.replaceAll("!\n"," ");
        str = str.replaceAll("-\n","");
        str = str.replace('.',' ');
        
        System.out.println(str);
		
        String [] keyTable = str.split(" ");
	    
		for(String s : keyTable)
		{
			listString.add(s);
		}
	}
	
    
	@Override
	public boolean hasNext() {
		
		return !listString.isEmpty();
	}
    
	@Override
	public String next() {
	 String str = "";
	 
	if(!listString.isEmpty())
	{
		str=listString.get(0);
		listString.remove(0);
	}
	else
	{
		throw new NoSuchElementException(); 
	}
	
	 return str ;
	}
	public void remove()
	{
		 throw new UnsupportedOperationException();
	}
	
	public String getAsString(Resource res)
	{   
		String str = "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
        
		return str ;
	}

}
