package com.model;

public class Garage {
	private int id;
	private String name;
	private String category;
	private String address;
	private String owner;
	private int contact;

	public Garage() {

	}

	public Garage(int id, String name, String category, String address, String owner, int contact) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.address = address;
		this.owner = owner;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

}
