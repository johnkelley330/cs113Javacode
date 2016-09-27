package testerForDubleLinkedList;
import doubleLinkedListDataStructure.DoubleLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestForDoubleLinkedList
{
	@Test
	public void testTheAddMethods()
	{
		DoubleLinkedList students = new DoubleLinkedList<String>();
		students.add(0, "John");
		Assert.assertTrue(students.get(0) == "John");
		students.add(0, "James");
		Assert.assertTrue(students.get(0) == "James");
		Assert.assertTrue(students.get(1) == "John");
		students.add("Will");
	}
}
