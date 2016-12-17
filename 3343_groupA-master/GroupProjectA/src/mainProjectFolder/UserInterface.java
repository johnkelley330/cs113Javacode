package mainProjectFolder;

import java.util.Scanner;

import sorters.FaceValueComparator;
import sorters.QuickSort;
import sorters.SuitComparator;

/**
 * 
 * @author John Kelley and Mand
 * 
 */
public class UserInterface {

	/**
	 * Returns the player object that the user logs into.
	 * 
	 * @param uDatabase
	 *            the user database
	 * @param userInput
	 *            the scanner to be used for input
	 * @return the player that is related to that user name
	 */
	public static Player login(UserDatabase uDatabase, Scanner userInput) {
		String storeName;
		int optionInput;
		System.out.println("Welcome to Tranjonian Trading Card!");
		System.out.print("Do you have a user account/name? [Choose 1 for Yes, 2 for No]: ");
		optionInput = userInput.nextInt();
		if (optionInput == 2) {
			do {
				System.out.print("Please Enter a user name to create your account: ");
				storeName = userInput.next();
				if (uDatabase.userExist(storeName)) {
					System.out.println("That username already exists.");
				}
			} while (uDatabase.userExist(storeName));
			uDatabase.addOrUpdateUser(storeName, new Player());
			uDatabase.outputDatabase();
			return uDatabase.getUser(storeName);
		} else if (optionInput == 1) {
			do {
				System.out.print("Please enter your user name: ");
				storeName = userInput.next();
				if (!uDatabase.userExist(storeName)) {
					System.out.println("The user name is not valid.");
				}
			} while (!uDatabase.userExist(storeName));
			do {
				System.out.print("Do you want to delete your account or player? [Choose 1 for play, 2 for delete]: ");
				optionInput = userInput.nextInt();
			} while ((optionInput == 2 && !deleteUser(uDatabase, storeName, userInput))
					|| (optionInput != 1 && optionInput != 2));
			uDatabase.outputDatabase();
			if (optionInput == 1) {
				return uDatabase.getUser(storeName);
			} else if (optionInput == 2) {
				return null;
			}
		} else {
			login(uDatabase, userInput);
		}
		return null;
	}

	/**
	 * Sorts and displays the deck by the value specified by the user.
	 * 
	 * @param user
	 *            the user whose deck to display
	 * @param input
	 *            the scanner to use for input
	 * @param deckSize
	 *            the size of the deck we
	 */
	public static void deckManager(Player user, Scanner input) {
		Integer[] deck = new Integer[user.getCardPile().getDeck().size()];
		deck = user.getCardPile().getDeck().toArray(deck);
		CardDatabase cards = new CardDatabase();
		System.out.print("Would you like to view your deck befor playing? [Choose 1 for yes, 2 for no]: ");
		int optionInput = input.nextInt();
		if (optionInput == 1) {
			String optionByUser;
			do {
				System.out.print(
						"What would you like to sort your deck by? s for suit, v for face value, and e to exit: ");
				optionByUser = input.next();
				if (optionByUser.equals("s") || optionByUser.equals("S")) {
					QuickSort.sort(deck, new SuitComparator());
					for (int card : deck) {
						System.out.println(cards.getCard(card).toString());
					}
				} else if (optionByUser.equals("v") || optionByUser.equals("V")) {
					QuickSort.sort(deck, new FaceValueComparator());
					for (int card : deck) {
						System.out.println(cards.getCard(card).toString());
					}
				}
			} while (!optionByUser.equals("e"));
		}
	}

	/**
	 * Deletes the user form the database
	 * 
	 * @param uDatabase
	 *            the user database
	 * @param userName
	 *            the user name to be removed
	 * @param userInput
	 *            the scanner to be used to get user input
	 */
	public static boolean deleteUser(UserDatabase uDatabase, String userName, Scanner userInput) {
		System.out.print("Would you like to delete your account? [choose 1:Yes, 2: No]: ");
		int intInput = userInput.nextInt();
		if (intInput == 1) {
			uDatabase.removeUser(userName);
			return true;
		} else if (intInput == 2) {
			return false;
		} else {
			return deleteUser(uDatabase, userName, userInput);
		}
	}

	/**
	 * Asks the player which card they want and get their input.
	 * 
	 * @param handSize
	 *            the hand size of the player
	 * @param userInput
	 *            the scanner to be used for user input
	 * @return the card to be used
	 */
	public static int cardPickPlayer(int handSize, Scanner userInput) {
		System.out.print("Please pick a card by using the corresponding number(so 1 for the first and so on): ");
		int pickNumber = userInput.nextInt();
		if (pickNumber > handSize || pickNumber <= 0) {
			return cardPickPlayer(handSize, userInput);
		}
		return pickNumber;
	}
}