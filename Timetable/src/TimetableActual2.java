import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class TimetableActual2 extends JFrame {

	private JPanel contentPane;
	private JTable table1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableActual2 frame = new TimetableActual2();
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
	private JTable table2;
	private JScrollPane scrollPane_1;
	private JTable table3;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton;
	public TimetableActual2() {
		
		setBounds(180, 30, 1700, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 120, 1035, 238);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JButton B1 = new JButton("Display TimeTable");
		B1.addActionListener(new ActionListener() {
			int counter = 0;
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					stet=con.createStatement();
					if(counter == 0) {
						String query1 = "select * from TimeTableTE2";
						re=stet.executeQuery(query1);
						table1.setModel(DbUtils.resultSetToTableModel(re));
						counter ++;
					}
					
					/*String query1 = "select * from TimeTableTE2";
					re=stet.executeQuery(query1);
					table1.setModel(DbUtils.resultSetToTableModel(re));*/
					
					String query2 = "select * from te2samplelbs";
					re=stet.executeQuery(query2);
					table2.setModel(DbUtils.resultSetToTableModel(re));
					
					String query3 = "select * from te2samplesubs";
					re=stet.executeQuery(query3);
					table3.setModel(DbUtils.resultSetToTableModel(re));
					
					
					
					re.close();
					con.close();

				}catch(Exception e1) {	
					e1.printStackTrace();
				}
			}
		});
		B1.setFont(new Font("Tahoma", Font.BOLD, 15));
		B1.setBounds(36, 33, 195, 42);
		contentPane.add(B1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 470, 510, 218);
		contentPane.add(scrollPane_1);
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(676, 466, 476, 220);
		contentPane.add(scrollPane_2);
		
		table3 = new JTable();
		scrollPane_2.setViewportView(table3);
		
		JLabel TE = new JLabel("TE2");
		TE.setFont(new Font("Tahoma", Font.BOLD, 20));
		TE.setBounds(1149, 33, 63, 42);
		contentPane.add(TE);
		
		btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toBack();
				//setVisible(false);
				TimetableGenerator2 timetableGenerator2 = new TimetableGenerator2();
				timetableGenerator2.toFront();
				timetableGenerator2.setState(java.awt.Frame.NORMAL);
				setVisible(false);
				timetableGenerator2.setState(java.awt.Frame.NORMAL);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1419, 42, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton RST = new JButton("Reset Timetable");
		RST.addActionListener(new ActionListener() {
			int counter = 1;
			public void actionPerformed(ActionEvent arg0) {
				try {
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Chinmay$7552");
					stet=con.createStatement();
					if(counter == 1) {
						String query5 = "select * from TimetableTE1";
						re=stet.executeQuery(query5);
						table1.setModel(DbUtils.resultSetToTableModel(re));
						counter++;
					}
					else if(counter == 2) {
						String query6 = "select t1.Time,t2.Monday,t1.Tuesday,t2.Wednesday,t1.Thursday,t2.Friday,t1.Saturday from timetablete1 t1,timetablete2 t2 where t1.Time=t2.Time;";
						re=stet.executeQuery(query6);
						table1.setModel(DbUtils.resultSetToTableModel(re));
						counter++;
					}
					else if(counter == 3) {
						String query7 = "select t1.Time,t1.Monday,t2.Tuesday,t1.Wednesday,t2.Thursday,t1.Friday,t2.Saturday from timetablete1 t1,timetablete2 t2 where t1.Time=t2.Time;";
						re=stet.executeQuery(query7);
						table1.setModel(DbUtils.resultSetToTableModel(re));
						counter++;
					}
					else if(counter == 4) {
						JOptionPane.showMessageDialog(null, "End of Combinations");
					}
					
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Creation Unsuccessfull");
					
				}
				
			}
		});
		RST.setFont(new Font("Tahoma", Font.BOLD, 15));
		RST.setBounds(318, 33, 188, 42);
		contentPane.add(RST);
	}
}
