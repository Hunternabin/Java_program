package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class QuickBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnAdd;
	private JButton btnCashierLogin;
	private JLabel lblQuckBill;
	private JLabel lblBill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuickBill frame = new QuickBill();
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
	public QuickBill() {
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnCashierLogin());
		contentPane.add(getLblQuckBill());
		contentPane.add(getLblBill());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome To SuperMarket BIlling System");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(90, 11, 433, 26);
		}
		return lblNewLabel;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Admin Login");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Loginform2 lgf;
					try {
						lgf = new Loginform2();
						lgf.setVisible(true);
//						setVisible(false);
//						lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
//						setState(JFrame.ICONIFIED);
//						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
					
					
//				RegisterForm rgf = new RegisterForm();
//				rgf.setVisible(true);
					
				}
			});
			btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAdd.setBackground(new Color(204, 204, 204));
			btnAdd.setBounds(351, 90, 112, 23);
		}
		return btnAdd;
	}
	private JButton getBtnCashierLogin() {
		if (btnCashierLogin == null) {
			btnCashierLogin = new JButton("Cashier Login");
			btnCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					/*
					 * AddCashierDetails addcashier = new AddCashierDetails();
					 * addcashier.setVisible(true); setVisible(false);
					 */
					
					try {
						new ClientLoginForm().setVisible(true);
						setVisible(false);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});
			btnCashierLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCashierLogin.setBackground(new Color(204, 204, 204));
			btnCashierLogin.setBounds(344, 140, 119, 23);
		}
		return btnCashierLogin;
	}
	private JLabel getLblQuckBill() {
		if (lblQuckBill == null) {
			lblQuckBill = new JLabel("Quick Bill");
			lblQuckBill.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
			lblQuckBill.setBounds(102, 162, 119, 31);
		}
		return lblQuckBill;
	}
	private JLabel getLblBill() {
		if (lblBill == null) {
			lblBill = new JLabel("");
			lblBill.setBounds(77, 48, 161, 103);
			lblBill.setIcon( new ImageIcon(new ImageIcon("E:\\java_ws\\InventoryProject\\quick_bill.png").getImage().getScaledInstance(lblBill.getWidth(),lblBill.getHeight() ,Image.SCALE_DEFAULT)));
			lblBill.setBorder(new LineBorder(new Color(204, 204, 204), 2));
			
			
			
		}
		return lblBill;
	}
}
