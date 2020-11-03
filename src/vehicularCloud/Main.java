package vehicularCloud;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vehicularCloud.MainFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new MainFrame();
		frame.setTitle("Welcome to The Vehicular Cloud Console");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}