package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Home {
	
	
	public Home() {
		
	}
	@FXML
	private Button homeAdmin;
	@FXML
	private Button homeEmployee;
	
	
	public void selectAdmin() throws IOException {
		Main m = new Main();
		m.changeScene("adminSignIn.fxml");
	}
	public void selectEmployee() throws IOException {
		Main m = new Main();
		m.changeScene("EmployeeSignIn.fxml");
	}
}
