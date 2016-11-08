package heaps;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class keeps a heap ordered greatest to smallest. This class allows for
 * the class implementing it to create it own compare method for its data fields.
 * 
 * @author W7258645
 *
 * @param <E>
 *            The type for the heap to hold.
 */
public class MaxHeap<E> extends Heap<E> {

	/**
	 * Creates a new heap.
	 */
	public MaxHeap() {
		dataList = new ArrayList<E>();
	}

	/**
	 * Creates a heap with a comparator object and compare method.
	 * 
	 * @param comp
	 *            The comparator object.
	 */
	public MaxHeap(Comparator<E> comp) {
		dataList = new ArrayList<E>();
		comparator = comp;
	}

	/**
	 * Uses the implementing classes compare method to compare the left and
	 * right. If the class does not implement the compare method it uses the
	 * compareTo.
	 * 
	 * @param left
	 *            The left node.
	 * @param right
	 *            The right node.
	 * @return 1 if right is greater the left, zero if they are equal, and -1 if right is less left.
	 *         right is greater the left.
	 */
	protected int compare(E left, E right) {
		if (comparator != null) {
			return comparator.compare(left, right);
		}
		return ((Comparable<E>) right).compareTo(left);
	}
}