package advancedProjectComputer;

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





public class Main extends Application {
	private static Stage mainStage;
	@Override
	public void start(Stage primaryStage) throws Exception{
		mainStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root,688,488));
		primaryStage.setTitle("Ticket Reservation");
		primaryStage.show();
	}
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		mainStage.getScene().setRoot(pane);
	}
	public static void main(String[] args) {
		
		//TicketReservationSystem system = new TicketReservationSystem();
		//system.intiateData();
		launch(args);
		
		
		
		
		
		
		//Scanner scanner=new Scanner(System.in);
		
		
		/*System.out.println(" Are you Admin or Employee (A/E) :");
		
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
			
		}*/
	}
}
