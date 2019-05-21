package class07;

import java.awt.*; // event
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConverterFrame extends JFrame // can be more flexible
{
	private static final long serialVersionUID = 1L;
	
	/** Member Fields */
	private JLabel lblDistance; // label
	private JTextField txtKmDistance; // input for kilometer
	private JButton btnCalculate; // calculate button
	private JTextField txtMileDistance; // output for miles
	
	/** Member Methods */
	public void showWindow()
	{
		// We already extend JFrame, so we don't need to specify that object here
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close action
		setSize(500, 300); // set frame size
		setVisible(true);
	}
	
	public ConverterFrame()
	{
		// to set window title call super constructor
		super("Converter"); // set title another way
		
		lblDistance = new JLabel("Distance in km"); // set label contents
		txtKmDistance = new JTextField(10); // generate text field component and set the maximum length
		btnCalculate = new JButton("Calculate"); // generate button component
		txtMileDistance = new JTextField(50); // generate text field component and set the maximum length
		txtMileDistance.setEditable(false); // prevent user from doing edit
		
		setLayout(new GridLayout(2, 2)); // set grid layout format
		btnCalculate.addActionListener(new CalculateHandler()); // add event listener to the component
		
		// add components to the frame
		this.add(lblDistance);
		this.add(txtKmDistance);
		this.add(btnCalculate);
		this.add(txtMileDistance);
	}
	
	class CalculateHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			// 1km = 0.621 miles
			double km = Double.parseDouble(txtKmDistance.getText());
			String mile = String.format("%.2f mile(s)", 0.624 * km);
			
			txtMileDistance.setText(mile); // append contents to the text field component
		}
	}
	
	public static void main(String[] args) 
	{
		ConverterFrame frame = new ConverterFrame();
		frame.showWindow();
	}
}