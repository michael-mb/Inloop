package mike_class;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PlainTextCollector implements KeywordCollector{
   
	@Override
	public Set<String> getKeywords(Resource res) {
		Set<String> keywords = new TreeSet<String>();
		if(res == null)
		{
			throw new NullPointerException();
		}
		Iterator<String> it = new TextFileIterator (res) ;
		while(it.hasNext())
		{
			keywords.add(it.next());
		}
		return keywords;
	}

}
