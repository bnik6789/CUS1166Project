package vehicularCloud;

import java.util.ArrayList;


public class ClientsList {
	private ArrayList<Client> clientsList;
	
	public ClientsList() 
	{
		this.clientsList = new ArrayList<Client>();
	}
	
	public void addClient(Client client) 
	{
		this.clientsList.add(client);
	}
	
	public Client findClient(String id)
	{
		for (Client c : clientsList) 
		{
			if (id.equals(c.getId())) 
			{
				return c;
			}
		}
		return null;
	}
	
}
