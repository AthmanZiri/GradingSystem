package gradingsys;

import javax.swing.JFrame;

public interface Across {
	
	JFrame frame = new JFrame();
	public default void showFrame(){
		frame.setBounds(450,250,415,232);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
