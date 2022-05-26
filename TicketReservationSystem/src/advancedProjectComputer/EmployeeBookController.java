package advancedProjectComputer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

public class EmployeeBookController {
	@FXML
	private TextField tfEventName;
	@FXML
	private TextField tfClientName;
	@FXML
	private Label errorShow;


	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m =new Main();
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
	// Event Listener on Button.onAction
	@FXML
	public void btnBookClicked(ActionEvent event) throws AlreadyInListException {
		try {
		TRS.letEmployeeControlClient(TRS.currentEmployee, 5, tfClientName.getText(), 0, tfEventName.getText());
		errorShow.setText("event booked sucessfuly");
		}
		catch (NotInListException e) {
		e.getNotFound();
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnUnBookClicked(ActionEvent event) throws AlreadyInListException {
		try {
			TRS.letEmployeeControlClient(TRS.currentEmployee, 6, tfClientName.getText(), 0, tfEventName.getText());
			errorShow.setText("event Unbooked sucessfuly");
			}
			catch (NotInListException e) {
			e.getNotFound();
			}
	}
}
