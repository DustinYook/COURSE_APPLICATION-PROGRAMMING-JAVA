/** 
 * 12131819 YOOK DONGHYUN
 * Java Application Programming-002 (Prof. Tamer) // Assignment05
 * MyCalculator.java : This is advanced calculator which provides square, square root, reverse and so on.
 * Reporting Date : 2019-05-07
 */

package homework05;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MyCalculator 
{
	/** Member Fields */
	static String expr = "";
	static String operand1 = "";
	static String operand2 = "";
	static String operator = "";

	/* Frame & Components */
	private JFrame frame;
	private JPanel pnShow;
	private JPanel pnKeys;
	private JTextField textOutput;

	/* Number Buttons */
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;

	/* Operator Buttons */
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMult;
	private JButton btnDiv;
	private JButton btnPoint;
	private JButton btnResult;
	private JButton btnMod;
	private JButton btnSqrt;
	private JButton btnSquare;
	private JButton btnReverse;

	/* System Buttons */
	private JButton btnClr;
	private JButton btnDel;

	/** Member Methods */
	/* Launch the application */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MyCalculator window = new MyCalculator();
					window.frame.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/* Create the application */
	public MyCalculator() { initialize(); }

	/* Exception Checking Method */
	public void exceptionCheck() 
	{
		if (operand2.length() > 5) 
		{
			System.out.println("[Exception] The number should be less than 5 digits!");
			operand2 = operand2.substring(0, operand2.length() - 1);
			textOutput.setText(operand2);
		}
	}

	/* Control Operator Buttons as a group */
	public void disableBtn(boolean flag) 
	{
		btnAdd.setEnabled(flag);
		btnSub.setEnabled(flag);
		btnMult.setEnabled(flag);
		btnDiv.setEnabled(flag);
		btnPoint.setEnabled(flag);
		btnMod.setEnabled(flag);
		btnSqrt.setEnabled(flag);
		btnSquare.setEnabled(flag);
		btnReverse.setEnabled(flag);
	}

	/* Initialize the contents of the frame */
	private void initialize() 
	{
		frame = new JFrame("My Calculator");
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(400, 500));
		frame.setBounds(600, 300, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		pnShow = new JPanel();
		frame.getContentPane().add(pnShow, BorderLayout.NORTH);

		textOutput = new JTextField();
		textOutput.setSize(new Dimension(400, 50));
		textOutput.setHorizontalAlignment(SwingConstants.CENTER);
		textOutput.setBackground(Color.WHITE);
		textOutput.setEditable(false);
		textOutput.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		textOutput.setColumns(15);
		pnShow.add(textOutput);

		pnKeys = new JPanel();
		pnKeys.setSize(new Dimension(400, 450));
		frame.getContentPane().add(pnKeys, BorderLayout.CENTER);
		pnKeys.setLayout(new GridLayout(5, 4));

		/** Number Buttons */
		// Number 9
		btn9 = new JButton("9");
		btn9.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "9";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 8
		btn8 = new JButton("8");
		btn8.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "8";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 7
		btn7 = new JButton("7");
		btn7.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "7";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 6
		btn6 = new JButton("6");
		btn6.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "6";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 5
		btn5 = new JButton("5");
		btn5.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "5";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 4
		btn4 = new JButton("4");
		btn4.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "4";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 3
		btn3 = new JButton("3");
		btn3.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "3";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 2
		btn2 = new JButton("2");
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "2";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 1
		btn1 = new JButton("1");
		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "1";
				textOutput.setText(expr + operand2);
			}
		});
		// Number 0
		btn0 = new JButton("0");
		btn0.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btn0.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				exceptionCheck();
				operand2 += "0";
				textOutput.setText(expr + operand2);
			}
		});

		/** Binary Operator Buttons */
		// Add
		btnAdd = new JButton("+");
		btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(false); // prevent click operator button twice
				operand1 = operand2;
				operand2 = "";
				operator = "+";
				expr += operand1 + operator;
				textOutput.setText(expr);
			}
		});
		// Subtract
		btnSub = new JButton("-");
		btnSub.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnSub.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(false); // prevent click operator button twice
				operand1 = operand2;
				operand2 = "";
				operator = "-";
				expr += operand1 + operator;
				textOutput.setText(expr);
			}
		});
		// Multiply
		btnMult = new JButton("×");
		btnMult.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnMult.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(false); // prevent click operator button twice
				operand1 = operand2;
				operand2 = "";
				operator = "×";
				expr += operand1 + operator;
				textOutput.setText(expr);
			}
		});
		// Divide
		btnDiv = new JButton("÷");
		btnDiv.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnDiv.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(false); // prevent click operator button twice
				operand1 = operand2;
				operand2 = "";
				operator = "÷";
				expr += operand1 + operator;
				textOutput.setText(expr);
			}
		});
		// Modular
		btnMod = new JButton("%");
		btnMod.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnMod.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(false); // prevent click operator button twice
				operand1 = operand2;
				operand2 = "";
				operator = "%";
				expr += operand1 + operator;
				textOutput.setText(expr);
			}
		});

		/** Unary Operator Buttons */
		// Square
		btnSquare = new JButton("^2");
		btnSquare.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnSquare.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				operand2 = Double.toString(Math.pow(Double.parseDouble(operand2), 2.0)); // square
				textOutput.setText(operand2);
			}
		});
		// Square Root
		btnSqrt = new JButton("√");
		btnSqrt.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnSqrt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				operand2 = Double.toString(Math.sqrt(Double.parseDouble(operand2))); // square root
				textOutput.setText(operand2);
			}
		});
		// Decimal Point
		btnPoint = new JButton(".");
		btnPoint.setVerticalAlignment(SwingConstants.TOP);
		btnPoint.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnPoint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(false); // prevent click operator button twice
				operand2 += ".";
				textOutput.setText(operand2);
			}
		});
		// Reverse
		btnReverse = new JButton("1/x");
		btnReverse.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnReverse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				operand2 = Double.toString(1 / Double.parseDouble(operand2)); // reverse
				textOutput.setText(operand2);
			}
		});
		
		/** System Buttons */
		// Delete
		btnDel = new JButton("←");
		btnDel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnDel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				operand2 = operand2.substring(0, operand2.length() - 1); // truncate 1 digit
				textOutput.setText(operand2);
			}
		});
		// Clear
		btnClr = new JButton("AC");
		btnClr.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnClr.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(true);
				expr = "";
				operand1 = "";
				operand2 = "";
				operator = "";
				textOutput.setText("");
			}
		});
		// Result
		btnResult = new JButton("=");
		btnResult.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnResult.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				disableBtn(true);
				expr = "";
				if (operator.equals("+"))
					operand2 = Double.toString(Double.parseDouble(operand1) + Double.parseDouble(operand2));
				else if (operator.equals("-"))
					operand2 = Double.toString(Double.parseDouble(operand1) - Double.parseDouble(operand2));
				else if (operator.equals("×"))
					operand2 = Double.toString(Double.parseDouble(operand1) * Double.parseDouble(operand2));
				else if (operator.equals("÷"))
					operand2 = Double.toString(Double.parseDouble(operand1) / Double.parseDouble(operand2));
				else if (operator.equals("%"))
					operand2 = Double.toString(Double.parseDouble(operand1) % Double.parseDouble(operand2));
				textOutput.setText(operand2);
			}
		});
		
		// Append components to container
		pnKeys.add(btnMod);pnKeys.add(btnSqrt);pnKeys.add(btnSquare);pnKeys.add(btnReverse);pnKeys.add(btnResult);
		pnKeys.add(btn7);pnKeys.add(btn8);pnKeys.add(btn9);pnKeys.add(btnDel);pnKeys.add(btnClr);
		pnKeys.add(btn4);pnKeys.add(btn5);pnKeys.add(btn6);pnKeys.add(btnDiv);pnKeys.add(btnMult);
		pnKeys.add(btn1);pnKeys.add(btn2);pnKeys.add(btn3);pnKeys.add(btnAdd);pnKeys.add(btnSub);
		pnKeys.add(btnPoint);pnKeys.add(btn0);
	}
}