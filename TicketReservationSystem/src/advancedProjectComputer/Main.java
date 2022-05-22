package advancedProjectComputer;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		TicketReservationSystem system = new TicketReservationSystem();
		system.intiateData();
		System.out.println(" Are you Admin or Employee (A/E) :");
		char checkChar=scanner.next().charAt(0);
		if(checkChar=='A') {
			Admin admin=system.letAdminSignin();
			
			while(admin.equals(null)) {
				 
				admin=system.letAdminSignin();
			}
			System.out.println("please select the what you want to do ");
			System.out.println("1:Manage Category");
			System.out.println("2:Manage Events");
			System.out.println("3:sign out");
			switch (scanner.nextInt()) {
			case 1: {
				
				
				system.letAdminControlCategory(admin);
				
				break;
			}
			
			case 2: {
				system.letAdminControlEvent(admin);
				
			break;	
			}
			
			case 3: {
				
				system.letAdminSignout(admin);
				
				break;
			}
			
			default:
				System.out.println("wrong insert");
			}
			
		}
		else if (checkChar=='E') {
			
			Employee employee=   system.letEmployeeStart();
			
			System.out.println("please select the what you want to do ");
			System.out.println("1:Manage Client");
			System.out.println("2:Manage Events");
			System.out.println("3:sign out");
			switch (scanner.nextInt()) {
			case 1: {
				
				
				system.letEmployeeControlClient(employee);
				
				break;
			}
			
			case 2: {
				system.letEmployeeControlEvent(employee);
				
			break;	
			}
			
			case 3: {
				
				system.letEmployeeSignout(employee);
				
				break;
			}
			
			default:
				System.out.println("wrong insert");
			}
			
			
			
		}
		else {
			
		}
	}
}
