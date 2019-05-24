package class11;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentListGUI 
{
	private JFrame frmStudentList;
	private JButton btnAddNew;
	private JScrollPane scrollPane;
	private JList list;
	
	public String[] array = new String[10];
	public int counter = 0;

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					StudentListGUI window = new StudentListGUI();
					window.frmStudentList.setVisible(true);
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application */
	public StudentListGUI() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		this.frmStudentList = new JFrame();
		this.frmStudentList.setTitle("Student List");
		this.frmStudentList.setBounds(100, 100, 450, 300);
		this.frmStudentList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try 
		{
			FileReader fr = new FileReader("students.txt");
			BufferedReader br = new BufferedReader(fr);
				
			String sCurrentLine;
			while((sCurrentLine = br.readLine())!= null)
			{
				array[counter] = sCurrentLine;
				counter++;
			}
		} 
		catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		for(int i = 0; i < array.length; i++)
			listModel.addElement(array[i]);
		
		this.btnAddNew = new JButton("New button");
		this.btnAddNew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AddItemDialog dlg = new AddItemDialog(frmStudentList);
				dlg.setVisible(true);
				
				String ret = dlg.getNewStudent();
				
				if(ret != null)
					listModel.addElement(ret);
			}
		});
		this.frmStudentList.getContentPane().add(this.btnAddNew, BorderLayout.SOUTH);
		
		this.scrollPane = new JScrollPane();
		this.frmStudentList.getContentPane().add(this.scrollPane, BorderLayout.CENTER);
		
		this.list = new JList(listModel);
		this.list.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(e.getClickCount() == 2) // only for double-clicked event
				{
					int index = list.getSelectedIndex(); // variable to save index of the list
					
					String element = listModel.getElementAt(index).toString(); // save the content of double-clicked item
					EditItemDialog dlg = new EditItemDialog(frmStudentList, element); // pass double-clicked element to edit dialog
					
					dlg.setVisible(true); // open edit dialog
					
					String ret = dlg.geteditStudent();
					if(ret != null)
						listModel.setElementAt(ret, index);
				}
			}
		});
		this.scrollPane.setViewportView(this.list);
	}
}