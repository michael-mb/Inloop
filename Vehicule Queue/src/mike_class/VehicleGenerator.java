package mike_class;

import java.util.Random;

public class VehicleGenerator {

	private Random randomGenerator ;
	public VehicleGenerator()
	{
		this.randomGenerator = new Random() ;
		
	}
	public Vehicle createVehicle()
	{
	    int value = this.randomGenerator.nextInt(3);
		
		if(value==0)
			return new Bus();
		else 
			if(value==1)
			return new Car();
			else 
				return new Bicycle();
	}
}
