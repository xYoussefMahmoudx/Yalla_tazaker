package advancedProjectComputer;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;

public class EmployeeClientHomeController {

	
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m =new Main();
	// Event Listener on Button.onAction
	@FXML
	public void btnAdd(ActionEvent event) throws IOException {
		m.changeScene("MainView.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnBook(ActionEvent event) throws IOException {
		m.changeScene("EmployeeBook.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnHome(ActionEvent event) throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnSignOut(ActionEvent event) throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
}
