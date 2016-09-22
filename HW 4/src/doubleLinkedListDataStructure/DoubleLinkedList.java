package doubleLinkedListDataStructure;

import java.util.*;
/**
 * 
 * @author John
 *
 * @param <E>
 */
public class DoubleLinkedList<E>
{
	private Node <E> head = null;
	private Node <E> tail = null;
	private int size = 0;
	
	/** Add an item at the specified index.
	 @param index The index at which the object is to be inserted
	 @param obj The object to be inserted
	 @throws IndexOutOfBoundsException
	 if the index is out of range (i < 0 || i > size())
	*/
	public void add(int index, E obj)
	{
		listIterator(index).add(obj);
	}

	/** Get the element at position index.
	 @param index Position of item to be retrieved
	 @return The item at index
	*/
	public E get(int index)
	{
		return listIterator(index).next();
	} 

	/**
	 * Adds to the front of the list.
	 * @param item  The object to be added.
	 */
	private void addFirst(E item)
	{
		add(0, item);
	}
	
	/**
	 * Adds to the last position.
	 * @param item  The object to be added.
	 */
	private void addLast(E item)
	{
		add(size, item);
	}
	
	/**
	 * Returns the first item of the list.
	 * @return  The first item of the list.
	 */
	public E getFirst()
	{
		return head.data;
	} 
	
	/**
	 * Returns the last item of the list.
	 * @return  The last item of the list
	 */
	public E getLast()
	{
		return tail.data;
	} 
	public int size()
	{
		return size;
	}
	public boolean remove(E obj){}
	public String toString(){}
	
	/**
	 * This class contains the data, prev, and next reference for the DoubleLinkedList class.
	 * @param <E>
	 */
	private static class Node<E>
	{
		private E data;
		private Node<E> next = null;
		private Node<E> prev = null;
		
		/** Creates a new node with a null next field
		 * @param data The data stored
		 */
		private Node(E data)
		{
			this.data = data;
		}
		 
		/** Creates a new node that references another node
		 * @param data The data stored
		 * @param prev  The previous node reference.
		 * @param next  The next node reference.
		 */
		private Node(E data, Node<E> prev, Node<E> next)
		{
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private class DoubleListIterator implements ListIterator<E> {
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index = 0;
		
		/**
		 * Constructs an iterator and set the index to the specified index.
		 * @param index  The index to start to iterator at.
		 */
		public DoubleListIterator(int index)
		{
			if (index < 0 || index > size) 
			{
				throw new IndexOutOfBoundsException("Invalid index " + index);
			}
			lastItemReturned = null; 
			if (index == size)
			{
				this.index = size;
				nextItem = null;
			}
			else
			{ 
				nextItem = head;
				for (index = 0; this.index < index; index++)
				{
					nextItem = nextItem.next;
				}
			}
		} 

		/**
		 * Returns if the is a next item in the list.
		 * @return  If the is a next item in the list it returns true.
		 */
		public boolean hasNext()
		{
			return nextItem != null;
		}
		
		/**
		 * Moves to index by one. Returns the item that was at the last index.
		 * @return The item that was at the last index.
		 */
		public E next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}

		/**
		 * Returns if the list has a previous object.
		 * @return  Returns true if the is a previous object.
		 */
		public boolean hasPrevious()
		{
			return (nextItem == null && size != 0) || nextItem.prev != null;
		}

		/**
		 * Moves the index down one and returns the item that was stepped over.
		 */
		public E previous()
		{
			if (!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			if (nextItem == null)
			{
				nextItem = tail;
			}
			else
			{
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
		
		public void add(E obj)
		{
			if (head == null)
			{
				head = new Node<E>(obj);
				tail = head;
			}
			else if (nextItem == head)
			{
				Node<E> newNode = new Node<E>(obj);
				newNode.next = nextItem;
				nextItem.prev = newNode;
				head = newNode;
			}
			else if (nextItem == null)
			{
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
			else
			{
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			} 
		}
		private int nextIndex(){}
		private void remove(){}
		void set(E obj){}
	}
}
