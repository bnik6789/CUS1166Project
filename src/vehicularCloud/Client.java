package vehicularCloud;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private String firstName, lastName, id;
	
	public Client(String firstName, String lastName, String id) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String getName() 
	{
		return this.firstName + " " + this.lastName;
	}
	
	public String getId() 
	{
		return this.id;
	}
	
	////////////////////////////////
	
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
			System.out.println("******** Client Side ********");
			System.out.println("Client Sucessfully Connected!... ");
			
			Socket socket = new Socket("localhost", 3333);
			
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Input the data that you want to send the server: ");
			input = new Scanner(System.in);
			dataOut = input.nextLine();
			outputStream.writeUTF(dataOut);
			
			while(true)
			{
				if(dataIn.equals("exit")) 
				{
					System.out.println("GOODBYE");
					System.exit(1);
				}
				dataIn = inputStream.readUTF();
				System.out.println("message received from server: " + "\"" + dataIn + "\"");
				System.out.println("Input data that you want to send the server.");
				System.out.println("If you dont have any more data to send the server, type exit");
				input = new Scanner(System.in);
				dataOut = input.nextLine();
				outputStream.writeUTF(dataOut);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
