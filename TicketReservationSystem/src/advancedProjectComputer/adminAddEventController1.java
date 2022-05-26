package advancedProjectComputer;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class adminAddEventController1 {
	TicketReservationSystem TRS=new TicketReservationSystem();
	Main m =new Main();
	@FXML
	private TextField EventBar;
	@FXML
	private Label AddEventStatus;
	@FXML
	private TextField Category;
	@FXML
	private TextField LocationBar;
	@FXML
	private TextField DateBar;
	@FXML
	private TextField StartTimeBar;
	@FXML
	private TextField DescriptionBar;
	@FXML
	private TextField TicketsBar;
	@FXML
	private TextField Endtimebar;

	// Event Listener on Button.onAction
	@FXML
	public void SelectHome(ActionEvent event) throws IOException {
		m.changeScene("adminHome.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void Signout(ActionEvent event) throws IOException {
		TRS.letAdminSignout(TRS.currentAdmin);
		m.changeScene("Home.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void AddEvent(ActionEvent event) {
	try{
	TRS.letAdminControlEvent(TRS.currentAdmin, 1, Category.getText(), EventBar.getText(), LocationBar.getText(),DateBar.getText(), StartTimeBar.getText(), Endtimebar.getText(), DescriptionBar.getText(),Integer.parseInt(TicketsBar.getText()));
		AddEventStatus.setText("succcessfully added");
	}
	catch(NotInListException e) {
		AddEventStatus.setText("category not found");
	}
	}
}
