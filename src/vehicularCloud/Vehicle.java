package vehicularCloud;

public class Vehicle {
	private String vehicleModel, vehicleLiscensePlate;
	
	public Vehicle(String vehicleModel, String vehicleLiscensePlate) {
		this.vehicleModel = vehicleModel;
		this.vehicleLiscensePlate = vehicleLiscensePlate;
	}
	
	public String getVehicleModel(){
		return this.vehicleModel;
	}
	
	public String getVehicleLiscensePlate() {
		return this.vehicleLiscensePlate;
	}
}
