/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment06
 * MainGUI.java : This class defines the whole prime number counter GUI
 * Reporting Date : 2019-05-21
 */

package homework06;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Component;
import java.awt.SystemColor;

public class MainGUI 
{
	private JFrame frmFindPrimeNumbers;
	private JPanel controlPanel;
	private JLabel lblFind;
	private JTextField startTxtField;
	private JLabel lblTo;
	private JTextField endTxtField;
	private JButton btnStart;
	private JButton btnStop;
	private JScrollPane resultPanel;
	private JTextArea resultTxtArea;
	private JPanel ProgressPanel;
	private JProgressBar progressBar;
	private JLabel progressLbl;
	private JLabel label;
	
	private FindPrimeNumber thread; // reference for SwingWorker

	/** Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainGUI window = new MainGUI();
					window.frmFindPrimeNumbers.setVisible(true);
				} catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/** Create the application */
	public MainGUI() { initialize(); }

	/** Initialize the contents of the frame */
	private void initialize() 
	{
		this.frmFindPrimeNumbers = new JFrame();
		this.frmFindPrimeNumbers.setResizable(false);
		this.frmFindPrimeNumbers.setTitle("Find Prime Numbers");
		this.frmFindPrimeNumbers.setBounds(100, 100, 500, 350);
		this.frmFindPrimeNumbers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.controlPanel = new JPanel();
		this.frmFindPrimeNumbers.getContentPane().add(this.controlPanel, BorderLayout.NORTH);
		this.controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.lblFind = new JLabel("Find prime from ");
		this.lblFind.setFont(new Font("Arial Black", Font.PLAIN, 12));
		this.controlPanel.add(this.lblFind);
		
		this.startTxtField = new JTextField();
		this.startTxtField.setToolTipText("enter the start number");
		this.startTxtField.setFont(new Font("굴림", Font.BOLD, 12));
		this.controlPanel.add(this.startTxtField);
		this.startTxtField.setColumns(8);
		
		this.lblTo = new JLabel(" to ");
		this.lblTo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		this.controlPanel.add(this.lblTo);
		
		this.endTxtField = new JTextField();
		this.endTxtField.setToolTipText("enter the end number");
		this.endTxtField.setFont(new Font("굴림", Font.BOLD, 12));
		this.controlPanel.add(this.endTxtField);
		this.endTxtField.setColumns(8);
		
		this.btnStart = new JButton("Start");
		this.btnStart.setFont(new Font("Arial Black", Font.PLAIN, 10));
		this.btnStart.setAlignmentX(0.5f);
		this.btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				resultTxtArea.setText(""); // clear text area which shows result
				
				// exception handling process before starting background thread
				try
				{
					int startNum = Integer.parseInt(startTxtField.getText()); // range start
					int endNum = Integer.parseInt(endTxtField.getText()); // range end
					
					// exception checking process
					if (startNum > endNum) 
						throw new IllegalRangeException();
					else if (startNum > 99999999 || endNum > 99999999) 
						throw new NumberOutOfBoundException();
					else if (startNum < 0 || endNum < 0) 
						throw new NumberTooSmallException();
					
					// if input has legal value and no exceptions, then create thread
					thread = new FindPrimeNumber(startNum, endNum); // create thread instance
					thread.execute(); // background thread starts
					
					// set start button disabled, so prevent user to click again
					btnStart.setEnabled(false); 
					btnStop.setEnabled(true);
				}
				catch(IllegalRangeException rangeEx)
				{
					JOptionPane.showMessageDialog(null, rangeEx.getMessage(), "Illegal Range Exception", JOptionPane.ERROR_MESSAGE);
					startTxtField.setText("");
					endTxtField.setText("");
				}
				catch(NumberOutOfBoundException outOfEx)
				{
					JOptionPane.showMessageDialog(null, outOfEx.getMessage(), "Number Out Of Bound Exception", JOptionPane.ERROR_MESSAGE);
					startTxtField.setText("");
					endTxtField.setText("");
				}
				catch(NumberTooSmallException tooSmallEx)
				{
					JOptionPane.showMessageDialog(null, tooSmallEx.getMessage(), "Number Too Small Exception", JOptionPane.ERROR_MESSAGE);
					startTxtField.setText("");
					endTxtField.setText("");
				}
				catch (NumberFormatException formatException) 
				{
					JOptionPane.showMessageDialog(null, "Please enter only integer values", "Number Format Exception", JOptionPane.ERROR_MESSAGE);
					startTxtField.setText("");
					endTxtField.setText("");
				}
			}
		});
		
		this.label = new JLabel("  ");
		this.controlPanel.add(this.label);
		this.controlPanel.add(this.btnStart);
		
		this.btnStop = new JButton("Stop");
		this.btnStop.setFont(new Font("Arial Black", Font.PLAIN, 10));
		this.btnStop.setEnabled(false);
		this.btnStop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				thread.cancel(true); // cancel execution of thread
				JOptionPane.showMessageDialog(null, "The background thread is stopped", "Stop Notice", JOptionPane.INFORMATION_MESSAGE);
					
				btnStart.setEnabled(true); // enable start button again, so enable user start another thread
				btnStop.setEnabled(false); // disable stop button, so prevent user to keep clicking stop button
			}
		});
		this.controlPanel.add(this.btnStop);
		
		this.resultPanel = new JScrollPane();
		this.resultPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
		this.frmFindPrimeNumbers.getContentPane().add(this.resultPanel, BorderLayout.CENTER);
		
		this.resultTxtArea = new JTextArea();
		this.resultTxtArea.setEditable(false);
		this.resultTxtArea.setFont(new Font("Arial Black", Font.BOLD, 12));
		this.resultPanel.setViewportView(this.resultTxtArea);
		
		this.ProgressPanel = new JPanel();
		this.ProgressPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.frmFindPrimeNumbers.getContentPane().add(this.ProgressPanel, BorderLayout.SOUTH);
		this.ProgressPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.progressBar = new JProgressBar();
		this.progressBar.setForeground(SystemColor.activeCaption);
		this.progressBar.setPreferredSize(new Dimension(400, 20));
		this.ProgressPanel.add(this.progressBar);
		
		this.progressLbl = new JLabel("0%");
		this.progressLbl.setPreferredSize(new Dimension(50, 20));
		this.progressLbl.setBorder(new EmptyBorder(0, 5, 0, 0));
		this.progressLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.progressLbl.setFont(new Font("Arial Black", Font.BOLD, 12));
		this.ProgressPanel.add(this.progressLbl);
	}
	
	/** Nested-class which find out prime numbers */
	public class FindPrimeNumber extends SwingWorker<Void, Integer>
	{
		private int startNum;
		private int endNum;
		private int primeCnt;
		
		/* Constructor */
		public FindPrimeNumber(int startNum, int endNum) 
		{
			this.startNum = startNum;  
			this.endNum = endNum;
			this.primeCnt = 0;
		}
	
		@Override
		protected Void doInBackground() throws Exception 
		{
			ArrayList<Boolean> primeList = new ArrayList<Boolean>(endNum + 1); // List for checking prime numbers
			
			primeList.add(false); // for 0
			primeList.add(false); // for 1
			
			// Let number between 2 and endNum as prime number
			for(int i = 2; i <= endNum; i++)
				primeList.add(i, true);

			// Using Sieve of Eratosthenes to filter out the number which is not a prime number
			for(int i = 2; i <= Math.sqrt(endNum); i++)
			{
				// 2 -> 3 -> 5 -> 7 -> ...
				if(primeList.get(i)) // only the number whose value is "true" (which means prime number)
				{
					for(int j = i * i; j <= endNum; j += i) // filter out
						primeList.set(j, false);
				}
			}

			// Print out found prime numbers to the text area
			for (int i = startNum; i <= endNum; i++) 
			{
				if (primeList.get(i)) // process only number which has "true" value
				{
					resultTxtArea.append(Integer.toString(i) + "\n"); // append to the text area
					Thread.sleep(300); // sleep for 300ms for each iteration
					primeCnt++; // increase the counter for prime number
				}
				progressBar.setValue(100 * (i - startNum + 1) / (endNum - startNum + 1)); // for updating progress bar
				progressLbl.setText(String.format("%d %%", 100 * (i - startNum + 1) / (endNum - startNum + 1))); // for updating progress label
			}

			// Pop up dialog box to alert user that the prime number finding process is done
			if(this.primeCnt == 0 || this.primeCnt == 1) // singular form
				JOptionPane.showMessageDialog(null, String.format("Found %d prime number", this.primeCnt), "Process is over", JOptionPane.INFORMATION_MESSAGE);
			else // plural form
				JOptionPane.showMessageDialog(null, String.format("Found %d prime numbers", this.primeCnt), "Process is over", JOptionPane.INFORMATION_MESSAGE);
			
			// After finishing, set up each components in default status
			btnStart.setEnabled(true);
			btnStop.setEnabled(false);
			
			return null;
		}
	}
}