package e512;

public class Exercise512
{
	public String stutter(String text){
		if(text == null || text.length() == 0) {
			return "";
		}
		else{
			return "" + text.charAt(0) + text.charAt(0) + stutter(text.substring(1));
		}
	}
}
