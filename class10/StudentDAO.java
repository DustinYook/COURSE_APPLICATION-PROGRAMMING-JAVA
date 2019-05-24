package class10;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentDAO implements Serializable 
{
	private int id;
	private String name;
	private double gpa;
	
	// in order to random access, we need to use fixed size -> for searching
	
	public static final int NAME_SIZE = 10; // enforce string size should be 10
	
	// Each integer is 4 bytes and double is 8 bytes
	public static final int OBJECT_SIZE = 4 + NAME_SIZE + 8;
	
	public StudentDAO() { }
	
	public StudentDAO(int id, String name, double gpa) 
	{
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public double getGpa() { return gpa; }
	public void setGpa(double gpa) { this.gpa = gpa; }
	
	public void writeData(RandomAccessFile raf) // write on the file
	{
		try 
		{
			raf.writeInt(id);
			raf.writeDouble(gpa);
			raf.writeChars(name); // all object size should have same size -> force to make size of 10
			
			if(name.length() > NAME_SIZE)
				name.substring(0, 10); // truncate long string force to be size of 10
			else
			{
				for(int i = name.length(); i< NAME_SIZE; i++) // make string bound to 10
					raf.writeChar(0x00); // null
			}
		} 
		catch (IOException e) { e.printStackTrace(); }
	}

	public void readData(RandomAccessFile raf) // read from the file
	{
		try 
		{
			// the order of reading is very important : id -> gpa -> name
			id = raf.readInt();
			gpa = raf.readDouble();
			
			int cnt = 0;
			while(cnt < NAME_SIZE)
			{
				char ch = raf.readChar();
				if(ch == 0x00)
					break;
				else
					name += ch;
			}
		} 
		catch (IOException e) { e.printStackTrace(); } 
	}
	
	@Override
	public String toString() { return String.format("ID : %d\nName : %d\nGPA: %.2f\n\n", id, name, gpa); }
}