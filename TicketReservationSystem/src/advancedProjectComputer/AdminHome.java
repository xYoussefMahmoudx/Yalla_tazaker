package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminHome {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	public AdminHome() {
		
	}
	
	@FXML
	private Button adminControlCategory;
	@FXML
	private Button adminControlEvent;
	@FXML
	private Button adminSignOut;
	
	public void selectControlCategory() throws IOException {
		Main m = new Main();
		m.changeScene("adminControlCategory.fxml");
	}
	public void selectControlEvent() throws IOException {
		Main m = new Main();
		m.changeScene("adminControlEvent.fxml");
	}
	public void adminSignOut() throws IOException {
		Main m = new Main();
		TRS.letAdminSignout(TRS.currentAdmin);
		m.changeScene("Home.fxml");
	}
}
