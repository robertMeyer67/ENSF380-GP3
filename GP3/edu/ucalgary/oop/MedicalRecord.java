package edu.ucalgary.oop;

public class MedicalRecord {
	private Location location;
	private String treatmentDetails;
	private String dateOfTreatment;
	
	//constructor
	public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
		this.location = location;
		this.treatmentDetails = treatmentDetails;
		//we use this method for setting dateOfTreatment
		setDateOfTreatment(dateOfTreatment);
	}
	
	//Getters and Setters
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getTreatementDetails() {
		return treatmentDetails;
	}
	
	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}
	public String getDateOfTreatment() {
		return dateOfTreatment;
	}
	public void setDateOfTreatment(String dateOfTreatment) {
		//insert code here for throwing an exception
		this.dateOfTreatment = dateOfTreatment;
	}
	
	

}
