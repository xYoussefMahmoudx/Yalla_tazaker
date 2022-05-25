package advancedProjectComputer;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class EmployeeSignInController {
	@FXML
	private TextField employeeUsername;
	@FXML
	private PasswordField employeePassword;
	@FXML
	private Button employeeSignInButton;
	@FXML
	private Label employeeSignInStatus;
	@FXML
	private Button employeeRegisterButton;
	Main m=new Main();
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	// Event Listener on Button[#employeeSignInButton].onAction
	@FXML
	public void employeeSignIn(ActionEvent event) throws IOException {
		
	
Employee myEmployee = TRS.letEmployeeStart('Y',employeeUsername.getText().toString(), employeePassword.getText().toString());
		
		if(myEmployee == null) {
			
			employeeSignInStatus.setText("Wrong username or password!");
			
		}
		else {
			
			m.changeScene("adminHome.fxml");
			//m.changeScene("adminSignIn.fxml");
		}
	}
	// Event Listener on Button[#employeeRegisterButton].onAction
	@FXML
	public void employeeRegister(ActionEvent event) throws IOException {
		
			Employee currentEmployee = TRS.letEmployeeStart('N',employeeUsername.getText().toString(), employeePassword.getText().toString());
					
					if(currentEmployee == null) {
						
						employeeSignInStatus.setText("Wrong username or password!");
						
					}
					else {
						
						m.changeScene("adminHome.fxml");
						//m.changeScene("adminSignIn.fxml");
				}
	}
		
}
