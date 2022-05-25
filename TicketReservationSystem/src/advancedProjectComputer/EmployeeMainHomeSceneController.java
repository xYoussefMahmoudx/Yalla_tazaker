package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

public class EmployeeMainHomeSceneController {
	
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	
	@FXML
	private Button btnSignOutClicked;
	@FXML
	private Button btnClientClicked;
	@FXML
	private Button btnEventClicked;
	
	Main m =new Main();


	public void signOut() throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
	
   public void Mangeevent() throws IOException {
		
		m.changeScene("EmployeeControlEvent.fxml");
	}
	
   public void Mangeclient() throws IOException {
	
	m.changeScene("Home.fxml");
   }

}
