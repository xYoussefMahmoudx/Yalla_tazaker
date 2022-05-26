package advancedProjectComputer;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class EmployeeControlEventController1 {
	@FXML
	private Button employeeHome;
	@FXML
	private Button EmployeeSignOut;
	@FXML
	private TextField tfSearchBar;
	@FXML
	private Label showLabel;
	@FXML
	private Label showLabel1;
	@FXML
	private Label showLabel11;
	@FXML
	private Label datelab;
	@FXML
	private Label starlab;
	@FXML
	private Label titleLab;
	@FXML
	private Label endLab;
	@FXML
	private Label catLab;
	@FXML
	private Label decrptionLab;
	@FXML
	private Label locationLab;
	@FXML
	private Label ticketLab;

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
	// Event Listener on Button.onAction
	@FXML
	public void btnViewEvent(ActionEvent event) {
		
			TRS.letEmployeeControlEvent(TRS.currentEmployee,2,tfSearchBar.getText());
			catLab.setText(TRS.eventTRS.getCategory().getType());
			titleLab.setText(TRS.eventTRS.getTitle());
			locationLab.setText(TRS.eventTRS.getLocation());
			datelab.setText(TRS.eventTRS.getDate().toString());
			starlab.setText(TRS.eventTRS.getStartTime().toString());
			endLab.setText(TRS.eventTRS.getEndTime().toString());
			decrptionLab.setText(TRS.eventTRS.getDescription());
			ticketLab.setText(String.valueOf(TRS.eventTRS.getAvailbleTickets()));
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnSearchEvent(ActionEvent event) {
		TRS.letEmployeeControlEvent(TRS.currentEmployee,1,tfSearchBar.getText());
		for(int i=0;i<TRS.eventNames.size();i++) {
		 returnLabel(i).setText(TRS.eventNames.get(i)); 
		}
	}
	public Label returnLabel(int i) {
		if(i==0)
		{
			return showLabel;
		}
		else if (i==1) {
			return showLabel1;
		}
		else {
			return showLabel1;
		}
	}
}
