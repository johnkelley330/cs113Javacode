package mainProjectFolder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import dataStructures.HashtableChain;

/**
 * Stores the cards in a hash table database for quick access.
 * 
 * @author John Kelley
 *
 */
public class CardDatabase implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashtableChain<Integer, Card> cardDatabase;

	/**
	 * Reads the database in from a file to keep the construction O(1).
	 * Suppresses the warning because all class inert object so it will never
	 * corrupted data in transfer.
	 */
	@SuppressWarnings("unchecked")
	public CardDatabase() {
		try {
			FileInputStream file = new FileInputStream("src\\tempFiles\\cardDatabase.dat");
			ObjectInputStream ois = new ObjectInputStream(file);
			cardDatabase = (HashtableChain<Integer, Card>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println(ex.toString());
			System.out.println("File error in input :(");
		}
	}

	/**
	 * Helper method to add new cards
	 * 
	 * @param card
	 *            The card to be added
	 * @return True if the card was added, otherwise false
	 */
	public boolean addCard(Card card) {
		return cardDatabase.put(card.hashCode(), card) != null;
	}

	/**
	 * Gets the cards associated with the key. Returns false if the card is not
	 * in the database.
	 * 
	 * @param key
	 *            The key to the card to be accessed
	 * @return The cards associated with the key. Returns false if the card is
	 *         not in the database.
	 */
	public Card getCard(int key) {
		return cardDatabase.get(key);
	}

	/**
	 * Return the string of all the cards in the database.
	 * 
	 * @return the string of all the cards in the database.
	 */
	public String toString() {
		return cardDatabase.toString();
	}

	/**
	 * Updates the database file.
	 * 
	 * @return true if the database was outputted successfully, false otherwise
	 */
	public boolean outputDatabase() {
		try {
			FileOutputStream file = new FileOutputStream("src\\tempFiles\\cardDatabase.dat");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(cardDatabase);
			oos.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
			System.out.println("File error in output :(");
			return false;
		}
		return true;
	}
}
