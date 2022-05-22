package advancedProjectComputer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class History {

	private ArrayList<Event> attendedEvent = new ArrayList<Event>(); ;
	private ArrayList<Event> upcomingEvent = new ArrayList<Event>(); ;

	History(){
		
		attendedEvent.add(null);
		upcomingEvent.add(null);
		
	}
	
	
	
	public ArrayList<Event> getAttendedEvents() {

		LocalDate dateNow =LocalDate.now();
		LocalTime timeNow =LocalTime.now();
		for (int i = 1; i < upcomingEvent.size(); i++) {
		     if (upcomingEvent.get(i).getStartTime().compareTo(timeNow)<=0 &&upcomingEvent.get(i).getDate().compareTo(dateNow)<=0) {
		    	attendedEvent.add(upcomingEvent.get(i));
		    	upcomingEvent.remove(i);
		     }

		    }

		return attendedEvent;

	}

	public ArrayList<Event> getUpcomingEvents() {
	try {	
		LocalDate dateNow =LocalDate.now();
		LocalTime timeNow =LocalTime.now();
		for (int i = 1; i < upcomingEvent.size(); i++) {
		     if (upcomingEvent.get(i).getStartTime().compareTo(timeNow)<=0 &&upcomingEvent.get(i).getDate().compareTo(dateNow)<=0) {
		    	attendedEvent.add(upcomingEvent.get(i)); 
		    	upcomingEvent.remove(i);
		     }
		    	 
		    }
		
		
	}
	catch (NullPointerException e) {
		System.out.println("no events found");
		
	}
	return upcomingEvent;
	}
	
	/*public void setEventsHistory(Event event) {
		LocalTime timeNow =LocalTime.now();
		LocalDate dateNow =LocalDate.now();

		if (event.getStartTime().compareTo(timeNow)<=0 &&event.getDate().compareTo(dateNow)<=0) {
			this.attendedEvent.add(event);
		}
		else {
			this.upcomingEvent.add(event);
		}

	}*/
	public void setUpcomingEvent(Event event)
		 {
			 upcomingEvent.add(event);
		 }

	
	
}
