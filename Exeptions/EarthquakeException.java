public class EarthquakeException extends Exception
{
	private double magnitude;
	private String location;
	
	public EarthquakeException()
	{
		super("Earthquake happened! Check gaslines, etc.");
	}
	
	public EarthquakeException(String m, double magnitude, String location)
	{
		super(m);
		this.magnitude = magnitude;
		this.location = location;
	}
	
	public double getMagnitude()
	{
		return this.magnitude;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	@Override
	public String getMessage()
	{
		if(this.magnitude == 0.0 || this.location == null)
		{
			return super.getMessage();
		}
		else
		{
			return String.format("%s; Magnitude %.1f; %s",
				super.getMessage(), this.magnitude, this.location);
		}
	}
	

}
