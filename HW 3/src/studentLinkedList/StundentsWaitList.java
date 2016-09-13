package studentLinkedList;

import singleLinkedListClass.SingleLinkedList;;
public class StundentsWaitList
{
	SingleLinkedList<String> waitList = new SingleLinkedList<String>();
	
	/**
	 * Adds a student to waitList.
	 * @param student  The student to be added.
	 */
	public void addStudent(String student)
	{
		waitList.add(student);
	}
	
	/**
	 * Adds a student to the front of waitList.
	 * @param student  The student to be added to the front of waitList.
	 */
	public void addStudentFirst(String student)
	{
		waitList.addFirst(student);
	}
	
	/**
	 * Removes the first student.
	 */
	public String removeFirstStudent()
	{
		return waitList.remove(0);
	}
	
	
	public String removeStudentByName(String name)
	{
		int index = 0;
		while(index < waitList.size() && name != waitList.get(index))
		{
			index++;
		}
		return waitList.remove(index);
	}
	
	/**
	 * Returns wait list as a string.
	 */
	public String toString()
	{
		return waitList.toString();
	}
}