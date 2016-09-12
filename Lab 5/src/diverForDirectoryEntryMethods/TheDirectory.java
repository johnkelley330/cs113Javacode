package diverForDirectoryEntryMethods;
import java.util.ArrayList;

public class TheDirectory {
	
	ArrayList<DirectoryEntry> directory = new ArrayList<DirectoryEntry>();
	
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
		boolean nameFound = false;
		String temp = null;
		for(int i = 0; i < directory.size() || nameFound == true; i++)
		{
			if(name == directory.get(i).getName())
			{
				nameFound = true;
				temp = directory.get(i).getNumber();
				directory.get(i).setNumber(number);
			}
		}
		if(nameFound == false)
		{
			directory.add(new DirectoryEntry(name, number));
		}
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
		}
		return temp;
	}
}
