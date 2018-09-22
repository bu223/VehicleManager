/**
 * 
 */
package com.bernardudu.vehiclefleetmanager;

/**
 * @author bernardudu
 *
 */
public class SUV extends Vehicle {
	private Integer towingCapacity;

	public SUV() {}

	public SUV(Integer tCapacity, String make, String vin, Integer capacity, Integer year, Integer mileage, Integer numCapacity,
			Integer mpg) {
		super(make, vin, capacity, year, mileage, numCapacity, mpg);
		
		if(make.isEmpty()){
			throw new InvalidVehicleTypeException(make);
		}
		this.towingCapacity = tCapacity;
	}

	/* (non-Javadoc)
	 * @see com.bernardudu.vehiclefleetmanager.Vehicle#formatAttributesToString()
	 */
	@Override
	public String formatAttributesToString() {
		return "<suv>" + 
				"<make>"+make+"</make>"+
				"<vin>"+ vin+"</vin>"+
				"<capacity>"+ capacity+"</capacity>"+
				"<year>"+ year+"</year>"+
				"<mileage>"+ mileage+"</mileage>"+
				"<numCapacity>"+ numCapacity+"</numCapacity>"+
				"<mpg>"+ mpg+"</mpg>"+
				"<towingCapacity>"+ towingCapacity+"</towingCapacity>"+
				"</suv>";
	}

	/* (non-Javadoc)
	 * @see com.bernardudu.vehiclefleetmanager.Vehicle#parseString(java.lang.String)
	 */
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
            System.out.println("SUV parse string error " + e.getMessage());
        }
	}

	/* (non-Javadoc)
	 * @see com.bernardudu.vehiclefleetmanager.Vehicle#calculateMileage()
	 */
	@Override
	public Integer calculateMileage() {
		return null;
	}

	public Integer getTowingCapacity() {
		return towingCapacity;
	}

	public void setTowingCapacity(Integer towingCapacity) {
		this.towingCapacity = towingCapacity;
	}

}
