package Com.inventoryproject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Com.inventoryproject.db.Database;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {
	
	Connection con = null;
	PreparedStatement ps = null;
	

	private JFrame frmLoginform;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblLoginForm;
	private JLabel lblX;
	private JLabel label;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JPasswordField password;
	private JButton btnCancel;
	private JButton btnLogin;
	private JLabel lablecreate;
	private JTextField username2;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmLoginform.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginform = new JFrame();
		frmLoginform.setUndecorated(true);
		frmLoginform.setTitle("LoginForm");
		frmLoginform.setBounds(100, 100, 450, 300);
		frmLoginform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginform.getContentPane().setLayout(null);
		frmLoginform.getContentPane().add(getPanel());
		frmLoginform.getContentPane().add(getPanel_1());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 204, 0));
			panel.setBounds(0, 0, 450, 42);
			panel.setLayout(null);
			panel.add(getLblLoginForm());
			panel.add(getLblX());
			panel.add(getLabel());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setBounds(0, 41, 450, 259);
			panel_1.setLayout(null);
			panel_1.add(getLblUserName());
			panel_1.add(getLblPassword());
			panel_1.add(getPassword());
			panel_1.add(getBtnCancel());
			panel_1.add(getBtnLogin());
			panel_1.add(getLablecreate());
			panel_1.add(getUsername2());
		}
		return panel_1;
	}
	private JLabel getLblLoginForm() {
		if (lblLoginForm == null) {
			lblLoginForm = new JLabel("Login Form");
			lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblLoginForm.setForeground(Color.WHITE);
			lblLoginForm.setBounds(107, 0, 146, 31);
		}
		return lblLoginForm;
	}
	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("X");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					System.exit(0);//exit garxa frame lai after clicking x
				}
			});
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblX.setBounds(417, 0, 33, 31);
		}
		return lblX;
	}
	
	private JLabel getLabel() {
		
		if (label == null) {
			label = new JLabel("-");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				//this.setState(JFrame.ICONIFIED); //for - minimize jlabel
					
				}
				
			});
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Tahoma", Font.BOLD, 30));
			label.setBounds(394, 0, 20, 31);
		}
		return label;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("User Name :");
			lblUserName.setForeground(Color.WHITE);
			lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUserName.setBackground(Color.RED);
			lblUserName.setBounds(37, 72, 73, 21);
		}
		return lblUserName;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setBackground(Color.WHITE);
			lblPassword.setBounds(37, 131, 73, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setForeground(Color.WHITE);
			password.setBackground(new Color(128, 128, 128));
			password.setBounds(137, 128, 148, 20);
		}
		return password;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCancel.setBackground(new Color(255, 0, 51));
			btnCancel.setBounds(137, 177, 84, 23);
		}
		return btnCancel;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				String uname = username2.getText();
				String pass = String.valueOf(password.getPassword());
				
				String sql = "SELECT * FROM `register` WHERE `username`= ? and `password`=?";
				
				try {
					
					ps = Database.getdbcon().prepareStatement(sql);
					ps.setString(1, uname);
					ps.setString(2, pass);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESS");
						
						QuickBill2 qckb = new QuickBill2();
						qckb.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "LOGIN FAILED");
					
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
					
				}
			});
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnLogin.setBackground(new Color(0, 255, 255));
			btnLogin.setBounds(231, 177, 78, 23);
		}
		return btnLogin;
	}
	private JLabel getLablecreate() {
		if (lablecreate == null) {
			lablecreate = new JLabel("Click here to create new account");
			lablecreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lablecreate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					RegisterForm rg = new RegisterForm();
					rg.setVisible(true);
					
					
//					rg.setSize(500,500);
					
				
//				
//				RegisterForm r = new RegisterForm();
//				r.setVisible(true);
//				
//				r.pack();
//				r.setLocationRelativeTo(null); //register form (next form) lai mid ma dekhauxa
//				r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				r.dispose();
			
					
					
				
				}
			});
			lablecreate.setForeground(Color.WHITE);
			lablecreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lablecreate.setBounds(116, 227, 211, 21);
		}
		return lablecreate;
	}
	private JTextField getUsername2() {
		if (username2 == null) {
			username2 = new JTextField();
			username2.setBackground(Color.GRAY);
			username2.setBounds(135, 72, 148, 20);
			username2.setColumns(10);
		}
		return username2;
	}
}
