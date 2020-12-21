import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TimetableGenerator2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableGenerator2 frame = new TimetableGenerator2();
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
	public TimetableGenerator2() {
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
		
		JComboBox S1 = new JComboBox();
		S1.setFont(new Font("Tahoma", Font.BOLD, 15));
		S1.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		S1.setSelectedItem(null);
		S1.setBounds(49, 79, 75, 33);
		contentPane.add(S1);
		
		JComboBox ST1 = new JComboBox();
		ST1.setFont(new Font("Tahoma", Font.BOLD, 15));
		ST1.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		ST1.setSelectedItem(null);
		ST1.setBounds(339, 79, 138, 33);
		contentPane.add(ST1);
		
		JComboBox S2 = new JComboBox();
		S2.setFont(new Font("Tahoma", Font.BOLD, 15));
		S2.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		S2.setSelectedItem(null);
		S2.setBounds(49, 134, 75, 33);
		contentPane.add(S2);
		
		JComboBox ST2 = new JComboBox();
		ST2.setFont(new Font("Tahoma", Font.BOLD, 15));
		ST2.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		ST2.setSelectedItem(null);
		ST2.setBounds(339, 134, 138, 33);
		contentPane.add(ST2);
		
		JComboBox S3 = new JComboBox();
		S3.setFont(new Font("Tahoma", Font.BOLD, 15));
		S3.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		S3.setSelectedItem(null);
		S3.setBounds(49, 199, 75, 33);
		contentPane.add(S3);
		
		JComboBox ST3 = new JComboBox();
		ST3.setFont(new Font("Tahoma", Font.BOLD, 15));
		ST3.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		ST3.setSelectedItem(null);
		ST3.setBounds(339, 199, 138, 33);
		contentPane.add(ST3);
		
		JComboBox S4 = new JComboBox();
		S4.setFont(new Font("Tahoma", Font.BOLD, 15));
		S4.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		S4.setSelectedItem(null);
		S4.setBounds(49, 260, 75, 33);
		contentPane.add(S4);
		
		JComboBox ST4 = new JComboBox();
		ST4.setFont(new Font("Tahoma", Font.BOLD, 15));
		ST4.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		ST4.setSelectedItem(null);
		ST4.setBounds(339, 260, 138, 33);
		contentPane.add(ST4);
		
		JComboBox S5 = new JComboBox();
		S5.setFont(new Font("Tahoma", Font.BOLD, 15));
		S5.setModel(new DefaultComboBoxModel(new String[] {"DBMS", "CN", "TOC", "SEPM", "ISEE"}));
		S5.setSelectedItem(null);
		S5.setBounds(49, 327, 75, 33);
		contentPane.add(S5);
		
		JComboBox ST5 = new JComboBox();
		ST5.setFont(new Font("Tahoma", Font.BOLD, 15));
		ST5.setBounds(339, 327, 138, 33);
		ST5.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		ST5.setSelectedItem(null);
		contentPane.add(ST5);
		/*JComboBox C25 = new JComboBox();
		C25.setFont(new Font("Tahoma", Font.BOLD, 15));
		C25.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Sarita Sapkal\t", "Asma Shaikh\t", "Anita Shinde\t", "Asma Shaikh\t", "Vandana Rupnar\t", "Kushal Khairnar\t", "Sandeep Chaware\t", "Jagruti Wagh\t", "Geeta Chillarge\t"}));
		C25.setSelectedItem(null);
		C25.setBounds(339, 327, 138, 33);*/
		
		JLabel L3 = new JLabel("Lab Name");
		L3.setFont(new Font("Tahoma", Font.BOLD, 16));
		L3.setBounds(49, 390, 115, 28);
		contentPane.add(L3);
		
		JComboBox Lab1 = new JComboBox();
		Lab1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Lab1.setModel(new DefaultComboBoxModel(new String[] {"DBMS Lab", "CN Lab", "SDL Lab"}));
		Lab1.setSelectedItem(null);
		Lab1.setBounds(49, 435, 105, 28);
		contentPane.add(Lab1);
		
		JComboBox Lab2 = new JComboBox();
		Lab2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Lab2.setModel(new DefaultComboBoxModel(new String[] {"DBMS Lab", "CN Lab", "SDL Lab"}));
		Lab2.setSelectedItem(null);
		Lab2.setBounds(49, 498, 105, 28);
		contentPane.add(Lab2);
		
		JComboBox Lab3 = new JComboBox();
		Lab3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Lab3.setModel(new DefaultComboBoxModel(new String[] {"DBMS Lab", "CN Lab", "SDL Lab"}));
		Lab3.setSelectedItem(null);
		Lab3.setBounds(49, 555, 105, 28);
		contentPane.add(Lab3);
		
		JLabel L4 = new JLabel("Staff Name");
		L4.setFont(new Font("Tahoma", Font.BOLD, 15));
		L4.setBounds(341, 390, 96, 23);
		contentPane.add(L4);
		
		JComboBox LST1 = new JComboBox();
		LST1.setFont(new Font("Tahoma", Font.BOLD, 15));
		LST1.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Asma Shaikh", "Vandana Rupnar", "Anita Shinde", "Sarita Sapkal", "Geeta Chillarge"}));
		LST1.setSelectedItem(null);
		LST1.setBounds(339, 436, 138, 28);
		contentPane.add(LST1);
		
		JComboBox LST2 = new JComboBox();
		LST2.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Asma Shaikh", "Vandana Rupnar", "Anita Shinde", "Sarita Sapkal", "Geeta Chillarge"}));
		LST2.setSelectedItem(null);
		LST2.setFont(new Font("Tahoma", Font.BOLD, 15));
		LST2.setBounds(339, 498, 138, 26);
		contentPane.add(LST2);
		
		JComboBox LST3 = new JComboBox();
		LST3.setModel(new DefaultComboBoxModel(new String[] {"Pradnya Mehta", "Asma Shaikh", "Vandana Rupnar", "Anita Shinde", "Sarita Sapkal", "Geeta Chillarge"}));
		LST3.setSelectedItem(null);
		LST3.setFont(new Font("Tahoma", Font.BOLD, 15));
		LST3.setBounds(339, 555, 138, 26);
		contentPane.add(LST3);
		
		JButton Submit = new JButton("SUBMIT");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Insert into Subjects
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					String sql1 = "insert into te2samplesubs (Subjects,StaffName) values ('"+ S1.getSelectedItem().toString() +"','"+ ST1.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql1);
					
					String sql2 = "insert into te2samplesubs (Subjects,StaffName) values ('"+ S2.getSelectedItem().toString() +"','"+ ST2.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql2);
					
					String sql3 = "insert into te2samplesubs (Subjects,StaffName) values ('"+ S3.getSelectedItem().toString() +"','"+ ST3.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql3);
					
					String sql4 = "insert into te2samplesubs (Subjects,StaffName) values ('"+ S4.getSelectedItem().toString() +"','"+ ST4.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql4);
					
					String sql5 = "insert into te2samplesubs (Subjects,StaffName) values ('"+ S5.getSelectedItem().toString() +"','"+ ST5.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql5);
					
					//insert labs
					String sql6 = "insert into te2samplelbs (Labname,LabStaff) values ('"+ Lab1.getSelectedItem().toString() +"','"+ LST1.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql6);
					
					String sql7 = "insert into te2samplelbs (Labname,LabStaff) values ('"+ Lab2.getSelectedItem().toString() +"','"+ LST2.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql7);
					
					String sql8 = "insert into te2samplelbs (Labname,LabStaff) values ('"+ Lab3.getSelectedItem().toString() +"','"+ LST3.getSelectedItem().toString()+"')";
					stet = con.createStatement();
					stet.executeUpdate(sql8);
					
					
					JOptionPane.showMessageDialog(null, "Successfully Submitted");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Submittion Unsuccessfull");
				}
			}
		});
		Submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		Submit.setBounds(49, 632, 97, 44);
		contentPane.add(Submit);
		
		JLabel lblNewLabel = new JLabel("TE2");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(631, 38, 96, 28);
		contentPane.add(lblNewLabel);
		
		JButton Generate = new JButton("Generate TimeTable");
		Generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TimetableActual2 timeTableActual2 = new TimetableActual2();
				timeTableActual2.setVisible(true);
				
				
			}
		});
		Generate.setFont(new Font("Tahoma", Font.BOLD, 15));
		Generate.setBounds(327, 632, 183, 44);
		contentPane.add(Generate);
		
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
		btnNewButton.setBounds(891, 40, 97, 25);
		contentPane.add(btnNewButton);
		
		

}
}
