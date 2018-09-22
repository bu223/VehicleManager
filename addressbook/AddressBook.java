package com.kuddu.addressbook;

import java.util.Vector;

public class AddressBook {
	private Person person;
	private Vector<Person> people;
	
	public AddressBook() {

		person = new Person();
		people = new Vector<Person>();
	}

	public Person getPerson() {
		return person;
	}
	public void addPerson(Person person){
		people.add(person);
	}
	public void deletePerson(String phone){
		for(int i = 0; i < people.size(); i++){
			if(people.get(i).getPhone().equals(phone)){
				people.removeElementAt(i);
				break;
			}
		}
	}

	public void updatePerson(Person person, int index, boolean isChangedPerson){
		for(int i = 0; i < people.size();){
			people.set(i, person);
			isChangedPerson = true;
			break;
			}
		}
	
	public void displayPeople(Person contact){
		for(int i = 0; i < people.size(); i++){
			System.out.println("Contact"+i+": "+ people.get(i));
		}
	}

	public Vector<Person> getPeople() {
		return people;
	} 
	
}