package advancedProjectComputer;



import java.util.ArrayList;
import java.util.InputMismatchException;
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
	public void addClient(ArrayList<Client>clients,String clientName,String clientMobile,String clientID,char clientGender) throws AlreadyInListException
	{
		
		
			try {
		if(loginFlag==true) {
			
			
				for(int i = 0;i < clients.size();i++) {
					if(clients.get(i).getNationalID().equals(clientID)) {
						throw new AlreadyInListException(clientID, " already exist!");
					}
				}
			 
			Client c1=new Client();
			
			System.out.println("adding client to system");
			System.out.println("insert client name ");
			c1.setName(clientName);
			
			c1.setSerialNumber();
			System.out.println("insert client mobile number");
			
				
			if(clientMobile.length()==11){
				c1.setMobile(clientMobile);

			}else {
				try {
					throw new Exception("Enter the mobile number not less than 11 digits");
					
				}catch(Exception e){
					System.out.println(e);
					
				}
				
			}
			
			System.out.println("insert client gender");
			c1.setGender(clientGender);
			System.out.println("insert client national ID");
			if(clientID.length() >= 14){
				c1.setNationalID(clientID);

			}else {
				try {
					throw new Exception("Enter the National ID not less than 14 digits");
					
				}catch(Exception e){
					System.out.println(e);
					
				}
				
			}
			clients.add(c1);
			System.out.println(" you have added client succesfuly");
		}
		
		
		
			
			/*catch (InputMismatchException exception){
				
	            System.out.println("your input is type mismatch, please check your input and try again. Press enter key to exit");
	            /*if (input.next().isEmpty()) {
	                break;
	            }
				
				
			}*/
			/*catch ( Exception e){
				
	            System.out.println(" you are not signed in, press enter to exist");
	            /*if (input.next().isEmpty()) {
	                break;
	            }
			}*/
			}
		catch (NullPointerException e) {
			e.getMessage();
		}
		/*catch (AlreadyInListException e) {
				e.getFound();
			}*/
	
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
	
	//exception by mahmoud talaat
	public Client getClientBySerial(int serialNumber ,ArrayList<Client> clients) 
	{
		int index=-1;
		for (int i = 0; i < clients.size(); i++) {
			try {
		      if(clients.get(i).getSerialNumber()==serialNumber ) {
		    	  
		    	 index=i;
		      }
		      
			}catch (InputMismatchException exception){
				
	            System.out.println("your input is type mismatch, please check your input and try again. Press enter key to exit");
	           
	            /*if (input.next().isEmpty()) {
	                break;
	            }*/
	            }
			catch ( Exception ex){
					
		            System.out.println(" Serial number is not found, press enter to exit");
		            /*if (input.next().isEmpty()) {
		                break;
		            }*/
		           
		           
	            }}
		if(loginFlag==true && index>=0) {
	    			System.out.println("client name is "+ clients.get(index).getName());
	    			System.out.println("client seial number is "+ clients.get(index).getSerialNumber());
	    			System.out.println("client national ID is "+ clients.get(index).getNationalID());
	    			System.out.println("client Gender is "+ clients.get(index).getGender());
	    			System.out.println("client mobile is "+ clients.get(index).getMobile());
	    			
	    			return clients.get(index);
	    		
		} else {
			try {
				throw new Exception("you are not signed in");
			}catch(Exception e) {
				System.out.println(e);
			}
			return null;
		}
	
		
		
		
	}
	//exception by mahmoud talaat
	public Client getClientByName(String name ,ArrayList<Client> clients)
	{
		int index=-1;
	try {
		for (int i = 0; i < clients.size(); i++) {
			
		      if(clients.get(i).getName().equals(name) ) {
		    	  
		    	 index=i;
		      }
		}
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("User not found!!");
		
	}
	
		if(loginFlag==true && index>=0) {
			
			System.out.println("client name is "+ clients.get(index).getName());
			System.out.println("client seial number is "+ clients.get(index).getSerialNumber());
			System.out.println("client national ID is "+ clients.get(index).getNationalID());
			System.out.println("client Gender is "+ clients.get(index).getGender());
			System.out.println("client mobile is "+ clients.get(index).getMobile());
			
			return clients.get(index);
		} else {
			try {
				throw new Exception("you are not signed in");
			}catch(Exception e) {
				System.out.println(e);
			}
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
				EmployeeControlEventController ec =new EmployeeControlEventController();
				if(events.get(i).getTitle().contains(title)) {	
					System.out.println("iam here");
					ec.getLabel( events.get(i).getTitle());
					break;
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
				EmployeeControlEventController ec =new EmployeeControlEventController();
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


