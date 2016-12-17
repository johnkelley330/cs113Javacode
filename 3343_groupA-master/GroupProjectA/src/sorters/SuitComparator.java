package sorters;

import java.util.Comparator;
import mainProjectFolder.CardDatabase;

/**
 * A comparator class for comparing suits. It has a CardDatabase object so that
 * when it takes in the keys it can convert them back to their original object.
 * 
 * @author John Kelley
 *
 */
public class SuitComparator implements Comparator<Integer> {
	private CardDatabase cards;

	/**
	 * Initializes in object properties
	 */
	public SuitComparator() {
		cards = new CardDatabase();
	}

	/**
	 * Takes in the two keys to the card objects; Uses card data base to get the
	 * real objects and then compares the suits of the card.
	 * 
	 * @param left
	 *            The key to one the card to compare
	 * @param right
	 *            The key to one the card to compare
	 * @return a positive number if the suit of left is greater then right's, 0
	 *         if they are equal, and a negative number if the suit of right is
	 *         greater then left's
	 */
	@Override
	public int compare(Integer left, Integer right) {
		return cards.getCard(left).getSuit().compareToIgnoreCase(cards.getCard(right).getSuit());
	}
}
