package class04;

import java.lang.String;

public class AddressBook 
{
	private String name;
	private String birthDay;
	private String[] mobile;
	private String email;
	private String company;
	
	public AddressBook(String name, int date, int month, int year, String[] mobile, String email, String company) 
	{
		this.mobile = new String[3];
		
		setName(name);
		setBirthDay(date, month, year);
		setMobile(mobile);
		setEmail(email);
		setCompany(company);
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		if(name.length() >= 20) // max-length validity checking
		{
			System.out.println("The name is too long, so the part of it will be saved");
			this.name = name.substring(0, 8);
		}
		else
			this.name = name;
	}

	public String getBirthDay() 
	{
		return birthDay;
	}

	public void setBirthDay(int date, int month, int year) 
	{
		String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		this.birthDay = months[month - 1] + " " + Integer.toString(date) + ", " + Integer.toString(year);
		// or "" + date + ... 
	}

	public String getMobile() 
	{
		String numbers = "";
		for(int i = 0; i < mobile.length; i++)
		{
			if(i != mobile.length - 1)
				numbers += mobile[i] + ", ";
			else
				numbers += mobile[i];
		}
		return numbers;
	}

	public void setMobile(String[] mobile) 
	{
		this.mobile = mobile;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getCompany() 
	{
		return company;
	}

	public void setCompany(String company) 
	{
		this.company = company;
	}

	@Override
	public String toString() 
	{
		return "Name: " + this.getName() + "\n" +
			   "Birthday: " + this.getBirthDay() + "\n" +
			   "Mobile: " + this.getMobile() + "\n" +
			   "Email: " + this.getEmail() + "\n" + 
			   "Company: " + this.getCompany() + "\n";
	}
}