package edu.miracosta.cs113;

import assistantJack.AssistantJack;

import java.util.Scanner;

/**
 * This class finds the solution answerSet form assistant jack in 20 moves or less.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class SmartSearch {
	public static void main(String[] args)
	{
		//Initializes the answerSet and wrongPosition
		int answerSet, wrongPosition;
		//Initializes the positions int array of size 3.
		int position[] = new int[3];
		position[0] = 1;
		position[1] = 1;
		position[2] = 1;
		//Creates Object jack of type AssistantJack
		AssistantJack jack;

		//Creates the Scanner object keyboard for System input.
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		//Sets the int answerSet to the next int entered in the terminal.
		answerSet = keyboard.nextInt();
		//Closes the keyboard Scanner
		keyboard.close();

		//Sets jack
		jack = new AssistantJack(answerSet);
		//Sets wrong position to the position that is wrong (murdered, location, or weapon).
		//Subtracts by 1 to account for the fact that list start at zero.
		wrongPosition = jack.checkAnswer(position[0], position[1], position[2]) - 1;
		//Repeats until all answers are the same as the AssistantJack answer set.
		while(wrongPosition != -1)
		{
			++position[wrongPosition];
			wrongPosition = jack.checkAnswer(position[0], position[1], position[2]) - 1;
		}
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + position[0] + " " + position[1] + " " + position[2]);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}
	}
}
