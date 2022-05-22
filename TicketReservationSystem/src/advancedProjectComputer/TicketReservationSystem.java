package advancedProjectComputer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class TicketReservationSystem {
	
	
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
		

		Category categ1 = new Category();
		
		categ1.setType("moviee");
		categories.add(categ1);

		Category categ2 = new Category();
		
		categ1.setType("match");
		categories.add(categ2);
		

		
		Event event1 = new Event();
		event1.setTitle("spiderman");
		event1.setLocation("voxcinema");
		event1.setDate(LocalDate.of(2022, 8, 9));
		event1.setStartTime(LocalTime.of(10,30 ));
		event1.setEndTime(LocalTime.of(11,30 ));
		event1.setDescription("bad moviee");
		event1.setAvailbleTickets(30);
		event1.setCategory(categ1);
		events.add(event1);
	
		
		
       Event event2 = new Event();	
       event2.setTitle("spiderwoman");
       event2.setLocation("voxcinema");
       event2.setDate(LocalDate.of(2022, 7, 9));
       event2.setStartTime(LocalTime.of(10,30 ));
       event2.setEndTime(LocalTime.of(11,30 ));
       event2.setDescription("good moviee");
       event2.setAvailbleTickets(30);
       event2.setCategory(categ1);
		events.add( event2);
		
	       Event event3 = new Event();	
	       event3 .setTitle("sharkia lldokhan vs m3sl elslom");
	       event3 .setLocation("abo attata");
	       event3 .setDate(LocalDate.of(2022, 10, 9));
	       event3 .setStartTime(LocalTime.of(10,30 ));
	       event3 .setEndTime(LocalTime.of(11,30 ));
	       event3 .setDescription("worst match ever waste for your money");
	       event3 .setAvailbleTickets(11);
	       event3 .setCategory(categ2);
			events.add( event3);
		
	}
	
	public Admin letAdminSignin() {
		
		System.out.println("please insert your username : " );
		Admin currentAdmin= new Admin();
		
		String userName = input.next();
		System.out.println("please insert your password : " );

		  String password = input.next();
		boolean accountExist=false;
		for (int i = 0; i < admines.size(); i++) {
			
	      if(admines.get(i).getAccount().getUserName() .equals(userName)&&admines.get(i).getAccount().getPassword().equals(password)) {
	    	  
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
	
	public void letAdminControlCategory(Admin currentAdmin){
		System.out.println("Please insert the one of the following numbers" );
		System.out.println("1: Add category");
		System.out.println("2: Edit category");
		System.out.println("3: Delete category");
		int sw;
		sw=input.nextInt();
	switch(sw) {	
	case 1:{
		categories.add(currentAdmin.addCategory());
		break;
	}
	case 2:{
		System.out.println("Please insert the Category  you wish to edit");
		try {
			String catType = input.next();
			for (int i = 0; i < categories.size(); i++) {
				
			      if(categories.get(i).getType() .equals(catType)) {
			    	  
			    	  currentAdmin.editCategory(categories.get(i));
			    	  break;  
			      }
			      if(i == categories.size()-1) {
			    	  throw new NotInListException(catType, "Category does not exist!");
			      }
			}
		}
		catch(NotInListException e) {
			e.getNotFound();
		}
		      
		break;
		
	}
	case 3:{
		System.out.println("Please insert the Category  you wish to delete");
		try {
			String catType = input.next();
			for (int i = 0; i < categories.size(); i++) {
				
			      if(categories.get(i).getType() .equals(catType)) {
			    	  
			    	  currentAdmin.deleteCategory(categories.get(i), categories);
			    	  break;  
			      }
			      if(i == categories.size()-1) {
			    	  throw new NotInListException(catType, "Category does not exist!");
			      }
			}
		}
		catch(NotInListException e) {
			e.getNotFound();
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
		
	public Employee letEmployeeStart() {
		
		
System.out.println("Do you Already have an Account (Y/N) : ");
		
		char checkChar2=input.next().charAt(0);
		if(checkChar2=='Y') {
			

			System.out.println("please insert your username : " );
			Employee currentEmployee= new Employee();
			
			String userName = input.next();
			System.out.println("please insert your password : " );

			  String password = input.next();
			boolean accountExist=false;
			for (int i = 0; i <employees.size(); i++) {
				
		      if(employees.get(i).getAccount().getUserName().equals(userName)&&employees.get(i).getAccount().getPassword().equals(password)) {
		    	  
		    	  accountExist = true;
		    	  currentEmployee= employees.get(i);
		    	  currentEmployee.signInAccount(userName,password);
		    	  
		    	  return currentEmployee;
		      }
		    }
			
			if(!accountExist)
				System.out.println("Account not exist ");
			return null;
			
			
		}
		else if (checkChar2=='N') {
			
			System.out.println("creating a new account ");
			System.out.println("insert your user name ");
			String userName =input.next();
			System.out.println("insert your password ");
			String password =input.next();
			Employee newEmployee= new Employee();
			newEmployee.registerAccount(userName, password);
			employees.add(newEmployee);
			
			Employee currentEmployee= new Employee();
			
			System.out.println(" now please sign in ");
			
			System.out.println(" please insert your user name ");
			 userName = input.next();
			System.out.println("please insert your password : " );

			  password = input.next();
			boolean accountExist=false;
			for (int i = 0; i <employees.size(); i++) {
				
		      if(employees.get(i).getAccount().getUserName() .equals(userName)&&employees.get(i).getAccount().getPassword().equals(password)) {
		    	  
		    	  accountExist = true;
		    	  currentEmployee= employees.get(i);
		    	  currentEmployee.signInAccount(userName,password);
		    	  return currentEmployee;
		      }
		    }
			
			if(!accountExist)
				System.out.println("Account not exist ");
			return null;
		}
		
		else {
			
			System.out.println("wrong choise  ");
			return null;
		}
		
	}
	
	public void letEmployeeControlClient(Employee currentEmployee) {
		
		System.out.println("Please insert the one of the following numbers" );
		System.out.println("1: Add client");
		System.out.println("2: Delete client");
		System.out.println("3: search client by name");
		System.out.println("4: search client by serial number");
		System.out.println("5: book event for client ");
		System.out.println("6: unbook event for client");
		
		
		
		
		switch (input.nextInt()) {

		case 1: {
			
			
			currentEmployee.addClient(clients);
			break;
		}
		
		
		case 2: {
			
			System.out.println("Please insert the name of the client you wish to delete his information");
			String clientName ;
			clientName = input.next();
			
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
			String clientName = input.next();
			currentEmployee.getClientByName(clientName, clients);
			
			break;
		}
		
		case 4: {
			
			System.out.println("Please insert the serial number of the client ");
			int clientNumber = input.nextInt();
			currentEmployee.getClientBySerial(clientNumber, clients);
			
			break;
		}
		
		case 5: {
		try {
			Boolean excptionCheckBoolean=false;
			System.out.println("plese insert title of event you want to book :");
			String eventTitle;
			eventTitle = input.next();
			System.out.println("please insert name of the client you want to book for him :");
			String clientName;
			clientName = input.next();
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
		} catch (NotInListException e) {
			e.getNotFound();
		}
	
			break;
		}
		
		case 6: {
			
			try {	
		Boolean excptionCheckBoolean=false;
			System.out.println("plese insert title of event you want to unbook :");
			
			String eventTitle;
			eventTitle = input.next();
			
			System.out.println("please insert name of the client you want to unbook for him :");
			String clientName;
			clientName = input.next();
			for (int i = 0; i < clients.size(); i++) {
				
			      if(clients.get(i).getName().equals(clientName) ) {
			    	  
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
			} catch (NotInListException e) {
				e.getNotFound();
			}
			
			
			break;
		}
		
		default: 
			System.out.println("Invalid input");
			
		}
		
	}
		
	public void letEmployeeControlEvent(Employee currentEmployee) {
		
		
		
		System.out.println("Please insert the one of the following numbers" );
		
		System.out.println("1: search event by name ");
		System.out.println("2: search event by name ");
		
		int sw;
		sw=input.nextInt();
		switch (sw) {
		case 1: {
			
			System.out.println("insert the name of the event ");
			String eventName;
			eventName=input.nextLine();
			currentEmployee.searchEventByTitle(eventName, events);
			
			break;
		}
		
		case 2: {
			
			System.out.println("insert the name of the event ");
			String eventName;
			eventName=input.nextLine();
			currentEmployee.viewEventDetails(eventName,events);	
			
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

