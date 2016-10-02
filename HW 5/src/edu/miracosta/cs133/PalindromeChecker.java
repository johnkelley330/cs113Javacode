package edu.miracosta.cs133;

import stack.ArrayStack;

/**
 * This class checks string for palindromes. It only considers letters.
 * 
 * @author John Kelley
 * @version 1.0
 */
public class PalindromeChecker {
	private ArrayStack<Character> stack1;
	private ArrayStack<Character> stack2;
	private String palindrome;

	/**
	 * Initializes the stacks.
	 */
	public PalindromeChecker() {
		stack1 = new ArrayStack<Character>();
		stack2 = new ArrayStack<Character>();
	}

	/**
	 * Removes all non letters.
	 * @param word  The string to remove non letters from.
	 * @return  The word string without the non letters
	 */
	private String removeNonLetter(String word) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i))) {
				sb.append(word.charAt(i));
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * Checks the word to see if it is a palindrome. Ignores non letters.
	 * @param word  The string to be checked.
	 * @return  True if it is a palindrome. False otherwise.
	 */
	public Boolean palindormeCheck(String word) {
		ArrayStack<Character> stack1 = new ArrayStack<Character>();
		ArrayStack<Character> stack2 = new ArrayStack<Character>();
		palindrome = removeNonLetter(word.toLowerCase());
		for (int i = 0; i < palindrome.length(); i++) {
			stack1.push(palindrome.charAt(i));
		}
		for (int i = 0; i < (palindrome.length() - palindrome.length() % 2) / 2; i++) {
			stack2.push(stack1.pop());
		}
		if (palindrome.length() % 2 == 1) {
			stack1.pop();
		}
		while (!stack1.empty()) {
			if (stack1.pop() != stack2.pop()) {
				return false;
			}
		}
		return true;
	}
}
