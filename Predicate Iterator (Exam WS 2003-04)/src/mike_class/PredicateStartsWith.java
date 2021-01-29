package mike_class;

public  class PredicateStartsWith<T extends String> implements Predicate<T> {

	@Override
	public boolean predicate(T element, T argument) {
		// TODO Auto-generated method stub
		if(argument==null || element==null)
			return false ;
		
		if(argument.length()>element.length())
			return false ;
		
		for(int i=0 ; i < argument.length() ; i++)
		{
			if(! (argument.charAt(i)==element.charAt(i)))
				return false ;
		}
		return true;
	}


}
