package mike_class;

import java.util.HashMap;
import java.util.Map;

public class PayrollDispositionImpl implements PayrollDisposition {

	private Map<Employee,Double> payments ;

	public PayrollDispositionImpl(){
		payments = new HashMap<>();
	}
	
	@Override
	public void sendPayment(Employee empl, double payment) {
		// TODO Auto-generated method stub
		if(empl == null)
			throw new NullPointerException();
		if(payment < 1 )
			throw new IllegalArgumentException();
		
		if(!payments.containsKey(empl))
			payments.put(empl, payment);
	}
	
	public double getTotal()
	{
		double total = 0 ;
		for(Employee emp : payments.keySet())
		{
			total += payments.get(emp);
		}
		return total ;
	}
	
	public double getAverage()
	{
		if(payments.isEmpty())
	     return 0 ;
		return this.getTotal()/(payments.keySet().size());
	}
	public Map<Employee , Double >getPayments()
	{
		return payments ;
	}
	
}
