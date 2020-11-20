package vehicularCloud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Controller {
	
	public Controller() 
	{
	    try
    	    {  
       		VehicularCloud VC = new VehicularCloud();
       		VC.readJobs("Job Owner Information.txt"); 
		System.out.println(completionTime("Job Owner Information.txt"));
     	    }
     	    catch(IOException e)
     	    {  
       		 JOptionPane.showMessageDialog(null, "Error opening accounts file.");
       		 return;
     	     }
	 
	}
	
	//Not sure about this
	public String completionTime(String filename) 
	         throws IOException
	   {  
	      try (Scanner in = new Scanner(new File(filename)))
	      {
	    	  int duration = in.nextInt();
	    	  String s = " ";
	    	  int i=1;
	    	  
	         while (in.hasNextInt())
	         {  
	        	s = s + "Job " + i + "Completion time: " + duration + "\n";
	            	duration = duration + in.nextInt();
	            	i++;
	         }
	         return s;
	      }
	      
	   }
	
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
	
	public static void main(String[] args) 
	{
		String dataIn = "";
		String dataOut = "";
		Scanner input;
		
		
		try 
		{
		
			String in = "";
			
			System.out.println("******** Server Side ********");
			System.out.println("Waiting for client to connect....");
			serverSocket = new ServerSocket(3333);
			socket = serverSocket.accept();
			System.out.println("Request accepted client is connected....");
			
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			
			class acceptRejectWindow extends JFrame
			{
				final int FrameWidth = 550;
				final int FrameHeight = 400;
				JLabel question;
				JButton acceptButton;
				JButton rejectButton;
				
				public acceptRejectWindow() 
				{
					question = new JLabel("Do you want to accept or reject the client's data?");
					createAcceptButton();
					createRejectButton();
					createPanel();
					
					setSize(FrameWidth, FrameHeight);	
				}
				
				private void createAcceptButton() 
				{
					acceptButton = new JButton("Accept");
					acceptButton.setBounds(10, 100, 180, 125);
					ActionListener acceptButtonListener = new acceptButtonListener(); 
					acceptButton.addActionListener(acceptButtonListener);
				}
				
				class acceptButtonListener implements ActionListener
				{
					
					
					public void actionPerformed(ActionEvent e)
					{	
						if(e.getActionCommand()== acceptButton.getActionCommand())
						{
								
							try 
							{
								PrintStream output = new PrintStream(new FileOutputStream("Client Data.txt", true));
								output.println("**************************************");
								output.println("CLIENT DATA: ");
								output.println(inputStream);
								output.println("**************************************");
								
								outputStream.writeUTF("DATA ACCEPTED");
							}
							catch(Exception ex){JOptionPane.showMessageDialog(null, ex);} 
							{
								
							}
						}
					}	
				}
				
				class rejectButtonListener implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{	
						if(e.getActionCommand()== rejectButton.getActionCommand())
						{
							try 
							{
								outputStream.writeUTF("DATA REJECTED");
							}
							catch(Exception ex){JOptionPane.showMessageDialog(null, ex);} 
							{
								
							}
						}
					}
				}

				private void createRejectButton() 
				{
					rejectButton = new JButton("Reject");
					rejectButton.setBounds(10, 125, 80, 25);
					ActionListener rejectButtonListener = new rejectButtonListener(); 
					rejectButton.addActionListener(rejectButtonListener);
				}
				private void createPanel() 
				{
					JPanel panel = new JPanel();
					panel.add(question);
					panel.add(acceptButton);
					panel.add(rejectButton);
					add(panel);
				}
					
			}
			
			
			while(true)
			{
				if(dataIn.equals("exit")==true) 
				{
					System.exit(1);
				}
				
				dataIn = inputStream.readUTF();
				System.out.println("Data received from client: " + "\"" + dataIn + "\"");
				
				
				JFrame frame = new acceptRejectWindow();
				frame.setTitle("SERVER");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	
}
