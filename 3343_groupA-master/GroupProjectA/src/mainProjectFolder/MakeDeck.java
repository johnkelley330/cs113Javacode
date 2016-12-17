package mainProjectFolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Can create a deck and shuffle it.
 * 
 * @author John Kelley
 *
 */
public class MakeDeck {
	/**
	 * Initializes the user's deck
	 * 
	 * @param user
	 *            The user whose deck will be created
	 */
	public static void createDeck(Player user) {
		for (int i = 2; i <= 14; i++) {
			user.getCardPile().addCard(new Card("Spades", i).hashCode());
			user.getCardPile().addCard(new Card("Hearts", i).hashCode());
			user.getCardPile().addCard(new Card("Clubs", i).hashCode());
			user.getCardPile().addCard(new Card("Diamonds", i).hashCode());
		}
		shuffle(user.getCardPile().getDeck());
	}

	/**
	 * Shuffle the deck given
	 * 
	 * @param deck
	 *            The deck to shuffle
	 */
	public static void shuffle(ArrayList<Integer> deck) {
		Random random = new Random();
		int index1;
		int index2;
		int temp;
		for (int i = 0; i < deck.size(); i++) {
			index1 = random.nextInt(deck.size());
			index2 = random.nextInt(deck.size());
			temp = deck.get(index1);
			deck.set(index1, deck.get(index2));
			deck.set(index2, temp);
		}
	}
}
