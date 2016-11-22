package merge;

import java.util.Comparator;

/**
 * This class implements the merge sort on the given array with the given
 * comparator.
 * 
 * @author John Kelley
 *
 */
public class MergeSortArray {
	/**
	 * Sorts the array using the comparator with a merge sort.
	 * SuppressWarning because all class implement object the E class will always
	 * inherit the object class
	 * 
	 * 
	 * @param array
	 *            The array to be sorted
	 * @param comp
	 *            The given comparator to compare the object with.
	 */
	@SuppressWarnings("unchecked")
	public <E> void sort(E[] array, Comparator<E> comp) {
		if (array.length > 1) {
			int halfSize = array.length / 2;
			E[] leftArray = (E[]) new Object[halfSize];
			E[] rightArray = (E[]) new Object[array.length - halfSize];
			for (int i = 0; i < halfSize; i++) {
				leftArray[i] = array[i];
			}
			for (int i = halfSize; i < array.length; i++) {
				rightArray[i - halfSize] = array[i];
			}
			sort(leftArray, comp);
			sort(rightArray, comp);
			for (int i = 0, j = 0, k = 0; i < array.length; i++) {
				if (k >= leftArray.length && j < rightArray.length) {
					array[i] = rightArray[j];
					j++;
				} else if (j >= rightArray.length && k < leftArray.length) {
					array[i] = leftArray[k];
					k++;
				} else {
					if (comp.compare(leftArray[k], rightArray[j]) > 0) {
						array[i] = rightArray[j];
						j++;
					} else if (comp.compare(leftArray[k], rightArray[j]) < 0) {
						array[i] = leftArray[k];
						k++;
					} else {
						array[i] = leftArray[k];
						k++;
					}
				}
			}
		}
	}
}
