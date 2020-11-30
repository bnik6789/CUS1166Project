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

}
