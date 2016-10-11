package printerQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class handles printer requests for 1, 2, or 3 printers.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class PrinterRequests {
	private Queue smallPrint;
	private Queue mediumPrint;
	private Queue largePrint;
	private int numberOfPrinters;
	private Printer printer1;
	private Printer printer2;
	private Printer printer3;

	/**
	 * Initializes all variables.
	 * 
	 * @param numberOfPrinters
	 *            The number of printers to be used.
	 */
	public PrinterRequests(int numberOfPrinters) {
		smallPrint = new LinkedList<Integer>();
		mediumPrint = new LinkedList<Integer>();
		largePrint = new LinkedList<Integer>();
		printer1 = new Printer();
		printer2 = new Printer();
		printer3 = new Printer();
		this.numberOfPrinters = numberOfPrinters;
	}

	/**
	 * Prints the pages specified if the queue is empty. Otherwise it prints the
	 * first item of the current priority queue and adds the pages specified to
	 * the printer queue.
	 * 
	 * @param pages
	 *            The pages to be printed.
	 * @param time
	 *            The current time.
	 */
	public void print(int pages, int time) {
		System.out.printf("Request: %2d ", pages);
		if (pages > 0 && pages < 10) {
			smallPrint.offer(pages);
		} else if (pages >= 10 && pages < 20) {
			mediumPrint.offer(pages);
		} else if (pages >= 20 && pages <= 50) {
			largePrint.offer(pages);
		}
		if (!smallPrint.isEmpty() && printerOpen(time) > 0) {
			System.out.printf("Printing: %2d", smallPrint.peek());
			setPrinter((int) smallPrint.poll(), time);
		} else if (!mediumPrint.isEmpty() && printerOpen(time) > 0) {
			System.out.printf("Printing: %2d", mediumPrint.peek());
			setPrinter((int) mediumPrint.poll(), time);
		} else if (!largePrint.isEmpty() && printerOpen(time) > 0) {
			System.out.printf("Printing: %2d", largePrint.peek());
			setPrinter((int) largePrint.poll(), time);
		} else {
			System.out.printf("Printing: Printer Busy");
		}
		System.out.printf("\n");
	}

	/**
	 * Checks which there is a printer open and then assigns that printer the
	 * print job.
	 * 
	 * @param pages
	 *            The number of pages to be printed.
	 * @param time
	 *            The current time.
	 */
	private void setPrinter(int pages, int time) {
		if (printerOpen(time) == 1) {
			printer1.print(pages, time);
		} else if (printerOpen(time) == 2) {
			printer2.print(pages, time);
		} else if (printerOpen(time) == 2) {
			printer3.print(pages, time);
		}
	}

	public void readFromQueue(int time) {
		if (!smallPrint.isEmpty() && printerOpen(time) > 0) {
			System.out.printf("Printing: %2d\n", smallPrint.peek());
			setPrinter((int) smallPrint.poll(), time);
		} else if (!mediumPrint.isEmpty() && printerOpen(time) > 0) {
			System.out.printf("Printing: %2d\n", mediumPrint.peek());
			setPrinter((int) mediumPrint.poll(), time);
		} else if (!largePrint.isEmpty() && printerOpen(time) > 0) {
			System.out.printf("Printing: %2d\n", largePrint.peek());
			setPrinter((int) largePrint.poll(), time);
		}
	}

	/**
	 * Checks if all the queues are empty.
	 * 
	 * @param time
	 *            The current time.
	 * @return True if all the queues are empty, False otherwise
	 */
	public boolean queuesEmpty(int time) {
		return smallPrint.isEmpty() && mediumPrint.isEmpty() && largePrint.isEmpty();
	}

	/**
	 * Returns which printer is open.
	 * 
	 * @param time
	 *            The current time.
	 * @return 1 if printer1 is open, 2 if printer2 is open, or 3 if printer3 is
	 *         open.
	 */
	private int printerOpen(int time) {
		if (printer1.printerOpen(time)) {
			return 1;
		}
		if (printer2.printerOpen(time) && numberOfPrinters > 1) {
			return 2;
		}
		if (printer3.printerOpen(time) && numberOfPrinters > 2) {
			return 3;
		}
		return 0;
	}

	/**
	 * The full time it took to complete the printing jobs.
	 * 
	 * @return The full time it took to complete the printing jobs
	 */
	public int fullTime() {
		if (printer1.timeJobCompleted() > printer2.timeJobCompleted()
				&& printer1.timeJobCompleted() > printer3.timeJobCompleted()) {
			return printer1.timeJobCompleted();
		} else if (printer2.timeJobCompleted() > printer3.timeJobCompleted()) {
			return printer2.timeJobCompleted();
		} else {
			return printer3.timeJobCompleted();
		}
	}
}