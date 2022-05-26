package advancedProjectComputer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;

import javafx.event.ActionEvent;

public class adminEditEventController {
	Main m =  new Main(); 
	TicketReservationSystem TRS=new TicketReservationSystem();
	@FXML
	private TextField EventBar;
	@FXML
	private TextField LocationBar;
	@FXML
	private TextField DateBar;
	@FXML
	private TextField StartTimeBar;
	@FXML
	private TextField EndTimeBar;
	@FXML
	private TextField DescriptionBar;
	@FXML
	private TextField TicketsBar;
	@FXML
	private Label EditStatus;
	
	// Event Listener on Button.onAction
	@FXML
	public void SignOut(ActionEvent event) throws IOException {
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
	public void EditEvent(ActionEvent event) {
		try{
			TRS.letAdminControlEvent(TRS.currentAdmin, 2,null, EventBar.getText(), LocationBar.getText(),DateBar.getText(), StartTimeBar.getText(), EndTimeBar.getText(), DescriptionBar.getText(),Integer.parseInt(TicketsBar.getText()));
			EditStatus.setText("succcessfully edited");
			}
			catch(NotInListException e) {
				EditStatus.setText("category not found");
			}
	}
}
