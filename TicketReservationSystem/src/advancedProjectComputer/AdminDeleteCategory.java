package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminDeleteCategory {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	public AdminDeleteCategory() {
		
	}
	
	@FXML
	private TextField adminDeleteCategory;
	@FXML
	private Label adminDeleteCategoryStatus;
	@FXML
	private Button adminDeleteCategoryButton;
	@FXML
	private Button adminHome;
	@FXML
	private Button adminSignOut;
	
	public void adminDeleteCategory() {
		TRS.letAdminControlCategory(TRS.currentAdmin, 3, adminDeleteCategory.getText(), null);
		if(TRS.error) {
			adminDeleteCategoryStatus.setText(TRS.forException);
		}
		else {
			
			adminDeleteCategoryStatus.setText("Category deleted successfuly!");
		}
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
