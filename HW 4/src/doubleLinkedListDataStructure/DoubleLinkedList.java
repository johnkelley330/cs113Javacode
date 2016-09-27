package doubleLinkedListDataStructure;

import java.util.*;

/**
 * DoubleLinkedList.java: contains the method and variables necessary to create
 * and manipulate a double linked list data structure. It contains the inner
 * classes Node<E> and DoubleListIterator.
 * 
 * @author John Kelley
 * @version 1.0
 * @param <E>
 *            The data type to be stored in the list.
 */
public class DoubleLinkedList<E> implements List<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	/**
	 * Returns a string of the double linked list.
	 * 
	 * @return The string of the double linked list.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> lastItem = head;
		sb.append("{");
		for (int index = 0; index < size; index++) {
			sb.append(lastItem.data);
			if (index < size - 1) {
				sb.append(" ==> ");
			}
			lastItem = lastItem.next;
		}
		sb.append("}");
		return sb.toString();

	}

	/**
	 * Add an item at the specified index.
	 * 
	 * @param The
	 *            index at which the object is to be inserted
	 * @param The
	 *            object to be inserted
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (i < 0 || i > size())
	 */
	public void add(int index, E obj) {
		listIterator(index).add(obj);
		System.out.println("1");
	}

	/**
	 * Add the object to the end of the list and returns true.
	 * 
	 * @param The
	 *            object to be added at the end of the list.
	 * @return Always returns true.
	 */
	public boolean add(E obj) {
		listIterator(size).add(obj);
		System.out.println("2");
		return true;
	}

	/**
	 * Get the element at position index.
	 * 
	 * @param The
	 *            position of item to be retrieved
	 * @return The item at index
	 */
	public E get(int index) {
		return listIterator(index).next();
	}

	/**
	 * Adds to the front of the list.
	 * 
	 * @param The
	 *            object to be added.
	 */
	private void addFirst(E item) {
		add(0, item);
	}

	/**
	 * Adds to the last position.
	 * 
	 * @param The
	 *            object to be added.
	 */
	private void addLast(E item) {
		add(size, item);
	}

	/**
	 * Returns the first item of the list.
	 * 
	 * @return The first item of the list.
	 */
	public E getFirst() {
		return head.data;
	}

	/**
	 * Returns the last item of the list.
	 * 
	 * @return The last item of the list
	 */
	public E getLast() {
		return tail.data;
	}

	/**
	 * Returns the size of the list.
	 * 
	 * @return The size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Creates and returns a new list iterator at index 0 for the double linked
	 * list.
	 * 
	 * @return The new list iterator.
	 */
	public ListIterator<E> listIterator() {
		return new DoubleListIterator(0);
	}

	/**
	 * Creates a list iterator and the index for a duble linked list.
	 * 
	 * @return The new list iterator.
	 */
	public ListIterator<E> listIterator(int index) {
		return new DoubleListIterator(index);
	}

	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	public void clear() {
	}

	public boolean contains(Object o) {
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		return false;
	}

	public boolean equals(Object o) {
		return false;
	}

	public int hashCode() {
		return -1;
	}

	public int indexOf(Object o) {
		return -1;
	}

	public boolean isEmpty() {
		return false;
	}

	public Iterator<E> iterator() {
		return null;
	}

	public int lastIndexOf(Object o) {
		return -1;
	}

	public E remove(int index) {
		return null;
	}

	public boolean remove(Object o) {
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		return false;
	}

	public E set(int index, E element) {
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	public Object[] toArray() {
		return null;
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

	/**
	 * This class contains the data, prev, and next reference for the
	 * DoubleLinkedList class.
	 * 
	 * @param <E>
	 *            The data type to be stored in the node.
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next = null;
		private Node<E> prev = null;

		/**
		 * Creates a new node with a null next field
		 * 
		 * @param The
		 *            data stored
		 */
		private Node(E data) {
			this.data = data;
		}

	}

	private class DoubleListIterator implements ListIterator<E> {
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index = 0;

		/**
		 * Constructs an iterator and set the index to the specified index.
		 * 
		 * @param index
		 *            The index to start to iterator at.
		 */
		public DoubleListIterator(int index) {
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException("Invalid index " + index);
			}
			lastItemReturned = null;
			if (index == size) {
				this.index = size;
				nextItem = null;
			} else {
				nextItem = head;
				for (int i = 0; i < index; index++) {
					nextItem = nextItem.next;
				}
			}
		}

		/**
		 * Returns if the is a next item in the list.
		 * 
		 * @return If the is a next item in the list it returns true.
		 */
		public boolean hasNext() {
			return nextItem != null;
		}

		/**
		 * Moves to index by one. Returns the item that was at the last index.
		 * 
		 * @return The item that was at the last index.
		 */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		/**
		 * Returns if the list has a previous object.
		 * 
		 * @return Returns true if the is a previous object.
		 */
		public boolean hasPrevious() {
			return (nextItem == null && size != 0) || nextItem.prev != null;
		}

		/**
		 * Moves the index down one and returns the item that was stepped over.
		 * 
		 * @return The node that was moved over to go to the previous node.
		 */
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (nextItem == null) {
				nextItem = tail;
			} else {
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		/**
		 * Adds the object
		 * 
		 * @param The
		 *            object to be added.
		 */
		public void add(E obj) {
			if (head == null) {
				head = new Node<E>(obj);
				tail = head;
			} else if (nextItem == head) {
				Node<E> newNode = new Node<E>(obj);
				newNode.next = nextItem;
				nextItem.prev = newNode;
				head = newNode;
			} else if (nextItem == null) {
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			} else {
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			size++;
			index++;
			lastItemReturned = null;
		}

		/**
		 * Returns the index of the next node.
		 * 
		 * @return The next node's index
		 */
		public int nextIndex() {
			if (nextItem == null) {
				return size;
			}
			return index;
		}

		/**
		 * Returns the index of the previous node.
		 * 
		 * @return The previous node's index
		 */
		public int previousIndex() {
			if (index == 0) {
				return -1;
			}
			return index - 1;
		}

		public void set(E obj) {
		}

		public void remove() {
		}
	}
}
