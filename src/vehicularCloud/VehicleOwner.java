package vehicularCloud;

public class VehicleOwner {
	private String firstName, lastName;
	private String arrivalTime, estimatedDepartueTime;
	private String vehicleModel;
	
	public VehicleOwner(String firstName, String lastName, String vehicleModel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicleModel = vehicleModel;
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
	
	public void addVehicle() {
		
	}
}
