package advancedProjectComputer;



import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Person  {
	
	private Account account=new Account();
	Scanner  input = new Scanner(System.in);
	boolean loginFlag = false;
	
	public Account getAccount() {
		
			return account;
		
	}

	public void registerAccount(String userName,String password) {

		account.setUserName(userName);
		account.setPassword(password);
		
		System.out.println("You've registerd successfully !!");
	}

	public void signInAccount(String userName,String password) {

		if(account.getUserName().equals(userName) && account.getPassword().equals(password))
		{
			System.out.println("You've logged in successfully !!");
			loginFlag=true;
		}
		else {
			System.out.println("wrong user name or password plese try again");
			
		}
	}
	
	public void signOutAccount() {
		if(loginFlag==true)
			{loginFlag=false;
			System.out.println("you have signed out");
			}
		else{System.out.println("you are not signed in");}
		
	}
	public void addClient(ArrayList<Client>clients)
	{
		
		
		if(loginFlag==true) {
			Client c1=new Client();
			
			System.out.println("adding client to system");
			System.out.println("insert client name ");
			c1.setName(input.next());
			
			c1.setSerialNumber();
			System.out.println("insert client mobile number");
			c1.setMobile(input.next());
			System.out.println("insert client gender");
			c1.setGender(input.next().charAt(0));
			System.out.println("insert client national ID");
			c1.setNationalID(input.next());
			clients.add(c1);
			System.out.println(" you have added client succesfuly");
			
		}
		else {
			System.out.println(" you are not signed in");
		
		
		}
		
	}
	
	public void deleteClient(Client c1,ArrayList<Client>clients)
	{
		if(loginFlag==true) {
			for(int i=0;i<clients.size();i++) {
				
				if(clients.get(i).equals(c1)) {
					
					for( int j=0;i<clients.get(i).getHistory().getUpcomingEvents().size();j++) {
						
						clients.get(i).getHistory().getUpcomingEvents().get(j).unbookedTickets();
					}
					clients.remove(i);
					break;
				}
			}
			
			c1 = null;
			System.out.println("Successfully deleted client.");
		}
		else {
			System.out.println(" you are not signed in");
		}
	}
	
	public Client getClientBySerial(int serialNumber ,ArrayList<Client> clients)
	{
		int index=-1;
		for (int i = 0; i < clients.size(); i++) {
			
		      if(clients.get(i).getSerialNumber()==serialNumber ) {
		    	  
		    	 index=i;
		      }
		}
		if(loginFlag==true && index>=0) {
			System.out.println("client name is "+ clients.get(index).getName());
			System.out.println("client seial number is "+ clients.get(index).getSerialNumber());
			System.out.println("client national ID is "+ clients.get(index).getNationalID());
			System.out.println("client Gender is "+ clients.get(index).getGender());
			System.out.println("client mobile is "+ clients.get(index).getMobile());
			
			return clients.get(index);
		}
		else if (loginFlag==false) {
			System.out.println(" you are not signed in");
			return null;
		}
		else {
			System.out.println("wrong serial number");
			return null;
		}
	}
	
	public Client getClientByName(String name ,ArrayList<Client> clients)
	{
		int index=-1;
		for (int i = 0; i < clients.size(); i++) {
			
		      if(clients.get(i).getName().equals(name) ) {
		    	  
		    	 index=i;
		      }
		}
		
		if(loginFlag==true && index>=0) {
			
			System.out.println("client name is "+ clients.get(index).getName());
			System.out.println("client seial number is "+ clients.get(index).getSerialNumber());
			System.out.println("client national ID is "+ clients.get(index).getNationalID());
			System.out.println("client Gender is "+ clients.get(index).getGender());
			System.out.println("client mobile is "+ clients.get(index).getMobile());
			
			return clients.get(index);
		}
		else if (loginFlag==false) {
			System.out.println(" you are not signed in");
			return null;

		}
		else {
			System.out.println("wrong name");
			return null;
		}
	}
	
	
	public void bookEvent(Client c1,Event e1) {

		if(loginFlag==true) {
			
			if(e1.getAvailbleTickets()>0) {
			c1.getHistory().setUpcomingEvent(e1);
			e1.bookedTickets();
			System.out.println("event has been succesfuly booked");
			}
			else {
				 System.out.println("not enough available Tickets");
				
			}
		}
		else {
			System.out.println(" you are not signed in");
		}
	}

	public void unbookEvent(Client c1,Event e1) {

         if(loginFlag==true) {
        try {
        	boolean exceptionCheck=false;
			for(int i=1;i<c1.getHistory().getUpcomingEvents().size();i++) {
				if(c1.getHistory().getUpcomingEvents().get(i).equals(e1)) {	
					c1.getHistory().getUpcomingEvents().remove(i);
					e1.unbookedTickets();
					System.out.println(" event has been unbooked");
					exceptionCheck=true;
					break;
				}
				if (exceptionCheck==false) {
					throw new NotInListException(e1.getTitle(),"event is not booked from the beginning");
				}
			}
        } catch (NotInListException e) {
 			e.getNotFound();
 			}
         }
       
		else {
			System.out.println(" you are not signed in");
		}
	}
	
	public void searchEventByTitle(String title,ArrayList<Event>events) {
		
		if(loginFlag==true) {	
			for(int i=0;i<events.size();i++) {
				
				if(events.get(i).getTitle().contains(title)) {
					System.out.println(" found event " + events.get(i).getTitle());
					
				}
			}
			
			
			}
			else {
				System.out.println("you are not signed in");
				
			}
	}

	public void viewEventDetails(String title,ArrayList<Event>events) {
		if(loginFlag==true) {
			
			try {
			int index=-1;
			for(int i=0;i<events.size();i++) {
				
				if(events.get(i).getTitle().equals(title)) {
					
					index=i;
					break;
				}
			}
			if(index==-1) {
				throw new NotInListException(title,"event not found" );
			}
			else {
				
				System.out.println("event title " + events.get(index).getTitle() );
				System.out.println("event category " + events.get(index).getCategory().getType() );
				System.out.println("event location " + events.get(index).getLocation() );
				System.out.println("event Start time " + events.get(index).getStartTime() );
				System.out.println("event end time  " + events.get(index).getEndTime() );
				System.out.println("event date " + events.get(index).getDate() );
					}
			
			}
			catch (Exception e) {
				e.getMessage();
			}
			
	
			
		
			
		}
		else {
			System.out.println("you are not signed in");
			
		}
		
	}
	
	public void getEventsOfSameCategoty(String catType,ArrayList<Event>events) {
		if(loginFlag==true) {
		Boolean check =false;
		System.out.println("please insert event's category Type");
		System.out.println("here are All the event of category" + catType);
		for(int i=0;i<events.size();i++) {
			
			if(events.get(i).getCategory().getType().equals(catType)) {
				System.out.println( events.get(i).getTitle());
				check=true;
			}
		}
		if (check==false) {
			System.out.println("no events found of this category");
			
		}
		
		
		
		}
		else {
			
		}
	
	}
	
	public Event findEvent(String eventName,ArrayList<Event>events) {
		
		if(loginFlag==true) {	
			for(int i=0;i<events.size();i++) {
				
				if(events.get(i).getTitle().equals(eventName)) {
					
					return events.get(i);
				}
			}
			
			
			}
			else {
				System.out.println("you are not signed in");
				return null;
			}
		
		return null;
		
	}
}


