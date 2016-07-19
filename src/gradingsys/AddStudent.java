package gradingsys;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends Connect implements Across, ActionListener{

	JFrame frame = new JFrame();
	
	JTextField txid = new JTextField(10);
	JTextField txfname = new JTextField(10);
	JTextField txmname = new JTextField(10);
	JTextField txlname = new JTextField(10);
	JTextField txage = new JTextField(10);
	JTextField txadd = new JTextField(10);//Replace with button or addsubject
	
	JLabel logo = new JLabel(new ImageIcon("bin/images/Sti.jpg"));
	
	JLabel lab1 = new JLabel("ID Number");
	JLabel lab2 = new JLabel("First Name");
	JLabel lab3 = new JLabel("Middle Initial");
	JLabel lab4 = new JLabel("Last Name");
	JLabel lab5 = new JLabel("Age");
	JLabel lab6 = new JLabel("Course");
	
	JButton btnad = new JButton(new ImageIcon("bin/images/useradd.png"));
	JButton btnback = new JButton("Back");
	
	String co[] = {"","BSIT", "BSCoE", "DIT"};//Replace course with class
	JComboBox<?> course = new JComboBox<String>(co);
	String cor = "";
	
	public AddStudent() {
		/*super("Add Student Information");
		 * 
		 */
		frame.setTitle("Add Student Info");
		
		//Container frame = frame.getContentPane();
		frame.setLayout(null);
		
		frame.add(logo);
		logo.setBounds(0,0,415,100);
		
		frame.add(lab1);
		lab1.setBounds(100,130,60,10);
		frame.add(txid);
		txid.setBounds(190,125,100,20);
		
		frame.add(lab2);
		lab2.setBounds(100,160,80,10);
		frame.add(txfname);
		txfname.setBounds(190,155,100,20);
		
		frame.add(lab3);
		lab3.setBounds(100,190,96,10);
		frame.add(txmname);
		txmname.setBounds(190,185,100,20);
		
		frame.add(lab4);
		lab4.setBounds(100,220,70,20);
		frame.add(txlname);
		txlname.setBounds(190, 215, 100, 20);
		
		frame.add(lab5);
		lab5.setBounds(100,250,64,20);
		frame.add(txage);
		txage.setBounds(190,245,100,20);
				
		frame.add(lab6);
		lab6.setBounds(100,280,60,10);
		
		frame.add(course);
		course.setSelectedIndex(0);
		course.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cor = (co[course.getSelectedIndex()]);
			}
		});
	
		course.setBounds(190,275,100,20);
		
		frame.add(btnad);
		btnad.setBounds(160,320,48,48);
		
		frame.add(btnback);
		btnback.setBounds(220,320,70,48);
		
		btnad.addActionListener(this);
		btnback.addActionListener(this);
		
		/*
		try {
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:db1");
			
		}catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
	
		}*/
	}
	
	public void clear() {
		
		txid.setText("");
		txfname.setText("");
		txmname.setText("");
		txlname.setText("");
		txage.setText("");
		course.setSelectedIndex(0);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source==btnad) {
			
			try {
				
				String id = txid.getText();
				String fname = txfname.getText();
				String mname = txmname.getText();
				String lname = txlname.getText();
				String age = txage.getText();
				
				if(!id.equals("")&&!fname.equals("")&&!mname.equals("")&&!lname.equals("")&&!age.equals("")) {
					
					st = con.createStatement();
					ps = con.prepareStatement("INSERT INTO tbl_studentinfo "+ "(ID_Number,First_Name,Middle_Initials,Last_Name,Age,Course)" + " VALUES(?,?,?,?,?,?)");
					
					ps.setString(1,txid.getText());
					ps.setString(2,txfname.getText());
					ps.setString(3,txmname.getText());
					ps.setString(4,txlname.getText());
					ps.setString(5,txage.getText());
					ps.setString(6,cor);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "New Account has been added", "Student Information", JOptionPane.INFORMATION_MESSAGE);
					st.close();
					
				}else {
					JOptionPane.showMessageDialog(null, "Please fill up empty fields", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}catch(SQLException e1) {
				
			}
			
			clear();
			
		}if (source==btnback) {
			
			Main mn = new Main();
			mn.showFrame();
			
			frame.dispose();
			
		}
	
	}
	

}
