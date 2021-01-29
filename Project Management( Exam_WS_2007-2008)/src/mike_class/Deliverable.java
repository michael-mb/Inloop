package mike_class;

import java.time.LocalDate;
import java.util.Calendar;

public class Deliverable extends ProjectItem{

	private long materialCost ;
	private double productionTime ;
	private  LocalDate date;
	
	public Deliverable(String name , String details , double rate , long materialCost , double productionTime , LocalDate date)
	{
		super(name , details , rate);
		if(materialCost < 0 || productionTime <= 0 )
			throw new IllegalArgumentException();
		if(date == null)
			throw new NullPointerException();
		
		this.materialCost = materialCost;
		this.productionTime = productionTime;
		this.date = date;
	}

	@Override
	public double getTimeRequired() {
		// TODO Auto-generated method stub
		
		return this.productionTime;
	}

	@Override
	public long getMaterialCost() {
		// TODO Auto-generated method stub
		return this.materialCost;
	}
	public LocalDate getDate()
	{
		return this.date;
		
	}
}
