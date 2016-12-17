package mainProjectFolder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Deck.java : a class designed to contain and process a stack of card objects.
 * 
 * @author Robert Young and John Kelley
 * @version 1.0
 */
public class Deck implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> deck;

	/**
	 * Constructor for Deck.
	 */
	public Deck() {
		deck = new ArrayList<Integer>();
	}

	/**
	 * Adds the given card to the deck.
	 * 
	 * @param card
	 *            the name of the card to be added to the deck
	 */
	public void addCard(int card) {
		deck.add(card);
	}

	/**
	 * Removes and returns the top card from the deck.
	 * 
	 * @return the top card from the deck
	 */
	public int popCard() {
		if (deck.size() > 0) {
			return deck.remove(deck.size() - 1);
		}
		return -1;
	}

	/**
	 * Return the top card.
	 * 
	 * @return The top card.
	 */
	public int peekCard() {
		if (deck.size() > 0) {
			return deck.get(deck.size() - 1);
		}
		return -1;
	}

	/**
	 * Gets the deck.
	 * 
	 * @return a reference to the deck.
	 */
	public ArrayList<Integer> getDeck() {
		return deck;
	}

	/**
	 * Returns the size of the deck.
	 * 
	 * @return the size of the deck
	 */
	public int size() {
		return deck.size();
	}

	/**
	 * Returns the deck's string version
	 * 
	 * @return the deck's string version
	 */
	public String toString() {
		return deck.toString();
	}
}
