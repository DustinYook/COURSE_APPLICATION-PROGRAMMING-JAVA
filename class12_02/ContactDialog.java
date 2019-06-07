package class12_02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtNumber;

	private String names = null;
	private String numbers = null;
	
	/** Create the dialog */
	public ContactDialog(JFrame parent, String name, String number) 
	{
		/** VERY IMPORTANT */
		super(parent, true); // bound this ContactDialog to main frame
		setBounds(100, 100, 325, 171);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 2, 0, 0));
		{
			JLabel lblname = new JLabel("name");
			contentPanel.add(lblname);
		}
		{
			txtName = new JTextField();
			contentPanel.add(txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblname = new JLabel("number");
			contentPanel.add(lblname);
		}
		{
			txtNumber = new JTextField();
			contentPanel.add(txtNumber);
			txtNumber.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton EditButton = new JButton("Edit");
				EditButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						names = txtName.getText();
						numbers = txtNumber.getText();
						
						setVisible(false);
					}
				});
				EditButton.setActionCommand("OK");
				buttonPane.add(EditButton);
				getRootPane().setDefaultButton(EditButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						names = null;
						numbers = null;
						
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		txtName.setText(name);
		txtNumber.setText(number);
	}
	
	public String getName() { return names; }
	public String getNumber() { return numbers; }
}