package testerForDubleLinkedList;

import doubleLinkedListDataStructure.DoubleLinkedList;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
/**
 * Tests the DoubleLinkedList class' methods.
 * @author John Kelley
 * @version 1.0
 *
 */
public class TestForDoubleLinkedList {
	@Test
	public void testToStringEmpty() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		Assert.assertEquals("{}", students.toString());
	}

	@Test
	public void testToStringOneElement() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		Assert.assertEquals("{John}", students.toString());
	}

	@Test
	public void testToStringElements() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		Assert.assertEquals("{John ==> James}", students.toString());
	}

	@Test
	public void testIndexedAddEmptyNotAtZero() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		try {
			students.add(1, "John");
			Assert.fail();
		} catch (IndexOutOfBoundsException ex) {
		}
	}

	@Test
	public void testIndexedAddEmptyAtZero() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add(0, "John");
		Assert.assertEquals(students.get(0), "John");
	}

	@Test
	public void testIndexedAddWithElementsAtZero() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("James");
		students.add(0, "John");
		Assert.assertEquals(students.get(0), "John");
	}

	@Test
	public void testIndexedAddWithElementsAtMiddle() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("James");
		students.add(1, "John");
		Assert.assertEquals(students.get(1), "John");
	}

	@Test
	public void testIndexedAddWithElementsAtEnd() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("James");
		students.add(2, "John");
		Assert.assertEquals(students.get(2), "John");
	}

	@Test
	public void testIndexedAddWithElementsPassedEnd() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("James");
		try {
			students.add(3, "John");
			Assert.fail();
		} catch (IndexOutOfBoundsException ex) {
		}
	}

	@Test
	public void testNonIndexedAddEmpty() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		Assert.assertEquals(students.get(0), "John");
	}

	@Test
	public void testNonIndexedAddElements() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("James");
		students.add("John");
		Assert.assertEquals(students.get(2), "John");
	}

	@Test
	public void testGetEmpty() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		try {
			students.get(0);
			Assert.fail();
		} catch (NoSuchElementException ex) {

		}
	}

	@Test
	public void testGetPastEnd() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		try {
			students.get(1);
			Assert.fail();
		} catch (NoSuchElementException ex) {

		}
	}

	@Test
	public void testGetNegitiveIndex() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		try {
			students.get(-1);
			Assert.fail();
		} catch (IndexOutOfBoundsException ex) {

		}
	}

	@Test
	public void testGetFirst() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		Assert.assertEquals("John", students.get(0));
	}

	@Test
	public void testGetMiddle() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("John");
		students.add("James");
		Assert.assertEquals("John", students.get(1));
	}

	@Test
	public void testGetEnd() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("Jim");
		students.add("John");
		students.add("James");
		Assert.assertEquals("James", students.get(2));
	}

	@Test
	public void testGetFirstEmpty() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		try {
			students.getFirst();
			Assert.fail();
		} catch (NoSuchElementException ex) {

		}
	}

	@Test
	public void testGetFirstElements() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		Assert.assertEquals("John", students.getFirst());
	}

	@Test
	public void testGetLastEmpty() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		try {
			students.getLast();
			Assert.fail();
		} catch (NoSuchElementException ex) {

		}
	}

	@Test
	public void testGetLastElements() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		Assert.assertEquals("James", students.getLast());
	}

	@Test
	public void testSize() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		Assert.assertTrue(students.size() == 0);
		students.add("John");
		Assert.assertTrue(students.size() == 1);
		students.add(0, "James");
		Assert.assertTrue(students.size() == 2);
		students.add(2, "Jim");
		Assert.assertTrue(students.size() == 3);
	}

	@Test
	public void testEqualsEmpty() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		Assert.assertTrue(students.equals(new DoubleLinkedList<String>()));
	}

	@Test
	public void testEqualsSizeNotEqual() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		DoubleLinkedList<String> kids = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		students.add("Jim");
		kids.add("Beth");
		kids.add("Joe");
		Assert.assertFalse(students.equals(kids));
	}

	@Test
	public void testEqualsElementsNotEqual() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		DoubleLinkedList<String> kids = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		students.add("Jim");
		kids.add("Beth");
		kids.add("Joe");
		kids.add("Hue");
		Assert.assertFalse(students.equals(kids));
	}

	@Test
	public void testEqualsElementsEqual() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		DoubleLinkedList<String> kids = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		students.add("Jim");
		kids.add("John");
		kids.add("James");
		kids.add("Jim");
		Assert.assertTrue(students.equals(kids));
	}

	@Test
	public void testClearOneElement() {
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.clear();
		Assert.assertTrue(students.size() == 0);
	}
	
	@Test
	public void testClearElements(){
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		students.clear();
		Assert.assertTrue(students.size() == 0);
	}
	
	@Test
	public void testIsEmptyEmpty()
	{
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		Assert.assertTrue(students.isEmpty());
	}
	
	@Test
	public void testIsEmptyElements()
	{
		DoubleLinkedList<String> students = new DoubleLinkedList<String>();
		students.add("John");
		students.add("James");
		Assert.assertFalse(students.isEmpty());
	}
}
