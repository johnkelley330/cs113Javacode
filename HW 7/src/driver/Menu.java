package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import trees.MorseCodeTree;
/**
 * This class is a menu program for the driver class.
 * @author John Kelley
 *
 */
public class Menu {
	/**
	 * The menu for the driver program.
	 * Enter 1 for a table of the morse code values in the tree.
	 * Enter 2 to enter a file path for the morse code to be decoded.
	 * Enter 3 to enter code in the console.
	 * Enter 4 to exit.
	 * @param mct  The morse code tree.
	 */
	public void menu(MorseCodeTree mct){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter 1 for a table of morse code values");
		System.out.println("Enter 2 to input a file of morse code to decode");
		System.out.println("Enter 3 to input a line of morse code in the console to be decoded");
		System.out.println("Enter 4 to exit program");
		String option = reader.nextLine();
		if(option.equals("1")){
			System.out.println(mct.morseCodeTable());
			menu(mct);
		} else if(option.equals("2")){
			System.out.println("Enter file path with double backslash");
			System.out.println("example: c:\\Users\\Documents\\example.txt");
			String file = reader.nextLine();
			try{
				Scanner morseCodeFile = new Scanner(new File(file));
				System.out.println(mct.decode(morseCodeFile.nextLine()));
				morseCodeFile.close();
			} catch(FileNotFoundException ex){
				System.out.println("File was not found");
			}
			menu(mct);
		} else if(option.equals("3")){
			System.out.println("Enter a line of morse code to be decoded");
			System.out.println(mct.decode(reader.nextLine()));
			menu(mct);
		} else if(option.equals("4")){
			System.out.println("This program has been closed");
		}
		reader.close();
	}
}