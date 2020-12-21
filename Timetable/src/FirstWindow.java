import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 200, 564, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel L1 = new JLabel("Admin");
		L1.setFont(new Font("Tahoma", Font.BOLD, 20));
		L1.setBounds(103, 180, 85, 27);
		frame.getContentPane().add(L1);
		
		JButton B1 = new JButton("Login");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLogin admin = new AdminLogin();
				admin.setVisible(true);
				frame.dispose();
			
			}
		});
		B1.setFont(new Font("Tahoma", Font.BOLD, 15));
		B1.setBounds(294, 174, 97, 42);
		frame.getContentPane().add(B1);
		
		JLabel L2 = new JLabel("Teachers");
		L2.setFont(new Font("Tahoma", Font.BOLD, 20));
		L2.setBounds(103, 283, 103, 33);
		frame.getContentPane().add(L2);
		
		JButton B2 = new JButton("Login");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherLogin teacher = new TeacherLogin();
				teacher.setVisible(true);
				
			}
		});
		B2.setFont(new Font("Tahoma", Font.BOLD, 15));
		B2.setBounds(294, 280, 97, 42);
		frame.getContentPane().add(B2);
		
		JLabel L3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/log-icon.png")).getImage();
		L3.setIcon(new ImageIcon(img));
		L3.setBounds(185, 13, 151, 135);
		frame.getContentPane().add(L3);
	}
}
