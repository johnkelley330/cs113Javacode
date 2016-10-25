package e521;
import org.junit.Assert;
import org.junit.Test;

import e512.Exercise512;

public class TestExercise521 {

	@Test
	public void testPositiveNumber(){
		Exercise521 e521 = new Exercise521();
		Assert.assertTrue(25 == (int)(1000 * e521.power(5, 2)) / 1000.0);
	}
	
	@Test
	public void testNegitiveNumber(){
		Exercise521 e521 = new Exercise521();
		System.out.println(1000 * e521.power(5, -2));
		Assert.assertTrue(1/5 == (1000 * e521.power(5, -2)) / 1000.0);
	}
	
}
