package advancedProjectComputer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class TicketReservationSystem {
	
	private  static  TicketReservationSystem instance;
	Scanner  input = new Scanner(System.in);
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	ArrayList<Admin> admines = new ArrayList<Admin>();
	
	ArrayList<Client> clients = new ArrayList<Client>();
	
	ArrayList<Category> categories = new ArrayList<Category>();
	
	ArrayList<Event> events = new ArrayList<Event>();
	
	
	public void intiateData() {
		
		Admin dummyAdmin1=new Admin();
		
		Employee dummyEmployee1=new Employee();
		
		employees.add(dummyEmployee1);
		dummyEmployee1.registerAccount("dummy1", "dummy1");
		
		employees.add(dummyEmployee1);

		dummyAdmin1.registerAccount("dummy1", "dummy1");
		
		admines.add(dummyAdmin1);
		
		Client client =new Client();
		client.setName("Ahmed");
		client.setMobile("01011111111");
		client.setGender('M');
		client.setSerialNumber();
		client.setNationalID("3020503030");
		
		clients.add(client);
		

		//Category categ1 = new Category();
		
		//categ1.setType("movie");
		categories.add(new Category("movie"));

		//Category categ2 = new Category();
		
		//categ1.setType("match");
		categories.add(new Category("sport"));
		

		
		Event event1 = new Event();
		event1.setTitle("spiderman");
		event1.setLocation("voxcinema");
		event1.setDate(LocalDate.of(2022, 8, 9));
		event1.setStartTime(LocalTime.of(10,30 ));
		event1.setEndTime(LocalTime.of(11,30 ));
		event1.setDescription("bad moviee");
		event1.setAvailbleTickets(30);
		event1.setCategory(categories.get(0));
		events.add(event1);
	
		
		
       Event event2 = new Event();	
       event2.setTitle("spiderwoman");
       event2.setLocation("voxcinema");
       event2.setDate(LocalDate.of(2022, 7, 9));
       event2.setStartTime(LocalTime.of(10,30 ));
       event2.setEndTime(LocalTime.of(11,30 ));
       event2.setDescription("good moviee");
       event2.setAvailbleTickets(30);
       event2.setCategory(categories.get(1));
		events.add( event2);
		
	       Event event3 = new Event();	
	       event3 .setTitle("sharkia lldokhan vs m3sl elslom");
	       event3 .setLocation("abo attata");
	       event3 .setDate(LocalDate.of(2022, 10, 9));
	       event3 .setStartTime(LocalTime.of(10,30 ));
	       event3 .setEndTime(LocalTime.of(11,30 ));
	       event3 .setDescription("worst match ever waste for your money");
	       event3 .setAvailbleTickets(11);
	       event3 .setCategory(categories.get(1));
			events.add( event3);
		
	}
	
	public static TicketReservationSystem getInstance(){
		if(instance == null){
			instance=new TicketReservationSystem();
			instance.intiateData();
		}
		return instance;
	}
	Admin currentAdmin= new Admin();
	Employee currentEmployee= new Employee();
	Client currentClient = new Client();
	boolean accountExist;
	String forException;
	public Admin letAdminSignin(String userName,String password) {
		
		System.out.println("please insert your username : " );
		
		
		System.out.println("please insert your password : " );

		for(int i = 0; i < admines.size(); i++) {
			
	      if(admines.get(i).getAccount().getUserName().equals(userName) && admines.get(i).getAccount().getPassword().equals(password)) {
	    	  
	    	  accountExist = true;
	    	  currentAdmin= admines.get(i);
	    	 
	    	  
	    	  currentAdmin.signInAccount(userName,password);
	    	  return currentAdmin;
	      }
		}
		
		if(!accountExist)
			System.out.println("Account not exist ");
		
		
		return null;
	}
	
	
	
	public void letAdminSignout(Admin currentAdmin) {
		
		currentAdmin.signOutAccount();
		
	}
	boolean error;
	public void letAdminControlCategory(Admin currentAdmin,int sw,String catType,String newCatType){
		System.out.println("Please insert the one of the following numbers" );
		System.out.println("1: Add category");
		System.out.println("2: Edit category");
		System.out.println("3: Delete category");
	
	switch(sw) {	
	case 1:{
		try {
			for (int i = 0; i < categories.size(); i++) {
				System.out.println(categories.get(i).getType());
			      
			      if(i == categories.size()-1) {
			    	  error = false;
			    	  categories.add(currentAdmin.addCategory(catType));
			    	  break;
			      }
			      if(categories.get(i).getType().equals(catType)) {
			    	  
			    	  error = true;
			    	  throw new AlreadyInListException(catType, " is already added!");
			    	  
			      }
			}
		} catch (AlreadyInListException e) {
			forException = e.getFound() + " is already added!";
		}
		
		break;
	}
	case 2:{
		System.out.println("Please insert the Category  you wish to edit");
		try {
			
			for (int i = 0; i < categories.size(); i++) {
				System.out.println(categories.get(i).getType());
			      if(categories.get(i).getType().equals(catType)) {
			    	  
			    	  currentAdmin.editCategory(categories.get(i),newCatType);
			    	  error = false;
			    	  break;  
			      }
			      if(i == categories.size()-1) {
			    	  error = true;
			    	  throw new NotInListException(catType, "Category does not exist!");
			      }
			}
		}
		catch(NotInListException e) {
			e.getNotFound();
			forException = e.getNotFound() + " does not exist!";
		}
		      
		break;
		
	}
	case 3:{
		System.out.println("Please insert the Category  you wish to delete");
		try {
			
			for (int i = 0; i < categories.size(); i++) {
					System.out.println(categories.get(i).getType());
			      if(categories.get(i).getType().equals(catType)) {
			    	  
			    	  currentAdmin.deleteCategory(categories.get(i), categories);
			    	  error = false;
			    	  break;  
			      }
			      if(i == (categories.size()-1)) {
			    	  error = true;
			    	  throw new NotInListException(catType, "Category does not exist!");
			    	  
			      }
			}
		}
		catch(NotInListException e) {
			e.getNotFound();
			forException = e.getNotFound() + " does not exist!";
		}
		catch (NullPointerException e) {
			error = true;
			e.getMessage();
		}
			break;
	}
	default:
		System.out.println("Invalid input");
		
	  }
	}

	public void letAdminControlEvent(Admin currentAdmin) {
		
		
		
		System.out.println("Please insert the one of the following numbers" );
		System.out.println("1: Add event");
		System.out.println("2: Edit event");
		System.out.println("3: Delete event");
		
	switch(input.nextInt()) {	
	
	case 1:{
		System.out.println("Please insert the category  you wish to add event of it");
		try {
			String catType = input.next();
			for (int i = 0; i < categories.size(); i++) {
			
				if(categories.get(i).getType() .equals(catType)) {
		    	  
					events.add(currentAdmin.addEvent(categories.get(i)));
		    	  break;  
				}
				if(i == categories.size()) {
					throw new NotInListException(catType, "Category does not exist!");
				}
		      
			
			}
		}
		catch(NotInListException e) {
			e.getNotFound();
		}
		break;
		
	}
	
	case 2:{
		System.out.println("Please insert the event  you wish to edit");
		try {	
			String catType = input.next();
			for (int i = 0; i < events.size(); i++) {
			
				if(events.get(i).getTitle() .equals(catType)) {
		    	  
		    	  currentAdmin.editEvent(events.get(i));
		    	  break;  
		      }
		      
		       if(i==events.size()-1) {
		    	   throw new NotInListException(catType,"The event does not exist! ");
		       }
		
	    }
			
			
		} 
		catch (NotInListException e) {
			e.getNotFound();
		}
	      
	
	
    break;
   }
	case 3:{
		System.out.println("Please insert the event  you wish to delete");
		try {
			String catType = input.next();
			for (int i = 0; i < events.size(); i++) {
				
			      if(events.get(i).getTitle() .equals(catType)) {
			    	  
			    	  currentAdmin.deleteEvent(events.get(i), events);
			    	  break;  
			      }
			      if(i==events.size()-1) {
			    	   throw new NotInListException(catType,"No event with this name to delete ");
			       }
			
			
		}
			}
			catch (NotInListException e) {
				e.getNotFound();
			}
	break;
	}
	
	default:
		System.out.println("Invalid input");
		
	}
	
}
		
	public Employee letEmployeeStart(char  checkChar2,String username,String password) throws NotInListException {
		
		
System.out.println("Do you Already have an Account (Y/N) : ");
		
	
		if(checkChar2=='Y') {

			try {
			boolean accountExist=false;
			for (int i = 0; i <employees.size(); i++) {
				
		      if(employees.get(i).getAccount().getUserName().equals(username)&&employees.get(i).getAccount().getPassword().equals(password)) {
		    	  
		    	  accountExist = true;
		    	  currentEmployee= employees.get(i);
		    	  currentEmployee.signInAccount(username,password);
		    	  break;
		      }
		    }
			
			if(accountExist==false) {
				System.out.println("Account not exist ");
			throw new NotInListException(username, " user name not found");}
             else {
				System.out.println("Account exist");
			}
			}catch (NullPointerException e) {
				
			}
			
			
			  return currentEmployee;
			
		}
		else  {
			

			Employee newEmployee= new Employee();
			newEmployee.registerAccount(username, password);
			employees.add(newEmployee);
			
			 currentEmployee=newEmployee;
			currentEmployee.signInAccount(username, password);
			
			return currentEmployee;}

		
	}
	String clientMobile,clientID;
	char clientGender;
	public void letEmployeeControlClient(Employee currentEmployee,int sw,String clientName,int clientNumber,String eventTitle) throws NotInListException, AlreadyInListException {
		
		System.out.println("Please insert the one of the following numbers" );
		System.out.println("1: Add client");
		System.out.println("2: Delete client");
		System.out.println("3: search client by name");
		System.out.println("4: search client by serial number");
		System.out.println("5: book event for client ");
		System.out.println("6: unbook event for client");
		
		
		
		
		switch (sw) {

		case 1: {
			
			
			currentEmployee.addClient(clients,clientName,clientMobile,clientID,clientGender);
			break;
		}
		
		
		case 2: {
			
			System.out.println("Please insert the name of the client you wish to delete his information");		
			try {
				boolean exceptionFlag=false;
				for (int i = 0; i < clients.size(); i++) {
					
				      if(clients.get(i).getName() .equals(clientName)) {
				    	  
				    	 currentEmployee.deleteClient(clients.get(i), clients);
				    	 exceptionFlag=true;
				    	  break;  
				      }
				      
				}
				if (exceptionFlag==false) {
					throw new NotInListException(clientName,"not found in list");
				}
			} 
			
			catch (NotInListException e) {
				e.getNotFound();
			}
			
			
			
			break;
		}
		
		
		
	case 3: {
			
			System.out.println("Please insert the name of the client ");
			currentClient =  currentEmployee.getClientByName(clientName, clients);
			
			break;
		}
		
	case 4: {
		
		System.out.println("Please insert the serial number of the client ");
		currentEmployee.getClientBySerial(clientNumber, clients);
		break;
	}
		
		case 5: {
		try {
			Boolean excptionCheckBoolean=false;
			System.out.println("plese insert title of event you want to book :");
			
			System.out.println("please insert name of the client you want to book for him :");
			for (int i = 0; i < clients.size(); i++) {
				
			      if(clients.get(i).getName().equals(clientName) ) {
			    	  
						currentEmployee.bookEvent(clients.get(i), currentEmployee.findEvent(eventTitle, events));
						excptionCheckBoolean=true;
						break;
			      }
			}
			if(excptionCheckBoolean==false) {
				throw new NotInListException(clientName, "client name not found");
			}

		}
		catch (NullPointerException n) {
			System.out.println("  event name not fount ");
		
		}
	
			break;
		}
		
		case 6: {
			
			try {	
		Boolean excptionCheckBoolean=false;
			System.out.println("plese insert title of event you want to unbook :");
			

			
			System.out.println("please insert name of the client you want to unbook for him :");
			for (int i = 0; i < clients.size(); i++) {
				
			      if(clients.get(i).getName().equals(clientName) ) {
			    	  excptionCheckBoolean = true;
			    	  currentEmployee.unbookEvent(clients.get(i), currentEmployee.findEvent(eventTitle, events));
						break;
			      }
			}
			if(excptionCheckBoolean==false) {
				throw new NotInListException(clientName, "client name not found");
			}

			}
			catch (NullPointerException n) {
				System.out.println("  event name not fount ");
			}
			
			
			break;
		}
		
		default: 
			System.out.println("Invalid input");
			
		}
		
	}
		
public void letEmployeeControlEvent(Employee currentEmployee,int sw,String eventName) {
		
		
		
		System.out.println("Please insert the one of the following numbers" );
		
		System.out.println("1: search event by name ");
		System.out.println("2: view event by name ");
		

		switch (sw) {
		case 1: {
			try {
			System.out.println("insert the name of the event ");
			
			currentEmployee.searchEventByTitle(eventName, events);

			
			}
			catch (Exception e) {
				e.getMessage();

			}

			break;
		}
		
		case 2: {
			try {
			System.out.println("insert the name of the event ");
			
			currentEmployee.viewEventDetails(eventName,events);	
			}

			catch (Exception e) {
				e.getMessage();
			}
			break;
			
		}
		
		default:
			
			System.out.println("wrong choise  ");
		}
		
	}
	
	public void letEmployeeSignout(Employee currentEmployee) {
		
		currentEmployee.signOutAccount();
		
	}





	

}