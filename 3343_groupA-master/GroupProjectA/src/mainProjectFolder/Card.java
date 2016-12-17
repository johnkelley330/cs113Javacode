package mainProjectFolder;

import java.io.Serializable;

/**
 * The card class stores a suit and a face value for the card.
 * 
 * @author John Kelley
 */

public class Card implements Comparable<Card>, Serializable {

	private static final long serialVersionUID = 1L;
	private String suit;
	private int faceValue;

	/**
	 * Initializes the values of the card object
	 * 
	 * @param suit
	 *            The suit
	 * @param faceValue
	 *            The face value
	 */
	public Card(String suit, int faceValue) {
		this.suit = suit;
		this.faceValue = faceValue;
	}

	/**
	 * Returns the suit
	 * 
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Returns the face value
	 * 
	 * @return the face value
	 */

	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * Sets the suit
	 * 
	 * @param suit
	 *            the new suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Sets the face value
	 * 
	 * @param faceValue
	 *            the new face value
	 */

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	/**
	 * Returns the string.
	 * 
	 * @return the string
	 */

	public String toString() {
		return String.format("____________\n| %-8d |\n|          |\n|          |\n| %-8s |\n|          |\n|          |\n| %8d |\n|__________|\n",faceValue, suit, faceValue);
	}

	/**
	 * Check for equality of the two object.
	 * 
	 * @param The
	 *            object to check for equality with
	 * @return True if the face values are equal, false otherwise.
	 */

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o instanceof Card) {
			if (((Card) o).getFaceValue() == faceValue) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a negative integer, zero, or a positive integer as this object is
	 * less than, equal to, or greater than the specified object.
	 * 
	 * @param card
	 *            The card to compare this card to.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	public int compareTo(Card card) {
		return faceValue - card.getFaceValue();
	}

	/**
	 * Returns the hash code for the card object
	 * 
	 * @return the hash code for the card object
	 */
	public int hashCode() {
		return suit.hashCode() - faceValue;
	}
}