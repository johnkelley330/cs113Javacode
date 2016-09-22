package driverForArrayListMethods;
import java.util.ArrayList;

/**
 * The class is made to test the delete and remove methods to modify arrayLists.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class arrayListDriver
{	
	public void testDelete()
	{
		ArrayList<String> orders = new ArrayList<String>();
		ArrayListMethods alm = new ArrayListMethods();
		orders.add("Hot Dog");
		orders.add("Fries");
		orders.add("Hot Dog");
		alm.delete(orders, "Fries");
	}
}