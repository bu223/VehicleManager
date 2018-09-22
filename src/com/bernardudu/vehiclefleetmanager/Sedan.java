package com.bernardudu.vehiclefleetmanager;

public class Sedan extends Vehicle {

	public Sedan() {}

	public Sedan(String make, String vin, Integer capacity, Integer year, Integer mileage, Integer numCapacity,
			Integer mpg) {
		super(make, vin, capacity, year, mileage, numCapacity, mpg);
		
		if(make.isEmpty()){
			throw new InvalidVehicleTypeException(make);
		}
	}

	@Override
	public String formatAttributesToString() {
		return "<sedan>" + 
				"<make>"+make+"</make>"+
				"<vin>"+ vin+"</vin>"+
				"<capacity>"+ capacity+"</capacity>"+
				"<year>"+ year+"</year>"+
				"<mileage>"+ mileage+"</mileage>"+
				"<numCapacity>"+ numCapacity+"</numCapacity>"+
				"<mpg>"+ mpg+"</mpg>"+
				"</sedan>";
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
        }
        catch (Exception e)
        {
            System.out.println("Sedan parse string error " + e.getMessage());
        }
	}

	@Override
	public Integer calculateMileage() {
		
		return null;
	}

}
