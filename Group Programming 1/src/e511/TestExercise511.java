package e511;
import org.junit.Assert;
import org.junit.Test;
public class TestExercise511
{
	@Test
	public void testAllNumberString(){
		Exercise511 e511 = new Exercise511();
		Assert.assertEquals(7, e511.toNumber("511"));
	}
	
	@Test
	public void testNumberAndLettersString(){
		Exercise511 e511 = new Exercise511();
		Assert.assertEquals(17, e511.toNumber("a4hj5fg7h1jf"));
	}
	
	@Test
	public void testAllLettersString(){
		Exercise511 e511 = new Exercise511();
		Assert.assertEquals(0, e511.toNumber("ajhfkadgh"));
	}
}
