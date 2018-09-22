package com.bernardudu.vehiclefleetmanager;

public class FleetManager {
	private Fleet fleet;
	
	public FleetManager(){
		fleet = new Fleet();
	}
	public void saveToFile(long fleetID){
		fleet.saveToFile(fleetID);
	}
	public void openFromFile(long fleetID){
		fleet.openFromFile(fleetID);
	}
	public void addVehicle(Vehicle vehicle){
		fleet.addVehicle(vehicle);
	}
	public void editVehicle(Vehicle vehicle){
		fleet.editVehicle(vehicle);
	}
	public void deleteVehicle(String vin){
		if(fleet != null){
		fleet.deleteVehicle(vin);
		}
	}
	
	public Fleet getFleet() {
		return fleet;
	}

}
