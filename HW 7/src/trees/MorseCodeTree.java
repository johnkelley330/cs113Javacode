package trees;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is a binary tree to decode morse code. It contains a inoder traversal method and a decode method.
 * It builds its self from the MorseCode file.
 * @author John Kelley
 *
 */
public class MorseCodeTree extends BinaryTree {
	/**
	 * Constructor for the morse code tree. Initializes the root to null.
	 * Builds the tree from the file MorseCode.txt
	 */
	public MorseCodeTree() {
		root = null;
		buildFromFile("src\\treeBuildFile\\MorseCode.txt");
	}

	/**
	 * Builds the tree from the file.
	 * @param file  The file to be built from.
	 */
	private void buildFromFile(String file) {
		try {
			Scanner in = new Scanner(new File(file));
			root = new Node<Character>(' ');
			while (in.hasNext()) {
				add(root, in.next().charAt(0), in.next());
			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * The wrapper method for the recursive decode method. Returns a string of the code decoded.
	 * @param code  The morse code to be decoded.
	 * @return  The decode code.
	 */
	public String decode(String code) {
		try {
			String[] codes = code.split("\\s+");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < codes.length; i++) {
				sb.append(decodeRecursive(root, codes[i]));
			}
			return sb.toString();
		} catch (UnsupportedOperationException ex) {
			return "Invalde code";
		}
	}

	/**
	 * Returns a table of all the code values for all the letters in the tree.
	 * @return  A table of all the code values for all the letters in the tree
	 */
	public String morseCodeTable() {
		StringBuilder sb = new StringBuilder();
		sb.append("Letter  Code\n");
		sb.append("------  ----\n");
		morseCodeTableRecursive(root.left, sb, "*");
		morseCodeTableRecursive(root.right, sb, "-");
		return sb.toString();
	}

	/**
	 * The recursive method for printing the table. It uses inorder traversal.
	 * @param node  The current node
	 * @param sb  The StringBuilder of all the table so that we do not waste memory.
	 * @param code  The current code for the node we are on.
	 */
	private void morseCodeTableRecursive(Node<Character> node, StringBuilder sb, String code) {
		if (node != null) {
			morseCodeTableRecursive(node.left, sb, code + "*");
			sb.append(String.format("%-7c %-4s\n", node.data, code));
			morseCodeTableRecursive(node.right, sb, code + "-");
		}
	}

	/**
	 * The recursive method for the decode method. Follows the code path through the tree to find the character.
	 * Throws the UnsupportedOperationException if the code is invaded. 
	 * @param node  The current node.
	 * @param code  The code for finding the character.
	 * @return  The character.
	 */
	private char decodeRecursive(Node<Character> node, String code) {
		if (node == null) {
			throw new UnsupportedOperationException();
		}
		if (code.length() == 0) {
			return node.data;
		} else if (code.charAt(0) == '*') {
			return decodeRecursive(node.left, code.substring(1));
		} else if(code.charAt(0) == '-') {
			return decodeRecursive(node.right, code.substring(1));
		} else{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Helper method to add the node to the tree.
	 * @param node  The current node.
	 * @param letter  The letter we are adding.
	 * @param code  The current code.
	 * @return  The data stored in the current node.
	 */
	private Node<Character> add(Node<Character> node, char letter, String code) {
		if (node == null) {
			return new Node<Character>(letter);
		} else if (code.charAt(0) == '*') {
			node.left = add(node.left, letter, code.substring(1));
			return node;
		} else {
			node.right = add(node.right, letter, code.substring(1));
			return node;
		}
	}
}