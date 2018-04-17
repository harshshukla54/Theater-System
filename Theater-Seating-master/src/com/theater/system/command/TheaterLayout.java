package com.theater.system.command;

import java.util.List;

/**
 * A standard Theater layout fields.
 * 
 * @author Harsh Shukla
 */
public class TheaterLayout {

    private int totalCapacity;
    private int availableSeats;
    //this list will hold the various section properties
    private List<TheaterSection> sections;

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<TheaterSection> getSections() {
        return sections;
    }

    public void setSections(List<TheaterSection> sections) {
        this.sections = sections;
    }
    
}
