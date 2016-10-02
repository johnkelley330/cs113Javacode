package edu.miracosta.cs133;
import org.junit.Assert;
import org.junit.Test;
public class JUnitForPalindromeChecker
{
	@Test
	public void testEmpty(){
		PalindromeChecker pc = new PalindromeChecker();
		Assert.assertTrue(pc.palindormeCheck(""));
	}
	
	@Test
	public void testOneDigit(){
		PalindromeChecker pc = new PalindromeChecker();
		Assert.assertTrue(pc.palindormeCheck("1"));
	}
	
	@Test
	public void testOnePunctuation(){
		PalindromeChecker pc = new PalindromeChecker();
		Assert.assertTrue(pc.palindormeCheck("."));
	}
	
	@Test
	public void testEvenNumberOfLetters(){
		PalindromeChecker pc = new PalindromeChecker();
		Assert.assertTrue(pc.palindormeCheck("aa"));
		Assert.assertTrue(pc.palindormeCheck("bbbb"));
		Assert.assertTrue(pc.palindormeCheck("cccccc"));
		Assert.assertFalse(pc.palindormeCheck("ab"));
		Assert.assertFalse(pc.palindormeCheck("abcd"));
		Assert.assertFalse(pc.palindormeCheck("abcdef"));
	}
	
	@Test
	public void testOddNumberOfLetters(){
		PalindromeChecker pc = new PalindromeChecker();
		Assert.assertTrue(pc.palindormeCheck("a"));
		Assert.assertTrue(pc.palindormeCheck("bbb"));
		Assert.assertTrue(pc.palindormeCheck("ccccc"));
		Assert.assertFalse(pc.palindormeCheck("abc"));
		Assert.assertFalse(pc.palindormeCheck("abcde"));
	}
	
	@Test
	public void testsentence(){
		PalindromeChecker pc = new PalindromeChecker();
		Assert.assertTrue(pc.palindormeCheck("Madam, I'm Adam"));
		Assert.assertFalse(pc.palindormeCheck("Yo. Sup."));
	}
}