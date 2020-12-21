import org.junit.jupiter.api.Test;

class test2 {

	@Test
	void test() {
		FirstWindow fw=new FirstWindow();
		
		try {
			fw.initialize();
			
			System.out.println("Test is Pass");
		} catch (Exception e) {
			// TODO: handle exception
			//to call initialize function()
			System.out.println("Test is fail");
			
		}
		
	}

}
