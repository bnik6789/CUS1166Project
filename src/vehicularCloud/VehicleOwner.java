package vehicularCloud;

public class VehicleOwner {
	private String firstName, lastName;
	private String arrivalTime, estimatedDepartueTime;
	private String vehicleModel;
	private String Id;
	
	public VehicleOwner(String firstName, String lastName, String vehicleModel, String Id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleModel = vehicleModel;
		this.Id = Id;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getArrivalTime() {
		return this.arrivalTime;
	}
	
	public String getDepartureTime() {
		return this.estimatedDepartueTime;
	}
	public String getVehicleModel() {
		return this.vehicleModel;
	}
	
	public String getId() 
	{
		return this.Id;
	}
	
	/*public void addVehicle() {
		
	}*/
}
