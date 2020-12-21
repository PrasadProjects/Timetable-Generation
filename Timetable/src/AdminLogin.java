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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AdminLogin frame = new AdminLogin();
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

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 697, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(89, 118, 111, -22);
		contentPane.add(lblNewLabel);
		
		JLabel L1 = new JLabel("Username");
		L1.setFont(new Font("Tahoma", Font.BOLD, 15));
		L1.setBounds(197, 97, 101, 26);
		contentPane.add(L1);
		
		JTextField T1 = new JTextField();
		T1.setBounds(323, 98, 258, 26);
		contentPane.add(T1);
		T1.setColumns(10);
		
		JLabel L2 = new JLabel("Password");
		L2.setFont(new Font("Tahoma", Font.BOLD, 15));
		L2.setBounds(197, 206, 101, 26);
		contentPane.add(L2);
		
		JPasswordField P = new JPasswordField();
		P.setBounds(323, 207, 258, 26);
		contentPane.add(P);
		
		JButton B1 = new JButton("Login");
		Image img1 = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		B1.setIcon(new ImageIcon(img1));
		B1.setFont(new Font("Tahoma", Font.BOLD, 14));
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean a;
				try {
					
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test/test","root","root");

                    stet=con.createStatement();
                    if(T1.getText() == null) {
                    	JOptionPane.showMessageDialog(null, "Enter Complete Login Details");
                    	
                    }

                    String sql = "select * from admin_Login where username='"+ T1.getText()+ "'and password='"+ Integer.parseInt(P.getText()) +"'";

                    re = stet.executeQuery(sql);
                    if(re.next()){
                        JOptionPane.showMessageDialog(null, "LoginSuccessFull...");
                        //new AdminLogin().setVisible(false);
                        AdminTasks admin = new AdminTasks();
                        admin.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect user or Password");
                    }
                    
                    re.close();
                    con.close();
                }catch(Exception e1) {
                    System.out.println(e1);
                }
				//toBack();
				//new AdminTasks().setVisible(true);
				//new AdminTasks().toFront();
				
            }
			
		});
		B1.setBounds(271, 292, 121, 37);
		contentPane.add(B1);
		
		
		
		JLabel L3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login-icon.png")).getImage();
		L3.setIcon(new ImageIcon(img));
		L3.setBounds(36, 97, 136, 135);
		contentPane.add(L3);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(271, 13, 121, 26);
		contentPane.add(lblNewLabel_1);
		
		
		
	}
}
