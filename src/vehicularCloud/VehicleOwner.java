package vehicularCloud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;

public class VehicleOwner extends JFrame{
	final int FrameWidth = 600;
	final int FrameHeight = 300;
	
	static JTextField ID = new JTextField(20);
	static JTextField Model = new JTextField(20);
	static JTextField licenseNumber = new JTextField(20);
	static JTextField residencyTime = new JTextField(20);
	JLabel ownerID = new JLabel("Owner ID: ");
	JLabel vehicleModel = new JLabel("Vehicle Model: ");
	JLabel vehicleLicenseNumber = new JLabel("License Plate Number: ") ;
	JLabel vehicleResidencyTime= new JLabel("Approximate Residency Time: ");
	JLabel directions = new JLabel("Please enter the following information");
	JLabel minutes = new JLabel(" Minutes");
	JButton enterButton;
	/* This is where a panel will open up asking the customer/owner the information that will need to be put into the code. */
	
	
	public VehicleOwner() {
		
		JPanel ownerPanel = new JPanel();
		JFrame ownerFrame = new JFrame();
		ownerFrame.setTitle("Vehicle Owner");
		ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ownerFrame.setVisible(true);
		ownerFrame.setSize(FrameWidth, FrameHeight);
		ownerFrame.add(ownerPanel);
		createOwnerEnterButton();
		
		ownerPanel.setLayout(null);
		directions.setBounds(20, 20, 500, 25);
		
		ownerID.setBounds(20, 50, 80, 25);
		vehicleModel.setBounds(20, 80, 200, 25);
		vehicleLicenseNumber.setBounds(20, 110, 300, 25);
		vehicleResidencyTime.setBounds(20, 140, 330, 25);
		minutes.setBounds(250, 140, 100, 25);
		
		
		ID.setBounds(80, 50, 165, 25);
		Model.setBounds(120, 80, 200, 25);
		licenseNumber.setBounds(165, 110, 200, 25);
		residencyTime.setBounds(200, 140, 50, 25);
		
		
		ownerPanel.add(directions);
		ownerPanel.add(ownerID);
		ownerPanel.add(vehicleModel);
		ownerPanel.add(vehicleLicenseNumber);
		ownerPanel.add(vehicleResidencyTime);
		ownerPanel.add(ID);
		ownerPanel.add(Model);
		ownerPanel.add(licenseNumber);
		ownerPanel.add(residencyTime);
		ownerPanel.add(minutes);
		ownerPanel.add(enterButton);	
	/*This is where the buttons are created on the panel of the program. User inputs information within the text boxes provided within the program */
	
  }
	
	private void createOwnerEnterButton() 
	{
		enterButton = new JButton("Enter");
		enterButton.setBounds(20, 190, 80, 25);
		ActionListener ownerEnterButtonListener = new ownerEnterButtonListener();
		enterButton.addActionListener(ownerEnterButtonListener);
	}
	
	class ownerEnterButtonListener implements ActionListener 
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		
		public void actionPerformed(ActionEvent ae) 
		{
			if(ae.getActionCommand()== enterButton.getActionCommand()) 
			{
				try 
				{	
					PrintStream output = new PrintStream(new FileOutputStream("Vehicle Owner Information.txt", true));
					
					output.println("*****************************************");
					output.println(ownerID.getText() + " " + ID.getText());
					output.println(vehicleModel.getText() + " " + Model.getText());
					output.println(vehicleLicenseNumber.getText() + " " + licenseNumber.getText());
					output.println(vehicleResidencyTime.getText() + " " + residencyTime.getText() + minutes.getText());
					output.println("TimeStamp: " + formatter.format(date));
					output.println("*****************************************");
					output.println(" ");
					output.close();
					JOptionPane.showMessageDialog(null, "Information Sent to the Server!");
					
				} catch(Exception e){JOptionPane.showMessageDialog(null, e);}				
			}
		}
		
	}
	public static String getVehicleOwnerId() 
	{
		return ID.getText();
	}
	
	public static String getVehicleModel() 
	{
		return Model.getText();
	}
	
	public static String getLicenseNumber() 
	{
		return licenseNumber.getText();
	}
	
	public static String getResidencyTime() 
	{
		return residencyTime.getText();
	}

}
