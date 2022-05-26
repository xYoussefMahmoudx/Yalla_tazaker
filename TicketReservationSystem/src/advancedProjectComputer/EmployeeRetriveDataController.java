package advancedProjectComputer;

import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeeRetriveDataController {
	@FXML
	private Label eve1;
	@FXML
	private Label eve2;
	@FXML
	private Label eve3;
	@FXML
	private Label eve4;
	@FXML
	private Label eve5;
	@FXML
	private Label eve6;
	@FXML
	private Label eve7;
	@FXML
	private Label errorShow;
	@FXML
	private TextField tfCat;
	
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m = new Main();

	// Event Listener on Button.onAction
	@FXML
	public void btnHome(ActionEvent event) throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnSignOut(ActionEvent event) throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnRetrive(ActionEvent event) {
	try {
		TRS.eventNames.clear();
			TRS.eventNames=	TRS.currentEmployee.getEventsOfSameCategoty(tfCat.getText(),TRS.events);
				for (int i=0;i<TRS.eventNames.size();i++) {
					getlabel(i).setText(TRS.eventNames.get(i));
				}
	} catch (NotInListException e) {
		errorShow.setText( "category is not found ");
	}
		
	}
	public Label getlabel(int i) {
		if (i==0) return eve1;
		else if (i==1)  return eve2;
		else if (i==2)  return eve3;
		else if (i==3)  return eve4;
		else if (i==4)  return eve5;
		else if (i==5)  return eve6;
			else return eve7;
				
			
		
	}
}
