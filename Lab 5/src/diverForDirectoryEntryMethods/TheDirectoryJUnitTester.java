package diverForDirectoryEntryMethods;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class is made to test the TheDirectory classes methods.
 * @author John Kelley
 * @version 1.0
 */
public class TheDirectoryJUnitTester
{
	TheDirectory directory = new TheDirectory();
	
	@Test
	public void testAdd()
	{
		directory.addOrChangeEntry("John", "123");
		Assert.assertTrue(directory.get(0).equals(new DirectoryEntry("John", "123")));
	}
	
	@Test
	public void testRemove()
	{
		directory.addOrChangeEntry("John", "123");
		directory.removeEntry("John");
		Assert.assertTrue(directory.getSize() == 0);
	}
	
	@Test
	public void testReplace()
	{
		directory.addOrChangeEntry("John", "123");
		directory.addOrChangeEntry("John", "321");
		Assert.assertTrue(directory.get(0).equals(new DirectoryEntry("John", "321")));
	}
}