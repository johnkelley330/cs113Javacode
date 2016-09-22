package driverForArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethods
{
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
