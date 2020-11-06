package vehicularCloud;

public class Vehicle {
	private String vehicleModel, vehicleLicensePlate;
	
	public Vehicle(String vehicleModel, String vehicleLicensePlate) {
		this.vehicleModel = vehicleModel;
		this.vehicleLicensePlate = vehicleLicensePlate;
	}
	
	public String getVehicleModel(){
		return this.vehicleModel;
	}
	
	public String getVehicleLicensePlate() {
		return this.vehicleLicensePlate;
	}
}
