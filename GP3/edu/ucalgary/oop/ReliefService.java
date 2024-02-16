package edu.ucalgary.oop;
import java.util.regex.*;

public class ReliefService {
    
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String dateOfInquiry;
    private String infoProvided;
    
    private static final String REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry,String infoProvided, Location lastKnownLocation){

        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        setDateOfInquiry(dateOfInquiry);
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
        
    }
    public Inquirer getInquirer(){
        return inquirer;
    }
    public DisasterVictim getMissingPerson(){
        return missingPerson;
    }

    public String getDateOfInquiry(){
        return dateOfInquiry;
    }
    
    public void setDateOfInquiry(String dateOfInquiry){
        // Validate date format using regex pattern
        Matcher matcher = PATTERN.matcher(dateOfInquiry);
        if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd format.");
            }
        this.dateOfInquiry = dateOfInquiry;
    }
    public String getInfoProvided(){
        return infoProvided;
    }
    public Location getLastKnownLocation(){
        return lastKnownLocation;
    }
    public String getLogDetails(){
        return "Inquirer:" + this.inquirer.getFirstName() + ", Missing Person:"+ this.missingPerson.getFirstName() + " " + this.missingPerson.getLastName() + ", Date Of Inquiry: "+ this.dateOfInquiry + ", Info Provided: " + this.infoProvided + ", Last Known Location: " + this.lastKnownLocation.getName();
    }
}
