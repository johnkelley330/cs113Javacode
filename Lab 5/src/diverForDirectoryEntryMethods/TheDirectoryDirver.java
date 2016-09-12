package diverForDirectoryEntryMethods;

/**
 * This class is made to test the TheDirectory classes methods.
 * @author John Kelley
 * @version 1.0
 */
public class TheDirectoryDirver {

	public static void main(String[] args)
	{
		TheDirectory directory = new TheDirectory();
		directory.addOrChangeEntry("Jill", "1(754)964-1572");
		directory.addOrChangeEntry("Hue", "1(534)845-9546");
		directory.addOrChangeEntry("Bill", "1(386)423-9460");
		System.out.println(directory.toString());
		directory.removeEntry("Hue");
		System.out.println(directory.toString());
	}

}
