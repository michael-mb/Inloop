package mike_class;

import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector {

	@Override
	public Set<String> getKeywords(Resource res) {
		if(res == null)
		{
			throw new NullPointerException() ;
		}
	    Set<String> container = new HashSet<String>();
	    container.add(res.getName());
		return container;
	}

}
