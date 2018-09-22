package com.bernardudu.vehiclefleetmanager;

import java.util.Vector;

public class FleetTester {

	public static void main(String[] args) {
		//testcase1();
		//testcase2();
		testcase3();
		//testcase4();
		//testcase5();
		//testcase6();
		//testcase7();

	}
	public static void testcase1()
    {
        Fleet fleet = new Fleet();
        Truck tk = new Truck();
        SUV sv = new SUV();
        Sedan sd = new Sedan();
        
        try
        {
        	tk = new Truck(10000, "GMC", "1G1PC5SB2D7133169", 7, 2015, 13000, 8, 19);
            fleet.addVehicle(tk);
            
           sv = new SUV(4000, "BMW", "1HD1DAL16NY129063", 5, 2014, 25000, 6, 22);
            fleet.addVehicle(sv);
            
            sd = new Sedan("Honda", "1FMEE11F9FHB96171", 3, 2011, 33000, 4, 28);
            fleet.addVehicle(sd);
            
            System.out.println("Test Case 1: Creates a fleet, displays it's content");
            Vector<Vehicle> vehicle = fleet.getVehicles();
            for (int x = 0; x < vehicle.size(); x++)
                System.out.println(vehicle.get(x).formatAttributesToString());
            } catch (Exception e){
            	System.out.println("Test case 1 error: " + e.getMessage());
            	}
        System.out.println("mpg = " + tk.calculateMileage());
        System.out.println("");
        }
	public static void testcase2()
    {
        try{
        	Fleet fleet = new Fleet();
            Truck tk = new Truck();
            SUV sv = new SUV();
            Sedan sd = new Sedan();
            
            tk = new Truck(12000, "Ford", "1FT7W2BT9EEA99024", 5, 2010, 8000, 8, 14);
            fleet.addVehicle(tk);
            fleet.addVehicle(new Truck(1000, "Ford", "4E3AL54F6TE480780", 5, 2001, 8000, 8, 11));
            fleet.addVehicle(new Truck(3000, "Chevrolet", "1G1YV2DW2B5131461", 5, 2017, 8000, 8, 20));
            
           sv = new SUV(4000, "Hyundai", "1G1AN69N3BJ237840", 5, 2014, 25000, 6, 22);
            fleet.addVehicle(sv);
            
            sd = new Sedan("Lexus", "1GDHC34T3GJ525697", 3, 2011, 33000, 4, 28);
            fleet.addVehicle(sd);
            
            System.out.println("Test Case 2: Creates a fleet with multiple trucks");

            String vehicle;
            Vector<Vehicle> myVehicle = fleet.getVehicles(); 
            for (int y = 0; y < myVehicle.size(); y++) {
            	vehicle = myVehicle.get(y).formatAttributesToString(); 
                System.out.println(vehicle);
                }
            System.out.println("Number of vehicles in fleet = " + fleet.getVehicles().size());
            } catch (Exception e){
            System.out.println("Test case 2 error: " + e.getMessage());
            }
        System.out.println("");
        }
	public static void testcase3()
    {
        try
        {
            Fleet fleet = new Fleet();
            
            fleet.addVehicle(new Truck(1000, "Ford", "4E3AL54F6TE480780", 5, 2001, 8000, 8, 11));
            fleet.addVehicle(new SUV(3000, "Chevrolet", "1G1YV2DW2B5131461", 5, 2017, 8000, 8, 20));
            fleet.addVehicle(new SUV(1000, "Ford", "5B3AL54F6TE480780", 5, 2001, 8000, 8, 11));
            fleet.addVehicle(new Sedan("Chevrolet", "P91YV2DW2B5131461", 5, 2017, 8000, 8, 20));
            
            fleet.saveToFile(fleet.getFleetID());
            
            System.out.println("Test Case 3: creates a fleet and saves it to a file");

            String vehicle;
            Vector<Vehicle> myVehicles = fleet.getVehicles();
            for (int z = 0; z < myVehicles.size(); z++) {
                vehicle = myVehicles.get(z).formatAttributesToString();
                System.out.println(vehicle);
                }
            System.out.println("Number of vehicles in fleet = " + fleet.getVehicles().size());
            } catch (Exception e){
            	System.out.println("Test case 3 error: " + e.getMessage());
            	}
        System.out.println("");
        }
	public static void testcase4()
    {
        try
        {
            System.out.println("Test Case 4 : load existing fleet from file and delete file");
            
            FleetManager fmgt = new FleetManager();
            fmgt.openFromFile(1512265203809L);
            Fleet ft = fmgt.getFleet();
            
            Vector<Vehicle> myVehicles = ft.getVehicles();
            String vehicle;
            for (int z = 0; z < myVehicles.size(); z++) {
            	vehicle = myVehicles.get(z).formatAttributesToString();
                System.out.println(vehicle);
            }
            	System.out.println("Number of vehicles in fleet = " + ft.getVehicles().size());
            	
            	ft.deleteFile();
            
        } catch (Exception e){
            System.out.println("Test case 4 error: " + e.getMessage());
        }
        System.out.println("");
        }
	public static void testcase5()
    {
        try
        {
            Fleet fleet = new Fleet();

            fleet.addVehicle(new Truck(1000, "Ford", "4E3AL54F6TE480780", 5, 2001, 8000, 8, 11));
            fleet.addVehicle(new SUV(3000, "Chevrolet", "1G1YV2DW2B5131461", 5, 2017, 8000, 8, 20));
            fleet.addVehicle(new Sedan("Honda", "P91YV2DW2B5131461", 5, 2017, 8000, 8, 20));
            
            fleet.saveToFile(fleet.getFleetID());
            System.out.println("Test Case 5: create fleet with 3 vehicles and delete all ");
            String vehicle = null;
            Vector<Vehicle> myVehicles = fleet.getVehicles();
            do{
            	for (int y = 0; y < myVehicles.size(); y++) {
                    vehicle = myVehicles.get(y).getVin();
                    fleet.deleteVehicle(vehicle);
            	}
            }while(vehicle != null);
            	System.out.println(vehicle);
            } catch (Exception e){
            	System.out.println("Test case 5 error: " + e.getMessage());
            	}
        System.out.println("");
        }
	public static void testcase6()
    {
		Fleet fleet = new Fleet();
        
        fleet.saveToFile(fleet.getFleetID());
        System.out.println("Test Case 6: test null vehicle make");

        try {
        	fleet.addVehicle(new Truck(1000, "Ford", "4E3AL54F6TE480780", 5, 2001, 8000, 8, 11));
        } catch (Exception e) {
            System.out.println("Error: truck not added " + e.getMessage());
        }
        
        try {
            fleet.addVehicle(new SUV(1000, null, "4E3AL54F6TE480780", 5, 2001, 8000, 8, 11));
        } catch (Exception e) {
            System.out.println("Error: SUV not added: " + e.getMessage());
        }
        fleet.saveToFile(fleet.getFleetID());

        System.out.println("Number of added vehicles = " + fleet.getVehicles().size());

        System.out.println("");
        }
	public static void testcase7()
    {
		Fleet fleet = new Fleet();
        
        System.out.println("Test case 7: Testing Truck constructor for invalid vehicle type");
        try {
        	fleet.addVehicle(new Truck(1000, null, "4E3AL54F6TE480780", 5, 2001, 8000, 8, 11));
        } catch (Exception e) {
            System.out.println("Truck Error:" + e.getMessage());
        }
        System.out.println("Number of added vehicles = " + fleet.getVehicles().size());
        }
	}
