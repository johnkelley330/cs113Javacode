/**
 * This class prints the numbers form 1 to 100 except for the multiples of 3 and 5.
 * If it is a multiple of 3 is prints Fizz and if it is a multiple of 5 it prints Buzz.
 * If it is a multiple of 3 and 5 it prints FizzBuzz
 * @author John Kelley
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		//This for loop run 100 times
		for(int i = 1; i <= 100; i++)
		{
			//Runs if i is a multiple of 3 and 5
			if(i % 3 == 0 && i % 5 == 0)
			{
				System.out.println("FizzBuzz");
			}
			//Runs if i is a multiple of 3
			else if(i % 3 == 0)
			{
				System.out.println("Fizz");
			}
			//Runs if i is a multiple of 5
			else if(i % 5 == 0)
			{
				System.out.println("Buzz");
			}
			//Runs if nothing else is true
			else
			{
				System.out.println(i);
			}
		}
	}

}
