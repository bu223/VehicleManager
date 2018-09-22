package com.kuddu.addressbook;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Address() {}
	
	public Address(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
}
