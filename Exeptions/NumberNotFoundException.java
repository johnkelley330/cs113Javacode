public class NumberNotFoundException extends Exception
{
	private int badNum;
	
	public NumberNotFoundException()
	{
		super("Number not found in array");
	}
	
	public NumberNotFoundException(String m, int badNum)
	{
		super(m + "; Bad number = " + badNum);
		this.badNum = badNum;
	}
	
	public int getBadNum()
	{
		return this.badNum;
	}

}
