package printerQueues;

import java.util.Random;

/**
 * Inputs the print request and compare how long it takes with one, two, or
 * three printers.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class Driver {

	public static void main(String[] args) {
		Random random = new Random();
		int time = 0;

		System.out.println("One Printer");
		PrinterRequests printers1 = new PrinterRequests(1);
		for (time = 0; time < 100; time++) {
			printers1.print((int) Math.ceil(random.nextDouble() * 50), time);
		}
		do {
			time++;
			printers1.readFromQueue(time);
		} while (!printers1.queuesEmpty(time));
		System.out.println("Time for jobs to be completed: " + printers1.fullTime());

		System.out.println("\nTwo Printers");
		PrinterRequests printers2 = new PrinterRequests(2);
		for (time = 0; time < 100; time++) {
			printers2.print((int) Math.ceil(random.nextDouble() * 50), time);
		}
		do {
			time++;
			printers2.readFromQueue(time);
		} while (!printers2.queuesEmpty(time));
		System.out.println("Time for jobs to be completed: " + printers2.fullTime());

		System.out.println("\nThree Printers");
		PrinterRequests printers3 = new PrinterRequests(3);
		for (time = 0; time < 100; time++) {
			printers3.print((int) Math.ceil(random.nextDouble() * 50), time);
		}
		do {
			time++;
			printers3.readFromQueue(time);
		} while (!printers3.queuesEmpty(time));
		System.out.println("Time for jobs to be completed: " + printers3.fullTime());
	}

}