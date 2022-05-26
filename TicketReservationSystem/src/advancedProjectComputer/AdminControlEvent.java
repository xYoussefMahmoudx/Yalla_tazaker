package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminControlEvent {
	
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
public AdminControlEvent() {
		
	}
	
	@FXML
	public void selectAddEvent() throws IOException {
		Main m = new Main();
		m.changeScene("adminAddEvent.fxml");
	}
	public void selectEditEvent() throws IOException {
		Main m = new Main();
		m.changeScene("adminEditEvent.fxml");
	}
	public void selectDeleteEvent() throws IOException {
		Main m = new Main();
		m.changeScene("adminDeleteEvent.fxml");
	}
	public void selectHome() throws IOException {
		Main m = new Main();
		m.changeScene("adminHome.fxml");
	}
	public void adminSignOut() throws IOException {
		Main m = new Main();
		TRS.letAdminSignout(TRS.currentAdmin);
		m.changeScene("Home.fxml");
	}
}
