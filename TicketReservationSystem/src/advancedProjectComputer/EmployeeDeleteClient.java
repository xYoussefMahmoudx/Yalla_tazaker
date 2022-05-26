package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeeDeleteClient {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m = new Main();
	
	public EmployeeDeleteClient() {
		
	}
	
	@FXML
	private Label employeeDeleteClientStatusLabel;
	@FXML
	private TextField clientNameField;
	@FXML
	private Button deleteClientClicked;
	@FXML
	private Button employeeHome;
	@FXML
	private Button employeeSignOut;
	
	
	
	public void DeleteClientClicked() throws Exception {
		try {
		TRS.letEmployeeControlClient(TRS.currentEmployee, 2, clientNameField.getText(), 0, null);
		employeeDeleteClientStatusLabel.setText("Client deleted successfuly!");
		}
		catch (NotInListException e) {
			employeeDeleteClientStatusLabel.setText(e.getNotFound() + " does not exist!");
		}
	}
	
	public void EmployeeHome() throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	public void EmployeeSignOut() throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
}
