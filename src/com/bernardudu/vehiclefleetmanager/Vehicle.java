package com.bernardudu.vehiclefleetmanager;

/**
 * @author bernardudu
 */
public abstract class Vehicle {
protected String make;
protected String vin;
protected Integer capacity;
protected Integer year;
protected Integer mileage;
protected Integer numCapacity;
protected Integer mpg;

public Vehicle(){}

public Vehicle(String make, String vin, Integer capacity, Integer year, Integer mileage, Integer numCapacity,
		Integer mpg) {
	super();
	this.make = make;
	this.vin = vin;
	this.capacity = capacity;
	this.year = year;
	this.mileage = mileage;
	this.numCapacity = numCapacity;
	this.mpg = mpg;
}

public abstract String formatAttributesToString();

public abstract void parseString(String readString);

public abstract Integer calculateMileage();

public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getVin() {
	return vin;
}
public void setVin(String vin) {
	this.vin = vin;
}
public Integer getCapacity() {
	return capacity;
}
public void setCapacity(Integer capacity) {
	this.capacity = capacity;
}
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}
public Integer getMileage() {
	return mileage;
}
public void setMileage(Integer mileage) {
	this.mileage = mileage;
}
public Integer getNumCapacity() {
	return numCapacity;
}
public void setNumCapacity(Integer numCapacity) {
	this.numCapacity = numCapacity;
}
public Integer getMpg() {
	return mpg;
	}
}
