package mike_class;

public class BankAccount {

	private double balance = 0.0 ;
	private double lineOfCredit ;
	private String accountNumber ;
	
	private AccountState state ;
	
	private AccountState positive ;
	private AccountState negative ;
	private AccountState frozen ;
	private AccountState closed ;
	
	
	public BankAccount(String accountNumber , double lineOfCredit)
	{
		if(accountNumber==null)
			throw new NullPointerException();
		if(lineOfCredit < 0 || accountNumber.isEmpty())
		    throw new IllegalArgumentException();
		
		this.accountNumber = accountNumber ;
		this.lineOfCredit = lineOfCredit ;
		 positive = new Positive();
		 negative = new Negative();
		 frozen = new Frozen();
		 closed = new Closed();
		
		this.state = positive ;	
	}
	
	public boolean payIn(double amount)
	{
		if(amount <= 0)
			throw new IllegalArgumentException();
		
		return state.payIn(amount);
	}
	
	public boolean payOff(double amount)
	{
		if(amount <= 0)
			throw new IllegalArgumentException();
		
		return state.payOff(amount);
	}
	
	public boolean close()
	{
		if(this.balance != 0)
		return false ;
				
		state = closed;		
		return true ;		
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public String getState()
	{
	
		return state.toString() ;
	}
	
	public void printBalance()
	{
		state.printBalance();
	}
	
	public void payInterest()
	{
		state.payInterest();
	}
	
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	
	// AccountState Class ! 
	public abstract class AccountState {
	
		public boolean payIn(double amount)
		{
			if(state instanceof Positive)
			{
				return positive.payIn(amount) ;
			}
			if(state instanceof Negative)
			{
				return negative.payIn(amount) ;
			}
			if(state instanceof Frozen)
			{
				return frozen.payIn(amount) ;
			}
			   return false ;
			
		}
		public boolean payOff(double amount)
		{
			if(state instanceof Positive)
			{
				return positive.payOff(amount) ;
			}
			if(state instanceof Negative)
			{
				return negative.payOff(amount) ;
			}
			if(state instanceof Frozen)
			{
				 throw new IllegalStateException();
			}
			return false ;
		}
		
		public String toString ()
		{
			if(state instanceof Positive)
			{
				return "Positive";
			}
			if(state instanceof Negative)
			{
				return "Negative";
			}
			if(state instanceof Frozen)
			{
				return "Frozen";
			}
			
		 	    return "Closed";
		}
		
		public void payInterest()
		{
			if(state instanceof Positive)
			{
				balance += (balance/100);
			}
			if(state instanceof Negative)
			{
				balance += (3*balance/100);
			}
			if(state instanceof Frozen)
			{
				balance += (5*balance/100);
			}
			if(state instanceof Closed)
			{
				throw new IllegalStateException();
			}
		}
		
		public abstract void printBalance();
		
	}
	
	// verschiedene State !! 
	
	//Positive
	public class Positive extends AccountState {

		public boolean payIn(double amount)
		{
			 balance += amount ;
			 
			 if(balance < 0)
				 state = negative ;
			 else
				 state = positive ;
			 
			 return true ;
		}
		public boolean payOff(double amount)
		{
			if(balance - amount < (lineOfCredit - lineOfCredit*2))
				return false ;
			 balance -= amount ;
			 
			 if(balance < 0)
				 state = negative ;
			 else
				 state = positive ;
			 
			 if(balance <= (lineOfCredit - lineOfCredit*2))
				 state = frozen ;
			 
			 return true ;
		}
		@Override
		public void printBalance() {
			// TODO Auto-generated method stub
			
			System.out.println("Balance is POSITIVE: +"+balance+".");
		}
		
	}
	
	//Negative
	public class Negative extends AccountState {

		public boolean payIn(double amount)
		{	
			 balance += amount ;
			 if(balance < 0)
				 state = negative ;
			 else
				 state = positive ;
			 
			 return true ;
		}
		public boolean payOff(double amount)
		{
			if(balance - amount < (lineOfCredit - lineOfCredit*2))
				return false ;
			
			 balance -= amount ;
			 
			 if(balance < 0)
				 state = negative ;
			 else
				 state = positive ;
			 
			 if(balance <= (lineOfCredit - lineOfCredit*2))
				 state = frozen ;
			 
			 return true ;
		}
		
		@Override
		public void printBalance() {
			// TODO Auto-generated method stub
			System.out.println("Balance is NEGATIVE: "+balance+".");
		}
		
	}
	
	//Frozen
	public class Frozen extends AccountState {

		public boolean payIn(double amount)
		{	
			 balance += amount ;
			 
			 if(balance < 0)
				 state = negative ;
			 else
				 state = positive ;
			 
			 return true ;
		}
		public boolean payOff(double amount)
		{	
			throw new IllegalStateException();
		}
		
		@Override
		public void printBalance() {
			// TODO Auto-generated method stub
			System.out.println("Balance is NEGATIVE: "+balance+". You need to pay in money.");
			
		}
		
	}
	
	//Closed
	public class Closed extends AccountState {

		public boolean payIn(double amount)
		{	
			throw new IllegalStateException();
		}
		public boolean payOff(double amount)
		{	
			throw new IllegalStateException();
		}
		@Override
		public void printBalance() {
			// TODO Auto-generated method stub
			System.out.println("This account is CLOSED. The balance is 0.");
		}
		
	}
	
	
}
