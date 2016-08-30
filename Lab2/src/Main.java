import java.util.Scanner;

/**
 * The power of 2 program takes a number for the user and outputs if it is a power of 2 or not.
 * It also returns to what power of two the number is if it was a power of two.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		//Imports a scanner to read the users input.
		Scanner numberScanner = new Scanner(System.in);
		//Creates the PowerOfTwo object.
		PowerOfTwo powerOfTwoFinder = new PowerOfTwo();
		System.out.println("Welcome to the power of two evaluator.           |");		
		System.out.println("Enter the number you wish to be evaluated below. V");
		//Assigns num to the user input.
		int num = numberScanner.nextInt();
		//Creates the powerOfTwoResults int to store the returned results
		int powerOfTwoResults = 0;
		//Closes scanner to prevent leakage.
		numberScanner.close();
		//Runs the evaluateNumber method from the PowerOfTwoClass with the input from the user.
		powerOfTwoResults = powerOfTwoFinder.evaluateNumber(num);
		//Runs if the user input was a power of two.
		if(powerOfTwoResults == 1) {
			System.out.println("The number " + num + " is a power of two.");
		}
		//Runs if the user input was not a power of two.
		else {
			System.out.println("The number " + num + " is not a power of two.");
		}
	}

}
