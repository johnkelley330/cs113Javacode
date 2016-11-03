package heaps;

import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<E> extends Heap<E> {
	public MinHeap(){
		dataList = new ArrayList<E>();
	}
	
	public MinHeap(Comparator<E> comp){
		dataList = new ArrayList<E>();
		comparator = comp;
	}
	
	protected int compare(E left, E right){
		if(comparator != null){
			return comparator.compare(left, right);
		}
		return ((Comparable<E>) left).compareTo(right);
	}
}