/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment02
 * HugeInteger.java : simple calculator for 40-digit-number (for calculator definition)
 * Reporting Date : 2019-03-28
 */

package homework02;

public class HugeInteger 
{
	/* Member Field */
	public int[] digits = new int[40]; // array for saving all the digits 
	
	/* Member Method */
	/** parse method */
	public void parse(String input)
	{
		// (39 - input.length()) + 1 + i : to start designated-digit
		// if user input 5-digit-number, let 12345, 
		// then it fills data from index 35 to 39 and fills 0 for the front number digit
		for(int i = 0; i < input.length(); i++)
			digits[(39 - input.length()) + 1 + i] = input.charAt(i) - 48;
	}
	
	/** toString method */
	public String toString()
	{
		// check which digit-position the none-zero-number occurs
		int nonZeroIndex = 0;
		int zeroCounter = 0;
		for(int i = 0; i < 40; i++)
		{
			if(this.digits[i] != 0)
			{
				nonZeroIndex = i;
				break;
			}
			zeroCounter++;
		}

		if(zeroCounter == 40) // if all the digits are zero, then return 0
			return "0";
		
		// make string which is composed of digits
		String objVal = "";
		for(int i = nonZeroIndex; i < 40; i++)
			objVal += this.digits[i];
			
		return objVal;
	}

	/** add method */
	public String add(HugeInteger counterpart)
	{
		// save the original copy 
		int[] copyOriginal = new int[40];
		for(int i = 0; i < 40; i++)
			copyOriginal[i] = this.digits[i];
		
		// process add-operation
		int carry = 0; // if sum is more than 10, it creates carry
		for(int i = 39; i >= 0; i--)
		{
			this.digits[i] = counterpart.digits[i] + this.digits[i] + carry;
			
			if(this.digits[i] >= 0 && this.digits[i] <= 9) // case for no-carry-generation
				carry = 0;
			else // case for carry-generation
			{
				this.digits[i] %= 10;
				carry = 1;
			}
		}

		// generate result string
		String addResult = "";
		
		// if the result is more-than-40-digit-number
		if(carry == 1) 
		{
			if(carry == 1) // case for having carry on the-highest-digit
				addResult = "1";
			for(int i : this.digits)
				addResult += i;
		}
		// if the result is within-40-digit-number
		else 
		{
			// check which digit-position the non-zero-number occurs
			int nonZeroIndex = 0;
			for(int i = 0; i < 40; i++)
			{
				if(this.digits[i] != 0)
				{
					nonZeroIndex = i;
					break;
				}
			}
			// make string which is composed of digits
			for(int i = nonZeroIndex; i < 40; i++)
				addResult += this.digits[i];
		}
		
		// restore original status
		for(int i = 0; i < 40; i++)
			this.digits[i] = copyOriginal[i];
		
		// return result to caller
		return addResult;
	}
	
	/** subtract method */
	public String subtract(HugeInteger counterpart)
	{
		String subtractResult = ""; // a variable for result 
		
		/** save the original copy */
		int[] copyOriginal = new int[40];
		for(int i = 0; i < 40; i++)
			copyOriginal[i] = this.digits[i];
		
		/** process subtract operation */
		// if two numbers are the same
		if(this.isEqualTo(counterpart))
			return "0";
		// if two numbers are different
		else 
		{
			// A > B : plus
			if(this.isGreaterThan(counterpart)) 
			{
				int burrow = 0;
				// process subtract operation
				for(int i = 39; i >= 0; i--)
				{
					// Note that the order of operation is different! (this - counterpart)
					this.digits[i] = (this.digits[i] - burrow) - counterpart.digits[i];
						
					if(this.digits[i] >= 0) // no-burrow is needed
						burrow = 0;
					else // burrow is needed
					{
						this.digits[i] += 10;
						burrow = 1;
					}
				}
			}
			// A < B : minus
			else if(this.isLessThan(counterpart)) 
			{
				subtractResult += "-"; // put the minus sign at the front
				
				int burrow = 0;
				// process subtract operation
				for(int i = 39; i >= 0; i--)
				{
					// Note that the order of operation is different! (counterpart - this)
					// because A-B is same as -(B-A)
					this.digits[i] = (counterpart.digits[i] - burrow) - this.digits[i];
						
					if(this.digits[i] >= 0) // no-burrow is needed
						burrow = 0;
					else // burrow is needed
					{
						this.digits[i] += 10;
						burrow = 1;
					}
				}
			}
			
			/** generate result string */
			// check which digit-position the none-zero-number occurs
			int nonZeroIndex = 0;
			for(int i = 0; i < 40; i++)
			{
				if(this.digits[i] != 0)
				{
					nonZeroIndex = i;
					break;
				}
			}
			// make string which is composed of digits
			for(int i = nonZeroIndex; i < 40; i++)
				subtractResult += this.digits[i];
			
			
			/** restore original status */
			for(int i = 0; i < 40; i++)
				this.digits[i] = copyOriginal[i];
			
			/** return result to caller */
			return subtractResult;
		}
	}
	
	/** isEqualTo method */
	public boolean isEqualTo(HugeInteger counterpart)
	{
		for(int i = 0; i < 40; i++)
		{
			// if at least one digit element is different, then return false
			if(this.digits[i] != counterpart.digits[i])
				return false;
		}
		return true;
	}
	
	/** isNotEqualTo method */
	public boolean isNotEqualTo(HugeInteger counterpart)
	{
		// isNotEqualTo is opposite to isNotEqualTo, so express this by using logical negation operator
		return !(this.isEqualTo(counterpart)); 
	}
	
	/** isGreaterThan method */
	public boolean isGreaterThan(HugeInteger counterpart)
	{
		int counter = 0; // initialized
		
		// comparison and index bound-checking 
		while((this.digits[counter] == counterpart.digits[counter]) && (counter < 39))
			counter++;
		
		if(counter == 40) // if all numbers are the same 
			return false;
		else // else the relationship holds
			return (this.digits[counter] > counterpart.digits[counter]);
	}
	
	/** isLessThan method */
	public boolean isLessThan(HugeInteger counterpart)
	{
		int counter = 0; // initialized
		
		// comparison and index bound-checking 
		while((this.digits[counter] == counterpart.digits[counter]) && (counter < 39))
			counter++;
		
		if(counter == 40) // if all numbers are the same
			return false;
		else // else the relationship holds
			return (this.digits[counter] < counterpart.digits[counter]);
	}
	
	/** isGreaterThanOrEqualTo method */
	public boolean isGreaterThanOrEqualTo(HugeInteger counterpart)
	{
		// isGreaterThan or(||) EqaulTo
		return (isGreaterThan(counterpart) || isEqualTo(counterpart));
	}
	
	/** isLessThanOrEqualTo method */
	public boolean isLessThanOrEqualTo(HugeInteger counterpart)
	{
		// isLessThan or(||) EqaulTo
		return (isLessThan(counterpart) || isEqualTo(counterpart));
	}
	
	/** isZero method */
	public boolean isZero()
	{
		for(int i = 0; i < 40; i++) 
		{
			if(this.digits[i] != 0) // if at least one digit is not zero
				return false; // then return false
		}
		return true;
	}
}