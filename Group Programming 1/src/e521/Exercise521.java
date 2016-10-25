package e521;

public class Exercise521
{
	public double power(int x, int n){
		if(n == 0) {
			return 1;
		}
		if(n < 0){
			++n;
			return 1.0/x * power(x, n); 
		}
		else {
			--n;
			return x * power(x, n); 
		}
	
		
	}
}
