package stackDataStructure;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack<E> {
	private static final int INITIAL_CAPACITY = 10;
	private ArrayList<E> stack;
	private int topOfStack;

	/**
	 * Constructs a new empty stack with topOfStack at -1.
	 */
	public ArrayStack() {
		topOfStack = -1;
		stack = new ArrayList<E>(INITIAL_CAPACITY);
	}

	/**
	 * @return Returns true if the stack is empty.
	 */
	public boolean empty() {
		return topOfStack == -1;
	}

	/**
	 * Throws the EmptyStackException if the stack is empty.
	 * 
	 * @return Returns the top element.
	 */
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		return stack.get(topOfStack);
	}

	/**
	 * Removes the top element. Throws the EmptyStackException if the stack is
	 * empty.
	 * 
	 * @return Returns the top element of the stack.
	 */
	public E pop() {
		if (empty()) {
			throw new EmptyStackException();
		}
		E temp = stack.get(topOfStack);
		topOfStack--;
		return temp;
	}

	/**
	 * Adds to the top and increments the topOfStack.
	 * 
	 * @param obj
	 *            The object to be added.
	 * @return The object added.
	 */
	public E push(E obj) {
		topOfStack++;
		stack.add(obj);
		return obj;
	}
}