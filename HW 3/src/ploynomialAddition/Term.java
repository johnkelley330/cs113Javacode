package ploynomialAddition;

public class Term implements Comparable<Term>
{
	private int coefficient;
	private int exponent;
	
	/**
	 * Creates the Term object.
	 * @param coefficient  The coefficient value.
	 * @param exponent  The exponent value.
	 */
	Term(int coefficient, int exponent)
	{
		setAll(coefficient, exponent);
	}
	
	/**
	 * Returns the string of the term object.
	 * @return The string version of term.
	 */
	public String toString()
	{
		if(exponent == 0)
		{
			return String.valueOf(coefficient);
		}
		if(exponent == 1)
		{
			return String.valueOf(coefficient) + "x";
		}
		else
		{
			return String.valueOf(coefficient) + "x^" + String.valueOf(exponent);
		}
	}
	
	/**
	 * Sets coefficient.
	 * @param coefficient  The new coefficient.
	 */
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	
	/**
	 * Sets exponent.
	 * @param exponent  The new exponent.
	 */
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	
	/**
	 * Sets all variables.
	 * @param coefficient  The new coefficient value.
	 * @param exponent  The new exponent value.
	 */
	public void setAll(int coefficient, int exponent)
	{
		setCoefficient(coefficient);
		setExponent(exponent);
	}
	
	/**
	 * Returns the coefficient.
	 * @return  The coefficient
	 */
	public int getCoefficient()
	{
		return coefficient;
	}
	
	/**
	 * Returns the exponent.
	 * @return  The exponent
	 */
	public int getExponent()
	{
		return exponent;
	}
	
	/**
	 * Compares the obj to the term object.
	 * @param obj  The obj to compare to the term obj.
	 */
	public boolean equals(Object obj)
	{
		if(obj instanceof Term)
		{
			Term comparedTerm = (Term) obj;
			return coefficient == comparedTerm.getCoefficient() && exponent == comparedTerm.getExponent();
		}
		return false;
	}
	
	/**
	 * Returns whether the specified object's exponent is less then, equal to, or greater then the exponent of this exponent.
	 * @param comparedTerm  The term whose exponents is compared to.
	 */
	public int compareTo(Term comparedTerm)
	{
		if(exponent < comparedTerm.exponent)
		{
			return -1;
		}
		else if(exponent > comparedTerm.exponent)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}