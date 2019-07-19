package Com.inventoryproject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Com.inventoryproject.db.Database;
import net.proteanit.sql.DbUtils;

import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProductInfo extends JFrame {

	private JPanel contentPane;
	private JLabel lblProduct;
	private JTextField textField;
	private JButton btnSearch;
	private JLabel lblProductInformation;
	private JScrollPane scrollPane;
	private JTable table;
	private Button button;

	/**
	 * Launch the application.
	 */
	
	Connection con = null;
	PreparedStatement ps = null;
	private JComboBox comboBoxSelect;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInfo frame = new ProductInfo();
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
	public ProductInfo() throws SQLException {
		
		con = Database.getdbcon();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProduct());
		contentPane.add(getTextField());
		contentPane.add(getBtnSearch());
		contentPane.add(getLblProductInformation());
		contentPane.add(getScrollPane());
		contentPane.add(getButton());
		contentPane.add(getComboBoxSelect());
	}
	private JLabel getLblProduct() {
		if (lblProduct == null) {
			lblProduct = new JLabel("Product");
			lblProduct.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblProduct.setBounds(34, 39, 83, 14);
		}
		return lblProduct;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
//					String query = textField.getText().toLowerCase();
//					filter(query);
					
//					try {
//						
////						String selection = 
//						String sql = "SELECT * FROM `stock` WHERE productname = ?";
//						
//						ps = con.prepareStatement(sql);
//						
//						ps.setString(1, textField.getText());
//						ResultSet rs = ps.executeQuery();
//						
//						table.setModel(DbUtils.resultSetToTableModel(rs));
//						
//						ps.close();
//					}
//					catch(Exception e4) {
//						e4.printStackTrace();
//					}
//					
					
					
				}

//				private void filter(String query) {
//					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>();
//					
//					
//				}
			});
			textField.setBounds(126, 38, 142, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						// on the basis of combobox selected items 
						String selection = comboBoxSelect .getSelectedItem().toString();
						String sql = "SELECT * FROM `stock` WHERE "+selection+ "= ?";
						
						ps = con.prepareStatement(sql);
						
						ps.setString(1, textField.getText());
						ResultSet rs = ps.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						ps.close();
					}
					catch(Exception e4) {
						e4.printStackTrace();
					}
					
					
					
					
					
				}
			});
			btnSearch.setIcon(new ImageIcon("E:\\coreswingdemo\\javastdApp\\src\\SourcePackage\\image\\search.png"));
			btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSearch.setBounds(313, 36, 119, 23);
		}
		return btnSearch;
	}
	private JLabel getLblProductInformation() {
		if (lblProductInformation == null) {
			lblProductInformation = new JLabel("Product Information");
			lblProductInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblProductInformation.setBounds(137, 11, 186, 14);
		}
		return lblProductInformation;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 116, 434, 206);
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
					"Pid", "Pname", "Available", "Mrp"
				}
			));
		}
		return table;
	}
	private Button getButton() {
		if (button == null) {
			button = new Button("Product Data");
			button.setFont(new Font("Dialog", Font.BOLD, 12));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					String sql = "SELECT id,productname,quantityavailable,mrp FROM `stock` ";
					
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
			button.setBounds(84, 88, 111, 22);
		}
		return button;
	}
	private JComboBox getComboBoxSelect() {
		if (comboBoxSelect == null) {
			comboBoxSelect = new JComboBox();
			comboBoxSelect.setFont(new Font("Tahoma", Font.BOLD, 13));
			comboBoxSelect.setModel(new DefaultComboBoxModel(new String[] {"id", "productname", "quantityavailable", "mrp"}));
			comboBoxSelect.setBounds(271, 85, 119, 20);
		}
		return comboBoxSelect;
	}
}
