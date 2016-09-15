package singleLinkedListClass;

public class SingleLinkedList<E>
{
	private Node<E> head = null;
	private int size;
	
	/**
	 * Add an item to the front of the list.
	 * @param item  The item to be added.
	 */
	public void addFirst(E item)
	{
		head = new Node<E>(item, head);
		size++;
	}
	

	/**
	 * Add after a given node.
	 * @param node  The node preceding the new item
	 * @param item  The item to be inserted.
	 */
	private void addAfter(Node<E> node, E item)
	{
		node.next = new Node<E>(item, node.next);
		size++;
	}
	
	/**
	 * Removes the node after the referenced node.
	 * @param node  The node preceding the node to be removed.
	 * @return  The removed nodes data.
	 */
	private E removeAfter (Node<E> node)
	{
		Node<E> temp = node.next;
		if (temp != null)
		{
			node.next = temp.next;
			size--;
			return temp.data;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Removes the first node.
	 * @return  The data of the removed node.
	 */
	private E removeFirst()
	{
		if (head == null)
		{
			return null;
		}
		else
		{
			Node<E> temp = head;
			head = head.next;
			size--;
			return temp.data;
		}
	}
	
	/**
	 * Returns the string of all the nodes.
	 */
	public String toString()
	{
		Node<E> nodeRef = head;
		String result = "";
		while (nodeRef != null)
		{
		result += (String)nodeRef.data;
			if (nodeRef.next != null) {
				result += " ==> ";
			}
		nodeRef = nodeRef.next;
		}
		return result;
	}
	
	/**
	 * Return the node at the index specified.
	 * @param index  The index of the node.
	 * @return  The node at the index, null if non at the index.
	 */
	private Node<E> getNode(int index)
	{
		Node<E> node = head;
		int i = 0;
		while(i < index && node != null)
		{
			node = node.next;
			i++;
		}
		return node;
	}
	
	/**
	 * Gets the node at the index specified. Some error checking on the index.
	 * @param index  The index of the node searched for.
	 * @return  The node at the index. null if not found.
	 */
	public E get (int index) {
		if (index < 0 || index >= size)
	    {
	    	throw new IndexOutOfBoundsException(Integer.toString(index));
	    }
	    Node<E> node = getNode(index);
	    return node.data;
	}
	
	/**
	 * Sets the node at index with the data specified.
	 * @param index  The index of the node the is going to be set.
	 * @param anEntry  The data.
	 * @return  The old data.
	 */
	public E set (int index, E newValue)
	{
		if (index < 0 || index >= size)
		{
			throw new
			IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}
	
	/**
	 * Adds before the index.
	 * @param index  The index of where to be added.
	 * @param item  The data to be added.
	 */
	public void add (int index, E item)
	{
		if (index < 0 || index > size)
		{
			throw new
			IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0)
		{
			addFirst(item);
		}
		else
		{
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}
	
	/**
	 * Adds to the end of the list.
	 * @param item  The data to be added.
	 * @return
	 */
	public boolean add (E item)
	{
		add(size, item);
		return true;
	}
	
	/**
	 * Returns the size.
	 * @return The size
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Removes the node at the index.
	 * @param index  The index at which to remove the node.
	 * @return  The old node's data.
	 */
	public E remove(int index)
	{
		if ((index < 0 || index > size) || index < size)
		{
			throw new
			IndexOutOfBoundsException(Integer.toString(index));
		}
		E oldData = null;
		if(index == 0)
		{
			oldData = removeFirst();
		}
		else
		{
			oldData = removeAfter(getNode(index));
		}
		return oldData;
	}
	
	/**
	 * This class contains the data and next reference for the SingleLinkedList class.
	 * @param <E>
	 */
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		
		/** Creates a new node with a null next field
		 * @param data The data stored
		 */
		private Node(E data)
		{
			this.data = data;
			this.next = null;
		}
		 
		/** Creates a new node that references another node
		 * @param data The data stored
		 * @param nodeRef The node referenced by new node
		 */
		private Node(E data, Node<E> nodeRef)
		{
			this.data = data;
			this.next = nodeRef;
		}
	}
}