import java.sql.DriverManager;
import org.junit.jupiter.api.Test;

class test5Teacherlogin {
	public String msg="connection fail";
	public String msg1="connection pass";
	

	@Test
	void test1() {
		
		TeacherLogin tl=new TeacherLogin();
		try {
            tl.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            tl.stet=tl.con.createStatement(); 
            System.out.println(msg1);
        }catch(Exception e1) {
        	e1.printStackTrace();
            System.out.println(msg);
        }
	}
	
	@Test
	 void test2()
	 {
		
		TimetableActual1 ta=new TimetableActual1();
		TimetableActual2 ta2=new TimetableActual2();
		
		if(ta==null||ta2==null)
		{
			System.out.println("Test is Fail");
		}
		else
		{
			System.out.println("Test is Pass");
		}
	 }
	
	public static void name(String args[]) {
		test5Teacherlogin ttl=new test5Teacherlogin();
		ttl.test1();
		ttl.test2();
				
		
	}

}
