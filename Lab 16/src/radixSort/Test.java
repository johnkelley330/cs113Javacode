package radixSort;

/**
 * Tests the radix sort.
 * 
 * @author John Kelley
 *
 */
public class Test {

	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int[] array = new int[6];
		array[0] = 10;
		array[1] = 43;
		array[2] = 7;
		array[3] = 1001;
		array[4] = 87;
		array[5] = 6;
		rs.sort(array);
		for (int element : array) {
			System.out.println(element);
		}
	}

}
