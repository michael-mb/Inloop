package mike_class;

import java.util.List;

public class Payroll {

	protected int payday ;
	PayrollDisposition disposition ;
	
	public Payroll(PayrollDisposition disposition , int payday)
	{
		if(disposition == null)
			throw new NullPointerException();
		if(payday < 1 || payday > 31)
			throw new IllegalArgumentException();
			
		this.payday = payday ;
		this.disposition = disposition ;
	}
	
	public void doPayroll(PayrollDB db)
	{

		
		if(db==null)
			throw new NullPointerException();

		List<Employee> listOfEmployee = db.getEmployeeList() ;
		
		for (Employee emp : listOfEmployee )
		{   
			if(emp instanceof Volunteer)
			{
				// nothing to do 
			}
			else
			{
				if(emp.isPayday(this.payday))
				{
					double payment;
					try {
						payment = emp.calculatePay() - emp.calculateDeductions();
						disposition.sendPayment(emp, payment);
					} catch (UnpayableEmployeeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				 
			}	
		}
	}
	
	
}
