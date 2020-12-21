import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class test4pdf {

	@Test
	void test() {
		PDFGenerator pdf=new PDFGenerator();
		
		PDFGenerator(JFrame.EXIT_ON_CLOSE);
		
		try {
			String path="";
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setDialogTitle("Save File");
			//jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = jFileChooser.showSaveDialog(null);
			File file = jFileChooser.getSelectedFile();
			FileOutputStream fileoutputStream = new FileOutputStream(file);
			fileoutputStream.flush();
			fileoutputStream.close();
			System.out.println("Test Case Pass");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Test Case fail");
		}
	}

	private void PDFGenerator(int exitOnClose) {
		// TODO Auto-generated method stub
		
		
	}

}
