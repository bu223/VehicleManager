package com.kuddu.addressbook;

public class Person {
	private String firstname;
	private String lastname;
	private String phone;
	private Address address;
	
	public Person(String firstname, String lastname, String phone, Address address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
	}
	public Person(){}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	public String toString() {
		return "firstname = "+firstname+
				" lastname = "+ lastname+
				" phone = "+ phone+
				" address = "+ address;
	}
	public String getPhone() {
		return phone;
	}
}
