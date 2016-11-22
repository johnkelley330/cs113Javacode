package test;

import java.io.File;

import merge.MergeSortFile;
/**
 * Tests the MergeSortFile class.
 * @author John Kelley
 *
 */
public class Test {

	public static void main(String[] args) {
		MergeSortFile msf = new MergeSortFile();
		msf.sort(new File("src\\test\\TestDoc.txt"), new Comp<Object>());
	}

}
