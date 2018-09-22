package com.bernardudu.vehiclefleetmanager;

/**
 * @author bernardudu
 *
 */
public class Truck extends Vehicle {
	private Integer towingCapacity;
	
	//Truck constructor that assigns all of Vehicle and specific Truck attributes
	public Truck(Integer tCapacity, String make, String vin, Integer capacity, Integer year, Integer mileage, Integer numCapacity,
			Integer mpg) {
		super(make, vin, capacity, year, mileage, numCapacity, mpg);
		
		if(make == null){
			throw new InvalidVehicleTypeException(make);
		}
		this.towingCapacity = tCapacity;
	}

	//Default Truck constructor
	Truck(){}

	public Integer getTowingCapacity() {
		return towingCapacity;
	}

	public void setTowingCapacity(Integer towingCapacity) {
		this.towingCapacity = towingCapacity;
	}

	@Override
	public String formatAttributesToString() {
		return "<truck>" + 
				"<make>"+make+"</make>"+
				"<vin>"+ vin+"</vin>"+
				"<capacity>"+ capacity+"</capacity>"+
				"<year>"+ year+"</year>"+
				"<mileage>"+ mileage+"</mileage>"+
				"<numCapacity>"+ numCapacity+"</numCapacity>"+
				"<mpg>"+ mpg+"</mpg>"+
				"<towingCapacity>"+ towingCapacity+"</towingCapacity>"+
				"</truck>";
	}

	@Override
	public void parseString(String line) { 
        make  = line.substring(line.indexOf("<make>") + 6, line.indexOf("</make>"));    
        vin = line.substring(line.indexOf("<vin>") + 5, line.indexOf("</vin>"));
        try{
	        capacity = Integer.parseInt(line.substring(line.indexOf("<capacity>") + 10, line.indexOf("</capacity>")));
	        year = Integer.parseInt(line.substring(line.indexOf("<year>") + 6, line.indexOf("</year>")));
	        mileage = Integer.parseInt(line.substring(line.indexOf("<mileage>") + 9, line.indexOf("</mileage>")));
	        numCapacity = Integer.parseInt(line.substring(line.indexOf("<numCapacity>") + 13, line.indexOf("</numCapacity>")));
	        mpg = Integer.parseInt(line.substring(line.indexOf("<mpg>") + 5, line.indexOf("</mpg>")));
	        towingCapacity = Integer.parseInt(line.substring(line.indexOf("<towingCapacity>") + 16, line.indexOf("</towingCapacity>")));
        }
        catch (Exception e)
        {
            System.out.println("Truck parse string error " + e.getMessage());
        }
	}

	@Override
	public Integer calculateMileage() {
		Integer gasUsed = 0;
		return mpg = mileage / (numCapacity - gasUsed);
	}

}
