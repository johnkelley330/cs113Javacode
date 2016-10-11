package changeFinder;

public class Test {
	public static void main(String[] agrs) {
		ChangeFinder change = new ChangeFinder();
		change.findChange(1.25);
		change.findChange(0.75);
		change.findChange(0.47);
	}
}