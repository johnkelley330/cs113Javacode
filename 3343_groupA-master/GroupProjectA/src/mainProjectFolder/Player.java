package mainProjectFolder;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Player.java : class that manages the user's deck and game actions.
 * 
 * @author Robert Young and John Kelley
 */
public class Player implements Serializable {

	// constants
	protected static final int INITIAL_HAND_SIZE = 5;
	protected static final int MAX_HAND_SIZE = 8;
	private static final long serialVersionUID = 1L;
	// data fields
	protected Deck cardPile;
	protected Deck discardPile;
	protected ArrayList<Integer> hand;
	protected CardDatabase cards;
	protected int score;

	/**
	 * Constructor for Player.
	 */
	public Player() {
		cardPile = new Deck();
		discardPile = new Deck();
		hand = new ArrayList<Integer>();
		cards = new CardDatabase();
		score = 0;
	}

	/**
	 * Draws the next card from the player's card pile.
	 */
	public void drawCard() {
		if (hand.size() < INITIAL_HAND_SIZE) {
			while (hand.size() < INITIAL_HAND_SIZE && cardPile.size() > 0) {
				hand.add(cardPile.popCard());
			}
		} else if (hand.size() < MAX_HAND_SIZE) {
			hand.add(cardPile.popCard());
		}
	}

	/**
	 * Plays the given card and removes it from the player's hand
	 * 
	 * post: the card is removed from the player's hand
	 * 
	 * @param cardNum
	 *            the card to be played.
	 * 
	 * @return the card
	 */
	public int useCard(int cardIndex) {
		cardIndex--;
		if (cardIndex >= 0 || cardIndex < hand.size()) {
			int removedCard = hand.get(cardIndex);
			discardCard(cardIndex);
			return removedCard;
		}
		return -1;
	}

	/**
	 * Discards the given card from the player's hand to the discard pile.
	 * 
	 * @param cardNum
	 *            the number of the card to be discarded
	 * @return true if successfully discarded, false otherwise
	 */
	public boolean discardCard(int cardIndex) {
		if (cardIndex >= 0 || cardIndex < hand.size()) {
			discardPile.addCard(hand.get(cardIndex));
			hand.remove(cardIndex);
			return true;
		}
		return false;
	}

	/**
	 * Returns displays the players hand and the top card of their discard pile.
	 * 
	 * @return Displays the players hand and the top card of their discard pile.
	 */
	public String toString() {
		return displayCardsInHand();
	}

	/**
	 * Returns the cards in the hand in string format
	 * 
	 * @return the cards in the hand in string format
	 */
	private String displayCardsInHand() {
		StringBuilder sb = new StringBuilder();
		for (int element : hand) {
			sb.append(cards.getCard(element) + "\n");
		}
		return sb.toString();
	}

	/**
	 * Returns the cardPile
	 * 
	 * @return the cardPile
	 */
	public Deck getCardPile() {
		return cardPile;
	}

	/**
	 * Returns the hand
	 * 
	 * @return the hand
	 */
	public ArrayList<Integer> getHand() {
		return hand;
	}

	/**
	 * Adds the card to the cardPile
	 * 
	 * @param card
	 *            The card to add
	 */
	public void addCardToDeck(int card) {
		cardPile.addCard(card);
	}

	/**
	 * Returns the current size of the hand
	 * 
	 * @return the current size of the hand
	 */
	public int handSize() {
		return hand.size();
	}

	/**
	 * Adds the points to the player's score.
	 * 
	 * @param points
	 *            the points to add to the player's score
	 */
	public void addPoint(int points) {
		score += points;
	}

	/**
	 * Returns the score
	 * 
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
}
