package edu.ucalgary.oop;

public class ReliefService {
    
    private Inquirer Inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String dateOfInquiry;
    private String infoProvided;
    

    Public ReliefService(Inquirer Inquirer, DisasterVictim missingPerson,Location lastKnownLocation){

        this.inquirer = Inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = Location;
        
    }
    public Inquirer getInquirer(){
        return inquirer;
    }
    public DisasterVictim getMissingPerson(){
        return missingPerson;
    }

    Public String getDateOfInquiry(){
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
        return "Inquirer:" + Inquirer.getName() + ", Missing Person:"+ missingPerson.getName() + ", Date Of Inquiry:"+ dateOfInquiry + ", Info Provided: " + infoProvided + ", Last Known Location: " + lastKnownLocation.getName();
    }



}
