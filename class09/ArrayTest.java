package class09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrayTest 
{
	private JFrame frame;
	private JTextField txtInputField;
	private JTextField txtIndex;
	private JTextField txtNumber;
	private JPanel panel;
	private GridBagLayout gbl_panel;
	private JLabel lblInputText;
	private GridBagConstraints gbc_lblInputText;
	private GridBagConstraints gbc_txtInputField;
	private JLabel lblArray;
	private GridBagConstraints gbc_lblArray;
	private JPanel panel_1;
	private GridBagConstraints gbc_panel_1;
	private JLabel lblA_1;
	private JLabel label;
	
	private int index = 0;
	private int array[] = new int[10];

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ArrayTest window = new ArrayTest();
					window.frame.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/** Create the application */
	public ArrayTest() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 104, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblInputText = new JLabel("Input the number of array");
		lblInputText.setFont(new Font("굴림", Font.BOLD, 18));
		gbc_lblInputText = new GridBagConstraints();
		gbc_lblInputText.insets = new Insets(0, 0, 5, 5);
		gbc_lblInputText.anchor = GridBagConstraints.EAST;
		gbc_lblInputText.gridx = 0;
		gbc_lblInputText.gridy = 0;
		panel.add(lblInputText, gbc_lblInputText);
		
		txtInputField = new JTextField();
		txtInputField.addActionListener(new ActionListener() 
		{
			// if you press enter, then it outputs the number to the console.
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					int num = Integer.parseInt(txtInputField.getText()); 
					insertToArray(num);
				}
				catch(DuplicateValueException duplicateEx)
				{
					JOptionPane.showMessageDialog(null, "Please enter only unique integers", "Duplicate Value Exception", JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException formatEx)
				{
					JOptionPane.showMessageDialog(null, "Please enter only integer", "Number Format Exception", JOptionPane.ERROR_MESSAGE);
				}
				catch(ArrayIndexOutOfBoundsException outOfBoundEx)
				{
					JOptionPane.showMessageDialog(null, "Please enter only less than 10", "Array Out of Bound Exception", JOptionPane.ERROR_MESSAGE);
				}
				finally 
				{ 
					updateArrayDisplay(); 
					txtInputField.setText("");
				}
			}
		});
		gbc_txtInputField = new GridBagConstraints();
		gbc_txtInputField.insets = new Insets(0, 0, 5, 0);
		gbc_txtInputField.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInputField.gridx = 1;
		gbc_txtInputField.gridy = 0;
		panel.add(txtInputField, gbc_txtInputField);
		txtInputField.setColumns(10);
		
		lblArray = new JLabel("a = []");
		lblArray.setFont(new Font("굴림", Font.BOLD, 18));
		gbc_lblArray = new GridBagConstraints();
		gbc_lblArray.insets = new Insets(0, 0, 5, 0);
		gbc_lblArray.gridwidth = 2;
		gbc_lblArray.gridx = 0;
		gbc_lblArray.gridy = 1;
		panel.add(lblArray, gbc_lblArray);
		
		panel_1 = new JPanel();
		gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblA_1 = new JLabel("a[");
		lblA_1.setFont(new Font("굴림", Font.BOLD, 18));
		panel_1.add(lblA_1);
		
		txtIndex = new JTextField();
		txtIndex.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					int num = Integer.parseInt(txtIndex.getText());
					
					if(num >= index || num < 0)
						throw new ArrayIndexOutOfBoundsException("Index Not Found!");
					
					txtNumber.setText(String.format("%d", array[num]));
				}
				catch(NumberFormatException formatEx)
				{
					JOptionPane.showMessageDialog(null, "Please enter only integers", "Integer Format Exception", JOptionPane.ERROR_MESSAGE);
					txtNumber.setText("");
				}
				catch(ArrayIndexOutOfBoundsException outOfBoundEx)
				{
					JOptionPane.showMessageDialog(null, "Please enter only less than 10", "Array Out of Bound Exception", JOptionPane.ERROR_MESSAGE);
					txtNumber.setText("");
				}
			}
		});
		panel_1.add(txtIndex);
		txtIndex.setColumns(3);
		
		label = new JLabel("] =");
		label.setFont(new Font("굴림", Font.BOLD, 18));
		panel_1.add(label);
		
		txtNumber = new JTextField();
		txtNumber.setEnabled(false);
		txtNumber.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					int num = Integer.parseInt(txtNumber.getText());
					int foundVal = -1;
					
					for(int i = 0; i < index; i++) // try to find in array
					{
						if(num == array[i])
							foundVal = i;
					}
					if(foundVal == -1)
					{
						throw new NumberNotFoundException();
					}
					
					txtIndex.setText(String.format("%d", foundVal));
				}
				catch(NumberFormatException formatEx)
				{
					JOptionPane.showMessageDialog(null, "Please enter only integers", "Integer Format Exception", JOptionPane.ERROR_MESSAGE);
					txtNumber.setText("");
				}
				catch(NumberNotFoundException numberEx)
				{
					JOptionPane.showMessageDialog(null, numberEx.getMessage(), "Not found", JOptionPane.ERROR_MESSAGE);
					txtNumber.setText("");
				}
			}
		});
		panel_1.add(txtNumber);
		txtNumber.setColumns(3);
	}
	
	// There are possibilities of two exceptions
	public void insertToArray(int num) throws DuplicateValueException, ArrayIndexOutOfBoundsException
	{
		for(int i = 0; i < index; i++)
		{
			if(num == array[i])
				throw new DuplicateValueException();
		}
		
		array[index] = num;
		index++;
	}
	
	// Update the label
	public void updateArrayDisplay()
	{
		String str = "";
		
		for(int i = 0; i < index; i++)
			str = str + array[i] + ", ";
		
		String  res = "a[" + str + "]";
		lblArray.setText(res);
	}
}