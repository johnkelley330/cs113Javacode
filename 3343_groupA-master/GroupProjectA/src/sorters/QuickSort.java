package sorters;

import java.util.Comparator;

/**
 * This is a quick sort implementation for O(nlog(n)) run time in sorting.
 * 
 * @author Mandzukic Kittani and John Kelley
 */

public class QuickSort {

	/**
	 * The wrapper for recursive quick sort method
	 * 
	 * @param inputArray
	 *            the array to be sorted
	 * @param comp
	 *            the comparator to be used
	 */

	public static <T> void sort(T[] inputArray, Comparator<T> comp) {
		quicksort(inputArray, 0, inputArray.length - 1, comp);
	}

	/**
	 * The recursive quick sort. It calls its self until it down to where one
	 * value then partitions recursively.
	 * 
	 * @param inputArray
	 *            the array to be sorted
	 * @param lowValue
	 *            the lowest value to sorted
	 * @param highValue
	 *            the highest value to be sorted
	 * @param comp
	 *            the comparator to be used
	 */

	private static <T> void quicksort(T[] inputArray, int lowValue, int highValue, Comparator<T> comp) {
		if (lowValue >= highValue) {
			return;
		}
		int parti = partition(inputArray, lowValue, highValue, comp);
		quicksort(inputArray, lowValue, parti - 1, comp);
		quicksort(inputArray, parti + 1, highValue, comp);
	}

	/**
	 * Picks a partition value and puts all elements greater the partition to
	 * the right of the array and all the value less then the partition to the
	 * left.
	 * 
	 * @param inputArray
	 *            The array to partition
	 * @param first
	 *            The first value to be partitioned
	 * @param last
	 *            The last value to be partitioned
	 * @param comp
	 *            the comparator to be used
	 * @return The middle value (the partitions address in the array)
	 */

	private static <T> int partition(T[] inputArray, int first, int last, Comparator<T> comp) {
		bubbleSort3(inputArray, first, last, comp);
		T pivot = inputArray[first];
		int up = first + 1;
		int down = last;
		while (up < down) {
			while (up < down && comp.compare(pivot, inputArray[up]) >= 0) {
				up++;
			}
			while (comp.compare(pivot, inputArray[down]) < 0) {
				down--;
			}
			if (up < down) {
				swap(inputArray, up, down);
			}
		}
		swap(inputArray, first, down);
		return down;
	}

	/**
	 * Swaps the two elements in the inputArray array.
	 * 
	 * @param inputArray
	 *            The array to swap in
	 * @param first
	 *            the first element to compare's address in the array
	 * @param second
	 *            the second element to compare's address in the array
	 */
	private static <T> void swap(T[] inputArray, int first, int second) {
		T temp = inputArray[first];
		inputArray[first] = inputArray[second];
		inputArray[second] = temp;
	}

	/**
	 * Sorts three values and set the middle value to the first position.
	 * 
	 * @param inputArray
	 *            The array to sort the three values in.
	 * @param first
	 *            The position of the first to sort
	 * @param last
	 *            The position of the last position to sort
	 * @param comp
	 *            The comparator to compare the values
	 */
	private static <T> void bubbleSort3(T[] inputArray, int first, int last, Comparator<T> comp) {
		int middle = (first + last) / 2;
		// if the middle is less than first we swap them.
		if (comp.compare(inputArray[middle], inputArray[first]) < 0) {
			swap(inputArray, first, middle);
		}
		if (comp.compare(inputArray[last], inputArray[middle]) < 0) {
			swap(inputArray, middle, last);
		}
		if (comp.compare(inputArray[middle], inputArray[first]) < 0) {
			swap(inputArray, first, middle);
		}
	}
}