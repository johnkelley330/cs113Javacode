package ploynomialAddition;
import singleLinkedListClass.SingleLinkedList;;

public class ploynomialAdditionDriver
{

	public static void main(String[] args)
	{
		int index1 = 0;
		int index2 = 0;
		int compare;
		String finalEquationString = "";
		
		SingleLinkedList<Term> polynomial1 = new SingleLinkedList<Term>();
		SingleLinkedList<Term> polynomial2 = new SingleLinkedList<Term>();
		SingleLinkedList<Term> finalEquation = new SingleLinkedList<Term>();
		
		polynomial1.add(new Term(3, 4));
		polynomial1.add(new Term(2, 2));
		polynomial1.add(new Term(3, 1));
		polynomial1.add(new Term(7, 0));
		polynomial2.add(new Term(2, 3));
		polynomial2.add(new Term(4, 1));
		polynomial2.add(new Term(5, 0));
		
		while(index1 < polynomial1.size() && index2 < polynomial2.size())
		{
			compare = polynomial1.get(index1).compareTo(polynomial2.get(index2));
			if(compare < 0)
			{
				finalEquation.add(polynomial2.get(index2));
				index2++;
			}
			else if(compare > 0)
			{
				finalEquation.add(polynomial1.get(index1));
				index1++;
			}
			else
			{
				finalEquation.add(new Term(polynomial1.get(index1).getCoefficient() + polynomial2.get(index2).getCoefficient(), polynomial1.get(index1).getExponent()));
				index1++;
				index2++;
			}
		}
		if(finalEquation.size() == 0)
		{
			finalEquation.add(new Term(0, 0));
		}
		
		for(int i = 0; i < finalEquation.size(); i++)
		{
			finalEquationString += finalEquation.get(i).toString();
			if(i < finalEquation.size() - 1)
			{
				finalEquationString += " + ";
			}
		}
		System.out.println("FinalEquation = " + finalEquationString);
	}

}
