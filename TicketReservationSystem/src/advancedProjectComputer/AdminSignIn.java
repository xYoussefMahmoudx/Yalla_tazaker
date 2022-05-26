package advancedProjectComputer;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminSignIn {
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	public AdminSignIn() {
		
	}
	
	@FXML
	private Button adminSignInButton;
	@FXML
	private Label adminSignInStatus;
	@FXML
	private TextField adminUsername;
	@FXML
	private PasswordField adminPassword;
	
	
	public void adminSignIn() throws IOException {
		Main m = new Main();
		Admin myAdmin = TRS.letAdminSignin(adminUsername.getText().toString(), adminPassword.getText().toString());
		
		if(myAdmin == null) {
			
			adminSignInStatus.setText("Wrong username or password!");
			
		}
		else {
			
			m.changeScene("adminHome.fxml");
			
		}
	}
	
	
	
	
	
	
	
	/*Scene adminSignInScene;
	@Override
	public void start(Stage adminSignInStage) {
		
	
	FlowPane adminSignInPane = new FlowPane();
	javafx.scene.control.Label adminSignInFailedLabel = new javafx.scene.control.Label();
	HBox adminSignInFailedHBox = new HBox(4);
	adminSignInFailedHBox.getChildren().addAll(adminSignInFailedLabel);
	
	javafx.scene.control.Label adminUserNameLabel = new javafx.scene.control.Label("User Name: ");
	javafx.scene.control.TextField adminUserNameTextField = new javafx.scene.control.TextField();
	HBox adminUserNameHBox = new HBox(4);
	adminUserNameHBox.getChildren().addAll(adminUserNameLabel,adminUserNameTextField);
	javafx.scene.control.Label adminPasswordLabel = new javafx.scene.control.Label("Password: ");
	javafx.scene.control.TextField adminPasswordTextField = new javafx.scene.control.TextField();
	HBox adminPasswordHBox = new HBox(4);
	adminPasswordHBox.getChildren().addAll(adminPasswordLabel,adminPasswordTextField);
	javafx.scene.control.Button adminSignInButton = new javafx.scene.control.Button("Sign In");
	adminSignInPane.getChildren().addAll(adminSignInFailedHBox,adminUserNameHBox,adminPasswordHBox,adminSignInButton);
	
	adminSignInScene = new Scene(adminSignInPane);
	adminSignInStage.setScene(adminSignInScene);
	
	
	adminSignInButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				TRS.letAdminSignin(adminUserNameTextField.getText(),adminPasswordTextField.getText());
				
				
			}
		
	});
	
	}
	public Scene getAdminSignInScene() {
		return adminSignInScene;
	}*/
}
