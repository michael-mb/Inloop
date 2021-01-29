package mike_class;

public class Appointee extends Employee{

	private int payday ;
	private int hoursPerMonth ;
	private double payPerHour ;
	public Appointee(String id , int payday , int hoursPerMonth , double payPerHour) {
		super(id);
		
		if(hoursPerMonth < 1)
			throw new IllegalArgumentException();
		if(payday < 1 || payday > 31)
			throw new IllegalArgumentException();
		if(payPerHour <= 0)
			throw new IllegalArgumentException();
		// TODO Auto-generated constructor stub
		this.hoursPerMonth = hoursPerMonth ;
		this.payday = payday ;
		this.payPerHour = payPerHour ;
		
	}

	@Override
	public boolean isPayday(int dayOfMonth) {
		// TODO Auto-generated method stub
			return payday==dayOfMonth ;
	}

	@Override
	public double calculatePay() throws UnpayableEmployeeException {
		// TODO Auto-generated method stub
		return this.hoursPerMonth*this.payPerHour;
	}

	@Override
	public double calculateDeductions() {
		// TODO Auto-generated method stub

		return ( (hoursPerMonth*payPerHour )/100)*40 ;
	}

}
