package advancedProjectComputer;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class EmployeeControlEventController {
	@FXML
	private Button employeeHome;
	@FXML
	private Button EmployeeSignOut;
	@FXML
	private Button adminEditCategory;
	@FXML
	private Button adminAddCategory;
	@FXML
	private TextField tfSearchBar;
	@FXML
	private Label showLabel;

	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m =new Main();
	
	// Event Listener on Button[#employeeHome].onAction
	@FXML
	public void selectHome(ActionEvent event) throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	// Event Listener on Button[#EmployeeSignOut].onAction
	@FXML
	public void employeeSignOut(ActionEvent event) throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
	// Event Listener on Button[#adminEditCategory].onAction
	@FXML
	public void btnViewEvent(ActionEvent event) {
		
	TRS.letEmployeeControlEvent(TRS.currentEmployee,2,tfSearchBar.getText());
	
	}
	// Event Listener on Button[#adminAddCategory].onAction
	@FXML
	public void btnSearchEvent(ActionEvent event) {
		TRS.letEmployeeControlEvent(TRS.currentEmployee,1,tfSearchBar.getText());
	}
	public void getLabel(String text) {
		showLabel.setText(text);

	}
}
