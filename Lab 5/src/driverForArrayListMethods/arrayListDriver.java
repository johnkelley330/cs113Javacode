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
	public static void main(String[] args)
	{
		ArrayList<String> orders = new ArrayList<String>();
		orders.add("Burger");
		orders.add("Fries");
		orders.add("Shake");
		orders.add("Chiken Fingers");
		orders.add("Coffee");
		orders.add("Diet Coca cola");
		orders.add("Burger");
		orders.add("Fries");
		System.out.println(orders.toString());
		replace(orders, "Fries", "Sold out");
		System.out.println("//Replaces fries with sold out.");
		System.out.println(orders.toString());
		delete(orders, "Coffee");
		System.out.println("//Removes the coffee form the list.");
		System.out.println(orders.toString());
	}

	/**
	 * Replace each occurrence of oldItem in aList with newItem.
	 * @param aList  The arrayList to be considered.
	 * @param oldItem  The item to be replaced.
	 * @param newItem  The item that is replacing the oldItem.
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i) == oldItem)
			{
				aList.set(i, newItem);
			}
		}
	}
	
	/**
	 * Removes each occurrence of the specified string.
	 * @param aList  The arrayList to be considered
	 * @param target  The item to be removed.
	 */
	public static void delete(ArrayList<String> aList, String target)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i) == target)
			{
				aList.remove(i);
			}
		}
	}
}