package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminAddCategory {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	public AdminAddCategory() {
		
	}
	
	@FXML
	private TextField adminAddCategoryType;
	@FXML
	private Button adminAddCategoryButton;
	@FXML
	private Button adminHome;
	@FXML
	private Button adminSignOut;
	@FXML
	private Label adminAddCategoryStatus;
	
	
	public void addCategory() {
		TRS.letAdminControlCategory(TRS.currentAdmin, 1, adminAddCategoryType.getText(), null);
		if(TRS.error) {
			adminAddCategoryStatus.setText(TRS.forException);
		}
		else {
			adminAddCategoryStatus.setText("Category Added Successfuly!");
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
