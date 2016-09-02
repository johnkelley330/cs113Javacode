
import java.util.Scanner;

/**
 * The power of 2 program takes a number for the user and outputs if it is a power of 2 or not.
 * It also returns to what power of two the number is if it was a power of two.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class Main
{

	public static void main(String[] args)
	{
		int powerOfTwoResults = 0;
		int num;
		
		Scanner numberScanner = new Scanner(System.in);
		PowerOfTwo powerOfTwoFinder = new PowerOfTwo();
		
		System.out.println("Welcome to the power of two evaluator.           |");		
		System.out.println("Enter the number you wish to be evaluated below. V");

		num = numberScanner.nextInt();

		numberScanner.close();

		powerOfTwoResults = powerOfTwoFinder.evaluateNumber(num);

		if(powerOfTwoResults == 1)
		{
			System.out.println("The number " + num + " is a power of two.");
		}
		else
		{
			System.out.println("The number " + num + " is not a power of two.");
		}
	}

}