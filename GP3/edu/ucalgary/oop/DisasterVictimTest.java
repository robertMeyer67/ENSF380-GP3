/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private List<Supply> suppliesToSet; 
    private List<FamilyRelation> familyRelations;
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female"; 
    public class DisasterVictimTest {
        private String expectedFirstName = "John";
        private String EXPECTED_ENTRY_DATE = "2024-01-20";
        private String invalidDate = "2024/01/20";
        private String expectedComments = "Needs medical attention and speaks 2 languages";

        @Before
        public void setUp() {
            victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
            suppliesToSet = new LinkedList<>();
            suppliesToSet.add(new Supply("Water Bottle", 10));
            suppliesToSet.add(new Supply("Blanket", 5));
            
            DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
            DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
            
        }

        @Test
        public void testConstructorWithValidEntryDate() {
            String validEntryDate = "2024-01-18";
            DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
            assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
            assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
        }

        @Test(expected = IllegalArgumentException.class)
        public void testConstructorWithInvalidEntryDateFormat() {
            String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
            new DisasterVictim("Freda", invalidEntryDate);
          
        }

        @Test
        public void testSetDateOfBirth() {
            String newDateOfBirth = "1987-05-21";
            victim.setDateOfBirth(newDateOfBirth);
            assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
        }

        @Test(expected = IllegalArgumentException.class)
        public void testSetDateOfBirthWithInvalidFormat() {
            victim.setDateOfBirth(invalidDate); // This format should cause an exception
        }

        @Test
        public void testSetAndGetFirstName() {
            String newFirstName = "Alice";
            victim.setFirstName(newFirstName);
            assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
        }

        @Test
        public void testSetAndGetLastName() {
            String newLastName = "Smith";
            victim.setLastName(newLastName);
            assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
        }

        @Test
        public void testGetComments() {
            victim.setComments(expectedComments);
            assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
        }

        @Test
        public void testSetComments() {
            victim.setComments(expectedComments);
            String newComments = "Has a minor injury on the left arm and eats pasta";
            victim.setComments(newComments);
            assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
        }

        @Test
        public void testGetAssignedSocialID() {
            // The next victim should have an ID one higher than the previous victim
            // Tests can be run in any order so two victims will be created
            DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
            int expectedSocialId = newVictim.getAssignedSocialID() + 1;
            DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

            assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
        }

        @Test
        public void testGetEntryDate() {
            assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
        }

        @Test
        public void testSetAndGetGender() {
            String newGender = "male";
            victim.setGender(newGender);
            assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
        }

        @Test
        public void testAddFamilyConnection() {
            DisasterVictim victim1 = new DisasterVictim("Mark", "2024-01-20");
            DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

            FamilyRelation relation = new FamilyRelation(victim2, "sibling", victim1);
            LinkedList<FamilyRelation> expectedRelations = new LinkedList<>();
            expectedRelations.add(relation);
            victim2.setFamilyConnections(expectedRelations);

            LinkedList<FamilyRelation> testFamily = victim2.getFamilyConnections();
            boolean correct = false;

            if ((testFamily != null) && (testFamily.getFirst() == expectedRelations.getFirst())) {
                correct = true;
            }
            assertTrue("addFamilyConnection should add a family relationship", correct);
        }

        @Test
        public void testAddPersonalBelonging() {
            Supply newSupply = new Supply("Emergency Kit", 1);
            victim.addPersonalBelonging(newSupply);
            LinkedList<Supply> testSupplies = victim.getPersonalBelongings();
            boolean correct = false;

            for (Supply supply : testSupplies) {
                if (supply == newSupply) {
                    correct = true;
                    break;
                }
            }
            assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
        }

        @Test
        public void testRemoveFamilyConnection() {
            DisasterVictim victim1 = new DisasterVictim("Mark", "2024-01-20");
            DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
            FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
            FamilyRelation relation2 = new FamilyRelation(victim, "parent", victim2);
            LinkedList<FamilyRelation> expectedRelations = new LinkedList<>();
            expectedRelations.add(relation2);
            LinkedList<FamilyRelation> originalRelations = new LinkedList<>();
            originalRelations.add(relation1);
            originalRelations.add(relation2);
            victim.setFamilyConnections(originalRelations);

            DisasterVictim victim = new DisasterVictim("Freda", "2024-01-23");
            victim.addFamilyConnection(relation1);
            victim.addFamilyConnection(relation2);
            victim.removeFamilyConnection(relation1);

            LinkedList<FamilyRelation> testFamily = victim.getFamilyConnections();
            boolean correct = true;

            for (FamilyRelation relation : testFamily) {
                if (relation == relation1) {
                    correct = false;
                    break;
                }
            }
            assertTrue("removeFamilyConnection should remove the family member", correct);
        }

        @Test
        public void testRemovePersonalBelonging() {
            Supply supplyToRemove = suppliesToSet.getFirst();
            victim.addPersonalBelonging(supplyToRemove);
            victim.removePersonalBelonging(supplyToRemove);

            LinkedList<Supply> testSupplies = victim.getPersonalBelongings();
            boolean correct = true;

            for (Supply supply : testSupplies) {
                if (supply == supplyToRemove) {
                    correct = false;
                    break;
                }
            }
            assertTrue("removePersonalBelonging should remove the supply from personal belongings", correct);
        }

        @Test
        public void testSetFamilyConnection() {
            DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
            DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

            FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
            LinkedList<FamilyRelation> expectedRelations = new LinkedList<>();
            expectedRelations.add(relation);
            victim1.setFamilyConnections(expectedRelations);
            boolean correct = true;

            LinkedList<FamilyRelation> actualRecords = victim1.getFamilyConnections();
            if (expectedRelations.size() != actualRecords.size()) {
                correct = false;
            } else {
                for (int i = 0; i < actualRecords.size(); i++) {
                    if (expectedRelations.get(i) != actualRecords.get(i)) {
                        correct = false;
                        break;
                    }
                }
            }
            assertTrue("Family relation should be set", correct);
        }

        @Test
        public void testSetMedicalRecords() {
            Location testLocation = new Location("Shelter 666", "123 Cool St.");
            MedicalRecord testRecord = new MedicalRecord(testLocation, "test for vaccine", "2024-02-09");
            boolean correct = true;

            LinkedList<MedicalRecord> newRecords = new LinkedList<>();
            newRecords.add(testRecord);
            victim.setMedicalRecords(newRecords);
            LinkedList<MedicalRecord> actualRecords = victim.getMedicalRecords();

            if (newRecords.size() != actualRecords.size()) {
                correct = false;
            } else {
                for (int i = 0; i < newRecords.size(); i++) {
                    if (actualRecords.get(i) != newRecords.get(i)) {
                        correct = false; 
                        break;
                    }
                }
            }
            assertTrue("setMedicalRecords should correctly update medical records", correct);
        }

        @Test
        public void testSetPersonalBelongings() {
            Supply one = new Supply("Tent", 1);
            Supply two = new Supply("WaterBottle", 3);
            LinkedList<Supply> newSupplies = new LinkedList<>();
            newSupplies.add(one);
            newSupplies.add(two);
            boolean correct = true;

            victim.setPersonalBelongings(newSupplies);
            LinkedList<Supply> actualSupplies = victim.getPersonalBelongings();

            if (newSupplies.size() != actualSupplies.size()) {
                correct = false;
            } else {
                for (int i = 0; i < newSupplies.size(); i++) {
                    if (actualSupplies.get(i) != newSupplies.get(i)) {
                        correct = false;
                        break;
                    }
                }
            }
            assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
        }

        @Test
        public void testAddDietaryRestriction() {
            DietaryRestriction restriction = new DietaryRestriction("Vegan");
            victim.addDietaryRestriction(restriction);
            List<DietaryRestriction> restrictions = victim.getDietaryRestrictions();
            boolean correct = false;

            for (DietaryRestriction r : restrictions) {
                if (r.equals(restriction)) {
                    correct = true;
                    break;
                }
            }
            assertTrue("addDietaryRestriction should add the dietary restriction", correct);
        }

        @Test
        public void testGetDietaryRestrictions() {
            List<DietaryRestriction> restrictions = victim.getDietaryRestrictions();
            assertNotNull("getDietaryRestrictions should return a non-null list", restrictions);
        }
    }
}