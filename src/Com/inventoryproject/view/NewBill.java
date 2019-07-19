package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import Com.inventoryproject.db.Database;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblBillNo;
	private JLabel lblCustomerName;
	private JLabel lblName;
	private JLabel lblMrp;
	private JLabel lblQuantity;
	private JComboBox cmbproductid;
	private JLabel lblProductId;
	private JLabel lblDiscount;
	private JTextField txtbillno;
	private JTextField txtcustname;
	private JTextField txtmrp;
	private JTextField txtname;
	private JTextField txtdiscount;
	private JTextField txtquantity;
	private JPanel panel;
	private JLabel lblNewBill;
	private JButton btnX;
	private JButton button;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblDate;
	private JDateChooser dateChooserdate;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnPrint;
	private JLabel lblTotal;
	private JTextField txttotal;
	private JButton btnLoadBillData;

	/**
	 * Launch the application.
	 */
	
		Connection con = null;
		PreparedStatement ps = null;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill frame = new NewBill();
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
	public NewBill() throws SQLException {
		
		
		con = Database.getdbcon();
		
//		getSum();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBillNo());
		contentPane.add(getLblCustomerName());
		contentPane.add(getLblName());
		contentPane.add(getLblMrp());
		contentPane.add(getLblQuantity());
		contentPane.add(getCmbproductid());
		contentPane.add(getLblProductId());
		contentPane.add(getLblDiscount());
		contentPane.add(getTxtbillno());
		contentPane.add(getTxtcustname());
		contentPane.add(getTxtmrp());
		contentPane.add(getTxtname());
		contentPane.add(getTxtdiscount());
		contentPane.add(getTxtquantity());
		contentPane.add(getPanel());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnRemove());
		contentPane.add(getLblDate());
		contentPane.add(getDateChooserdate());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnPrint());
		contentPane.add(getLblTotal());
		contentPane.add(getTxttotal());
		contentPane.add(getBtnLoadBillData());
	}
	
	
//	public void getSum() {
//	int sum = 0;
//	for (int i = 0; i<table.getRowCount();i++) {
//		sum = sum +Integer.parseInt(table.getValueAt(i, 2).toString());
//		
//		
//	}
//	txttotal.setText(Integer.toString(sum));
//	
//	}

	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill NO");
			lblBillNo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblBillNo.setBounds(23, 64, 58, 14);
		}
		return lblBillNo;
	}
	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer Name");
			lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCustomerName.setBounds(10, 113, 100, 14);
		}
		return lblCustomerName;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblName.setBounds(33, 189, 48, 14);
		}
		return lblName;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("Mrp");
			lblMrp.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblMrp.setBounds(23, 233, 48, 14);
		}
		return lblMrp;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity");
			lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblQuantity.setBounds(23, 276, 70, 14);
		}
		return lblQuantity;
	}
	private JComboBox getCmbproductid() {
		if (cmbproductid == null) {
			cmbproductid = new JComboBox();
			cmbproductid.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103", "104", "105", "106"}));
			cmbproductid.setBounds(133, 146, 96, 22);
		}
		return cmbproductid;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id");
			lblProductId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblProductId.setBounds(23, 150, 70, 14);
		}
		return lblProductId;
	}
	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount");
			lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDiscount.setBounds(23, 322, 70, 14);
		}
		return lblDiscount;
	}
	private JTextField getTxtbillno() {
		if (txtbillno == null) {
			txtbillno = new JTextField();
			txtbillno.setBounds(133, 61, 96, 20);
			txtbillno.setColumns(10);
		}
		return txtbillno;
	}
	private JTextField getTxtcustname() {
		if (txtcustname == null) {
			txtcustname = new JTextField();
			txtcustname.setColumns(10);
			txtcustname.setBounds(133, 110, 96, 20);
		}
		return txtcustname;
	}
	private JTextField getTxtmrp() {
		if (txtmrp == null) {
			txtmrp = new JTextField();
			txtmrp.setColumns(10);
			txtmrp.setBounds(133, 227, 96, 20);
		}
		return txtmrp;
	}
	private JTextField getTxtname() {
		if (txtname == null) {
			txtname = new JTextField();
			txtname.setColumns(10);
			txtname.setBounds(133, 186, 96, 20);
		}
		return txtname;
	}
	private JTextField getTxtdiscount() {
		if (txtdiscount == null) {
			txtdiscount = new JTextField();
			txtdiscount.setColumns(10);
			txtdiscount.setBounds(133, 316, 96, 20);
		}
		return txtdiscount;
	}
	private JTextField getTxtquantity() {
		if (txtquantity == null) {
			txtquantity = new JTextField();
			txtquantity.setColumns(10);
			txtquantity.setBounds(133, 267, 96, 20);
		}
		return txtquantity;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(204, 204, 204));
			panel.setBounds(0, 0, 602, 33);
			panel.setLayout(null);
			panel.add(getLblNewBill());
			panel.add(getBtnX());
			panel.add(getButton());
		}
		return panel;
	}
	private JLabel getLblNewBill() {
		if (lblNewBill == null) {
			lblNewBill = new JLabel("New Bill");
			lblNewBill.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewBill.setBounds(278, 5, 101, 14);
		}
		return lblNewBill;
	}
	private JButton getBtnX() {
		if (btnX == null) {
			btnX = new JButton("X");
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnX.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnX.setBackground(new Color(204, 0, 0));
			btnX.setBounds(547, 1, 55, 23);
		}
		return btnX;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("-");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			button.setFont(new Font("Tahoma", Font.BOLD, 20));
			button.setBackground(new Color(255, 204, 0));
			button.setBounds(474, 1, 55, 23);
		}
		return button;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\add (2).png"));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(txtquantity.equals("") )
						 {
						JOptionPane.showMessageDialog(null, "Quantity is empty");
					}
					
					else if( txtname.equals("")) {
						JOptionPane.showMessageDialog(null, "Name is empty");
					}
					else if(txtmrp.equals("")) {
						JOptionPane.showMessageDialog(null, "MRP is empty");
					}
					
					else if(txtdiscount.equals(" ") ) {
						JOptionPane.showMessageDialog(null, "Discount is empty");
					}
					
					   
					
//					else {
					String sql = "INSERT INTO `newbill`(`Billno`, `Custname`, `Productid`, `Name`, `Mrp`, `Quantity`, `Discount`, `Date`) VALUES (?,?,?,?,?,?,?,?)";
					
					try {
						ps = con.prepareStatement(sql);
						ps.setString(1, txtbillno.getText());
						ps.setString(2, txtcustname.getText());
						ps.setString(3, cmbproductid.getSelectedItem().toString());
						ps.setString(4, txtname.getText());
						ps.setString(5, txtmrp.getText());
						ps.setString(6, txtquantity.getText());
						ps.setString(7, txtdiscount.getText());
						
						
						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						String date2 = date.format(dateChooserdate.getDate());
						ps.setString(8, date2);
						
						if(ps.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null,"Data Inserted");
							
							//clear the text field after inserted data
							txtbillno.setText(null);
							txtcustname.setText(null);
							cmbproductid.setSelectedItem(null);
							txtname.setText(null);
							txtmrp.setText(null);
							txtquantity.setText(null);
							txtdiscount.setText(null);
							dateChooserdate.setDate(null);
						
							
						}
						
						
					
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
//					}
				}
			});
			btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAdd.setBounds(23, 376, 84, 23);
		}
		return btnAdd;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int opt = JOptionPane.showConfirmDialog(null, "Are you want to delete data");
					
					if(opt == 0) {
					
						String sql = "DELETE FROM `newbill` WHERE Billno = '"+txtbillno.getText() + "'";
					//on the basis of billno delete the data from table
					try {
						ps = con.prepareStatement(sql);
						ps.setString(1, txtbillno.getText().toString());
						
						ps.execute();
						JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1);
					}
					
					}
					
				
				}
			});
			btnRemove.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\delete (2).png"));
			btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnRemove.setBounds(130, 376, 112, 23);
		}
		return btnRemove;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDate.setBounds(280, 64, 48, 14);
		}
		return lblDate;
	}
	private JDateChooser getDateChooserdate() {
		if (dateChooserdate == null) {
			dateChooserdate = new JDateChooser();
			dateChooserdate.setBounds(318, 61, 119, 20);
		}
		return dateChooserdate;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(259, 113, 343, 246);
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
					"Quantity", "Name", "Mrp", "Discount"
				}
			));
		}
		return table;
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						table.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnPrint.setBounds(384, 405, 100, 23);
		}
		return btnPrint;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					int sum = 0;
					for (int i = 0; i<table.getRowCount();i++) {
						sum = sum +Integer.parseInt(table.getValueAt(i, 2).toString());
						
						
					}
					txttotal.setText(Integer.toString(sum));
							
//					int mrp = Integer.parseInt(txtmrp.getText());
//					int qunty= Integer.parseInt(txtquantity.getText());
//					int total =  mrp * qunty;
//					
//					txttotal.setText(String.valueOf(total));
					
				
					
					
					
					
					
					
				}
			});
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTotal.setBounds(338, 380, 58, 14);
		}
		return lblTotal;
	}
	private JTextField getTxttotal() {
		if (txttotal == null) {
			txttotal = new JTextField();
//			txttotal.addActionListener(new ActionListener() {
//				
//				
//				
//				
//				public void actionPerformed(ActionEvent e) {
					
//					
//					int sum = 0;
//					for (int i = 0; i<table.getRowCount();i++) {
//						sum = sum +Integer.parseInt(table.getValueAt(i, 2).toString());
//						
//						
//					}
//					txttotal.setText(Integer.toString(sum));
							
//					int mrp = Integer.parseInt(txtmrp.getText());
//					int qunty= Integer.parseInt(txtquantity.getText());
//					int total =  mrp * qunty;
//					
//					txttotal.setText(String.valueOf(total));
//					
//				}
//			
//			});
			
			
			
			
			txttotal.setBounds(408, 377, 96, 20);
			txttotal.setColumns(10);
		}
		return txttotal;
	}
	private JButton getBtnLoadBillData() {
		if (btnLoadBillData == null) {
			btnLoadBillData = new JButton("Load Bill Data");
			btnLoadBillData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					String sql = "SELECT Quantity,Name,Mrp,Discount FROM newbill  ";
					try {
						ps = con.prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
				}
			});
			btnLoadBillData.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnLoadBillData.setBounds(453, 60, 142, 23);
		}
		return btnLoadBillData;
	}
}
