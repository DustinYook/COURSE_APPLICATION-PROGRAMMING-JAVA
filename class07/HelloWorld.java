package class07;

import java.awt.*; // Dimension
import javax.swing.*; // JFrame, JLabel

public class HelloWorld 
{
	public static void main(String[] args) 
	{
		// Set up the window
		/** Generate Frame */
		JFrame frame = new JFrame(); // generate frame object
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what action should program take when close button is clicked
		frame.setSize(new Dimension(500, 300)); // this is defined in AWT package
		frame.setTitle("Java Window"); // set title
		
		/** Add Label */
		JLabel label = new JLabel("Winter is here!"); // generate label object
		frame.add(label);
		
		frame.setVisible(true);
	}
}