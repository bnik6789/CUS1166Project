package vehicularCloud;

import java.util.ArrayList;

public class VehicleOwnerList {
	private ArrayList<VehicleOwner> vehicleOwnerList;
	
	public VehicleOwnerList() {
		this.vehicleOwnerList = new ArrayList<VehicleOwner>();
	}
	
	public void addVehicleOwner(VehicleOwner vehicleOwner) {
		this.vehicleOwnerList.add(vehicleOwner);
	}
	
	public VehicleOwner getVehicleOwner(String id) {
		return null;
	}
	
}
