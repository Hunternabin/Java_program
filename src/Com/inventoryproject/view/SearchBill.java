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
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Com.inventoryproject.db.Database;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class SearchBill extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSearchBill;
	private JLabel lblSearchsBill_1;
	private JLabel lblBillNo;
	private JTextField textbillno;
	private JLabel lblSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnX;
	private JLabel label;
	private JButton btnLoadBillInfo;

	/**
	 * Launch the application.
	 */
	
	Connection con = null;
	PreparedStatement ps = null;
	
			
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
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
	public SearchBill() throws SQLException {
		
		con =Database.getdbcon();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 404);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblSearch());
		contentPane.add(getLblBillNo());
		contentPane.add(getTextbillno());
		contentPane.add(getLblSearch());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnLoadBillInfo());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(153, 204, 204));
			panel.setBounds(0, 0, 481, 29);
			panel.setLayout(null);
			panel.add(getLblSearchBill());
			panel.add(getBtnX());
			panel.add(getLabel());
		}
		return panel;
	}
	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Search Bill");
			lblSearchBill.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblSearchBill.setBounds(150, 11, 163, 14);
		}
		return lblSearchBill;
	}
	private JLabel getLblSearchBill_1() {
		if (lblSearchsBill_1 == null) {
			lblSearchsBill_1= new JLabel("Search BIll");
			lblSearchsBill_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblSearchsBill_1.setBounds(146, 57, 117, 19);
		}
		return lblSearchsBill_1;
	}
	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill No");
			lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblBillNo.setBounds(58, 98, 80, 14);
		}
		return lblBillNo;
	}
	private JTextField getTextbillno() {
		if (textbillno == null) {
			textbillno = new JTextField();
			textbillno.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textbillno.setText("10");
			textbillno.setBounds(156, 95, 96, 20);
			textbillno.setColumns(10);
		}
		return textbillno;
	}
	private JLabel getLblSearch() {
		if (lblSearch == null) {
			lblSearch = new JLabel("Search");
			lblSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					//to search the table data from Billno 
					String sql = "select Billno,Custname,Mrp,Date from newbill where Billno = ?";
					
					try {
						ps = con.prepareStatement(sql);
						
						ps.setString(1, textbillno.getText());
						
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						ps.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
			});
			lblSearch.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\search.png"));
			lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblSearch.setBounds(262, 96, 106, 19);
		}
		return lblSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(204, 204, 255));
			scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
			scrollPane.setBounds(33, 174, 441, 192);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Billno", "CustomerName", "Amount", "Date"
				}
			));
		}
		return table;
	}
	private JButton getBtnX() {
		if (btnX == null) {
			btnX = new JButton("X");
			btnX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			btnX.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnX.setBackground(new Color(255, 0, 51));
			btnX.setBounds(421, 2, 60, 23);
		}
		return btnX;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("-");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			label.setFont(new Font("Tahoma", Font.BOLD, 24));
			label.setForeground(new Color(255, 204, 0));
			label.setBackground(new Color(255, 204, 0));
			label.setBounds(399, 3, 48, 23);
		}
		return label;
	}
	private JButton getBtnLoadBillInfo() {
		if (btnLoadBillInfo == null) {
			btnLoadBillInfo = new JButton("Load Bill Info");
			btnLoadBillInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					String sql = "select Billno, Custname, Mrp,Date from newbill";
					
					try {
						
						ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
					
					
					
					
				}
			});
			btnLoadBillInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			btnLoadBillInfo.setBounds(145, 140, 162, 23);
		}
		return btnLoadBillInfo;
	}
}
