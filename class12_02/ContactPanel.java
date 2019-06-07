package class12_02;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblName;
	private JLabel lblPhone;
	private JButton btnEdit;
	private JButton btnDelete;

	/** Create the panel */
	public ContactPanel(PhoneBookUpdated phonebookupd) // get parameter from main frame
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(2, 2, 0, 0));
		
		this.lblName = new JLabel("Name");
		add(this.lblName);
		
		this.btnEdit = new JButton("Edit");
		this.btnEdit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// receive name & number
				ContactDialog dialog = new ContactDialog(null, lblName.getText(), lblPhone.getText());
				
				dialog.setVisible(true);
				
				String name = dialog.getName();
				String number = dialog.getNumber();
				
				if(name != null & number != null) // null이면 아무것도 안함
				{
					setContactName(name);
					setContactPhone(number);
				}
				
				phonebookupd.updateGUI();
			}
		});
		add(this.btnEdit);
		
		this.lblPhone = new JLabel("Phone");
		add(this.lblPhone);
		
		this.btnDelete = new JButton("Delete");
		this.btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int ret = JOptionPane.showConfirmDialog(phonebookupd, "Do you want to delete this item?", "DeleteItem", JOptionPane.YES_NO_OPTION);
				
				if(ret == JOptionPane.YES_OPTION)
				{
					phonebookupd.removeItem(ContactPanel.this);
					phonebookupd.updateGUI();
				}
			}
		});
		add(this.btnDelete);
	}
	
	public void setContactName(String name) { lblName.setText(name); }
	public String getContactName() { return lblName.getText(); }
	
	public void setContactPhone(String phone) { lblPhone.setText(phone); }
	public String getContactPhone() { return lblPhone.getText(); }
}