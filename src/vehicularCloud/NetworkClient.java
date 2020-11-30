package vehicularCloud;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class NetworkClient{

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
				
				Socket socket = new Socket("localhost", 3322);
				
				inputStream = new DataInputStream(socket.getInputStream());
				outputStream = new DataOutputStream(socket.getOutputStream());
				
				System.out.println("Enter Yes if you have data you want to send to the server.");
				System.out.println("Otherwise type exit.");
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
					
					System.out.println("Enter Yes if you have data you want to send to the server.");
					System.out.println("Otherwise type exit.");
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
