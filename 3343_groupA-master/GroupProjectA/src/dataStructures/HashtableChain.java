package dataStructures;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * This class is a hash table implementation using chaining.
 * 
 * @author John Kelley
 *
 * @param <K>
 *            The key type
 * @param <V>
 *            The value type
 */
public class HashtableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V>, Serializable {

	private static final long serialVersionUID = 1L;
	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 0.75;

	/**
	 * This class stores a key and a value paired together.
	 * 
	 * @author John Kelley
	 *
	 * @param <K>
	 *            The type of the key.
	 * @param <V>
	 *            The type of the value.
	 */
	private static class Entry<K, V> implements Map.Entry<K, V>, Serializable {

		private static final long serialVersionUID = 1L;
		private K key;
		private V value;

		/**
		 * Creates a new key-value pair.
		 * 
		 * @param key
		 *            The key
		 * @param value
		 *            The value
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Retrieves the key.
		 * 
		 * @return The key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Retrieves the value.
		 * 
		 * @return The value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * Sets the value.
		 * 
		 * @param value
		 *            The new value
		 * @return The old value
		 */
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		/**
		 * Returns a string representation of the key-value pair.
		 */
		public String toString() {
			return key.toString() + " = " + value.toString();
		}
	}

	/** Inner class to implement the set view. */
	private class EntrySet extends java.util.AbstractSet<Map.Entry<K, V>> {

		/** Return the size of the set. */
		@Override
		public int size() {
			return numKeys;
		}

		/** Return an iterator over the set. */
		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new SetIterator();
		}
	}

	/**
	 * Inner class to implement the set iterator. It contains a next, hasNext,
	 * and remove.
	 */
	private class SetIterator implements Iterator<Map.Entry<K, V>> {
		private int index = 0;
		private Iterator<Entry<K, V>> localIterator = null;
		private Entry<K, V> lastItemReturned;

		/**
		 * Returns true if there is a next value.
		 * 
		 * @return ture if there is a next value; otherwise, false.
		 */
		@Override
		public boolean hasNext() {
			if (localIterator != null) {
				if (localIterator.hasNext()) {
					return true;
				} else {
					localIterator = null;
					index++;
				}
			}
			while (index < table.length && table[index] == null) {
				index++;
			}
			if (index == table.length) {
				return false;
			}
			localIterator = table[index].iterator();
			return localIterator.hasNext();
		}

		/**
		 * Returns the next value. Throws NoSuchElementException if there is no
		 * next element.
		 * 
		 * @return the next value
		 */
		@Override
		public Map.Entry<K, V> next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = localIterator.next();
			return lastItemReturned;
		}

		/**
		 * Removes the last I item returned by next.
		 */
		@Override
		public void remove() {
			localIterator.remove();
		}
	}

	/**
	 * Constructs a new Hashtable. Since you can not create a generic array we.
	 * Can not assign the linked list a type.
	 */
	@SuppressWarnings("unchecked")
	public HashtableChain() {
		table = new LinkedList[CAPACITY];
		numKeys = 0;
	}

	/**
	 * Returns the value paired with the key entered; otherwise, null.
	 * 
	 * @param key
	 *            The key of the value sought
	 * @return the value paired with the key entered; otherwise, null.
	 */
	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null;
		}
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key)) {
				return nextItem.value;
			}
		}
		return null;
	}

	/**
	 * The key-value pair is inserted in the table
	 * 
	 * @param key
	 *            The key
	 * @param value
	 *            The value
	 * @return The old value associated with the key if found; otherwise, null.
	 */
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			table[index] = new LinkedList<Entry<K, V>>();
		}
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key)) {
				V oldValue = nextItem.value;
				nextItem.setValue(value);
				return oldValue;
			}
		}
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length)) {
			rehash();
		}
		return null;
	}

	/**
	 * Removes and return the value that is matched to the key. Returns null if
	 * the key is not found.
	 * 
	 * @param key
	 *            The key to the value to be removed
	 * @return The removed value. Null if the key is not found.
	 */
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		if (table[index] == null) {
			return null;
		}
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key)) {
				V removedValue = nextItem.value;
				table[index].remove(nextItem);
				numKeys--;
				if (table[index].isEmpty()) {
					table[index] = null;
				}
				return removedValue;
			}
		}
		return null;
	}

	/**
	 * Returns the size.
	 * 
	 * @return The table size.
	 */
	@Override
	public int size() {
		return numKeys;
	}

	/**
	 * Returns if the table is empty or not.
	 * 
	 * @return True if the table is empty; otherwise, false.
	 */
	@Override
	public boolean isEmpty() {
		return numKeys == 0;
	}

	/**
	 * The helper method rehash doubles the table size + 1 when the table has
	 * past its load capacity. The conversion between table and oldTable is safe
	 * because they are the same data type
	 */
	@SuppressWarnings("unchecked")
	private void rehash() {
		LinkedList<Entry<K, V>>[] oldTable = table;
		table = new LinkedList[table.length * 2 + 1];
		for (LinkedList<Entry<K, V>> nextList : oldTable) {
			if (nextList != null) {
				for (Entry<K, V> nextItem : nextList) {
					put(nextItem.key, nextItem.value);
				}
			}
		}
	}

	/**
	 * Returns the string version of the hash table.
	 * 
	 * @return the string version of the hash table
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (LinkedList<Entry<K, V>> nextList : table) {
			if (nextList != null) {
				sb.append(nextList.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Returns an entrySet object for HashtableChain.
	 * 
	 * @return an entrySet object for HashtableChain
	 */
	@Override
	public java.util.Set<Map.Entry<K, V>> entrySet() {
		return new EntrySet();
	}
}