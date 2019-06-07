package class12_01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel; // for DefaultListModel
import java.util.ArrayList; // for ArrayList
import java.util.Collections; // for Collection methods

public class PhoneBook 
{
	private JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblTotal;
	private JMenuBar menuBar;
	private JMenu mnCollections;
	private JMenuItem mntmSort;
	private JMenuItem mntmShuffle;
	private JMenuItem mntmDuplicate;
	private JList list;

	/** User-defined variables */
	private DefaultListModel<String> listModel;
	ArrayList<String> phonebook;

	/** Names of work people */
	public static String[] names = { 
			"Mitsue Tani", "Amelia McGuiness", "Austin Irwin", "David Ponte", "Maria Casillas",
			"Klaus Zimmer", "Arvind Poortvliet", "Kimberly Bryant", "Robert Foss", "Veronica Hartnoll", "Barry Peters",
			"Melanie Morris", "Dorian Mota", "Melisande Paiement", "Elias Stuinen", "Luke Gilbert", "Orpheo Meijerhof",
			"Marijke Thorsen", "Christopher Hogan", "Veijo Hurme", "Donna Scott", "Brenda Thomas", "Martin Biermann",
			"Alvedin Bauk", "Christy Reynolds", "Dale Escobar", "Julia Ebersbacher", "Elisa Baresi", "Cui Teng",
			"Pal Majer", "Arika Fujii", "Janek Maciejewski", "Horace Provost", "Mary Rainey"
			};

	/** Phone number for work people. Each phone number entry lines up with the names in 'names' */
	public static String[] phones = { 
			"501-645-0791", "502-519-4634", "317-716-6323", "817-941-8660", "703-224-8177",
			"734-876-8318", "845-225-2412", "478-967-9476", "706-283-9218", "520-838-0633", "760-951-2970",
			"419-980-0128", "919-477-2904", "478-553-3218", "410-418-9516", "916-771-3266", "413-526-1632",
			"845-756-2888", "757-935-8572", "469-362-6326", "541-563-2254", "484-544-4646", "661-302-6845",
			"301-905-3083", "513-629-1553", "330-948-2674", "913-727-1550", "704-201-9570", "715-348-8673",
			"615-823-2105", "631-558-5171", "830-778-9357", "954-877-1843", "304-702-4314"
			};

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PhoneBook window = new PhoneBook();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/** Create the application */
	public PhoneBook() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 555, 459);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setPreferredSize(new Dimension(2, 350));
		this.frame.getContentPane().add(this.scrollPane, BorderLayout.NORTH);

		/** instantiate DefaultListModel */
		listModel = new DefaultListModel<String>();

		// for(int i = 0; i < names.length; i++)
		//	listModel.addElement(names[i] + ": " + phones[i]);

		/** instantiate ArrayList */
		phonebook = new ArrayList<String>();
		
		/** add elements to ArrayList */
		for (int i = 0; i < names.length; i++)
			phonebook.add(names[i] + ": " + phones[i]);

		/** add record from ArrayList to DefaultListModel */
		for (String record : phonebook)
			listModel.addElement(record);

		this.list = new JList(listModel); // put DefaultListModel to JList
		// Now you can see the list through GUI
		this.scrollPane.setViewportView(this.list);

		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.SOUTH);

		this.lblTotal = new JLabel("Total");
		this.lblTotal.setText("Total: " + listModel.size() + " records"); // show how many records it has
		this.panel.add(this.lblTotal);

		this.menuBar = new JMenuBar();
		this.frame.setJMenuBar(this.menuBar);

		this.mnCollections = new JMenu("Collections");
		this.menuBar.add(this.mnCollections);

		this.mntmSort = new JMenuItem("Sort");
		this.mntmSort.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Collections.sort(phonebook); // sort methods in collections
				update();
			}
		});
		this.mnCollections.add(this.mntmSort);

		this.mntmShuffle = new JMenuItem("Shuffle");
		this.mntmShuffle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Collections.shuffle(phonebook); // shuffle methods in collections
				update();
			}
		});
		this.mnCollections.add(this.mntmShuffle);

		this.mntmDuplicate = new JMenuItem("Duplicate");
		this.mntmDuplicate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				/** duplicate and add right behind of selected item */
				phonebook.add(list.getSelectedIndex() + 1, phonebook.get(list.getSelectedIndex()));
				
				/** duplicate and add selected item to the end of ArrayList */
				// phonebook.add(phonebook.get(list.getSelectedIndex()));
				
				update();
			}
		});
		this.mnCollections.add(this.mntmDuplicate);
	}

	public void update() 
	{
		/** clear before print */
		listModel.clear(); 
		
		/** add record from ArrayList to DefaultListModel */
		for (String record : phonebook) 
			listModel.addElement(record);

		lblTotal.setText("Total: " + listModel.getSize() + " records");
	}
}