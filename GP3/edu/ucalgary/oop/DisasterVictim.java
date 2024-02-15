package edu.ucalgary.oop;

import java.util.regex.*;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
//    private MedicalRecord[] medicalRecords;
//    private FamilyRelation[] familyConnections;
    private final String ENTRY_DATE;
    private Supply[] personalBelongings = new Supply[5];
    private String gender;
    private static int counter;
//    private static final String REGEX = "^(\\d{4})(\\d{2})(\\d{2})\\.(\\d{2})(\\d{2})(\\d{2}) User:(.{4}) Door:(.{3})$";
    private static final String REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    private static final Pattern PATTERN = Pattern.compile(REGEX);

    // Constructor
    DisasterVictim(String firstName, String ENTRY_DATE) throws IllegalArgumentException {
        Matcher match = PATTERN.matcher(ENTRY_DATE);
        boolean matchFound = match.find();
        if (matchFound) {
            this.firstName = firstName;
            this.ENTRY_DATE = ENTRY_DATE;
            this.ASSIGNED_SOCIAL_ID = counter;
            DisasterVictim.counter += 1;
        } else {
            throw new IllegalArgumentException("IllegalArgumentException: Not a valid date: " + ENTRY_DATE);
        }
    }
    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getComments() {
        return comments;
    }

//    public MedicalRecord[] getMedicalRecords() {
//        return medicalRecords;
//    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

//    public FamilyRelation[] getFamilyConnections() {
//        return familyConnections;
//    }

    public String getGender() {
        return gender;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException{
        // some logic to check format of date
        Matcher match = PATTERN.matcher(dateOfBirth);
        boolean matchFound = match.find();
        if (matchFound) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new IllegalArgumentException("IllegalArgumentException: Not a valid date: " + dateOfBirth);
        }
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

//    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
//        this.medicalRecords = medicalRecords;
//    }

    public void setPersonalBelongings(Supply[] supplies) {
        this.personalBelongings = supplies;
    }

//    public void setFamilyConnections(FamilyRelation[] relations) {
//        this.familyConnections = relations;
//    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addPersonalBelonging(Supply supply) {
        Supply[] temp = new Supply[personalBelongings.length + 1];
        int i = 0;
        for ( ; i < this.personalBelongings.length; i++) {
            temp[i] = this.personalBelongings[i];
        }
        temp[i] = supply;
        this.personalBelongings = temp;
    }

    public void removePersonalBelonging(Supply supply) {
        for (int i = 0; i < this.personalBelongings.length; i++) {
            if (this.personalBelongings[i] == supply) { //if the item is found
                Supply[] temp = new Supply[personalBelongings.length - 1];
                int j = 0;
                for ( ; j < i; j++) {
                    temp[j] = this.personalBelongings[j];
                }
                if (i != this.personalBelongings.length) {
                    for ( ; j < this.personalBelongings.length - 1; j++) { //removing the item
                        temp[j] = this.personalBelongings[j+1];
                    }
                }
                this.personalBelongings = temp;
            }
        }
    }
    /*
    public void addFamilyConnection(FamilyRelation familyConnection) {
        FamilyRelation[] temp = new FamilyRelation[personalBelongings.length + 1];
        int i = 0;
        for ( ; i < this.familyConnections.length; i++) {
            temp[i] = this.familyConnections[i];
        }
        temp[i] = familyConnection;
        this.familyConnections; = temp;
    }

    public void removeFamilyConnction(FamilyRelation familyConnection) {
        for (int i = 0; i < this.familyConnections.length; i++) {
            if (this.familyConnections[i] == supply) { //if the item is found
                FamilyRelation[] temp = new FamilyRelation[familyConnection.length - 1];
                int j = 0;
                for ( ; j < i; j++) {
                    temp[j] = this.familyConnections[j];
                }
                if (i != this.familyConnections.length) {
                    for ( ; j < this.familyConnections.length - 1; j++) { //removing the item
                        temp[j] = this.familyConnections[j+1];
                    }
                }
                this.familyConnections = temp;
            }
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord[] temp = new MedicalRecord[personalBelongings.length + 1];
        int i = 0;
        for ( ; i < this.medicalRecords.length; i++) {
            temp[i] = this.medicalRecords[i];
        }
        temp[i] = medicalRecord;
        this.medicalRecords = temp;

    }
     */
}

