package heaps;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Heap is an abstract class and is the base for other heaps and priory queues.
 * It includes an insert, a remove, an isEmpty, and a toString.
 * 
 * @author W7258645
 *
 * @param <E>
 *            The type of data to be stored in the heap.
 */
public abstract class Heap<E> {
	ArrayList<E> dataList;
	Comparator<E> comparator;

	/**
	 * This method is left abstract because every subclass may use it
	 * differently.
	 * 
	 * @param left
	 *            The left object to be compared.
	 * @param right
	 *            The right object to be compared.
	 * @return  It returns -1 if left < right, 0 if left == right, and 1 if left > right.
	 */
	protected abstract int compare(E left, E right);

	/**
	 * 
	 * @param newData
	 * @return
	 */
	public boolean insert(E newData) {
		dataList.add(newData);
		int child = dataList.size() - 1;
		int parent = (child - 1) / 2;
		while (parent >= 0 && compare(dataList.get(parent), dataList.get(child)) > 0) {
			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}

	public E remove() {
		if (isEmpty()) {
			return null;
		}
		E root = dataList.get(0);
		if (dataList.size() == 1) {
			dataList.remove(0);
			return root;
		}
		dataList.set(0, dataList.remove(dataList.size() - 1));
		int parent = 0;
		int leftChild = 2 * parent + 1;
		int rightChild = leftChild + 1;
		int minChild = 0;
		do {
			minChild = leftChild;
			if (rightChild < dataList.size() && compare(dataList.get(leftChild), dataList.get(rightChild)) > 0) {
				minChild = rightChild;
			}
			if (compare(dataList.get(parent), dataList.get(minChild)) > 0) {
				swap(parent, minChild);
				parent = minChild;
			}
			leftChild = 2 * parent + 1;
			rightChild = leftChild + 1;
		} while (leftChild <= dataList.size() && minChild == parent);
		return root;
	}

	public boolean isEmpty() {
		return dataList.isEmpty();
	}

	public String toString() {
		return dataList.toString();
	}

	private void swap(int index1, int index2) {
		E temp = dataList.get(index1);
		dataList.set(index1, dataList.get(index2));
		dataList.set(index2, temp);
	}
}
