package edu.ucalgary.oop;

public class ReliefService {
    
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String dateOfInquiry;
    private String infoProvided;
    

    ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry,String infoProvided, Location lastKnownLocation){

        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
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
        this.dateOfInquiry = dateOfInquiry;
    }
    public String getInfoProvided(){
        return infoProvided;
    }
    public Location getLastKnownLocation(){
        return lastKnownLocation;
    }
    public String getLogDetails(){
        return "Inquirer:" + this.inquirer.getFirstName() + " " + this.inquirer.getLastName() + ", Missing Person:"+ this.missingPerson.getFirstName() + " " + this.missingPerson.getLastName() + ", Date Of Inquiry:"+ this.dateOfInquiry + ", Info Provided: " + this.infoProvided + ", Last Known Location: " + this.lastKnownLocation.getName();
    }



}
