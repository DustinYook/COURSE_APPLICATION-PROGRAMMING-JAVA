package class12_02;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.DefaultListModel;

public class PhoneBookUpdated extends JFrame // extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblTotal;

	/** User-defined variables */
	private DefaultListModel<ContactPanel> listModel; // DefaultListModel for ContactPanel object
	private ArrayList<ContactPanel> phonebook; // ArrayList for ContactPanel object

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
	
	private JPanel pnList;

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PhoneBookUpdated window = new PhoneBookUpdated();
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
	public PhoneBookUpdated() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		this.frame = new JFrame("PhoneBook");
		this.frame.setBounds(100, 100, 555, 459);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setPreferredSize(new Dimension(2, 350));
		this.frame.getContentPane().add(this.scrollPane, BorderLayout.NORTH);

		this.pnList = new JPanel();
		this.scrollPane.setViewportView(this.pnList);
		this.pnList.setLayout(new GridLayout(0, 1, 0, 0));

		/** instantiate DefaultListModel & ArrayList */
		listModel = new DefaultListModel<ContactPanel>();
		phonebook = new ArrayList<ContactPanel>(); 

		for (int i = 0; i < names.length; i++) 
		{
			ContactPanel contact = new ContactPanel(this); // new instance for ContactPanel
			
			contact.setContactName(names[i]); // set name to ContactPanel
			contact.setContactPhone(phones[i]); // set phone to ContactPanel

			phonebook.add(contact); 
		}

		this.panel = new JPanel();
		this.frame.getContentPane().add(this.panel, BorderLayout.SOUTH);

		this.lblTotal = new JLabel("Total");
		this.lblTotal.setText("Total: " + listModel.size() + " records"); // show how many records it has
		this.panel.add(this.lblTotal);

		updateGUI();
	}

	public void updateTotal() { lblTotal.setText("Total: " + phonebook.size() + " records"); }

	public void updateGUI() 
	{
		pnList.removeAll(); // clear before print

		ListIterator<ContactPanel> iter = phonebook.listIterator(); // get iterator
		
		while (iter.hasNext()) // until the end
		{
			ContactPanel record = iter.next(); 
			pnList.add(record);
		}
		
		revalidate();
		repaint();
		
		updateTotal();
	}

	public void removeItem(ContactPanel contact) { phonebook.remove(contact); }
}
