package e512;
import org.junit.Assert;
import org.junit.Test;
public class TestExercise512
{
	@Test
	public void testSmallString(){
		Exercise512 e512 = new Exercise512();
		Assert.assertEquals("HHeelllloo", e512.stutter("Hello"));
	}
	
	@Test
	public void testLongString(){
		Exercise512 e512 = new Exercise512();
		Assert.assertEquals("HHeelllloo  WWoorrlldd!!!!", e512.stutter("Hello World!!"));
	}
	
	@Test
	public void testNullString(){
		Exercise512 e512 = new Exercise512();
		Assert.assertEquals("", e512.stutter(null));
	}
	
	@Test
	public void testEmptyString(){
		Exercise512 e512 = new Exercise512();
		Assert.assertEquals("", e512.stutter(""));
	}
}
