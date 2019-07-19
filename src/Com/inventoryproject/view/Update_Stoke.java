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
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Com.inventoryproject.db.Database;
import net.proteanit.sql.DbUtils;

public class Update_Stoke extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnX;
	private JButton button;
	private JLabel lblUpdateStock;
	private JLabel lblProductId;
	private JLabel lblProductName;
	private JLabel lblQuantityAvailable;
	private JLabel lblQuantityAdded;
	private JLabel lblMrp;
	private JTextField txtid;
	private JTextField txtpname;
	private JTextField txtqavailable;
	private JTextField txtqadded;
	private JTextField txtmrp;
	private JButton btnNew;
	private JButton btnU;

	/**
	 * Launch the application.
	 */
	
	Connection con = null;
	PreparedStatement ps = null;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnLoadStockData;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Stoke frame = new Update_Stoke();
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
	public Update_Stoke() throws SQLException {
		
		con = Database.getdbcon();
		
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblUpdateStock());
		contentPane.add(getLblProductId());
		contentPane.add(getLblProductName());
		contentPane.add(getLblQuantityAvailable());
		contentPane.add(getLblQuantityAdded());
		contentPane.add(getLblMrp());
		contentPane.add(getTxtid());
		contentPane.add(getTxtpname());
		contentPane.add(getTxtqavailable());
		contentPane.add(getTxtqadded());
		contentPane.add(getTxtmrp());
		contentPane.add(getBtnNew());
		contentPane.add(getBtnU());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnLoadStockData());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(204, 204, 204));
			panel.setBounds(0, 0, 544, 33);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getBtnX());
			panel.add(getButton());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Update Stock");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(146, 5, 117, 17);
		}
		return lblNewLabel;
	}
	private JButton getBtnX() {
		if (btnX == null) {
			btnX = new JButton("X");
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
//					System.exit(0);
					
					
				}
			});
			btnX.setBackground(new Color(204, 0, 0));
			btnX.setForeground(new Color(255, 255, 255));
			btnX.setBounds(472, 2, 62, 23);
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
			button.setForeground(new Color(255, 255, 255));
			button.setBackground(new Color(255, 204, 0));
			button.setBounds(400, 2, 62, 23);
		}
		return button;
	}
	private JLabel getLblUpdateStock() {
		if (lblUpdateStock == null) {
			lblUpdateStock = new JLabel("Update Stock");
			lblUpdateStock.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUpdateStock.setBounds(80, 60, 119, 26);
		}
		return lblUpdateStock;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id");
			lblProductId.setBounds(20, 109, 71, 20);
		}
		return lblProductId;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("Product Name");
			lblProductName.setBounds(0, 149, 71, 14);
		}
		return lblProductName;
	}
	private JLabel getLblQuantityAvailable() {
		if (lblQuantityAvailable == null) {
			lblQuantityAvailable = new JLabel("Quantity Available");
			lblQuantityAvailable.setBounds(11, 191, 90, 14);
		}
		return lblQuantityAvailable;
	}
	private JLabel getLblQuantityAdded() {
		if (lblQuantityAdded == null) {
			lblQuantityAdded = new JLabel("Quantity Added");
			lblQuantityAdded.setBounds(3, 232, 90, 14);
		}
		return lblQuantityAdded;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("MRP");
			lblMrp.setBounds(22, 273, 71, 14);
		}
		return lblMrp;
	}
	private JTextField getTxtid() {
		if (txtid == null) {
			txtid = new JTextField();
			txtid.setBounds(93, 109, 96, 20);
			txtid.setColumns(10);
		}
		return txtid;
	}
	private JTextField getTxtpname() {
		if (txtpname == null) {
			txtpname = new JTextField();
			txtpname.setBounds(93, 146, 96, 20);
			txtpname.setColumns(10);
		}
		return txtpname;
	}
	private JTextField getTxtqavailable() {
		if (txtqavailable == null) {
			txtqavailable = new JTextField();
			txtqavailable.setBounds(103, 188, 96, 20);
			txtqavailable.setColumns(10);
		}
		return txtqavailable;
	}
	private JTextField getTxtqadded() {
		if (txtqadded == null) {
			txtqadded = new JTextField();
			txtqadded.setBounds(103, 229, 96, 20);
			txtqadded.setColumns(10);
		}
		return txtqadded;
	}
	private JTextField getTxtmrp() {
		if (txtmrp == null) {
			txtmrp = new JTextField();
			txtmrp.setBounds(103, 270, 96, 20);
			txtmrp.setColumns(10);
		}
		return txtmrp;
	}
	private JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton("NEW");
			btnNew.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\add (2).png"));
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					try {
						String sql = "INSERT INTO `stock`( `productname`, `quantityavailable`, `quantityadded`, `mrp`) VALUES (?,?,?,?)";
						
						ps = con.prepareStatement(sql);
						
						
						ps.setString(1, txtpname.getText());
						ps.setString(2, txtqavailable.getText());
						ps.setString(3, txtqadded.getText());
						ps.setString(4, txtmrp.getText());
						
						ps.execute();
//						==================================
						//to refresh jtable after inserting data
						
//						DefaultTableModel model =(DefaultTableModel)table.getModel();
//						
//						model.setRowCount(0);
//						=======================================
						
						
						JOptionPane.showMessageDialog(null,"Product Added");
						
						//after inserting data textfield will be null
						txtid.setText(null);
						txtpname.setText(null);
						txtqavailable.setText(null);
						txtqadded.setText(null);
						txtmrp.setText(null);
//						
						
						
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
					
					
				}
					
					
					
					
					
					
					
					
//					Image img = new ImageIcon(this.getClass().getResource("E:\\java_ws\\InventoryProject/additon.png")).getImage();
//					btnNew.setIcon(new ImageIcon(img));
					
				
			});
			btnNew.setBounds(10, 337, 106, 33);
		}
		return btnNew;
	}
	private JButton getBtnU() {
		if (btnU == null) {
			btnU = new JButton("Update");
			btnU.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//update/edit the table data value
					int i = table.getSelectedRow();
					String value = table.getModel().getValueAt(i, 0).toString(); //id ko basis ma update
					
					String sql = "UPDATE `stock` SET `productname`=?,`quantityavailable`=?,`quantityadded`=?,`mrp`=? WHERE id = "+value;
					
					try {
						ps = con.prepareStatement(sql);
						ps.setString(1, txtpname.getText());
						ps.setString(2, txtqavailable.getText());
						ps.setString(3, txtqadded.getText());
						ps.setString(4, txtmrp.getText());
						
						ps.execute();
						JOptionPane.showConfirmDialog(null, "Updated Successfully");
						
						//set text field blank after update
						txtid.setText(null);
						txtpname.setText(null);
						txtqavailable.setText(null);
						txtqadded.setText(null);
						txtmrp.setText(null);
						
						
						
						
					} catch (SQLException e1) {
						
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
					
					
				}
			});
			btnU.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\edit.png"));
			btnU.setBounds(126, 337, 119, 33);
		}
		return btnU;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(209, 74, 335, 233);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "pname", "qvailable", "qadded", "mrp"
				}
			));
		}
		return table;
	}
	private JButton getBtnLoadStockData() {
		if (btnLoadStockData == null) {
			btnLoadStockData = new JButton("Load Stock Data");
			btnLoadStockData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//populate data in jtable of stock
					try {
						
						String sql = "select * from stock";
						ps = con.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
					}
					catch(Exception e3) {
						JOptionPane.showMessageDialog(null, e3);
						
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
					txtid.setText(model.getValueAt(i, 0).toString());
					txtpname.setText(model.getValueAt(i, 1).toString());
					txtqavailable.setText(model.getValueAt(i, 2).toString());
					txtqadded.setText(model.getValueAt(i, 3).toString());
					txtmrp.setText(model.getValueAt(i, 4).toString());
					
					
					
					
				}
			});
			
			btnLoadStockData.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLoadStockData.setBounds(300, 44, 156, 23);
		}
		return btnLoadStockData;
	}
}
