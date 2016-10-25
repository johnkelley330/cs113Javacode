package e511;

public class Exercise511 {
	
	
	public int toNumber(String text) {
		int digit;
		if(text.length() == 0){
			return 0;
		}
		if(Character.isDigit(text.charAt(0))) {
			digit = Character.digit(text.charAt(0), 10);
			text = text.substring(1);
			return digit + toNumber(text);
		}
		else{
			text = text.substring(1);
			return toNumber(text);
		}
	}
}
