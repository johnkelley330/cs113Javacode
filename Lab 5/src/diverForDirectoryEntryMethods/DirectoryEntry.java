package diverForDirectoryEntryMethods;

public class DirectoryEntry
{
	String name;
	String number;
	
	/**
	 * Default constructor.
	 */
	public DirectoryEntry()
	{
		name = "";
		number = "";
	}
	
	/**
	 * The full constructor. Sets all the variables.
	 * @param name
	 * @param number
	 */
	public DirectoryEntry(String name, String number)
	{
		setAll(name, number);
	}
	
	public String toString()
	{
		return "[" + name + ", " + number + "]";
	}
	
	/**
	 * Sets name.
	 * @param name  The new name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets number.
	 * @param number  The new number.
	 */
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	/**
	 * Sets all the variables in one method.
	 * @param name  The new name.
	 * @param number  The new number
	 */
	public void setAll(String name, String number)
	{
		setName(name);
		setNumber(number);
	}
	
	/**
	 * Returns the name.
	 * @return  The name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the number.
	 * @return  The number.
	 */
	public String getNumber()
	{
		return number;
	}
	
	/**
	 * Copies one object to another.
	 * @param directoryToBeCopied  The object to be copied.
	 */
	public void copy(DirectoryEntry directoryToBeCopied)
	{
		name = directoryToBeCopied.getName();
		number = directoryToBeCopied.getNumber();
	}
	
	/**
	 * Compares two objects name for equality.
	 * @param directoryToBeCompared  The object to be compared to.
	 * @return  If the objects variables were equal it returns true.
	 */
	public boolean equals(Object obj)
	{
		if(obj instanceof DirectoryEntry)
		{
			DirectoryEntry comparedDirectoryEntry = (DirectoryEntry) obj;
			return name == comparedDirectoryEntry.getName();
		}
		return false;
	}
}
