package printerQueues;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Is a class to emulate a printer.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class Printer {
	private int timeJobStarted;
	private int pages;

	/**
	 * Initializes all variables.
	 */
	public Printer() {
		timeJobStarted = 0;
		pages = 0;
	}

	/**
	 * Prints if the printer is open.
	 * 
	 * @param pages
	 *            The amount of pages to be printed.
	 * @param time
	 *            The current time.
	 */
	public void print(int pages, int time) {
		if (pages < 0) {
		} else if (!printerOpen(time)) {
		} else {
			this.pages = pages;
			timeJobStarted = time;
		}
	}

	/**
	 * Checks if the printer is open.
	 * 
	 * @param time
	 *            The current time.
	 * @return true if the printer is open, False otherwise.
	 */
	public boolean printerOpen(int time) {
		if (pages == 0) {
			return true;
		}
		return time >= timeJobStarted + Math.ceil((double) pages / 10);
	}

	/**
	 * The time the job is done.
	 * 
	 * @return The time the job is done.
	 */
	public int timeJobCompleted() {
		return timeJobStarted + (int) Math.ceil((double) pages / 10);
	}
}