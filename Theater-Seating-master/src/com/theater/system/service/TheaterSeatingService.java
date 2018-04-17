package com.theater.system.service;

import java.util.List;

import com.theater.system.command.TheaterLayout;
import com.theater.system.command.TheaterRequest;

/**
 * Interface to bind the different service request to get the theater ticket request,layout and processs the service
 * 
 * @author Harsh Shukla
 */

public interface TheaterSeatingService {
    
    TheaterLayout getTheaterLayout(String rawLayout);
    
    List<TheaterRequest> getTicketRequests(String ticketRequests);
    
    void processTicketRequests(TheaterLayout layout, List<TheaterRequest> requests);

}
