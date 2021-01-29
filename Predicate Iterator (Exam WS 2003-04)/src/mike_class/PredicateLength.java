package mike_class;

public class PredicateLength<T extends String> implements Predicate<T> {

	@Override
	public boolean predicate(T element, T argument) {
		// TODO Auto-generated method stub
		if(argument==null || element==null)
			return false ;
		
		String s = ""+element.length();
		if(argument.equals(s))
			return true ;
		
		return false;
	}

}
