package class10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class StudentInfo 
{
	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnSave;
	private JButton btnSearch;
	private JButton btnClose;
	private JLabel lblId;
	private JTextField txtID;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblGpa;
	private JTextField txtGpa;
	
	StudentDAO[] students = new StudentDAO[10];
	int i = 0; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo window = new StudentInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 442, 211);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel.getLayout();
		flowLayout.setHgap(15);
		this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.frame.getContentPane().add(this.panel, BorderLayout.SOUTH);
		
		this.btnSave = new JButton("Save");
		this.btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				students[i] = new StudentDAO(Integer.parseInt(txtID.getText()), txtName.getText(), Double.parseDouble(txtGpa.getText()));
				try 
				{
					RandomAccessFile out = new RandomAccessFile("students.bin", "rw"); // for reading and writing
					out.seek(out.length()); // pointer shows offset
					students[i].writeData(out);
					out.close();
				} 
				catch (FileNotFoundException e1) { e1.printStackTrace(); } 
				catch (IOException e1) { e1.printStackTrace(); }
				
				i++;
				
				txtID.setText("");
				txtName.setText("");
				txtGpa.setText("");
			}
		});
		this.btnSave.setFont(new Font("굴림", Font.BOLD, 12));
		this.panel.add(this.btnSave);
		
		this.btnSearch = new JButton("Search");
		this.btnSearch.setFont(new Font("굴림", Font.BOLD, 12));
		this.panel.add(this.btnSearch);
		this.btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				StudentDAO newStudent = new StudentDAO();
				int id = Integer.parseInt(txtID.getText());
				
				try
				{
					RandomAccessFile in = new RandomAccessFile("students.bin", "r");
					in.seek((id - 1) * newStudent.OBJECT_SIZE); // 학생 데이터 단위로 읽음
					newStudent.readData(in);
					System.out.printf("%d, %d %.2f", newStudent.getName(), newStudent.getName(), newStudent.getGpa());
					
					txtName.setText(newStudent.getName());
					txtGpa.setText(newStudent.getGpa() + "");
					
					in.close();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		
		this.btnClose = new JButton("Close");
		this.btnClose.setFont(new Font("굴림", Font.BOLD, 12));
		this.panel.add(this.btnClose);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.frame.getContentPane().add(this.panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{148, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.panel_1.setLayout(gbl_panel_1);
		
		this.lblId = new JLabel("ID");
		this.lblId.setFont(new Font("굴림", Font.BOLD, 20));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		this.panel_1.add(this.lblId, gbc_lblId);
		
		this.txtID = new JTextField();
		GridBagConstraints gbc_txtID = new GridBagConstraints();
		gbc_txtID.insets = new Insets(0, 0, 5, 0);
		gbc_txtID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtID.gridx = 1;
		gbc_txtID.gridy = 0;
		this.panel_1.add(this.txtID, gbc_txtID);
		this.txtID.setColumns(10);
		
		this.lblName = new JLabel("Name");
		this.lblName.setFont(new Font("굴림", Font.BOLD, 20));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		this.panel_1.add(this.lblName, gbc_lblName);
		
		this.txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 1;
		this.panel_1.add(this.txtName, gbc_txtName);
		this.txtName.setColumns(10);
		
		this.lblGpa = new JLabel("GPA");
		this.lblGpa.setFont(new Font("굴림", Font.BOLD, 20));
		GridBagConstraints gbc_lblGpa = new GridBagConstraints();
		gbc_lblGpa.anchor = GridBagConstraints.WEST;
		gbc_lblGpa.insets = new Insets(0, 0, 0, 5);
		gbc_lblGpa.gridx = 0;
		gbc_lblGpa.gridy = 2;
		this.panel_1.add(this.lblGpa, gbc_lblGpa);
		
		this.txtGpa = new JTextField();
		GridBagConstraints gbc_txtGpa = new GridBagConstraints();
		gbc_txtGpa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGpa.gridx = 1;
		gbc_txtGpa.gridy = 2;
		this.panel_1.add(this.txtGpa, gbc_txtGpa);
		this.txtGpa.setColumns(10);
	}
}