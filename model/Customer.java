package model;

public class Customer {
// every customer has an identification 
	 private int id;
	
	 private int arrivalTime;
	 private int departTime ;
	 private int service ;
	 
	public Customer (int id ,int arrivalTime ,int service ) {
	this.id = id ;
	this.arrivalTime = arrivalTime ;
	this.departTime = arrivalTime + service;
	this.service = service ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getDepartTime() {
		return departTime;
	}

	public void setDepartTime(int departTime) {
		this.departTime = departTime;
	}

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
	}
	public void decrementService() {
		this.service -- ;
	}
}
