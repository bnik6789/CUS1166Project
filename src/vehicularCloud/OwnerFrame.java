package vehicularCloud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class OwnerFrame extends JFrame{

	/**
	 *
	 */
	//private static final long serialVersionUID = 1L;
	final int FrameWidth = 600;
	final int FrameHeight = 300;
	
	JLabel clientFirstName = new JLabel("First Name: "); 
	JLabel clientLastName = new JLabel("Last Name: ");    
	JLabel clientID = new JLabel("Client ID:  ");
	JLabel approximateJobDuration = new JLabel("Approximate Job Duration:  ");
	JLabel jobDeadline = new JLabel("Job Deadline: ");
	JLabel directions = new JLabel("Please Enter the Following Information:  ");
	JLabel jobDurationMinutes = new JLabel("   Minutes"); // This label could be renamed to 'minutes' so we don't need a duplicate label and to avoid confusion.
	JLabel jobDeadlineMinutes = new JLabel("   Minutes");


	static JTextField firstName = new JTextField(20);  
	static JTextField lastName = new JTextField(20);    
	static JTextField ID = new JTextField(20);
	JTextField jobDuration = new JTextField(20);
	static JTextField deadLine = new JTextField(20);
	
	JButton enterButton;
	
	
	public OwnerFrame() 
  	{
	
		JPanel clientPanel = new JPanel();
		JFrame clientFrame = new JFrame();
		clientFrame.setTitle("Job Owner");
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.setVisible(true);
		clientFrame.setSize(FrameWidth, FrameHeight);
		clientFrame.add(clientPanel);
		
		createClientEnterButton();
		
		clientPanel.setLayout(null);
		directions.setBounds(20, 20, 500, 25);
		
		clientFirstName.setBounds(20, 50, 80, 25 ); 
		clientLastName.setBounds(20, 80, 80, 25); 
		clientID.setBounds(20, 110, 80, 25);
		approximateJobDuration.setBounds(20, 140, 400, 25);
		jobDeadline.setBounds(20, 170, 80, 25);

		firstName.setBounds(89, 50, 200, 25);    
		lastName.setBounds(89, 80, 200 , 25);        
		ID.setBounds(73, 110, 165, 25);
		jobDuration.setBounds(180, 140, 50, 25);
		deadLine.setBounds(100, 170, 50, 25);
		jobDurationMinutes.setBounds(225, 140, 100, 25);
		jobDeadlineMinutes.setBounds(145, 170, 100, 25);

		clientPanel.add(clientFirstName);
		clientPanel.add(clientLastName);
		clientPanel.add(firstName);
		clientPanel.add(lastName);
		clientPanel.add(directions);
		clientPanel.add(clientID);
		clientPanel.add(approximateJobDuration);
		clientPanel.add(jobDeadline);
		clientPanel.add(ID);
		clientPanel.add(jobDuration);
		clientPanel.add(deadLine);
		clientPanel.add(jobDurationMinutes);
		clientPanel.add(jobDeadlineMinutes);
		clientPanel.add(enterButton);

	}

	private void createClientEnterButton() {
		enterButton = new JButton("Enter");
		enterButton.setBounds(20, 200, 80, 25);
		ActionListener clientEnterButtonListener = new clientEnterButtonListener();
		enterButton.addActionListener(clientEnterButtonListener);
	}

	class clientEnterButtonListener implements ActionListener {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

		public void actionPerformed(ActionEvent ae) {
			String jDuration = jobDuration.getText();
			String jDeadline = deadLine.getText();
			int duration = Integer.parseInt(jDuration);
			int deadline = Integer.parseInt(jDeadline);

			if (ae.getActionCommand() == enterButton.getActionCommand()) {
				try {
					PrintStream output = new PrintStream(new FileOutputStream("Job Owner Information.txt", true));
					output.println("*****************************************");
					output.println("Name: " + firstName.getText() + " " + lastName.getText());
					output.println(clientID.getText() + " " + ID.getText());
					output.println(
							approximateJobDuration.getText() + " " + duration + " " + jobDurationMinutes.getText());
					output.println(jobDeadline.getText() + " " + deadline + " " + jobDeadlineMinutes.getText());
					output.println("TimeStamp: " + formatter.format(date));
					output.println("*****************************************");
					output.println(" ");
					output.close();
					JOptionPane.showMessageDialog(null, "Information Sent to the Server!");
					firstName.setText("");
					lastName.setText("");
					ID.setText("");
					jobDuration.setText("");
					deadLine.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}

	}

	public static String getClientName() {
		return firstName.getText() + " " + lastName.getText();
	}

	public static String getClientID() {
		return ID.getText();
	}

	public static String getJobDeadline() {
		return deadLine.getText();
	}
	
}
