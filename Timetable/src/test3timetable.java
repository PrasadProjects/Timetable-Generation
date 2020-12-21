import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test3timetable {

	@Test
	void test() {
		TimetableGenerator tg1=new TimetableGenerator();
		TimetableGenerator1 tg2 =new TimetableGenerator1();
		TimetableGenerator2 tg3=new TimetableGenerator2();
				
				if(tg1==null|| tg2==null|| tg3==null)
				{
					System.out.println("Test is Fail");
				}
				else {
					System.out.println("Test Pass");
				}
				
	}

}
