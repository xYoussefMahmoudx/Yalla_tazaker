package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EmployeeManageClient {
	
	public EmployeeManageClient() {
		
	}
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m = new Main();
	
	@FXML
	private Button SearchClientButton;
	@FXML
	private Button AddClientButton;
	@FXML
	private Button DeleteClientButton;
	@FXML
	private Button HomeButton;
	@FXML
	private Button SignOutButton;
	
	public void SearchClientClicked() throws IOException {
		m.changeScene("EmployeeSearchClient.fxml");
	}
	public void AddClientClicked() throws IOException {
		m.changeScene("EmployeeAddClient.fxml");
	}
	public void DeleteClientClicked() throws IOException {
		m.changeScene("EmployeeDeleteClient.fxml");
	}
	public void EmployeeHome() throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	public void EmployeeSignOut() throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
}
