import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TeacherLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin frame = new TeacherLogin();
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
	
	public TeacherLogin() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(89, 118, 111, -22);
		contentPane.add(lblNewLabel);
		
		JLabel L1 = new JLabel("Username");
		L1.setBounds(211, 98, 101, 26);
		L1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(L1);
		
		JTextField T1 = new JTextField();
		T1.setBounds(339, 99, 240, 26);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel L2 = new JLabel("Password");
		L2.setBounds(211, 206, 101, 26);
		L2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(L2);
		
		JPasswordField P1 = new JPasswordField();
		P1.setBounds(339, 209, 240, 22);
		contentPane.add(P1);
		
		JButton B1 = new JButton("Login");
		Image img1 = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		B1.setIcon(new ImageIcon(img1));
		B1.setFont(new Font("Tahoma", Font.BOLD, 14));
		B1.setBounds(297, 301, 97, 39);
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

                    stet=con.createStatement();

                    String sql = "select * from teacher_Login where username='"+T1.getText()+"'and password='"+Integer.parseInt(P1.getText())+"'";

                    re = stet.executeQuery(sql);
                    if(re.next()){
                        
                        JOptionPane.showMessageDialog(null, "LoginSuccessFull...");
                        TeachersData teachers = new TeachersData();
                        teachers.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect user or Password");
                    }
                    
                    re.close();
                    con.close();
                }catch(Exception e1) {
                    System.out.println(e1);
                }
            }
			
		});
		contentPane.add(B1);
		
		JLabel label = new JLabel("");
		label.setBounds(89, 172, 56, 16);
		contentPane.add(label);
		
		JLabel L3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login-icon.png")).getImage();
		L3.setIcon(new ImageIcon(img));
		L3.setBounds(34, 100, 145, 154);
		contentPane.add(L3);
		
		
	}

}
