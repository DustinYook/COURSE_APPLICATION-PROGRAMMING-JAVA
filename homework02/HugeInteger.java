package homework02;

public class HugeInteger 
{
	public int[] arr = new int[40];
	
	public void parse(String inputString)
	{
		for(int i = 0; i < inputString.length(); i++)
			arr[i] = inputString.charAt(i) - 48;
	}
	
	public String toString()
	{
		String resultString = "";
		for(int i = 0; i < arr.length; i++)
			resultString += (char)(arr[i] + 48);
		return resultString;
	}
	
	public String add(HugeInteger counterpart)
	{
		int carry = 0;
		for(int i = 0; i < this.arr.length; i++)
		{
			int digitSum = this.arr[i] + counterpart.arr[i];
			if(digitSum > 9)
			{
				if(i > 1)
				{
					this.arr[i] = digitSum % 10;
					this.arr[i-1] += (int)(digitSum / 10);
				}
				else
				{
					this.arr[i] = digitSum % 10;
					carry = (int)(digitSum / 10);
				}
			}
			else
				this.arr[i] = digitSum;
		}
		return (carry == 0 ? "" : carry) + this.toString();
	}
}