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
		try {
			Employee myEmployee = TRS.letEmployeeStart('Y',employeeUsername.getText().toString(), employeePassword.getText().toString());
			m.changeScene("adminHome.fxml");
			System.out.println("1"+TRS.employees.get(0).getAccount().getUserName());
		}
		catch(NullPointerException e) {
			employeeSignInStatus.setText("Wrong username or password!");
			System.out.println("2"+TRS.employees.get(0).getAccount().getUserName());
		}
	}
	// Event Listener on Button[#employeeRegisterButton].onAction
	@FXML
	public void employeeRegister(ActionEvent event) throws IOException {
		
			
					try {
						
						Employee currentEmployee = TRS.letEmployeeStart('N',employeeUsername.getText().toString(), employeePassword.getText().toString());
						
						m.changeScene("adminHome.fxml");
						System.out.println("1"+TRS.employees.get(0).getAccount().getUserName());
					}
					catch (Exception e) {
						employeeSignInStatus.setText("Wrong username or password!");	
						System.out.println("2"+TRS.employees.get(0).getAccount().getUserName());
						e.printStackTrace();
				}
	}
		
}
