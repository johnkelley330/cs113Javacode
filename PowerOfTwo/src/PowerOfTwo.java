
/**
 * PowerOfTwo class: Contains the evaluateNumber method to return where the inputed number
 * is a power of two. If the number is a power of two it returns a one otherwise it returns 0.
 * 
 * @author John Kelley
 * @version 1.0
 *
 */
public class PowerOfTwo
{

   	/**
   	 * Returns if a number is a power of two or not.
   	 * @param num  The number to be evaluated.
   	 * @return  One if it is a power of two and zero if it is not.
   	 */
	public int evaluateNumber(int num)
	{
	   	int powerOfTwo = 2;
		while( powerOfTwo < num){
			powerOfTwo *= 2;
		}
		if(powerOfTwo == num)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}