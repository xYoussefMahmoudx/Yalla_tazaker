package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeeAddClient {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m = new Main();
	
	public EmployeeAddClient() {
		
	}
	
	@FXML
	private TextField clientNameField;
	@FXML
	private TextField clientIDField;
	@FXML
	private TextField clientGenderField;
	@FXML
	private TextField clientMobileField;
	@FXML
	private Label employeeAddClientStatus;
	@FXML
	private Button employeeAddClientButton;
	@FXML
	private Button employeeHomeButton;
	@FXML
	private Button employeeSignOutButton;
	
	
	public void addClientClicked() {
		try {
			//if(clientGenderField.getText().isBlank() || clientMobileField.getText().isBlank() || clientNameField.getText().isBlank() || clientIDField.getText().isBlank())throw new Exception("All fields are required!");
			//if(!(clientMobileField.getText().length() == 11))throw new Exception("Mobile must be 11 numbers!");
			//if(clientGenderField.getText().charAt(0) == 'M' || clientGenderField.getText().charAt(0) == 'F')throw new Exception("Gender must be M or F");
			//if(clientIDField.getText().length() > 14 || clientIDField.getText().length() < 14)throw new Exception("National ID must be 14 numbers");
			//Integer.parseInt(clientMobileField.getText());
			//Integer.parseInt(clientIDField.getText());
		TRS.clientID = clientIDField.getText();
		TRS.clientMobile = clientMobileField.getText();
		TRS.clientGender = clientGenderField.getText().charAt(0);
		TRS.letEmployeeControlClient(TRS.currentEmployee, 1, clientNameField.getText(), 0, null);
		employeeAddClientStatus.setText("Client added successfuly!");
		}
		/*catch (AlreadyInListException e) {
			
			employeeAddClientStatus.setText(e.getFound() + "  This national ID exist!");
		}*/
		catch (NotInListException e) {
			employeeAddClientStatus.setText(e.getNotFound());
		}
		catch (AlreadyInListException e) {
			employeeAddClientStatus.setText("Client already exist!");
		}
		/*catch (Exception e) {
			System.out.println("in exception");
			e.printStackTrace();
			employeeAddClientStatus.setText(e.getMessage());
		}*/
		/*catch (NumberFormatException e) {
			employeeAddClientStatus.setText("Invalid Details!");
		}*/
	}
	
	
	
	public void EmployeeHome() throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	public void EmployeeSignOut() throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
}
