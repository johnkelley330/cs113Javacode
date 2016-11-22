package merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Sorts a given file using a basic merge sort using files in place of arrays.
 * 
 * @author John Kelley
 *
 */
public class MergeSortFile {
	private final static int STARTRUNSIZE = 10;

	/**
	 * Sorts the given file using a merge sort algorithm and the comparator
	 * to compare the objects. Since the file is stored with string the
	 * comparator will have to convert the string to the wanted type before
	 * comparing.
	 * 
	 * @param initialFileName
	 *            The file of data to sort
	 * @param comp
	 *            The comparator to compare with.
	 */
	public void sort(File initialFileName, Comparator<Object> comp) {
		int outPutFile = 0;
		int fileLength = 0;
		Object[] run;
		Object[] temp1Run;
		Object[] temp2Run;
		MergeSortArray mergeSort = new MergeSortArray();
		Scanner initialFileIn;
		PrintWriter initialFileOut;
		PrintWriter temp1Out;
		Scanner temp1In;
		PrintWriter temp2Out;
		Scanner temp2In;
		for (int runSize = STARTRUNSIZE, start = 0; start == 0 || runSize < fileLength; runSize *= 2, start = 1) {
			try {
				initialFileIn = new Scanner(initialFileName);
				temp1Out = new PrintWriter(new File("src\\tempFiles\\Temp1.txt"));
				temp2Out = new PrintWriter(new File("src\\tempFiles\\Temp2.txt"));
			} catch (FileNotFoundException ex) {
				System.out.println("error");
				return;
			}
			// Reading into the temp outPut files
			run = new Object[runSize];
			for (int i = 0, length = 0; initialFileIn.hasNext(); i = (i + 1) % runSize, length++) {
				run[i] = initialFileIn.next();
				if (i == runSize - 1 || !initialFileIn.hasNext()) {
					if (i < runSize - 1) {
						Object[] temp = run;
						run = new Object[i + 1];
						for (int j = 0; j <= i; j++) {
							run[j] = temp[j];
						}
					}
					mergeSort.sort(run, comp);
					for (int j = 0; j <= i; j++) {
						if (outPutFile == 0) {
							temp1Out.println(run[j].toString());
						} else {
							temp2Out.println(run[j].toString());
						}
					}
					outPutFile = (outPutFile + 1) % 2;
					fileLength = length + 1;
				}
			}
			initialFileIn.close();
			temp1Out.close();
			temp2Out.close();
			try {
				initialFileOut = new PrintWriter(initialFileName);
				temp1In = new Scanner(new File("src\\tempFiles\\Temp1.txt"));
				temp2In = new Scanner(new File("src\\tempFiles\\Temp2.txt"));
			} catch (FileNotFoundException ex) {
				System.out.println("error");
				return;
			}
			// Reading and merging
			while (temp1In.hasNext() || temp2In.hasNext()) {

				temp1Run = new Object[runSize];
				temp2Run = new Object[runSize];
				for (int i = 0; i < runSize; i++) {
					if (temp1In.hasNext()) {
						temp1Run[i] = temp1In.next();
					} else {
						temp1Run[i] = null;
					}
					if (temp2In.hasNext()) {
						temp2Run[i] = temp2In.next();
					} else {
						temp2Run[i] = null;
					}
				}
				for (int i = 0, j = 0; (i < runSize && temp1Run[i] != null) || (j < runSize && temp2Run[j] != null);) {
					if ((i == runSize || (i < runSize && temp1Run[i] == null))
							&& (j < runSize && temp2Run[j] != null)) {
						initialFileOut.println(temp2Run[j]);
						j++;
					} else if ((j == runSize || (j < runSize && temp2Run[j] == null))
							&& (i < runSize && temp1Run[i] != null)) {
						initialFileOut.println(temp1Run[i]);
						i++;
					} else if (i < runSize && j < runSize) {
						if (comp.compare(temp1Run[i], temp2Run[j]) > 0) {
							initialFileOut.println(temp2Run[j]);
							j++;
						} else if (comp.compare(temp1Run[i], temp2Run[j]) < 0) {
							initialFileOut.println(temp1Run[i]);
							i++;
						} else {
							initialFileOut.println(temp1Run[i]);
							i++;
						}
					}
				}
			}
			initialFileOut.close();
			temp1In.close();
			temp2In.close();
		}
	}
}