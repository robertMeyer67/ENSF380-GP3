package edu.ucalgary.oop;

public class Supply {
	//fields
	private String type;
	private int quantity;
	
	//constructor
	public Supply(String type, int quantity) {
		this.type = type;
		this.quantity = quantity;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
