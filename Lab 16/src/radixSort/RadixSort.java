package radixSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements the radix sort with numbers in the buckets.
 * 
 * @author John Kelley
 *
 */
public class RadixSort {
	private Queue<Integer>[] buckets;
	int length;

	/**
	 * Initializes and creates the array of queues for buckets. Suppress the
	 * unchecked conversion warning because we will fill the queue spots in the
	 * array with Integer LinkedLists.
	 */

	@SuppressWarnings("unchecked")
	public RadixSort() {
		buckets = new Queue[10];
		for (int i = 0; i < 10; i++) {
			buckets[i] = new LinkedList<Integer>();
		}
		length = 0;
	}

	/**
	 * Uses the radix sort, numbers in buckets, to sort the given array of ints.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if ((int) Math.floor(Math.log10(array[i]) + 1) > length) {
				length = (int) Math.floor(Math.log10(array[i]) + 1);
			}
		}
		length = (int) Math.pow(10, length - 1);
		for (int place = 1; place <= length; place *= 10) {
			for (int i = 0; i < array.length; i++) {
				buckets[array[i] / place % 10].offer(array[i]);
			}
			for (int i = 0, j = 0; i < array.length; i++) {
				array[i] = buckets[j].remove();
				while (buckets[j].isEmpty() && j < 9) {
					j++;
				}
			}
		}
	}
}
