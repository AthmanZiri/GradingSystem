package gradingsys;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Connect implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	
	
	JFrame fr = new JFrame();
	
	JLabel lab = new JLabel("What would you like to do?",new ImageIcon("bin/images/STI.JPG"), JLabel.CENTER);
	
	JButton btnadd= new JButton("Add Student Information");
	JButton btncalc = new JButton("Caculate Grade");

	
	public Main() {
		//super("Grading System");
		fr.setTitle("Grading System");
		//Container pane = getContentPane();
		fr.setLayout(new FlowLayout(FlowLayout.CENTER));

		fr.add(lab);
		lab.setVerticalTextPosition(JLabel.BOTTOM);
		lab.setHorizontalTextPosition(JLabel.CENTER);

		
		fr.add(btnadd);
		fr.add(btncalc);
		
		btnadd.addActionListener(this);
		btncalc.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnadd) {
			
			new AddStudent();
			fr.setVisible(true);
			fr.setBounds(450,100,425,500);
			
		}
		
		if (source == btncalc) {
			
			new Calculate();
			fr.setVisible(true);
			fr.setBounds(450,100,425,550);
		}
		fr.dispose();		
		
	}


}
