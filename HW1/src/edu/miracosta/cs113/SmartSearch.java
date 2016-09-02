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
		int answerSet, wrongPosition;
		int position[] = new int[3];
		position[0] = 1;
		position[1] = 1;
		position[2] = 1;
		AssistantJack jack;

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();

		jack = new AssistantJack(answerSet);
		wrongPosition = jack.checkAnswer(position[0], position[1], position[2]) - 1;
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
