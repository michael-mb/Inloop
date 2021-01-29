package mike_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class VehicleQueue implements Observer{

	private double entryDelay ;
	private double exitDelay;
	private int trafficLigthRate;
	private boolean greenLight = false ;
	private VehicleGenerator generator ;
	private List<Vehicle> queue;
	
	
	private static int curTimeTrafficChanged = 0 ;
	private static double entryNext ;
	private static double leaveNext ;
	
	
	public VehicleQueue(double entryDelay ,  double exitDelay , int trafficLightRate , VehicleGenerator generator)
	{
		if(entryDelay <= 0 || exitDelay <=0 || trafficLightRate  <= 0)
			throw new IllegalArgumentException();
		if(generator==null)
			throw new NullPointerException();
		
		this.entryDelay = entryDelay ;
		this.exitDelay = exitDelay ;
		this.trafficLigthRate = trafficLightRate;
		this.generator = generator ;
		this.queue = new ArrayList<Vehicle>();
		this.entryNext = 0 ;
		this.leaveNext = 0 ;
	}	
	public void enter()
	{
		
		Vehicle v =  generator.createVehicle();
		this.queue.add(v);
	}
	public void leave()
	{
		if(this.queue.isEmpty())
		{
			
		}
		else
		{
			this.queue.remove(this.queue.get(0));
		}
	   
	}
	public double getLength()
	{
		double l = 0 ; 
		for (Vehicle v : this.queue)
		{
			l += v.getLength();
		}
        return l;
	}
	public int getSize()
	{

		return this.queue.size()  ;
	}

	@Override
	public void update(Observable o, Object o2) {
		// TODO Auto-generated method stub
		
		int curTime = (int)o2 ;
					
		System.out.println("! --------------------- !\ncurTime= "+curTime);
	
		//Enter  !!!!!
		if(curTime % this.entryDelay >= 0 && curTime % this.entryDelay < 1 )
		{
	
			if(this.entryDelay>=1)
			{
				System.out.println("Enter 1");
				enter();
				this.entryNext += this.entryDelay ;
			}
			else
			{
				System.out.println("Enter 2");
				enter();
				this.entryNext += this.entryDelay ;	
				
				this.entryNext = (double) (Math.round(this.entryNext*1000) )/ 1000 ;
				
				//System.out.println("Next "+ this.entryNext+" Delay "+this.entryDelay);
				
				while( this.entryNext <= curTime && this.entryNext + this.entryDelay  <= curTime) 
				{					
					System.out.println("Enter 3");
					enter();
					this.entryNext += this.entryDelay;
					this.entryNext = (double)Math.round(this.entryNext*1000) / 1000 ;
//					this.entryDelay = (double)Math.round(this.entryDelay*1000) / 1000;
				
				}
				System.out.println("EntryNext "+this.entryNext+" and EntryNext + entryDelay "+ (this.entryNext + this.entryDelay) +" Is True : " + ( this.entryNext <= curTime && this.entryNext + this.entryDelay <= curTime));
				
			}
			
			//System.out.println(this.entryNext);
			
		}
		
		//leave !!!!!
		
		if(this.greenLight)
		{
			if( (curTime - curTimeTrafficChanged ) % this.exitDelay >= 0 &&  (curTime - curTimeTrafficChanged) % this.exitDelay < 1  )
			{

				if(this.exitDelay>=1)
				{
				    System.out.println("Leave 1" + curTime % this.exitDelay);
					System.out.println("curtime " + curTime + " Delay "+this.exitDelay);
					leave();
					this.leaveNext += this.exitDelay ;
				}
				else
				{
					System.out.println("leave 2");
					leave();
					this.leaveNext += this.exitDelay ;
					
					this.leaveNext = (double)Math.round(this.leaveNext*1000) / 1000 ;
					
					System.out.println("leaveNext " + this.leaveNext +" Abstand : "+ (curTime - curTimeTrafficChanged ));
					
					while(this.leaveNext <= (curTime - curTimeTrafficChanged ) && this.leaveNext + this.exitDelay <= (curTime - curTimeTrafficChanged ))
					{
						System.out.println("leave 3");
						leave();
						this.leaveNext += this.exitDelay ;
						this.leaveNext = (double)Math.round(this.leaveNext*1000) / 1000 ;
					}
					
//					System.out.println("leaveNext " + this.leaveNext +" Abstand : "+ (curTime - curTimeTrafficChanged ));
					
				}
			}
		
			
		}
		
		if(curTime % this.trafficLigthRate == 0)
		{
		  	this.greenLight = !this.greenLight; 
		  	curTimeTrafficChanged = curTime ;
		  	System.out.println("CurTime "+curTime + " and TrafficLigthRate " +this.trafficLigthRate +" GrennLigth :"+this.greenLight);
		  	if(this.greenLight==false)
		  	{
		  		this.leaveNext = 0 ;
		  	}
		}
		
		//System.out.println("Mod "+ (4.3 % 1.3));
		
		System.out.println("Size = "+this.getSize());
	
	}
	
	
}
