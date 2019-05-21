package class07;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TipOfTheDay 
{
	private JFrame frame;

	/** Launch the application. */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TipOfTheDay window = new TipOfTheDay();
					window.frame.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/** Create the application. */
	public TipOfTheDay() { initialize(); }

	/** Initialize the contents of the frame. */
	private void initialize() 
	{
		/* JFrame */
		frame = new JFrame("Tip of the Day");
		frame.setResizable(false);
		frame.setMaximumSize(new Dimension(450, 300));
		frame.setBounds(100, 100, 456, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* JPanel #1 */
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 60));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		/* JLabel #1 */
		JLabel lblJdeveloperProductivtyHints = new JLabel("JDeveloper Productivty Hints");
		lblJdeveloperProductivtyHints.setBounds(17, 20, 217, 17);
		lblJdeveloperProductivtyHints.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblJdeveloperProductivtyHints);
		
		/* JLabel #2 */
		JLabel lblForicon = new JLabel("Foricon");
		lblForicon.setIcon(new ImageIcon("C:\\Workspace\\JavaProject\\src\\class07\\image.png"));
		lblForicon.setBounds(366, 2, 50, 50);
		panel.add(lblForicon);
		
		/* JPanel #2 */
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		/* JTextPane */
		JTextPane txtpnClosingWindowsUsing = new JTextPane();
		txtpnClosingWindowsUsing.setContentType("text/html"); // set content type as HTML format
		txtpnClosingWindowsUsing.setEditable(false);
		txtpnClosingWindowsUsing.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpnClosingWindowsUsing.setText("<html><b>Closing windows using the mouse wheel</b><br><p>Clicking with the mouse wheel on an editor tab closes the window.<br>This method works also with dockable windows or Log window tabs</p></html>");
		txtpnClosingWindowsUsing.setBounds(17, 15, 408, 103);
		panel_1.add(txtpnClosingWindowsUsing);
		
		/* JCheckBox */
		JCheckBox chckbxShowTipsAt = new JCheckBox("Show Tips at startup");
		chckbxShowTipsAt.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxShowTipsAt.setBounds(13, 129, 232, 29);
		panel_1.add(chckbxShowTipsAt);
		
		/* JButton #1 */
		JButton btnNextTip = new JButton("Next Tip");
		btnNextTip.setFont(new Font("Arial", Font.BOLD, 14));
		btnNextTip.setBounds(234, 169, 99, 29);
		panel_1.add(btnNextTip);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Arial", Font.BOLD, 14));
		btnClose.addActionListener(new ActionListener() 
		{
			// frame.dispose : close window
			public void actionPerformed(ActionEvent e) { frame.dispose(); }
		});
		btnClose.setBounds(341, 169, 92, 29);
		panel_1.add(btnClose);
	}
}
