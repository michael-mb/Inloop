package mike_class;

public class Volunteer extends Employee{

	public Volunteer(String id) {
		super(id);
	}

	@Override
	public boolean isPayday(int dayOfMonth) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculatePay() throws UnpayableEmployeeException {
		throw new UnpayableEmployeeException("I am a volunteer !");
	}

	@Override
	public double calculateDeductions() {
		// TODO Auto-generated method stub
		return 0;
	}

}
