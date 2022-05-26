package advancedProjectComputer;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class adminDeleteEventController {
	Main m=new Main();
	TicketReservationSystem TRS= new TicketReservationSystem();
	@FXML
	private TextField DeleteBar;
	@FXML
	private Label DeleteStatus;

	// Event Listener on Button.onAction
	@FXML
	public void Signout(ActionEvent event) throws IOException {
		TRS.letAdminSignout(TRS.currentAdmin);
		m.changeScene("Home.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void SelectHome(ActionEvent event) throws IOException {
		m.changeScene("adminHome.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void SelectDelete(ActionEvent event) throws NotInListException {
		TRS.letAdminControlEvent(TRS.currentAdmin, 3, DeleteBar.getText(), null,null,null,null,null,null,0);
		if(TRS.error) {
			DeleteStatus.setText(TRS.forException);
		}
		else {
			
			DeleteStatus.setText("Category deleted successfuly!");
		}
	}
}
