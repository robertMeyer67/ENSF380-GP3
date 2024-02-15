package edu.ucalgary.oop;


public class location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;
    

    //constructor
    public location(String name, String address) {
        this.name = name;
        this.address = address;
    }
    

    //setters
    public void setOccupants(DisasterVictim[] occupants) {
        this.occupants = occupants;
    }
    public void setSupplies(Supply[] supplies) {
        this.supplies = supplies;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
   
    public void setAddress(String address) {
        this.address = address;
    }
    

    //getters

    public DisasterVictim[] getOccupants() {
        return occupants;
    }
    

    
    public Supply[] getSupplies() {
        return supplies;
    }
    
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    
   
    //methods to add and remove occupants and supplies
    public void addOccupant(DisasterVictim occupant) {
        DisasterVictim[] list = new DisasterVictim[occupants.length + 1];
        int i = 0;
        for (; i < occupants.length; i++) {
            list[i] = occupants[i];
        }
        list[i] = occupant;
        occupants = list;
    }
    
    public void removeOccupant(DisasterVictim occupant) {
        if (occupants != null) {
            int index = -1; // i = -1 means not found, yes?
            for (int i = 0; i < occupants.length; i++) {
                if (occupants[i] == occupant) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                DisasterVictim[] list = new DisasterVictim[occupants.length - 1];
                int j = 0;
                for (int i = 0; i < occupants.length; i++) {
                    if (i != index) {
                        list[j] = occupants[i];
                        j++;
                    }
                }
                occupants = list;
            }
        }
    }
    

    //methods to add and remove supplies
    
    public void addSupply(Supply supply) {
        Supply[] list = new Supply[supplies.length + 1];
        int i = 0;
        for (; i < supplies.length; i++) {
            list[i] = supplies[i];
        }
        list[i] = supply;
        supplies = list;
    }

    public void removeSupply(Supply supply) {
        if (supplies != null) {
            int index = -1; // i = -1 means not found, yessir
            for (int i = 0; i < supplies.length; i++) {
                if (supplies[i] == supply) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                Supply[] list = new Supply[supplies.length - 1]; 
                int j = 0;
                for (int i = 0; i < supplies.length; i++) {
                    if (i != index) {
                        list[j] = supplies[i];
                        j++;
                    }
                }
                supplies = list;
            }
        }
    }
}
