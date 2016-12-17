package mainProjectFolder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dataStructures.HashtableChain;

/**
 * Stores the users in a database for quick access to their accounts.
 * 
 * @author John Kelley
 *
 */
public class UserDatabase {
	private HashtableChain<String, Player> userDatabase;

	/**
	 * Reads the database in from a file to keep the construction O(1). All
	 * class inert object so it will never corrupted data in transfer.
	 */
	@SuppressWarnings("unchecked")
	public UserDatabase() {
		try {
			FileInputStream file = new FileInputStream("src\\tempFiles\\userDatabase.dat");
			ObjectInputStream ois = new ObjectInputStream(file);
			userDatabase = (HashtableChain<String, Player>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("File error in input :(");
		}
	}

	/**
	 * Returns the user associated with the key
	 * 
	 * @param key
	 *            The user name of the user
	 * @return The user.
	 */
	public Player getUser(String key) {
		return userDatabase.get(key);
	}

	/**
	 * Returns if the user is in the database or not.
	 * 
	 * @param key
	 *            The user name to check
	 * @return True if the user exists, otherwise false.
	 */
	public boolean userExist(String key) {
		return userDatabase.get(key) != null;
	}

	/**
	 * Add or updates the user.
	 * 
	 * @param key
	 *            The user name to add or update
	 * @return True if the user was added or updated, otherwise false.
	 */
	public Player addOrUpdateUser(String key, Player player) {
		return userDatabase.put(key, player);
	}

	/**
	 * Removes the user from the database.
	 * 
	 * @param key
	 *            The user name to the user object.
	 * @return True if the user was removed, otherwise false.
	 */
	public boolean removeUser(String key) {
		return userDatabase.remove(key) != null;
	}

	/**
	 * Outputs the database to a binary file
	 * 
	 * @return True if there were no errors, otherwise false
	 */
	public boolean outputDatabase() {
		try {
			FileOutputStream file = new FileOutputStream("src\\tempFiles\\userDatabase.dat");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(userDatabase);
			oos.close();
		} catch (IOException ex) {
			System.out.println("Output file error :(");
			return false;
		}
		return true;
	}

	/**
	 * Returns the string representation of the user database.
	 * 
	 * @return the string representation of the user database.
	 */
	public String toString() {
		return userDatabase.toString();
	}
}