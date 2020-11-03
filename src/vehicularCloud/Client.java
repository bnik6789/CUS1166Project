package vehicularCloud;

public class Client {

	private String firstName, lastName, id;
	
	public Client(String firstName, String lastName, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void createJob() {
		
	}
	
	public void addJob() {
		
	}
	
	
}
