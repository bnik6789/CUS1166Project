package vehicularCloud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainFrame extends JFrame 
{
	final int FrameWidth = 600;
	final int FrameHeight = 300;
	JLabel question;
	JButton ownerButton;
	JButton clientButton;
	
	public MainFrame()
	{
		question = new JLabel("Are you a Client who wants to submit a job? OR an Owner who wants to rent out her/his car?");
		createOwnerButton();
		createClientButton();
		createPanel();
		
		setSize(FrameWidth, FrameHeight);		
	}


	private void createOwnerButton() 
	{
		ownerButton = new JButton("Owner");
		ownerButton.setBounds(10, 100, 180, 125);
		ActionListener ownerButtonListener = new ownerButtonListener();
		ownerButton.addActionListener(ownerButtonListener);
	}
	
	class ownerButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame = new VehicleOwner();
		}
	}
	
	private void createClientButton() 
	{
		clientButton = new JButton("Client");
		clientButton.setBounds(10, 125, 80, 25);
		ActionListener clientButtonListener = new clientButtonListener();
		clientButton.addActionListener(clientButtonListener);
	}
	
	class clientButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JFrame frame = new OwnerFrame();
		}
		
	}
	
	private void createPanel() 
	{
		JPanel panel = new JPanel();
		panel.add(question);
		panel.add(ownerButton);
		panel.add(clientButton);
		add(panel);
	}

}
