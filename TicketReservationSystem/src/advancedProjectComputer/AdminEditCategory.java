package advancedProjectComputer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdminEditCategory {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	public AdminEditCategory() {
		
	}
	
	@FXML
	private TextField adminEditCategoryOld;
	@FXML
	private TextField adminEditCategoryNew;
	@FXML
	private Label adminEditCategoryStatus;
	@FXML
	private Button adminEditCategoryButton;
	@FXML
	private Button adminHome;
	@FXML
	private Button adminSignOut;
	
	public void adminEditCategory() {
		TRS.letAdminControlCategory(TRS.currentAdmin, 2, adminEditCategoryOld.getText(), adminEditCategoryNew.getText());
		if(!TRS.error) {
		adminEditCategoryStatus.setText("Category Edited Successfuly!");
		}
		else {
			adminEditCategoryStatus.setText(TRS.forException);
			
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
