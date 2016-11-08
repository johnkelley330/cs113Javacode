package heaps;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * This class keeps a heap ordered smallest to greatest. This class allows for
 * the class implementing it to create it own compare method for its data fields.
 * 
 * @author W7258645
 *
 * @param <E>
 *            The type for the heap to hold.
 */
public class MinHeap<E> extends Heap<E> {
	
	/**
	 * Creates a new heap.
	 */
	public MinHeap(){
		dataList = new ArrayList<E>();
	}
	
	/**
	 * Creates a heap with a comparator object and compare method.
	 * 
	 * @param comp
	 *            The comparator object.
	 */
	public MinHeap(Comparator<E> comp){
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
	 * @return 1 if left is greater the right, zero if they are equal, and -1 if left is less then right.
	 *         right is greater the left.
	 */
	protected int compare(E left, E right){
		if(comparator != null){
			return comparator.compare(left, right);
		}
		return ((Comparable<E>) left).compareTo(right);
	}
}