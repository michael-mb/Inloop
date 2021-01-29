package mike_class;

public class Time {

	private int hour ;
	private int minute ;
	
	public Time(int hour , int minute)
	{
		if( hour< 0 || minute < 0 || hour >= 24 || minute >= 60)
			throw new IllegalArgumentException();
		
		this.hour = hour ;
		this.minute = minute ;
	}
	public int getHour()
	{
		return this.hour ;
	}
	public int getMinute()
	{
		return this.minute;
	}
}
