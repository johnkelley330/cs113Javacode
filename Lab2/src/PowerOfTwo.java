/**
 * PowerOfTwo class: Contains the evaluateNumber method to return where the inputed number
 * is a power of two. If the number is a power of two it returns a one otherwise it returns 0.
 * 
 * @author John Kelley
 * @version 1.0
 *
 */
public class PowerOfTwo {
	public PowerOfTwo(){
	}
	
   	public int evaluateNumber(int num){
	   	int powerOfTwo = 2;
		while( powerOfTwo < num){
			powerOfTwo *= 2;
		}
		//Runs if the user input was a power of two.
		if(powerOfTwo == num) {
			return 1;
		}
		//Runs if the user input was not a power of two.
		else {
			return 0;
		}
	}
}
