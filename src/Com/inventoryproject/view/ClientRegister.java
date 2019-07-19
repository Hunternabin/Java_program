package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Com.inventoryproject.db.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientRegister extends JFrame {

	private JPanel contentPane;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblRepass;
	private JTextField textfname;
	private JTextField textlname;
	private JTextField textusername;
	private JPasswordField password;
	private JPasswordField repass;
	private JButton btnRegister;
	private JLabel lblClickHereTo;

	/**
	 * Launch the application.
	 */
	
	Connection con = null;
	PreparedStatement ps = null;
	private JLabel lblClientRegistrationForm;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientRegister frame = new ClientRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ClientRegister() throws SQLException {
		
		con = Database.getdbcon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblFname());
		contentPane.add(getLblLname());
		contentPane.add(getLblPassword());
		contentPane.add(getLblUsername());
		contentPane.add(getLblRepass());
		contentPane.add(getTextfname());
		contentPane.add(getTextlname());
		contentPane.add(getTextusername());
		contentPane.add(getPassword());
		contentPane.add(getRepass());
		contentPane.add(getBtnRegister());
		contentPane.add(getLblClickHereTo());
		contentPane.add(getLblClientRegistrationForm());
	}
	private JLabel getLblFname() {
		if (lblFname == null) {
			lblFname = new JLabel("Fname:");
			lblFname.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFname.setBounds(27, 57, 80, 14);
		}
		return lblFname;
	}
	private JLabel getLblLname() {
		if (lblLname == null) {
			lblLname = new JLabel("Lname:");
			lblLname.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLname.setBounds(27, 105, 80, 14);
		}
		return lblLname;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(27, 201, 80, 14);
		}
		return lblPassword;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsername.setBounds(27, 153, 80, 14);
		}
		return lblUsername;
	}
	private JLabel getLblRepass() {
		if (lblRepass == null) {
			lblRepass = new JLabel("Re-Pass:");
			lblRepass.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblRepass.setBounds(27, 255, 80, 14);
		}
		return lblRepass;
	}
	private JTextField getTextfname() {
		if (textfname == null) {
			textfname = new JTextField();
			textfname.setBounds(137, 54, 145, 20);
			textfname.setColumns(10);
		}
		return textfname;
	}
	private JTextField getTextlname() {
		if (textlname == null) {
			textlname = new JTextField();
			textlname.setColumns(10);
			textlname.setBounds(137, 102, 145, 20);
		}
		return textlname;
	}
	private JTextField getTextusername() {
		if (textusername == null) {
			textusername = new JTextField();
			textusername.setColumns(10);
			textusername.setBounds(137, 150, 145, 20);
		}
		return textusername;
	}
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setBounds(137, 198, 145, 20);
		}
		return password;
	}
	private JPasswordField getRepass() {
		if (repass == null) {
			repass = new JPasswordField();
			repass.setBounds(137, 252, 145, 20);
		}
		return repass;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("REGISTER");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(textusername.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Username field is empty");
					}
					else if( password.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Password field is empty");
					}
//					 
//					else if(! password.getText().equals(repass)) {
//						JOptionPane.showMessageDialog(null, "Password don't match");
//					}
//					
					else {
					String sql = "INSERT INTO `clientregister`( `Firstname`, `Lastname`, `Username`, `Password`) VALUES (?,?,?,?)";
					try {
						
						ps = con.prepareStatement(sql);
						ps.setString(1, textfname.getText());
						ps.setString(2, textlname.getText());
						ps.setString(3, textusername.getText());
						ps.setString(4, password.getText());
//		OR				ps.setString(4, password.getText().toString()); 
//						ps.setString(5, repass.getText());
						
						ps.execute();
						JOptionPane.showMessageDialog(null, "CLINT REGISTERED SUCCESSFULLY");
					
						//clear the text field after inserted
						textfname.setText("");
						textlname.setText("");
						textusername.setText("");
						password.setText("");
						repass.setText("");
						
						
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
					}
				}
			});
			btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnRegister.setBounds(159, 300, 110, 23);
		}
		return btnRegister;
	}
	private JLabel getLblClickHereTo() {
		if (lblClickHereTo == null) {
			lblClickHereTo = new JLabel("Click Here To Login");
			lblClickHereTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					try {
						ClientLoginForm client = new ClientLoginForm();
						client.setVisible(true);
						setVisible( false);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
					
				}
			});
			lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblClickHereTo.setHorizontalAlignment(SwingConstants.CENTER);
			lblClickHereTo.setBounds(120, 358, 162, 14);
		}
		return lblClickHereTo;
	}
	private JLabel getLblClientRegistrationForm() {
		if (lblClientRegistrationForm == null) {
			lblClientRegistrationForm = new JLabel("CLIENT REGISTRATION FORM");
			lblClientRegistrationForm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblClientRegistrationForm.setBounds(95, 11, 213, 20);
		}
		return lblClientRegistrationForm;
	}
}
