package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminControlCategory {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	public AdminControlCategory() {
		
	}
	
	@FXML
	private Button adminAddCategory;
	@FXML
	private Button adminEditCategory;
	@FXML
	private Button adminDeleteCategory;
	@FXML
	private Button adminHome;
	@FXML
	private Button adminSignOut;
	
	public void selectAddCategory() throws IOException {
		Main m = new Main();
		m.changeScene("adminAddCategory.fxml");
	}
	public void selectEditCategory() throws IOException {
		Main m = new Main();
		m.changeScene("adminEditCategory.fxml");
	}
	public void selectDeleteCategory() throws IOException {
		Main m = new Main();
		m.changeScene("adminDeleteCategory.fxml");
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
