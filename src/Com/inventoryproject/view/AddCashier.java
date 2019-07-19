package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Com.inventoryproject.db.Database;
import Com.inventoryproject.model.CashierInfo;
import net.proteanit.sql.DbUtils; //rs2xml.jar file ko class ho DbUtils which is used
// to populate the data in jtbale from database

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class AddCashier extends JFrame {
	
	
	

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblAddCashier;
	private JButton button;
	private JButton button_1;
	private JLabel lblAddCashierDetail;
	private JLabel lblCashierId;
	private JLabel lblCashierName;
	private JLabel lblMobileNumber;
	private JLabel lblAddress;
	private JLabel lblEmailId;
	private JLabel lblPassword;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtmno;
	private JTextField txtemail;
	private JTextField txtaddress;
	private JButton btnAddNew;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;
	
	private JButton btnLoadCashierData;
	
	
	

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	
	Connection con = null;
	PreparedStatement ps = null;
	private JPasswordField txtpassword;

	
	
	public AddCashier() throws SQLException {
		
		con = Database.getdbcon();
		
//		showUser();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblAddCashierDetail());
		contentPane.add(getLblCashierId());
		contentPane.add(getLblCashierName());
		contentPane.add(getLblMobileNumber());
		contentPane.add(getLblAddress());
		contentPane.add(getLblEmailId());
		contentPane.add(getLblPassword());
		contentPane.add(getTxtid());
		contentPane.add(getTxtname());
		contentPane.add(getTxtmno());
		contentPane.add(getTxtemail());
		contentPane.add(getTxtaddress());
		contentPane.add(getBtnAddNew());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnDelete());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnLoadCashierData());
		contentPane.add(getTxtpassword());
		
		
		
		
	}
	
	/*
	public ArrayList<CashierInfo> cashierList() throws SQLException{
		ArrayList<CashierInfo> cashier = new ArrayList<>();
		
		
//		return null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb","root","");
			
			String sql = "select * from cashier";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			CashierInfo cash;
			while(rs.next()){
				cash = new CashierInfo(rs.getInt("Id"), rs.getString("Name"), rs.getString("Mno"), rs.getString("Address"), rs.getString("Email"), rs.getString("Password"));
				
				cashierList().add(cash);
				
				
			}
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, e);
		}
		return cashier;
		
		
		
		
	}
	
	*/
	/*
	public void showUser() throws SQLException {
		ArrayList<CashierInfo> list = cashierList();
		
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		Object[] row =new Object[6];
		
		for (int i =0; i<list.size();i++) {
			
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getMno();
			row[3]= list.get(i).getAddress();
			row[4] = list.get(i).getEmail();
			row[5] = list.get(i).getPassword();
			
			model.addRow(row);
			
			
		}
		
	}
	*/

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(204, 204, 204));
			panel.setBounds(0, 0, 724, 34);
			panel.setLayout(null);
			panel.add(getLblAddCashier());
			panel.add(getButton());
			panel.add(getButton_1());
		}
		return panel;
	}
	private JLabel getLblAddCashier() {
		if (lblAddCashier == null) {
			lblAddCashier = new JLabel("Add Cashier");
			lblAddCashier.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAddCashier.setBounds(287, 5, 140, 18);
		}
		return lblAddCashier;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("-");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.BOLD, 20));
			button.setBackground(new Color(255, 204, 0));
			button.setBounds(590, 3, 62, 23);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("X");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			button_1.setForeground(Color.WHITE);
			button_1.setBackground(new Color(204, 0, 0));
			button_1.setBounds(662, 3, 62, 23);
		}
		return button_1;
	}
	private JLabel getLblAddCashierDetail() {
		if (lblAddCashierDetail == null) {
			lblAddCashierDetail = new JLabel("Add Cashier Details");
			lblAddCashierDetail.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAddCashierDetail.setBounds(75, 45, 168, 26);
		}
		return lblAddCashierDetail;
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Cashier Id");
			lblCashierId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCashierId.setBounds(35, 95, 81, 14);
		}
		return lblCashierId;
	}
	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Cashier Name");
			lblCashierName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCashierName.setBounds(35, 137, 81, 14);
		}
		return lblCashierName;
	}
	private JLabel getLblMobileNumber() {
		if (lblMobileNumber == null) {
			lblMobileNumber = new JLabel("Mobile Number");
			lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblMobileNumber.setBounds(35, 174, 92, 14);
		}
		return lblMobileNumber;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAddress.setBounds(35, 210, 81, 14);
		}
		return lblAddress;
	}
	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("Email Id");
			lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblEmailId.setBounds(35, 252, 81, 14);
		}
		return lblEmailId;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPassword.setBounds(35, 296, 81, 14);
		}
		return lblPassword;
	}
	private JTextField getTxtid() {
		if (txtid == null) {
			txtid = new JTextField();
			txtid.setBounds(126, 92, 96, 20);
			txtid.setColumns(10);
		}
		return txtid;
	}
	private JTextField getTxtname() {
		if (txtname == null) {
			txtname = new JTextField();
			txtname.setColumns(10);
			txtname.setBounds(126, 134, 96, 20);
		}
		return txtname;
	}
	private JTextField getTxtmno() {
		if (txtmno == null) {
			txtmno = new JTextField();
			txtmno.setColumns(10);
			txtmno.setBounds(126, 171, 96, 20);
		}
		return txtmno;
	}
	private JTextField getTxtemail() {
		if (txtemail == null) {
			txtemail = new JTextField();
			txtemail.setColumns(10);
			txtemail.setBounds(103, 249, 119, 20);
		}
		return txtemail;
	}
	private JTextField getTxtaddress() {
		if (txtaddress == null) {
			txtaddress = new JTextField();
			txtaddress.setColumns(10);
			txtaddress.setBounds(126, 210, 96, 20);
		}
		return txtaddress;
	}
	private JButton getBtnAddNew() {
		if (btnAddNew == null) {
			btnAddNew = new JButton("Add New");
			btnAddNew.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAddNew.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\add (2).png"));
			btnAddNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String sql = "INSERT INTO `cashier`( `Name`, `Mno`, `Address`, `Email`, `Password`) VALUES (?,?,?,?,?)";
						
						ps = con.prepareStatement(sql);
						
						ps.setString(1, txtname.getText());
						ps.setString(2, txtmno.getText());
						ps.setString(3, txtaddress.getText());
						ps.setString(4, txtemail.getText());
						ps.setString(5, txtpassword.getText());
						
						ps.execute();
//						==================================
						//to refresh jtable after inserting data
						
//						DefaultTableModel model =(DefaultTableModel)table.getModel();
//						
//						model.setRowCount(0);
//						=======================================
						
						
						JOptionPane.showMessageDialog(null,"Data Added");
						
						//after inserting data textfield will be null
						txtid.setText(null);
						txtname.setText(null);
						txtmno.setText(null);
						txtaddress.setText(null);
						txtemail.setText(null);
						txtpassword.setText(null);
						
						
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
					
					
				}
			});
			btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAddNew.setBounds(35, 349, 119, 23);
		}
		return btnAddNew;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					//update stmt same as insert stmt
					
					try {
						
						int row = table.getSelectedRow();
						String value = table.getModel().getValueAt(row, 0).toString() ; //for id
						
						
						
				String sql = "UPDATE `cashier` SET `Name`=?,`Mno`=?,`Address`=?,`Email`=?,`Password`=? WHERE id ="+value;
						
						ps = con.prepareStatement(sql);
						
						ps.setString(1, txtname.getText());
						ps.setString(2, txtmno.getText());
						ps.setString(3, txtaddress.getText());
						ps.setString(4, txtemail.getText());
						ps.setString(5, txtpassword.getText());
						
						ps.execute();
						JOptionPane.showMessageDialog(null,"Data Updated");
						
						//set text field blank after updated data
						txtid.setText(null);
						txtname.setText(null);
						txtmno.setText(null);
						txtaddress.setText(null);
						txtemail.setText(null);
						txtpassword.setText(null);
						
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
					
					
				}
			});
			btnUpdate.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\edit.png"));
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnUpdate.setBounds(185, 349, 111, 23);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//show th confirmation before deleting data
						
					 int opt = JOptionPane .showConfirmDialog(null, "Are your sure want to delete the data");
					
					if(opt ==0) {
				
					try {
						
						String sql = "DELETE FROM `cashier` WHERE id ='"+txtid.getText()+"'";//delete on the basis of id which is pk
						
						ps = con.prepareStatement(sql);
						
//						ps.setString(1, txtid.getText().toString());
						ps.execute();
						JOptionPane.showMessageDialog(null, "Data Deleted");
					}
					
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
					}
					
					
					
					
				}
			});
			btnDelete.setHorizontalAlignment(SwingConstants.RIGHT);
			btnDelete.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\remove (2).png"));
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnDelete.setBounds(316, 349, 126, 23);
		}
		return btnDelete;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(204, 204, 255));
			scrollPane.setBounds(246, 80, 478, 248);
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
					"id", "Name", "Mno", "Address", "Email", "Password"
				}
			));
		}
		
		return table;
	}
	private JButton getBtnLoadCashierData() {
		if (btnLoadCashierData == null) {
			btnLoadCashierData = new JButton("Load Cashier Data");
			btnLoadCashierData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// populate data in jtable of cashier using DbUtils of rs2xms jar file
					
					try {
						String sql = "select * from cashier";
						
						PreparedStatement pst = con.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
//DbUtils helps to populate the resultset value in jtable(tablemodel)
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			
			table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table.getSelectedRow();
					TableModel model = table.getModel();
				txtid.setText(model.getValueAt(i,0).toString());
				txtname.setText(model.getValueAt(i, 1).toString());
				txtmno.setText(model.getValueAt(i, 2).toString());
				txtaddress.setText(model.getValueAt(i, 3).toString());
				txtemail.setText(model.getValueAt(i, 4).toString());
				txtpassword.setText(model.getValueAt(i, 5).toString());
				
				}
			});
			
			btnLoadCashierData.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnLoadCashierData.setBounds(429, 45, 195, 23);
		}
		return btnLoadCashierData;
	}
	private JPasswordField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JPasswordField();
			txtpassword.setBounds(126, 293, 96, 20);
		}
		return txtpassword;
	}
}
