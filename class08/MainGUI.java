package class08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MainGUI 
{
	private JFrame frame;
	private JPanel pnInput;
	private JPanel pnList;
	private JPanel pnStatus;
	private JLabel lblInputANumber;
	private JTextField inputTextField;
	private JButton btnRun;
	private JButton btnCancel;
	private JProgressBar progressBar;
	private JLabel lblStatus;
	private JScrollPane scrollPane;
	private JTextArea outputTextArea;
	
	Thread workThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnInput = new JPanel();
		frame.getContentPane().add(pnInput, BorderLayout.NORTH);
		pnInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblInputANumber = new JLabel("Input a number");
		pnInput.add(lblInputANumber);
		
		inputTextField = new JTextField();
		pnInput.add(inputTextField);
		inputTextField.setColumns(10);
		
		btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				outputTextArea.setText("");
				int number = Integer.parseInt(inputTextField.getText()); // txtFld.getText()'s return value is String type
				// System.out.println(number);
				workThread = new Thread(new CalculateRandom(number));
				workThread.start();
			}
		});
		pnInput.add(btnRun);
		
		btnCancel = new JButton("Cancel\r\n");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				workThread.stop(); // stop working (or interrupt if we need to do exception handling)
			}
		});
		btnCancel.setEnabled(false); // after click the button, it is deactivated
		pnInput.add(btnCancel); 
		
		pnList = new JPanel();
		frame.getContentPane().add(pnList, BorderLayout.CENTER);
		pnList.setLayout(new BorderLayout(0, 0));
		
		outputTextArea = new JTextArea();
		scrollPane = new JScrollPane(outputTextArea); // add textArea to scroll pane
		pnList.add(scrollPane, BorderLayout.CENTER);
		
		pnStatus = new JPanel();
		frame.getContentPane().add(pnStatus, BorderLayout.SOUTH);
		pnStatus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		progressBar = new JProgressBar();
		pnStatus.add(progressBar);
		
		lblStatus = new JLabel("Status");
		pnStatus.add(lblStatus);
	}

	// inner class can access all fields of the outer class
	class CalculateRandom implements Runnable
	{
		int num;
		public CalculateRandom(int n)
		{
			num = n;
		}
		
		@Override
		public void run() 
		{
			btnRun.setEnabled(false); // after click the button, it is deactivated
			btnCancel.setEnabled(true); // after click the button, it is activated
			
			try 
			{
				for(int i = 0; i < num; i++)
				{
					Random randNum = new Random();
					double number = randNum.nextDouble();
					Thread.sleep(300);
					
					// append is method to append content into component
					outputTextArea.append(String.format("%d.Random number=%f\n", i+1, number)); 
					progressBar.setValue((i+1)*100/num);
					lblStatus.setText(String.format("Finish %d work(s).", (i+1)));
				}
				btnRun.setEnabled(true); // after finished the job, it is activated
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}