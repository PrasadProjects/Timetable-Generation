import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class TimetableGenerator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableGenerator frame = new TimetableGenerator();
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
	Connection con = null;
	Statement stet = null;
	ResultSet re = null;
	private JTable table;
	public TimetableGenerator() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 731, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox C1 = new JComboBox();
		C1.setFont(new Font("Tahoma", Font.BOLD, 15));
		C1.setModel(new DefaultComboBoxModel(new String[] {"Second Year", "Third Year", "Final year"}));
		//C2.setSelectedItem(null);
		C1.setBounds(22, 82, 196, 32);
		contentPane.add(C1);
		
		JComboBox C2 = new JComboBox();
		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					String sql = "select subjects from subject_details where semester ='" + (String)C2.getSelectedItem()+ "' and Year = '" + (String)C1.getSelectedItem() +"';";
					stet = con.createStatement();
					re = stet.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(re));
					
					
				}catch(Exception e1) {
					
				}
			}
		});
		C2.setModel(new DefaultComboBoxModel(new String[] {"Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"}));
		//C2.setSelectedItem(null);
		C2.setFont(new Font("Tahoma", Font.BOLD, 15));
		C2.setBounds(249, 82, 196, 32);
		contentPane.add(C2);
		
		JButton B1 = new JButton("BACK");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				//setVisible(false);
				AdminTasks admin = new AdminTasks();
				admin.toFront();
				admin.setState(java.awt.Frame.NORMAL);
				setVisible(false);
				admin.setState(java.awt.Frame.NORMAL);
			}
		});
		B1.setFont(new Font("Tahoma", Font.BOLD, 15));
		B1.setBounds(589, 13, 97, 32);
		contentPane.add(B1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 177, 241, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel L1 = new JLabel("Select Year");
		L1.setFont(new Font("Tahoma", Font.BOLD, 15));
		L1.setBounds(22, 57, 113, 25);
		contentPane.add(L1);
		
		JLabel L2 = new JLabel("Select Semester");
		L2.setFont(new Font("Tahoma", Font.BOLD, 15));
		L2.setBounds(249, 57, 128, 25);
		contentPane.add(L2);
		
		JLabel L4 = new JLabel("Subjects:-");
		L4.setFont(new Font("Tahoma", Font.BOLD, 15));
		L4.setBounds(190, 139, 113, 25);
		contentPane.add(L4);
		
		JComboBox C3 = new JComboBox();
		C3.setFont(new Font("Tahoma", Font.BOLD, 17));
		C3.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		C3.setBounds(477, 82, 102, 31);
		contentPane.add(C3);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a =(String)C3.getSelectedItem();
				String b =(String)C2.getSelectedItem();
				
				if(b=="Semester5" || b=="Semester6") {
					if(a=="1") {
						TimetableGenerator1 timetable1 = new TimetableGenerator1();
						timetable1.setVisible(true);
					}
					else
					{
						TimetableGenerator2 timetable2 = new TimetableGenerator2();
						timetable2.setVisible(true);
						
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Select Semester 5 or 6 and 3rd Year");
				}
				
				
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBounds(270, 380, 107, 37);
		contentPane.add(btnNext);
		
		
		
		JLabel L3 = new JLabel("Select Division");
		L3.setFont(new Font("Tahoma", Font.BOLD, 14));
		L3.setBounds(477, 58, 102, 25);
		contentPane.add(L3);
	}
}
