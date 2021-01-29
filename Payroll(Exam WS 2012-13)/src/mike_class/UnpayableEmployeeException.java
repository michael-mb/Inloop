package mike_class;

public class UnpayableEmployeeException extends Exception{

	public UnpayableEmployeeException(String message)
	{
		super(message);
		System.err.println(message);
	}
}
