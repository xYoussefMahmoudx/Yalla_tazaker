

package advancedProjectComputer;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;



public class Admin extends Person {
	private Account account = new Account();
	Scanner adminInput = new Scanner(System.in);
	boolean adminLoginFlag = false;
	
	
	public void registerAccount(String userName,String password) {

		account.setUserName(userName);
		account.setPassword(password);
		
		System.out.println("You've registerd successfully !!");
	}
	public Account getAccount() {
		
			return account;
		
	}
	public void signInAccount(String userName ,String password) {
		if(account.getUserName().equals(userName) && account.getPassword().equals(password)) {
			System.out.println("You've logged in successfully !!");
			adminLoginFlag = true;
		}
		else System.out.println("wrong user name or password plese try again");
	}
	public void signOutAccount() {
		if(adminLoginFlag == true) {
			adminLoginFlag = false;
			System.out.println("you have signed out");
		}
		else System.out.println("you are not signed in");
	}
	public Category addCategory() {
		
		if(adminLoginFlag == true) {
			Category categ1 = new Category();
			System.out.println("Adding new categoty...");
			System.out.println("Enter category type:");
			categ1.setType(adminInput.next());
			System.out.println("Added succesfully!");
			return categ1;
		}
		else {
			System.out.println("You are not signed in.");
			return null;
		}
		
	}
	public void editCategory(Category cat1) {
		System.out.println("Current type of category is: "+ cat1.getType());
		System.out.println("Enter new category type:");
		cat1.setType(adminInput.nextLine());
		System.out.println("Succefully edited!");
	}
	public void deleteCategory(Category cat1,ArrayList<Category> categories) {
		
	if(adminLoginFlag==true)	{
		for(int i=0;i<categories.size();i++) {
		
			if(categories.get(i).equals(cat1)) {
				categories.remove(i);
				break;
			}
		}
		
		cat1 = null;
		System.out.println("Successfully deleted category.");
	}
	else {
		System.out.println("you are not signed in");
	  }
	}
	public Event addEvent(Category category) {
		Event event1 = new Event();
		if(adminLoginFlag == true) {
			System.out.println("Adding new event...");
			System.out.println("Enter event title:");
			event1.setCategory(category);
			System.out.println("Enter event title:");
			event1.setTitle(adminInput.nextLine());
			System.out.println("Enter event location:");
			event1.setLocation(adminInput.nextLine());
			System.out.println("Enter event date YYYY-MM-DD :");
			
			event1.setDate(LocalDate.parse(adminInput.nextLine()));
			System.out.println("Enter event start time:");
			event1.setStartTime(LocalTime.parse(adminInput.nextLine()));
			System.out.println("Enter event end time:");
			event1.setEndTime(LocalTime.parse(adminInput.nextLine()));
			System.out.println("Enter event's description");
			event1.setDescription(adminInput.nextLine());
			System.out.println("Enter event's number of tickets");
			event1.setAvailbleTickets(adminInput.nextInt());
			System.out.println(" you have succesfully Added a new event.");
			return event1;
		}
		else {
			System.out.println("You are not signed in.");
			return null;
		}
	}
	public void editEvent(Event event1) {
		
	if(adminLoginFlag==true) {	
		System.out.println("Editing event " + event1.getTitle());
		System.out.println("Enter event title:");
		event1.setTitle(adminInput.nextLine());
		System.out.println("Enter event location:");
		event1.setLocation(adminInput.nextLine());
		System.out.println("Enter event date YYYY-MM-DD :");
		event1.setDate(LocalDate.parse(adminInput.nextLine()));
		System.out.println("Enter event start time:");
		event1.setStartTime(LocalTime.parse(adminInput.nextLine()));
		System.out.println("Enter event end time:");
		event1.setEndTime(LocalTime.parse(adminInput.nextLine()));
		System.out.println("Enter event's description");
		event1.setDescription(adminInput.nextLine());
		System.out.println("Enter event's number of tickets");
		event1.setAvailbleTickets(adminInput.nextInt());
		System.out.println("Successfuly modified event.");
	  }
	else {
		System.out.println("you are not signed in");
	 }
	}
	public void deleteEvent(Event event1,ArrayList<Event>events) {
		
		if(adminLoginFlag==true) {	
		for(int i=0;i<events.size();i++) {
			
			if(events.get(i).equals(event1)) {
				events.remove(i);
				break;
			}
		}
		
		
		
		event1 = null;
		System.out.println("Successfuly deleted event.");
		}
		else {
			System.out.println("you are not signed in");
		}
	}

	
}
