package class10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JScrollPane;
import java.awt.Font;

public class SimpleNotePad 
{
	private JFrame frmSimpleNotePad;
	private JMenuBar menuBar;
	private JMenu mnTextFile;
	private JMenu mnBinaryFile;
	private JMenuItem mnItmSaveTxt;
	private JMenuItem mnItmOpenTxt;
	private JTextArea textArea;
	private JMenuItem mnItmSaveBin;
	private JMenuItem mnItmOpenBin;
	private JScrollPane scrollPane;

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SimpleNotePad window = new SimpleNotePad();
					window.frmSimpleNotePad.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/** Create the application */
	public SimpleNotePad() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		this.frmSimpleNotePad = new JFrame();
		this.frmSimpleNotePad.setTitle("Simple Note Pad");
		this.frmSimpleNotePad.setBounds(100, 100, 549, 368);
		this.frmSimpleNotePad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.menuBar = new JMenuBar();
		this.frmSimpleNotePad.setJMenuBar(this.menuBar);
		
		this.mnTextFile = new JMenu("Text File");
		this.mnTextFile.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		this.menuBar.add(this.mnTextFile);
		
		this.mnItmSaveTxt = new JMenuItem("Save");
		this.mnItmSaveTxt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					// FileOutputStream file = new FileOutputStream("data.txt");
					// PrintWriter stream = new PrintWriter(file);
					PrintWriter stream = new PrintWriter(new FileOutputStream("C:\\Users\\aomor\\OneDrive\\Desktop\\data.txt", true)); 
					// "true" enables program to append data in original file
					String outputData = textArea.getText();
					stream.println(outputData);
					stream.flush();
					textArea.setText("");
					stream.close(); // prevent memory leakage
				} 
				catch (FileNotFoundException e1) { e1.printStackTrace(); }
			}
		});
		this.mnTextFile.add(this.mnItmSaveTxt);
		
		this.mnItmOpenTxt = new JMenuItem("Open");
		this.mnItmOpenTxt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FileInputStream file;
				try 
				{
					file = new FileInputStream("C:\\Users\\aomor\\OneDrive\\Desktop\\data.txt");
					Scanner stream = new Scanner(file);
					while(stream.hasNext())
					{
						String inData = stream.nextLine();
						textArea.append(inData + "\n");
					}
					stream.close();
				} 
				catch (FileNotFoundException e1) { e1.printStackTrace(); }
			}
		});
		this.mnTextFile.add(this.mnItmOpenTxt);
		
		this.mnBinaryFile = new JMenu("Binary File");
		this.mnBinaryFile.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		this.menuBar.add(this.mnBinaryFile);
		
		this.mnItmSaveBin = new JMenuItem("Save");
		this.mnItmSaveBin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Student s1 = new Student(12131819, "YOOK DONGHYUN", 4.13);
				Student s2 = new Student(12131820, "LEE HYEBIN", 4.35);
				
				try 
				{
					FileOutputStream file = new FileOutputStream("C:\\Users\\aomor\\OneDrive\\Desktop\\file.bin", true);
					ObjectOutputStream stream = new ObjectOutputStream(file);
					
					stream.writeObject(s1);
					stream.writeObject(s2);
					
					stream.flush();
					stream.close(); // to prevent memory leakage
				} 
				catch (FileNotFoundException e1) { e1.printStackTrace(); } 
				catch (IOException e1) { e1.printStackTrace(); }
			}
		});
		this.mnBinaryFile.add(this.mnItmSaveBin);
		
		this.mnItmOpenBin = new JMenuItem("Open");
		this.mnItmOpenBin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					FileInputStream file = new FileInputStream("C:\\Users\\aomor\\OneDrive\\Desktop\\file.bin");
					ObjectInputStream stream = new ObjectInputStream(file);
					
					try 
					{
						Student inStudent = (Student) stream.readObject();
						textArea.setText(inStudent.toString());
					} 
					catch (ClassNotFoundException e1) { e1.printStackTrace(); }
					
					stream.close();
				} 
				catch (FileNotFoundException e1) { e1.printStackTrace(); } 
				catch (IOException e1) { e1.printStackTrace(); }
			}
		});
		this.mnBinaryFile.add(this.mnItmOpenBin);
		
		this.textArea = new JTextArea();
		this.frmSimpleNotePad.getContentPane().add(this.textArea, BorderLayout.CENTER);
		
		this.scrollPane = new JScrollPane();
		this.frmSimpleNotePad.getContentPane().add(this.scrollPane, BorderLayout.EAST);
	}
}