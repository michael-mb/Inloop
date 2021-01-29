package mike_class;

public class PredicateEndsWith < T extends String> implements Predicate <T> {

	@Override
	public boolean predicate(T element, T argument) {
		// TODO Auto-generated method stub
		if(argument==null || element==null)
			return false ;
		
		if(argument.length()>element.length())
			return false ;
		
		String eleR="" ;
		String argR="" ;
		for(int i = argument.length()-1; i >= 0; i--)
		{
			argR = argR + argument.charAt(i); 
		}
		for(int i = element.length()-1; i >= 0; i--)
		{
			eleR = eleR + element.charAt(i); 
		}
		
		for(int i=0 ; i < argR.length() ; i++)
		{
			if(! (argR.charAt(i)==eleR.charAt(i)))
				return false ;
		}
		
		return true;
	}

}
