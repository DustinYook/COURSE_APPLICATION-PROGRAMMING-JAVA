package class10;

import java.io.Serializable;

public class Student implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa) 
	{
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	public double getGpa() { return this.gpa; }
	public void setGpa(double gpa) { this.gpa = gpa; }

	@Override
	public String toString() { return String.format("ID : %d\nName : %s\nGPA: %.2f\n\n", this.id, this.name, this.gpa); }
}