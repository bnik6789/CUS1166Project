package vehicularCloud;

import java.util.ArrayList;

public class VehicleOwnerList {
	private ArrayList<VehicleOwner> OwnerListVehicle;
	
	public VehicleOwnerList() {
		this.OwnerListVehicle = new ArrayList<VehicleOwner>();
	}
	
	public void addVehicleOwner(VehicleOwner vehicleOwner) {
		this.OwnerListVehicle.add(vehicleOwner);
	}	
}
