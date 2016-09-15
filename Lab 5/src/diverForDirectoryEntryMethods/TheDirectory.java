package diverForDirectoryEntryMethods;

import java.util.ArrayList;

/**
 * This class uses the DirectoryEntry class method to create a directory and the addOrChangeEntry and removeEntry methods.
 * @author John Kelley
 * @version 1.0
 */
public class TheDirectory{
	
	ArrayList<DirectoryEntry> directory = new ArrayList<DirectoryEntry>();
	int size = 0;
	
	/**
	 * Default constructor.
	 */
	public TheDirectory()
	{
	}
	
	/**
	 * Returns the string of the directory ArrayList.
	 * @return  String of the directory ArrayList.
	 */
	public String toString()
	{
		String stringOfDirectory = "(";
		for(int i = 0; i < directory.size(); i++)
		{
			if(i == directory.size() - 1)
			{
				stringOfDirectory += directory.get(i).toString();
			}
			else
			{
				stringOfDirectory += directory.get(i).toString() + ", ";
			}
		}
		stringOfDirectory += ")";
		return stringOfDirectory;
	}
	
	/**
	 * Add an entry to theDriectory or change existing entry.
	 * @param name  The name of the person being added or changed.
	 * @param number  The new number to be assigned.
	 * @return  The old number, or if new entry, null.
	 */
	public String addOrChangeEntry(String name, String number)
	{
		String temp = null;
		int index = directory.indexOf(new DirectoryEntry(name, ""));
		if(index != -1)
		{
			temp = directory.get(index).getName();
			directory.set(index, new DirectoryEntry(name, number));
		}
		else
		{
			directory.add(new DirectoryEntry(name, number));
		}
		++size;
		return temp;
	}
	
	/**
	 * Remove an entry.
	 * @param name  The name of the person being removed
	 * @return  The entry removed, null if there is no entry for the name.
	 */
	public DirectoryEntry removeEntry(String name)
	{
		int index = directory.indexOf(new DirectoryEntry(name, ""));
		DirectoryEntry temp = null;
		if(index > -1)
		{
			temp = directory.get(index);
			directory.remove(index);
			--size;
		}
		return temp;
	}
	
	/**
	 * Gets the directory entry at the index.
	 * @param index  The index to find the directory entry
	 * @return  The found directory entry, null, otherwise.
	 */
	public DirectoryEntry get(int index)
	{
		if(index < 0 || index >= directory.size())
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return directory.get(index);
	}
	
	/**
	 * Returns the size of the directory arrayList.
	 * @return  The size of the directory arrayList.
	 */
	public int getSize()
	{
		return size;
	}
}
