package edu.ucalgary.oop;

import java.util.regex.*;

public class MedicalRecord {
	private Location location;
	private String treatmentDetails;
	private String dateOfTreatment;

	private static final String REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

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
	
	public String getTreatmentDetails() {
		return treatmentDetails;
	}
	
	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}
	public String getDateOfTreatment() {
		return dateOfTreatment;
	}
	public void setDateOfTreatment(String dateOfTreatment) {

		// Validate date format using regex pattern
        Matcher matcher = PATTERN.matcher(dateOfTreatment);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd format.");
        }
		this.dateOfTreatment = dateOfTreatment;
	}
	
}
