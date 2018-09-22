package com.kuddu.addressbook;

import java.util.Vector;

import org.junit.Test;

public class AddressBookTester {
	public static void main(String[] args) {
		//addContactTest();
		//deleteContactTest();
		updateContactTest();
		//displayContactTest();
	}
	@Test
	public static void addContactTest() {
		AddressBook addrbk = new AddressBook();
		
		addrbk.addPerson(new Person("Bernard", "Udu", "212-232-3232", new Address("123 Figure Str", "Aiea", "HI", "76865")));
		addrbk.addPerson(new Person("Emma", "Udu", "212-232-2214", new Address("155P Figure Str", "Perly", "HI", "02210")));
		addrbk.addPerson(new Person("Jane", "Udu", "212-232-5885", new Address("123 Rocky Str", "kent", "HI", "21545")));
		addrbk.addPerson(new Person("Rita", "Udu", "212-232-3654", new Address("123 Figure Str", "Aiea", "HI", "74581")));
	 		 		
     	Vector<Person> people = addrbk.getPeople();
     	for (int x = 0; x < people.size(); x++){
     		System.out.println(people.get(x).toString());
     		}
     	}
	@Test
	public static void deleteContactTest(){
		
		AddressBook addbk = new AddressBook();
        Vector<Person> people = addbk.getPeople();
        
		try{
			addbk.addPerson(new Person("Bernard", "Udu", "212-232-3232", new Address("123 Figure Str", "Aiea", "HI", "76865")));
			addbk.addPerson(new Person("Emma", "Udu", "212-232-2214", new Address("155P Figure Str", "Perly", "HI", "02210")));
			addbk.addPerson(new Person("Jane", "Udu", "212-232-5885", new Address("123 Rocky Str", "kent", "HI", "21545")));
			
			System.out.println("Total contacts: "+people.size());
			String phone = null;
			while(!people.isEmpty()){
				for (int y = 0; y < people.size();) {
					phone = people.get(y).getPhone();
					addbk.deletePerson(phone);
					System.out.println("Deleted contact with phone id: "+phone);
					}
				}
			} catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Delete contact test case error: " + e.getMessage());
				}
		}
	@Test
	public static void updateContactTest(){
		AddressBook addbk = new AddressBook();
        Vector<Person> people = addbk.getPeople();
        
		try{
			addbk.addPerson(new Person("Bernard", "Udu", "212-232-3232", new Address("123 Figure Str", "Aiea", "HI", "76865")));
			addbk.addPerson(new Person("Emma", "Udu", "212-232-2214", new Address("155P Figure Str", "Perly", "HI", "02210")));
			addbk.addPerson(new Person("Jane", "Udu", "212-232-5885", new Address("123 Rocky Str", "kent", "HI", "21545")));
			for(int i=0;i<people.size();i++){
				System.out.println("Original contact list: "+people.get(i));
				}
			System.out.println("");
			addbk.updatePerson(new Person("Emma", "Oli", "212-232-2214", new Address("123 Yon Str", "Ried", "HI", "96998")), 1,true);
			for(int i=0;i<people.size();i++){
				System.out.println("updated contact list: "+people.get(i));
				}
			}catch(Exception e){
				System.out.println("Updating contact error: "+e.getStackTrace());
				}
		}
	@Test
	public static void displayContactTest(){
		AddressBook addbk = new AddressBook();
        
		try{
			addbk.addPerson(new Person("Bernard", "Udu", "212-232-3232", new Address("123 Figure Str", "Aiea", "HI", "76865")));
			addbk.addPerson(new Person("Emma", "Udu", "212-232-2214", new Address("155P Figure Str", "Perly", "HI", "02210")));
			addbk.addPerson(new Person("Jane", "Udu", "212-232-5885", new Address("123 Rocky Str", "kent", "HI", "21545")));
			
			addbk.displayPeople(addbk.getPerson());
			
			}catch(Exception e){
		System.out.println("Updating contact error: "+e.getStackTrace());
		}
	}
}

