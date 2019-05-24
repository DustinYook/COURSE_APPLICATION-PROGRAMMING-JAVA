package class11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditItemDialog extends JDialog 
{
	private final JPanel contentPanel = new JPanel();
	private JLabel lblName;
	private JTextField txtName;
	private JTextField txtDept;
	private JTextField txtGPA;
	
	String editStudent = null;

	// 따로 동작하길 원하지 않으므로 지움
//	public static void main(String[] args) {
//		try {
//			AddItemDialog dialog = new AddItemDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/** Create the dialog */
	public EditItemDialog(JFrame frame, String studentElement) // 2번째 파라미터 추가
	{
		// VERY IMPORTANT!
		super(frame, true); // this dialog belongs to STudentListGUI frame
		// we can't make any operation in frame without closing dialog
				
		setBounds(100, 100, 341, 305);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.lblName = new JLabel("Name :");
		this.lblName.setFont(new Font("굴림", Font.BOLD, 14));
		this.lblName.setBounds(55, 61, 50, 15);
		contentPanel.add(this.lblName);
		
		this.txtName = new JTextField();
		this.txtName.setBounds(134, 58, 128, 18);
		contentPanel.add(this.txtName);
		this.txtName.setColumns(10);
		{
			JLabel lblDepartment = new JLabel("Department : ");
			lblDepartment.setFont(new Font("굴림", Font.BOLD, 14));
			lblDepartment.setBounds(55, 102, 93, 15);
			contentPanel.add(lblDepartment);
		}
		{
			this.txtDept = new JTextField();
			this.txtDept.setBounds(182, 99, 96, 21);
			contentPanel.add(this.txtDept);
			this.txtDept.setColumns(10);
		}
		{
			JLabel lblGpa = new JLabel("GPA :");
			lblGpa.setFont(new Font("굴림", Font.BOLD, 14));
			lblGpa.setBounds(55, 162, 50, 15);
			contentPanel.add(lblGpa);
		}
		{
			this.txtGPA = new JTextField();
			this.txtGPA.setBounds(169, 156, 96, 21);
			contentPanel.add(this.txtGPA);
			this.txtGPA.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Edit");
				okButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						editStudent = txtName.getText() + " " + txtDept.getText() + " " + txtGPA.getText();
						System.out.println(editStudent);
						setVisible(false); // close dialog
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						editStudent = null; // should not do any actions
						clearAndHide();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		String[] split = studentElement.split("\\s+");
		txtName.setText(split[0]);
		txtDept.setText(split[1]);
		txtGPA.setText(split[2]);
	}
	
	public String geteditStudent()
	{
		return editStudent;
	}
	
	public void clearAndHide()
	{
		txtName.setText("");
		txtDept.setText("");
		txtGPA.setText("");
		
		setVisible(false);
	}
}
