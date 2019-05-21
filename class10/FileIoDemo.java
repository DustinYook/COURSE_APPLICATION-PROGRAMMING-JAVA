package class10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("serial")
public class FileIoDemo extends JFrame implements ActionListener // extends JFrame means this program is GUI
{
	private JFrame frmFileIoDemo;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mnbtOpen;
	private JMenuItem mnbtSave;
	private JMenuItem mnbtExit;
	private JPanel panel;
	private JTextArea textArea;

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FileIoDemo window = new FileIoDemo();
					window.frmFileIoDemo.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/** Create the application */
	public FileIoDemo() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		this.frmFileIoDemo = new JFrame();
		this.frmFileIoDemo.setTitle("No Title - Note Pad");
		this.frmFileIoDemo.setBounds(100, 100, 450, 300);
		this.frmFileIoDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.menuBar = new JMenuBar();
		this.frmFileIoDemo.setJMenuBar(this.menuBar);
		
		this.mnFile = new JMenu("File");
		this.menuBar.add(this.mnFile);
		
		this.mnbtOpen = new JMenuItem("Open");
		this.mnbtOpen.addActionListener(this); // add action listener to each object -> "this" (important)
		this.mnFile.add(this.mnbtOpen);
		
		this.mnbtSave = new JMenuItem("Save");
		this.mnbtSave.addActionListener(this); // add action listener to each object
		this.mnFile.add(this.mnbtSave);
		
		this.mnbtExit = new JMenuItem("Exit");
		this.mnbtExit.addActionListener(this); // add action listener to each object
		this.mnFile.add(this.mnbtExit);
		
		this.panel = new JPanel();
		this.panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.frmFileIoDemo.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.textArea = new JTextArea();
		this.panel.add(this.textArea, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) // all the actions will be handled in here
	{ // e.getSource() identify where the action happened
		if(e.getSource() == mnbtOpen)
		{
			JFileChooser fc = new JFileChooser(); // can select file from dialog box
			int returnVal = fc.showOpenDialog(FileIoDemo.this); // belong dialog to program
			this.frmFileIoDemo.setTitle(fc.getSelectedFile().getName() + " - Note Pad"); // set title
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				textArea.setText("");
				File file = fc.getSelectedFile();
				
				try 
				{
					BufferedReader reader = new BufferedReader(new FileReader(file));
					
					String line = null;
					while((line = reader.readLine()) != null)
						textArea.append(line + "\n");
					reader.close();
				} 
				catch (FileNotFoundException e1) { e1.printStackTrace(); } 
				catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		else if(e.getSource() == mnbtSave)
		{
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(FileIoDemo.this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				try 
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					writer.write(textArea.getText());
					writer.flush();
					writer.close();
				} 
				catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		else if(e.getSource() == mnbtExit)
			this.frmFileIoDemo.dispose(); // target of object needs to be frame object
	}
}