package com.example.petproject.entity;

public class Apartment {
	private int id;
	private String city;
	private int price;
	private int countOfRoom;

	public Apartment(int id, String city, int price, int room) {
		this.id = id;
		this.city = city;
		this.price = price;
		this.countOfRoom = room;
	}

	public Apartment( String city, int price, int room) {
		this.city = city;
		this.price = price;
		this.countOfRoom = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRoom() {
		return countOfRoom;
	}

	public void setRoom(int room) {
		this.countOfRoom = room;
	}
}
