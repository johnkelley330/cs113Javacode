
public class PartA
{
	public static void main(String[] args)
	{
		//PART A
		try
		{
			throw new EarthquakeException();
		}
		catch(EarthquakeException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Done testing default EarthquakeException!");
		}
		
		try
		{
			throw new EarthquakeException("This was a bad one!", 8.4, "Chile");
		}
		catch(EarthquakeException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Done testing full EarthquakeException!");
		}
		
	}
}
