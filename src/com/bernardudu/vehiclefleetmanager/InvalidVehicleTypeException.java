package com.bernardudu.vehiclefleetmanager;

public class InvalidVehicleTypeException extends RuntimeException {
/**
* 
*/
	private static final long serialVersionUID = 6457311053017260423L;
public String vehicleType;
public String toString() {
	return this.getClass().getSimpleName() + " Vehicle type is invalid: "+ vehicleType;
	}

public InvalidVehicleTypeException(String vehicleType){
	super("Vehicle type is invalid: " + vehicleType);
	this.vehicleType = vehicleType;
	}
}
