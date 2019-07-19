package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;


import Com.inventoryproject.db.Database;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterForm extends JFrame {
	
	Connection con = null;
	PreparedStatement ps =null;

	private JPanel RegisterForm;
	private JPanel panel;
	private JLabel lblRegister;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel textareaaddress;
	private JButton btncancel;
	private JButton btnRegister;
	private JLabel lblFirstName;
	private JTextField txtfirstname;
	private JLabel lblLastName;
	private JTextField txtlastname;
	private JLabel label_4;
	private JTextField txtusername;
	private JLabel lblPassword;
	private JPasswordField password;
	private JLabel lblAddress;
	private JTextField txtaddress;
	private JDateChooser dateChooserdob;
	private JLabel lblBdate;
	private JLabel lblClickHereTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterForm() {
		setUndecorated(true);
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 502);
		RegisterForm = new JPanel();
		RegisterForm.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(RegisterForm);
		RegisterForm.setLayout(null);
		RegisterForm.add(getPanel());
		RegisterForm.add(getTextareaaddress());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(255, 204, 0));
			panel.setBounds(0, 0, 569, 42);
			panel.add(getLblRegister());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
		}
		return panel;
	}
	private JLabel getLblRegister() {
		if (lblRegister == null) {
			lblRegister = new JLabel("Register");
			lblRegister.setForeground(Color.WHITE);
			lblRegister.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblRegister.setBounds(107, 0, 146, 31);
		}
		return lblRegister;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("X");
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_1.setBounds(520, 1, 33, 31);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("-");
			label_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					//this.setState(JFrame.ICONIFIED);
				}
			});
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Tahoma", Font.BOLD, 30));
			label_2.setBounds(490, 0, 20, 31);
		}
		return label_2;
	}
	private JPanel getTextareaaddress() {
		if (textareaaddress == null) {
			textareaaddress = new JPanel();
			textareaaddress.setLayout(null);
			textareaaddress.setBackground(Color.DARK_GRAY);
			textareaaddress.setBounds(0, 42, 569, 460);
			textareaaddress.add(getBtncancel());
			textareaaddress.add(getBtnRegister());
			textareaaddress.add(getLblFirstName());
			textareaaddress.add(getTxtfirstname());
			textareaaddress.add(getLblLastName());
			textareaaddress.add(getTxtlastname());
			textareaaddress.add(getLabel_4_1());
			textareaaddress.add(getTxtusername());
			textareaaddress.add(getLabel_3_2());
			textareaaddress.add(getPasswordField_1());
			textareaaddress.add(getLblAddress());
			textareaaddress.add(getTxtaddress());
			textareaaddress.add(getDateChooserdob());
			textareaaddress.add(getLblBdate());
			textareaaddress.add(getLblClickHereTo());
		}
		return textareaaddress;
	}
	private JButton getBtncancel() {
		if (btncancel == null) {
			btncancel = new JButton("Cancel");
			btncancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					System.exit(0);
				}
			});
			btncancel.setFont(new Font("Tahoma", Font.BOLD, 12));
			btncancel.setBackground(new Color(255, 0, 51));
			btncancel.setBounds(111, 373, 84, 23);
		}
		return btncancel;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					String fname = txtfirstname.getText();
					String lname = txtlastname.getText();
					String uname = txtusername.getText();
					String pass  = String.valueOf(password.getPassword());
					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
					String bdate = dateformat.format(dateChooserdob.getDate());
					
					String address = txtaddress.getText();	
					
					if(txtusername.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Username is empty");
					}
					else if(password.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Password is empty");
					}
					
					else {
					String sql = "INSERT INTO `register`( `firstname`, `lastname`, `username`, `password`, `date`, `address`) VALUES (?,?,?,?,?,?)";
					try {
						ps = Database.getdbcon().prepareStatement(sql);
						ps.setString(1, fname);
						ps.setString(2, lname);
						ps.setString(3, uname);
						ps.setString(4, pass);
						ps.setString(5, bdate);
						ps.setString(6, address);
						
						if(ps.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null, "USER ADDED");
							
							
							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
				
//					try {
//						ps = con.prepareStatement(sql);
//						 ps.setString(1, txtfirstname.getText());
//						 ps.setString(2, txtlastname.getText());
//						 ps.setString(3, txtusername.getText());
//						 ps.setString(4, password.getText());
//						 ps.setString(5, gender.getSelectedItem().toString());
//						 ps.setString(6, txtaddress.getText());
//						 
//						 ps.executeUpdate();
//						 JOptionPane.showMessageDialog(null, "REGISTER SUCCESSFULLY");
//						 
//						
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e1);
//					}
//					
					
					
					
			
					
				}
			});
			btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnRegister.setBackground(Color.CYAN);
			btnRegister.setBounds(205, 373, 95, 23);
		}
		return btnRegister;
	}
	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name :");
			lblFirstName.setForeground(Color.WHITE);
			lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblFirstName.setBackground(Color.RED);
			lblFirstName.setBounds(40, 47, 73, 21);
		}
		return lblFirstName;
	}
	private JTextField getTxtfirstname() {
		if (txtfirstname == null) {
			txtfirstname = new JTextField();
			txtfirstname.setForeground(Color.WHITE);
			txtfirstname.setColumns(10);
			txtfirstname.setBackground(Color.GRAY);
			txtfirstname.setBounds(140, 47, 148, 20);
		}
		return txtfirstname;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name :");
			lblLastName.setForeground(Color.WHITE);
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLastName.setBackground(Color.RED);
			lblLastName.setBounds(40, 94, 73, 21);
		}
		return lblLastName;
	}
	private JTextField getTxtlastname() {
		if (txtlastname == null) {
			txtlastname = new JTextField();
			txtlastname.setForeground(Color.WHITE);
			txtlastname.setColumns(10);
			txtlastname.setBackground(Color.GRAY);
			txtlastname.setBounds(140, 94, 148, 20);
		}
		return txtlastname;
	}
	private JLabel getLabel_4_1() {
		if (label_4 == null) {
			label_4 = new JLabel("User Name :");
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			label_4.setBackground(Color.RED);
			label_4.setBounds(40, 140, 73, 21);
		}
		return label_4;
	}
	private JTextField getTxtusername() {
		if (txtusername == null) {
			txtusername = new JTextField();
			txtusername.setForeground(Color.WHITE);
			txtusername.setColumns(10);
			txtusername.setBackground(Color.GRAY);
			txtusername.setBounds(140, 140, 148, 20);
		}
		return txtusername;
	}
	private JLabel getLabel_3_2() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password :");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPassword.setBackground(Color.WHITE);
			lblPassword.setBounds(40, 196, 73, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField_1() {
		if (password == null) {
			password = new JPasswordField();
			password.setForeground(Color.WHITE);
			password.setBackground(Color.GRAY);
			password.setBounds(140, 193, 148, 20);
		}
		return password;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setForeground(Color.WHITE);
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAddress.setBackground(Color.WHITE);
			lblAddress.setBounds(40, 327, 73, 14);
		}
		return lblAddress;
	}
	private JTextField getTxtaddress() {
		if (txtaddress == null) {
			txtaddress = new JTextField();
			txtaddress.setForeground(Color.WHITE);
			txtaddress.setColumns(10);
			txtaddress.setBackground(Color.GRAY);
			txtaddress.setBounds(131, 307, 202, 55);
		}
		return txtaddress;
	}
	private JDateChooser getDateChooserdob() {
		if (dateChooserdob == null) {
			dateChooserdob = new JDateChooser();
			dateChooserdob.getCalendarButton().setBounds(127, 0, 21, 20);
			dateChooserdob.setBackground(Color.WHITE);
			dateChooserdob.setBounds(140, 236, 148, 20);
			dateChooserdob.setLayout(null);
		}
		return dateChooserdob;
	}
	private JLabel getLblBdate() {
		if (lblBdate == null) {
			lblBdate = new JLabel("Bdate");
			lblBdate.setForeground(Color.WHITE);
			lblBdate.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBdate.setBackground(Color.WHITE);
			lblBdate.setBounds(57, 236, 73, 14);
		}
		return lblBdate;
	}
	private JLabel getLblClickHereTo() {
		if (lblClickHereTo == null) {
			lblClickHereTo = new JLabel("Click Here To Login");
			lblClickHereTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					Loginform2 lgf2;
					try {
						lgf2 = new Loginform2();
						
						lgf2.setVisible(true);
						setVisible(false);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			lblClickHereTo.setForeground(Color.WHITE);
			lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblClickHereTo.setBackground(Color.WHITE);
			lblClickHereTo.setBounds(171, 422, 162, 27);
		}
		return lblClickHereTo;
	}
}
