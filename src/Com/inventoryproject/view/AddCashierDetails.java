package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AddCashierDetails extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCashier;
	private JLabel lblTransaction;
	private JLabel lblStock;
	private JLabel lblSales;
	private JLabel lblExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashierDetails frame = new AddCashierDetails();
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
	public AddCashierDetails() {
		setTitle("Quick BIll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(240, 230, 140));
			panel.setBounds(0, 0, 913, 61);
			panel.setLayout(null);
			panel.add(getLblCashier());
			panel.add(getLblTransaction());
			panel.add(getLblStock());
			panel.add(getLblSales());
			panel.add(getLblExit());
		}
		return panel;
	}
	private JLabel getLblCashier() {
		if (lblCashier == null) {
			lblCashier = new JLabel("Cashier");
			lblCashier.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					try {
						AddCashier ac = new AddCashier();
						ac.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
				}
			});
			lblCashier.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\cashier.png"));
			lblCashier.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCashier.setBounds(24, 11, 110, 42);
		}
		return lblCashier;
	}
	private JLabel getLblTransaction() {
		if (lblTransaction == null) {
			lblTransaction = new JLabel("Transaction");
			lblTransaction.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\computer.png"));
			lblTransaction.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTransaction.setBounds(144, 11, 127, 39);
		}
		return lblTransaction;
	}
	private JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock");
			lblStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					Update_Stoke update;
					try {
						update = new Update_Stoke();
						update.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
							
					
					
				}
			});
			lblStock.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\dollar.png"));
			lblStock.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblStock.setBounds(304, 22, 80, 28);
		}
		return lblStock;
	}
	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("sales");
			lblSales.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\sales.png"));
			lblSales.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSales.setBounds(415, 29, 62, 21);
		}
		return lblSales;
	}
	private JLabel getLblExit() {
		if (lblExit == null) {
			lblExit = new JLabel("Exit");
			lblExit.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\delete (2).png"));
			lblExit.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblExit.setBounds(841, 36, 72, 14);
		}
		return lblExit;
	}
}
