import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PDFGenerator extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDFGenerator frame = new PDFGenerator();
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
	public PDFGenerator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton B1 = new JButton("Generate PDF");
		B1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String path="";
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Save File");
				//jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = jFileChooser.showSaveDialog(null);
				File file = jFileChooser.getSelectedFile();
				try {
					FileOutputStream fileoutputStream = new FileOutputStream(file);
					fileoutputStream.flush();
					fileoutputStream.close();
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
				
			/*if(result == jFileChooser.APPROVE_OPTION) {
					
					path = jFileChooser.getSelectedFile().getPath();
					
				}
				
				Document document = new Document();
				try {
					PdfWriter.getInstance(document, new FileOutputStream(path + "FirstPDF.pdf"));
					
					document.open();
					
					PdfPTable ptable = new PdfPTable(3);
					 
					ptable.addCell("t_id");
					ptable.addCell("t_name");
					ptable.addCell("t_subjects");
					
					for(int i=0;i<table.getRowCount();i++) {
						
						String t_id = table.getValueAt(1,0).toString();
						String t_name = table.getValueAt(1,1).toString();
						String t_subjects = table.getValueAt(1,2).toString();
						
						ptable.addCell(t_id);
						ptable.addCell(t_name);
						ptable.addCell(t_subjects);
						
					}
					
					document.add(ptable);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (DocumentException e) {
					
					e.printStackTrace();
				}
				document.close();*/
				
				
			}
		});
		B1.setBounds(159, 156, 134, 25);
		contentPane.add(B1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 89, 314, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton B2 = new JButton("Load Data");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				stet=con.createStatement();
				String query = "select t_id,t_name,t_subjects from teacher_details";
				
				re=stet.executeQuery(query);
				
				table.setModel(DbUtils.resultSetToTableModel(re));
				
				re.close();
				con.close();
	
			}catch(Exception e1) {	
				e1.printStackTrace();
			}

			}
		});
		B2.setBounds(458, 451, 97, 25);
		contentPane.add(B2);
	}
}
