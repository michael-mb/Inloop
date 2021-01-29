package mike_class;

public class Flooring extends Material{

	private static double limit = 0.02 ;
	private double widthOfFlooring ;
	

	public Flooring(String name, double price , double width) {
		super(name, price);
		// TODO Auto-generated constructor stub
		if(width <=0)
			throw new IllegalArgumentException();
		
		this.widthOfFlooring = width ;
	}
	public double getWidth()
	{
		return this.widthOfFlooring;
	}
	
	@Override
	public int getMaterialReq(Surface s) {
		// TODO Auto-generated method stub
		if (s==null)
			throw new NullPointerException();
			
		double y = (s.getArea()/this.widthOfFlooring) ;
		int x = (int) y ;
		if((y - limit ) / x >= 1)
		{
			x = (int)y+1;
		}
		return x;
	}

}
