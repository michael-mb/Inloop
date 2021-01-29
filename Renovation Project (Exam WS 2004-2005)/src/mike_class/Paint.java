package mike_class;

public class Paint extends Material{

	private static double limit = 0.02 ;
	private int noCoats ;
	private double noOfSqMPerLiter ;
	
	public Paint(String name, double price , int noCoats , double noOfSqMPerLiter) {
		super(name, price);
		// TODO Auto-generated constructor stub
		if(noCoats<=0 || noOfSqMPerLiter<=0)
		    throw new IllegalArgumentException();
		this.noCoats = noCoats ;
		this.noOfSqMPerLiter = noOfSqMPerLiter;
	}

	public int getNoOfCoats()
	{
		return this.noCoats;
	}
	public double getNoOfSqMPerLiter()
	{
		return this.noOfSqMPerLiter;
	}
	@Override
	public int getMaterialReq(Surface s) {
		// TODO Auto-generated method stub
		if(s==null)
			throw new NullPointerException();
		
		double y = s.getArea()*this.noCoats / this.noOfSqMPerLiter * 2 ;
		int x =(int) Math.round(y);
		double z = ((y - limit) / x) ;
		if(z >1)
		{
			x = (int)y+1;
		}

		System.out.println("x="+x+" et y="+y+" et z="+z);
		return x;
	}
}
