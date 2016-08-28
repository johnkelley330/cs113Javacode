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
		System.out.println("Welcome to the power of two evaluator.           |");		
		System.out.println("Enter the number you wish to be evaluated below. V");
		//Assigns num to the user input.
		int num = numberScanner.nextInt();
		//Closes scanner to prevent leakage.
		numberScanner.close();
		//The variable powerOfTwo keeps track of the multiple of two that we are on.
		int powerOfTwo = 2;
		//The variable i keeps track of what power of two we are on.
		int i = 1;
		while( powerOfTwo < num){
			powerOfTwo *= 2;
			i++;
		}
		//Runs if the user input was a power of two.
		if(powerOfTwo == num) {
			System.out.println("The number " + num + " is two to the power of " + i + ".");
		}
		//Runs if the user input was not a power of two.
		else {
			System.out.println("The number " + num + " is not a power of two.");
		}
	}

}
