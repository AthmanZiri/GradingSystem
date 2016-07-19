package gradingsys;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogIn extends Connect implements ActionListener, Across{
	
	JFrame frame = new JFrame();

	JButton btnlog = new JButton(new ImageIcon("bin/images/login.png"));
	JButton btncan = new JButton(new ImageIcon("bin/images/cancel.png"));
	JTextField txtuser = new JTextField(10);
	JPasswordField txtpass = new JPasswordField(10);
	
	JLabel lab = new JLabel(new ImageIcon("bin/images/STI.JPG"));
	
	JLabel user = new JLabel("Username");
	JLabel pass = new JLabel("Password");
	
	
	public LogIn() {
		
		//super("LogIn");
		frame.setTitle("LogIn");
		
		JPanel pane = new JPanel(new FlowLayout());
		
		pane.add(lab);

		pane.add(user);
		pane.add(txtuser);
		
		pane.add(pass);
		pane.add(txtpass);
		
		pane.add(btnlog);
		pane.add(btncan);
		btnlog.addActionListener(this);
		btncan.addActionListener(this);
		
		frame.setContentPane(pane);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source==btnlog) {
			
			try {
				
				String username = "";
				String password = "";
				
				String struname = txtuser.getText();
				char [] strpas = txtpass.getPassword();
				
				if (struname.length()==0 || strpas.length==0) {
					JOptionPane.showMessageDialog(null, "Please enter Username/Password", "Warning", JOptionPane.WARNING_MESSAGE);
					
				}else {
					st = con.createStatement();
					
					rs = st.executeQuery("Select * FROM Log_in WHERE Username = '" + txtuser.getText() + "'AND Password = '" + txtpass.getText() +"'");
					
					while(rs.next()) {
						username = rs.getString("Username");
						password = rs.getString("Password");
						
					}
					if (!username.equals(txtuser.getText()) || !password.equals(txtpass.getPassword())) {
						
						JOptionPane.showMessageDialog(null, "Wrong Username/Password", "Try Again", JOptionPane.ERROR_MESSAGE);
						txtuser.setText("");
						txtpass.setText("");
						txtuser.requestFocus(true);
					}else {
						JOptionPane.showMessageDialog(null, "Successfully Login", "Sucess", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						
						new Main();
						frame.setVisible(true);
						frame.setResizable(false);
						frame.setBounds(450,250,415,232);
						
					}
				}
				
			}catch(SQLException ex) {
				
			}
					
			
		}
		if (source==btncan) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to EXIT?", "Message", JOptionPane.YES_NO_OPTION);
			
			if (reply == JOptionPane.YES_OPTION) {
				
				System.exit(0);

			}else {

			}

		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogIn lg = new LogIn();
		lg.showFrame();

	}

}
