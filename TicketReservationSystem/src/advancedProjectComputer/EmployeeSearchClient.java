package advancedProjectComputer;

import java.io.IOException;
import java.util.InputMismatchException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeeSearchClient {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m = new Main();
	public EmployeeSearchClient() {
		
	}
	
	
	@FXML
	private TextField searchByNameField;
	@FXML
	private TextField searchBySerialField;
	@FXML
	private Label SearchClientStatus;
	@FXML
	private Label ClientName;
	@FXML
	private Label ClientSerial;
	@FXML
	private Label ClientID;
	@FXML
	private Label ClientGender;
	@FXML
	private Label ClientMobile;
	@FXML
	private Button employeeSearchButton;
	@FXML
	private Button homeButton;
	@FXML
	private Button signOutButton;
	
	
	public void SearchClicked() throws NotInListException, AlreadyInListException {
		if(searchBySerialField.getText().isBlank() ) {
			try {
			TRS.letEmployeeControlClient(TRS.currentEmployee, 3, searchByNameField.getText(), 0, null);
			if(TRS.currentClient == null)throw new NotInListException(searchByNameField.getText(), " does not exist;");
			ClientName.setText(TRS.currentClient.getName());
			ClientSerial.setText(Integer.toString(TRS.currentClient.getSerialNumber()));
			ClientID.setText(TRS.currentClient.getNationalID());
			ClientGender.setText(TRS.currentClient.getGender()+"");
			ClientMobile.setText(TRS.currentClient.getMobile());
			}
			catch (NotInListException e) {
				SearchClientStatus.setText(e.getNotFound() + " does not exist!");
			}
			catch(ArrayIndexOutOfBoundsException a) {
				SearchClientStatus.setText(searchByNameField.getText() + " does not exist!");
			}
		}
		else if(searchByNameField.getText().isBlank()) {
			try {
			TRS.letEmployeeControlClient(TRS.currentEmployee, 4, null, Integer.parseInt(searchBySerialField.getText()), null);
			if(TRS.currentClient == null)throw new NotInListException(searchBySerialField.getText(), " does not exist;");
			ClientName.setText(TRS.currentClient.getName());
			ClientSerial.setText(Integer.toString(TRS.currentClient.getSerialNumber()));
			ClientID.setText(TRS.currentClient.getNationalID());
			ClientGender.setText(TRS.currentClient.getGender()+"");
			ClientMobile.setText(TRS.currentClient.getMobile());
			}
			catch (NotInListException e) {
				SearchClientStatus.setText("Invalid serial number");
			}
			catch (NumberFormatException e) {
				SearchClientStatus.setText("Invalid serial number");
			}
			
			catch (InputMismatchException e) {
				SearchClientStatus.setText("Invalid serial number");
			}
			
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
