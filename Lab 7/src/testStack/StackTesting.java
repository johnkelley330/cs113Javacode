package testStack;

import org.junit.Assert;
import org.junit.Test;
import stackDataStructure.ArrayStack;
import java.util.EmptyStackException;

public class StackTesting {

	ArrayStack<String> students;

	@Test
	public void testEmptyNew() {
		students = new ArrayStack<String>();
		Assert.assertTrue(students.empty() == true);
	}

	@Test
	public void testEmptyPush() {
		students = new ArrayStack<String>();
		students.push("John");
		Assert.assertFalse(students.empty() == true);
	}

	@Test
	public void testEmpty2PushPop() {
		students = new ArrayStack<String>();
		students.push("John");
		students.push("James");
		students.pop();
		Assert.assertFalse(students.empty() == true);
	}

	@Test
	public void testEmptyPushPop() {
		students = new ArrayStack<String>();
		students.push("John");
		students.pop();
		Assert.assertTrue(students.empty() == true);
	}

	@Test
	public void testPushEmptyStack() {
		students = new ArrayStack<String>();
		students.push("John");
		Assert.assertEquals(students.peek(), "John");
	}

	@Test
	public void testPushWithElements() {
		students = new ArrayStack<String>();
		students.push("John");
		students.push("James");
		Assert.assertEquals(students.peek(), "James");
	}

	@Test
	public void testPeekEmpty() {
		students = new ArrayStack<String>();
		try {
			students.peek();
			Assert.fail();
		} catch (EmptyStackException ex) {
		}
	}

	@Test
	public void testPeekFirstElement() {
		students = new ArrayStack<String>();
		students.push("John");
		Assert.assertEquals(students.peek(), "John");
	}

	@Test
	public void testPeekWithElements() {
		students = new ArrayStack<String>();
		students.push("John");
		students.push("James");
		Assert.assertEquals(students.peek(), "James");
	}

	@Test
	public void testPopEmpty() {
		students = new ArrayStack<String>();
		try {
			students.pop();
			Assert.fail();
		} catch (EmptyStackException ex) {
		}
	}

	@Test
	public void testPopFirst() {
		students = new ArrayStack<String>();
		students.push("John");
		Assert.assertEquals(students.pop(), "John");
	}

	@Test
	public void testPopWithElements() {
		students = new ArrayStack<String>();
		students.push("John");
		students.push("James");
		Assert.assertEquals(students.pop(), "James");
	}
}
