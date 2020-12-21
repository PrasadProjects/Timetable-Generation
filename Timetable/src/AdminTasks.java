import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminTasks extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//private JComboBox C1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTasks frame = new AdminTasks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	Statement stet = null;
	ResultSet re = null;
	private JTextField T1;
	private JTextField T2;
	private JTextField T3;
	private JComboBox comboBoxSelection;
	
	/*public void fillComboBox() {
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
			String sql = "select t_subjects from teacher_details";
			Statement stet=con.createStatement();
			ResultSet re=stet.executeQuery(sql);
			
			while(re.next()) {
				C1.addItem(re.getString("t_subjects"));
				
			}
			
			re.close();
			con.close();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
	}*/
	public void refreshTable() {
		
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			stet=con.createStatement();
			String query = "select t_id,t_name,t_subjects from teacher_details";
			
			re=stet.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(re));
			
			re.close();
			con.close();

		}catch(Exception e1) {	
			e1.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	public AdminTasks() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 916, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton B1 = new JButton("Load Teachers Data");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
					stet=con.createStatement();
					String query = "select t_id,t_name,t_subjects from teacher_details";
					
					re=stet.executeQuery(query);
					
					table.setModel(DbUtils.resultSetToTableModel(re));
					
					re.close();
					con.close();
		
				}catch(Exception e1) {	
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		B1.setFont(new Font("Tahoma", Font.BOLD, 14));
		B1.setBounds(498, 446, 171, 33);
		contentPane.add(B1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 88, 388, 348);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row = table.getSelectedRow();
					String t_id = (table.getModel().getValueAt(row, 0)).toString();
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
					stet=con.createStatement();
					
					String query ="select * from teacher_details where t_id ='"+ t_id+"'";
					re = stet.executeQuery(query);
					
					while(re.next()) {
						T1.setText(re.getString("t_id"));
						T2.setText(re.getString("t_name"));
						
					}
					
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel L1 = new JLabel("EID");
		L1.setFont(new Font("Tahoma", Font.BOLD, 17));
		L1.setBounds(53, 132, 80, 33);
		contentPane.add(L1);
		
		JLabel L2 = new JLabel("NAME");
		L2.setFont(new Font("Tahoma", Font.BOLD, 17));
		L2.setBounds(53, 192, 68, 25);
		contentPane.add(L2);
		
		JComboBox C1 = new JComboBox();
		C1.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE", "DM", "DELD", "DSA", "COA", "OOP", "M3", "CG", "ADS", "MP", "PPL"}));
		C1.setFont(new Font("Tahoma", Font.BOLD, 17));
		C1.setBounds(149, 251, 141, 33);
		contentPane.add(C1);
		
		JLabel L3 = new JLabel("Subjects");
		L3.setFont(new Font("Tahoma", Font.BOLD, 17));
		L3.setBounds(53, 255, 80, 25);
		contentPane.add(L3);
		
		T1 = new JTextField();
		T1.setFont(new Font("Tahoma", Font.BOLD, 15));
		T1.setBounds(149, 133, 141, 33);
		contentPane.add(T1);
		T1.setColumns(10);
		
		T2 = new JTextField();
		T2.setFont(new Font("Tahoma", Font.BOLD, 15));
		T2.setBounds(149, 189, 141, 33);
		contentPane.add(T2);
		T2.setColumns(10);
		
		JButton B2 = new JButton("SAVE");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
					String sql = "insert into teacher_details (t_id,t_name,t_subjects) values ('"+ Integer.parseInt(T1.getText()) +"','"+ T2.getText() +"','"+ C1.getSelectedItem().toString() +"')";
					stet = con.createStatement();
					stet.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Successfully Inserted");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Insertion Unsuccessfull");
				}
				refreshTable();
			}
		});
		B2.setFont(new Font("Tahoma", Font.BOLD, 15));
		B2.setBounds(29, 316, 119, 38);
		contentPane.add(B2);
		
		JButton B3 = new JButton("DELETE");
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
					String sql = "delete from teacher_details where t_id ='"+ Integer.parseInt(T1.getText())+ "'or t_name='"+ T2.getText() +"'";
					stet = con.createStatement();
					stet.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Successfully Deleted");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Deletion Unsuccessfull");
				}
				refreshTable();
			}
		});
		B3.setFont(new Font("Tahoma", Font.BOLD, 14));
		B3.setBounds(29, 359, 119, 33);
		contentPane.add(B3);
		
		JButton B4 = new JButton("Update Data");
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		B4.setFont(new Font("Tahoma", Font.BOLD, 14));
		B4.setBounds(29, 397, 124, 33);
		contentPane.add(B4);
		
		JButton B5 = new JButton("Propose Timetable");
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TimetableGenerator timetable = new TimetableGenerator();
				timetable.setVisible(true);
			}
		});
		B5.setFont(new Font("Tahoma", Font.BOLD, 15));
		B5.setBounds(174, 442, 184, 33);
		contentPane.add(B5);
		
		JButton B6 = new JButton("BACK");
		B6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				//setVisible(false);
				AdminLogin admin = new AdminLogin();
				admin.toFront();
				admin.setState(java.awt.Frame.NORMAL);
				setVisible(false);
				admin.setState(java.awt.Frame.NORMAL);
				
			}
		});
		B6.setFont(new Font("Tahoma", Font.BOLD, 14));
		B6.setBounds(789, 446, 97, 33);
		contentPane.add(B6);
		
		T3 = new JTextField();
		T3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
					stet = con.createStatement();
					String selection = (String)comboBoxSelection.getSelectedItem();
					String query = "select t_id,t_name,t_subjects from teacher_details where "+ selection +" = '"+T3.getText() +"'";
					
					re = stet.executeQuery(query);
					
					table.setModel(DbUtils.resultSetToTableModel(re));
					
					stet.close();
					
				}catch(Exception e) {
					
					e.printStackTrace();
				
				}
			}
		});
		T3.setBounds(718, 42, 154, 33);
		contentPane.add(T3);
		T3.setColumns(10);
		
		JLabel L4 = new JLabel("Search By:");
		L4.setFont(new Font("Tahoma", Font.BOLD, 17));
		L4.setBounds(498, 43, 91, 32);
		contentPane.add(L4);
		
		comboBoxSelection = new JComboBox();
		comboBoxSelection.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxSelection.setModel(new DefaultComboBoxModel(new String[] {"t_id", "t_name", "t_subjects"}));
		comboBoxSelection.setBounds(601, 42, 80, 33);
		contentPane.add(comboBoxSelection);
		
		JLabel L5 = new JLabel("Staff Details :-");
		L5.setFont(new Font("Tahoma", Font.BOLD, 17));
		L5.setBounds(53, 53, 124, 33);
		contentPane.add(L5);
		
		//refreshTable();
	}
}
