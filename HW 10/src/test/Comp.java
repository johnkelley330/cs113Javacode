package test;

import java.util.Comparator;
/**
 * The comparator for the test class
 * @author John Kelley
 *
 * @param <E>  The type to compare
 */
public class Comp<E> implements Comparator<E> {
	public int compare(E left, E right){
		return Integer.parseInt((String)left) - Integer.parseInt((String)right);
	}
}
