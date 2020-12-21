import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.junit.jupiter.api.Test;

class test1admin {
	public String msg="connection fail";
	public String msg1="connection pass";
	private JPanel contentPane;

	@Test
	void test1() {
		AdminLogin ad=new AdminLogin();
		
		try {
			//here check to connection sql
			ad.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test/test","root1","root1");
			 ad.stet=ad.con.createStatement();
			 System.out.println(msg1);
			
             
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 System.out.println(msg);
			
		}
		
	}
	@Test
	void test2()
	{
        AdminLogin ad=new AdminLogin();
	
		try {
			//here check to connection sql
			ad.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test/test","root","root");
			 ad.stet=ad.con.createStatement();
			 System.out.println(msg1);
			
             
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 System.out.println(msg);
			
		}
		
		
	}
	
	public static void name(String args[]) {
		
		test1admin td=new test1admin();
				td.test1();
		        td.test2();
		
	}

}
