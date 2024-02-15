
package edu.ucalgary.oop;



public class FamilyRelation {
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;


    //constructor
    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    //setters
    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }
    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
    
    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }

    //getters
    public String getRelationshipTo() {
        return relationshipTo;
    }
    
    public DisasterVictim getPersonOne() {
        return personOne;
    }
    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

}