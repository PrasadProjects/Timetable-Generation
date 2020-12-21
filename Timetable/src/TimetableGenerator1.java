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
import javax.swing.border.EmptyBorder;

public class TimetableGenerator1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableGenerator1 frame = new TimetableGenerator1();
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
	public TimetableGenerator1() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 1060, 0);
		contentPane.add(label);
		
		JLabel L1 = new JLabel("Subjects");
		L1.setFont(new Font("Tahoma", Font.BOLD, 15));
		L1.setBounds(49, 38, 75, 28);
		contentPane.add(L1);
		
		JLabel L2 = new JLabel("Staff Name");
		L2.setFont(new Font("Tahoma", Font.BOLD, 15));
		L2.setBounds(339, 38, 85, 28);
		contentPane.add(L2);
		
		JComboBox Sub1 = new JComboBox();
		Sub1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sub1.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		Sub1.setSelectedItem(null);
		Sub1.setBounds(49, 79, 75, 33);
		contentPane.add(Sub1);
		
		JComboBox SS1 = new JComboBox();
		SS1.setFont(new Font("Tahoma", Font.BOLD, 15));
		SS1.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		SS1.setSelectedItem(null);
		SS1.setBounds(339, 79, 138, 33);
		contentPane.add(SS1);
		
		JComboBox Sub2 = new JComboBox();
		Sub2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sub2.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		Sub2.setSelectedItem(null);
		Sub2.setBounds(49, 134, 75, 33);
		contentPane.add(Sub2);
		
		JComboBox SS2 = new JComboBox();
		SS2.setFont(new Font("Tahoma", Font.BOLD, 15));
		SS2.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		SS2.setSelectedItem(null);
		SS2.setBounds(339, 134, 138, 33);
		contentPane.add(SS2);
		
		JComboBox Sub3 = new JComboBox();
		Sub3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sub3.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		Sub3.setSelectedItem(null);
		Sub3.setBounds(49, 199, 75, 33);
		contentPane.add(Sub3);
		
		JComboBox SS3 = new JComboBox();
		SS3.setFont(new Font("Tahoma", Font.BOLD, 15));
		SS3.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		SS3.setSelectedItem(null);
		SS3.setBounds(339, 199, 138, 33);
		contentPane.add(SS3);
		
		JComboBox Sub4 = new JComboBox();
		Sub4.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sub4.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		Sub4.setSelectedItem(null);
		Sub4.setBounds(49, 260, 75, 33);
		contentPane.add(Sub4);
		
		JComboBox SS4 = new JComboBox();
		SS4.setFont(new Font("Tahoma", Font.BOLD, 15));
		SS4.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		SS4.setSelectedItem(null);
		SS4.setBounds(339, 260, 138, 33);
		contentPane.add(SS4);
		
		JComboBox Sub5 = new JComboBox();
		Sub5.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sub5.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		Sub5.setSelectedItem(null);
		Sub5.setBounds(49, 327, 75, 33);
		contentPane.add(Sub5);
		
		JComboBox SS5 = new JComboBox();
		SS5.setFont(new Font("Tahoma", Font.BOLD, 15));
		SS5.setBounds(339, 327, 138, 33);
		SS5.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		SS5.setSelectedItem(null);
		contentPane.add(SS5);
		/*JComboBox C25 = new JComboBox();
		C25.setFont(new Font("Tahoma", Font.BOLD, 15));
		C25.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		C25.setSelectedItem(null);
		C25.setBounds(339, 327, 138, 33);*/
		
		JLabel L3 = new JLabel("Lab Name");
		L3.setFont(new Font("Tahoma", Font.BOLD, 16));
		L3.setBounds(49, 390, 115, 28);
		contentPane.add(L3);
		
		JComboBox LA1 = new JComboBox();
		LA1.setFont(new Font("Tahoma", Font.BOLD, 15));
		LA1.setModel(new DefaultComboBoxModel(new String[] {"DBMS Lab", "CN Lab", "SDL Lab"}));
		LA1.setSelectedItem(null);
		LA1.setBounds(49, 435, 105, 28);
		contentPane.add(LA1);
		
		JComboBox LA2 = new JComboBox();
		LA2.setFont(new Font("Tahoma", Font.BOLD, 15));
		LA2.setModel(new DefaultComboBoxModel(new String[] {"DBMS Lab", "CN Lab", "SDL Lab"}));
		LA2.setSelectedItem(null);
		LA2.setBounds(49, 498, 105, 28);
		contentPane.add(LA2);
		
		JComboBox LA3 = new JComboBox();
		LA3.setFont(new Font("Tahoma", Font.BOLD, 15));
		LA3.setModel(new DefaultComboBoxModel(new String[] {"DBMS Lab", "CN Lab", "SDL Lab"}));
		LA3.setSelectedItem(null);
		LA3.setBounds(49, 555, 105, 28);
		contentPane.add(LA3);
		
		JLabel L4 = new JLabel("Staff Name");
		L4.setFont(new Font("Tahoma", Font.BOLD, 15));
		L4.setBounds(341, 390, 96, 23);
		contentPane.add(L4);
		
		JComboBox LS1 = new JComboBox();
		LS1.setFont(new Font("Tahoma", Font.BOLD, 15));
		LS1.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Asma Shaikh", "Vandana Rupnar", "Anita Shinde", "Sarita Sapkal", "Geeta Chillarge"}));
		LS1.setSelectedItem(null);
		LS1.setBounds(339, 436, 138, 28);
		contentPane.add(LS1);
		
		JComboBox LS2 = new JComboBox();
		LS2.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Asma Shaikh", "Vandana Rupnar", "Anita Shinde", "Sarita Sapkal", "Geeta Chillarge"}));
		LS2.setSelectedItem(null);
		LS2.setFont(new Font("Tahoma", Font.BOLD, 15));
		LS2.setBounds(339, 498, 138, 26);
		contentPane.add(LS2);
		
		JComboBox LS3 = new JComboBox();
		LS3.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Asma Shaikh", "Vandana Rupnar", "Anita Shinde", "Sarita Sapkal", "Geeta Chillarge"}));
		LS3.setSelectedItem(null);
		LS3.setFont(new Font("Tahoma", Font.BOLD, 15));
		LS3.setBounds(339, 555, 138, 26);
		contentPane.add(LS3);
		
		JButton B1 = new JButton("SUBMIT");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Insert into Subjects
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					String sql1 = "insert into te1samplesubs (Subjects,StaffName) values ('"+ Sub1.getSelectedItem().toString() +"','"+ SS1.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql1);
					
					String sql2 = "insert into te1samplesubs (Subjects,StaffName) values ('"+ Sub2.getSelectedItem().toString() +"','"+ SS2.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql2);
					
					String sql3 = "insert into te1samplesubs (Subjects,StaffName) values ('"+ Sub3.getSelectedItem().toString() +"','"+ SS3.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql3);
					
					String sql4 = "insert into te1samplesubs (Subjects,StaffName) values ('"+ Sub4.getSelectedItem().toString() +"','"+ SS4.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql4);
					
					String sql5 = "insert into te1samplesubs (Subjects,StaffName) values ('"+ Sub5.getSelectedItem().toString() +"','"+ SS5.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql5);
					
					//insert labs
					String sql6 = "insert into te1samplelbs (Labname,LabStaff) values ('"+ LA1.getSelectedItem().toString() +"','"+ LS1.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql6);
					
					String sql7 = "insert into te1samplelbs (Labname,LabStaff) values ('"+ LA2.getSelectedItem().toString() +"','"+ LS2.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql7);
					
					String sql8 = "insert into te1samplelbs (Labname,LabStaff) values ('"+ LA3.getSelectedItem().toString() +"','"+ LS3.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql8);
					
					
					JOptionPane.showMessageDialog(null, "Successfully Submitted");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Submittion Unsuccessfull");
				}
			}
		});
		B1.setFont(new Font("Tahoma", Font.BOLD, 15));
		B1.setBounds(49, 632, 97, 44);
		contentPane.add(B1);
		
		JLabel lblNewLabel = new JLabel("TE1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(628, 38, 96, 28);
		contentPane.add(lblNewLabel);
		
		JButton B2 = new JButton("Generate TimeTable");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TimetableActual1 timeTableActual1= new TimetableActual1();
				timeTableActual1.setVisible(true);
				
				
				
				
			}
		});
		B2.setFont(new Font("Tahoma", Font.BOLD, 15));
		B2.setBounds(327, 632, 183, 44);
		contentPane.add(B2);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toBack();
				//setVisible(false);
				TimetableGenerator timetableGenerator = new TimetableGenerator();
				timetableGenerator.toFront();
				timetableGenerator.setState(java.awt.Frame.NORMAL);
				setVisible(false);
				timetableGenerator.setState(java.awt.Frame.NORMAL);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(904, 40, 97, 25);
		contentPane.add(btnNewButton);
		
		

}
}
