/**
 * Main.java: Prints the numbers form 1 to 100 except for the multiples of 3 and 5.
 * If it is a multiple of 3 is prints Fizz and if it is a multiple of 5 it prints Buzz.
 * If it is a multiple of 3 and 5 it prints Fizzbuzz
 * @author John Kelley
 * @version 1.0
 */
public class Main
{

	public static void main(String[] args)
	{
		for(int i = 1; i <= 100; i++)
		{
			if(i % 3 == 0 && i % 5 == 0)
			{
				System.out.println("Fizzbuzz");
			}
			else if(i % 3 == 0)
			{
				System.out.println("Fizz");
			}
			else if(i % 5 == 0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(i);
			}
		}
	}

}