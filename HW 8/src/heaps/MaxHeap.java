package heaps;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<E> extends Heap<E> {
	public MaxHeap(){
		dataList = new ArrayList<E>();
	}
	
	public MaxHeap(Comparator<E> comp){
		dataList = new ArrayList<E>();
		comparator = comp;
	}
	
	protected int compare(E left, E right){
		if(comparator != null){
			return comparator.compare(right, left);
		}
		return ((Comparable<E>) right).compareTo(left);
	}
}