import java.util.Scanner;


public class PartB
{
	public static void main(String[] args)
	{
		
		//PART B		
		int[] nums = {3, 5, 6, 1, 0, 9};
		Scanner keyboard = new Scanner(System.in);
		int userNum, index;
		
		System.out.print("Please enter a number to search for: ");
		userNum = keyboard.nextInt();
		
		try
		{
			index = findNum(nums, userNum);
			System.out.println("Found number at index " + index);	
		}
		catch(NumberNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Done testing NumberNotFoundException");
		}
		
	}
	
	public static int findNum(int[] nums, int key) throws NumberNotFoundException
	{
		int i = 0;
		boolean isFound = false;

		while (i < nums.length && !isFound)
		{
			isFound = (key == nums[i]);
			i++;
		}
		
		if(!isFound)
		{
			throw new NumberNotFoundException("Number not found :(", key);
		}
		
		return i;
	}
}
