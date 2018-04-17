package com.theater.system.main;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.theater.system.command.TheaterLayout;
import com.theater.system.command.TheaterRequest;
import com.theater.system.service.TheaterSeatingService;
import com.theater.system.service.TheaterSeatingServiceImpl;

/**
 * @author Harsh Shukla
 *
 */
/** This is the main class which reads the input file and call the service processors
 */ 

public class TheatreSeating {
	
	private static final String INPUT_FILE = "input.txt"; // Externalize later to a properties files
	static final Logger LOGGER = Logger.getLogger(TheatreSeating.class.getName());
    
    public static void main(String[] args) {
        
        String line;
        StringBuilder layout = new StringBuilder();
        StringBuilder ticketRequests = new StringBuilder();
        boolean isLayoutFinished = false;
        LOGGER.info("Please enter Theater Layout and Ticket requests and then enter 'done'.\n");
        Scanner input = new Scanner(TheatreSeating.class.getResourceAsStream(INPUT_FILE));
        while((line = input.nextLine()) != null && !line.equals("Done")){
            
            if(line.length() == 0){
                isLayoutFinished = true;
                continue;
            }
            
            if(!isLayoutFinished){
                layout.append(line + System.lineSeparator());
            }else{
                ticketRequests.append(line + System.lineSeparator());
            }
        }
        input.close();
        TheaterSeatingService service = new TheaterSeatingServiceImpl();
        try{
            TheaterLayout theaterLayout = service.getTheaterLayout(layout.toString());
            List<TheaterRequest> requests = service.getTicketRequests(ticketRequests.toString());
            service.processTicketRequests(theaterLayout, requests);
        }catch(NumberFormatException nfe){
            
        	LOGGER.severe("Could not create the theater layout. " + nfe.getMessage());
            
        }catch(Exception e){
            
            e.printStackTrace();
            LOGGER.severe("Could not map the ticket request. " + e.getMessage());
        }

        
        
    }

}
