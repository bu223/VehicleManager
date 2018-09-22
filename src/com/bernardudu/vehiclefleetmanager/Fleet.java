/**
 * 
 */
package com.bernardudu.vehiclefleetmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Vector;

/**
 * @author bernardudu
 *
 */
public class Fleet {
private Vector<Vehicle> vehicles;
private long fleetID;

public Fleet(){
	vehicles = new Vector<Vehicle>();
	fleetID = Calendar.getInstance().getTimeInMillis();
	}

public void saveToFile(long fleetID){
	try {
		PrintWriter writer = new PrintWriter( new Long(fleetID).toString()+".txt");

		writer.println("<fleet>"+ fleetID + "</fleet>");
		
		for(int veh = 0; veh < vehicles.size(); veh++){
			Vehicle vehicle = vehicles.elementAt(veh);
			writer.println(vehicle.formatAttributesToString());
			}
		writer.close();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
}

public void openFromFile(long fleetID){
	try {
		vehicles = new Vector<Vehicle>();
		FileInputStream finput = new FileInputStream(String.valueOf(fleetID).toString()+".txt");
        BufferedReader bdreader = new BufferedReader(new InputStreamReader(finput));
        String line = null;

        line = bdreader.readLine();
        fleetID = Long.parseLong(line.substring(line.indexOf("<fleet>") + 7, line.indexOf("</fleet>")));
        
        while (line != null){
    		
        	if (line.substring(0, 7).equals("<truck>")){
        		try {
        			Truck tk = new Truck();
            		tk.parseString(line);
            		vehicles.add(tk);
            		} catch (InvalidVehicleTypeException e) {
            			System.out.println("Vehicle was not added "+ e.getLocalizedMessage());
            			}
        		}
        	else if(line.substring(0, 5).equals("<suv>")){
        		SUV sv = new SUV();
        		sv.parseString(line);
        		vehicles.add(sv);
        		}
        	else if(line.substring(0, 7).equals("<sedan>")){
        		Sedan sd = new Sedan();
        		sd.parseString(line);
        		vehicles.add(sd);
        		}
        	}
        bdreader.close();
        }catch (IOException e) {
        	System.out.println(e.getMessage());
        	}
	}

public void deleteFile(){
	File file = new File(String.valueOf(getFleetID()).toString()+".txt");
	if(file.exists()){
		file.delete();
	}
}

public void addVehicle(Vehicle vehicle){
	vehicles.add(vehicle); //add a vehicle into the list of vehicles
}

public void editVehicle(Vehicle vehicle){
	//loop over all vehicles in the list
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getClass().equals(vehicle)){
				vehicles.setElementAt(vehicle, i); //update the vehicle at the specified index
				break; //end loop
			}
		}
}

public void deleteVehicle(String vin){
	//loop over all vehicles in the list
	for (int i = 0; i < vehicles.size(); i++) {
		//look for a vehicle and remove it from the list
		if (vehicles.get(i).getVin().equalsIgnoreCase(vin)){
			vehicles.removeElementAt(i);
			break;
		}
	}
}

public Vector<Vehicle> getVehicles() {
	return vehicles;
	}

public void setVehicles(Vector<Vehicle> vehicles) {
	this.vehicles = vehicles;
	}

public long getFleetID() {
	return fleetID;
	}

public void setFleetID(long fleetID) {
	this.fleetID = fleetID;
	}
}
