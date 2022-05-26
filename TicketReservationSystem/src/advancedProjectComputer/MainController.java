package advancedProjectComputer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MainController  implements Initializable {


	@FXML
	private TextField serialTextFieldinput;
	
	@FXML
	private TextField SearchNametxtFieldInput;
	
	
	@FXML
	private TextField clientNameTxtField;
	@FXML
	private TextField clientSerialTxtField;
	@FXML
	private TextField clientNationalIDTxtField;
	@FXML
	private TextField clientGenderTxtField;
	@FXML
	private TextField mobileTxtField;
	

	@FXML
	private Label errorMsgs;
	@FXML
	private Label nameLabel;
	@FXML
	private Label clientserialNumberLabel;
	@FXML
	private Label nationalIDLabel;	
	@FXML
	private Label genderLabel;	
	@FXML
	private Label mobileLabel;	
	boolean loginFlag = false;
	static String errorMsg;
	Integer serialNumber;
	String SearchNamestr;
	TicketReservationSystem TRS = TicketReservationSystem.getInstance();
	Main m =new Main();

	@FXML
	private void searchName(ActionEvent event) {
		event.consume();
		try {
			SearchNamestr =SearchNametxtFieldInput.getText();
		}
		catch(NullPointerException exx) {
			
			errorMsgs.setText(exx.getMessage());
		}

		
		int index=-1;
		try {
			for (int i = 0; i < TRS.clients.size(); i++) {
				
			      if(TRS.clients.get(i).getName().equals(SearchNamestr) ) {
			    	  
			    	 index=i;
			      }
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("User not found!!");
			errorMsgs.setText("User not found!!");
			
		}
		
			if(loginFlag==true && index>=0) {
				
				System.out.println("client name is "+ TRS.clients.get(index).getName());
				System.out.println("client seial number is "+ TRS.clients.get(index).getSerialNumber());
				System.out.println("client national ID is "+ TRS.clients.get(index).getNationalID());
				System.out.println("client Gender is "+ TRS.clients.get(index).getGender());
				System.out.println("client mobile is "+ TRS.clients.get(index).getMobile());
				
				
				
				String name= TRS.clients.get(index).getName();
				nameLabel.setText(name);
				
				int clientserialNumber= TRS.clients.get(index).getSerialNumber();
				String s=Integer.toString(clientserialNumber);
				clientserialNumberLabel.setText(s);

				String nationalID= TRS.clients.get(index).getNationalID();
				nationalIDLabel.setText(nationalID);
				
				char gender= TRS.clients.get(index).getGender();
				String tempStr=Character.toString(gender);
				genderLabel.setText(tempStr);
				
				String mobile =TRS.clients.get(index).getMobile();
				mobileLabel.setText(mobile);
				
	
			} else {
				try {
					throw new Exception("you are not signed in");
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
					errorMsgs.setText(e.getMessage());
				}
			
			}

			
		
		
		

	}
	@FXML
	private void searchSerialNumber(ActionEvent event) {
		event.consume();
		try {
		 serialNumber =Integer.parseInt(serialTextFieldinput.getText());
		}
		catch(NullPointerException exx) {
			
			errorMsgs.setText(exx.getMessage());
		}

		int index=-1;
		for (int i = 0; i <TRS.clients.size(); i++) {
			try {
				if(TRS.clients.get(i).getSerialNumber()==serialNumber ) {

					index=i;
				}

			}catch (InputMismatchException exception){

				System.out.println("your input is type mismatch, please check your input and try again. Press enter key to exit");
				errorMsg="your input is type mismatch, please check your input and try again.";
				errorMsgs.setText(errorMsg);

				if (serialNumber.equals(null)) {
					break;
				}}catch ( Exception ex){

					System.out.println(" Serial number is not found, press enter to exit");
					errorMsg= "Serial number is not found, press enter to exit";
					errorMsgs.setText(errorMsg);
					if (serialNumber.equals(null)) {
						break;
					}


				}}


		if(loginFlag==true && index>=0) {
			
			String name= TRS.clients.get(index).getName();
			nameLabel.setText(name);
			
			int clientserialNumber= TRS.clients.get(index).getSerialNumber();
			String s=Integer.toString(clientserialNumber);
			clientserialNumberLabel.setText(s);

			String nationalID= TRS.clients.get(index).getNationalID();
			nationalIDLabel.setText(nationalID);
			
			char gender= TRS.clients.get(index).getGender();
			String tempStr=Character.toString(gender);
			genderLabel.setText(tempStr);
			
			String mobile =TRS.clients.get(index).getMobile();
			mobileLabel.setText(mobile);


		} else {
			try {
				new Exception("you are not signed in");

			}catch(Exception e) {
				System.out.println(e.getMessage());
				errorMsg =e.getMessage().toString();
				errorMsgs.setText(errorMsg);
			}

		}
	}
	
	
	@FXML
	private void addClient(ActionEvent event) {
		event.consume();
		while(true) {
			try {
		if(loginFlag==true) {
			
			
			Client c1=new Client();
			
			System.out.println("adding client to system");
			System.out.println("insert client name ");
			c1.setName(clientNameTxtField.getText());
			
			c1.setSerialNumber();
			System.out.println("insert client mobile number");
			
				
			if(mobileTxtField.getText().length()==11){
				c1.setMobile(mobileTxtField.getText());

			}else {
				try {
					throw new Exception("Enter the mobile number not less than 11 digits");
					
				}catch(Exception e){
					System.out.println(e);
					errorMsgs.setText(e.getMessage());
					
				}
				
			}
			
			System.out.println("insert client gender");
			c1.setGender(clientGenderTxtField.getText().charAt(0));
			System.out.println("insert client national ID");
			if(clientNationalIDTxtField.getText().length()==14){
				c1.setNationalID(clientNationalIDTxtField.getText());

			}else {
				try {
					throw new Exception("Enter the National ID not less than 14 digits");
					
				}catch(Exception e){
					System.out.println(e);
					errorMsgs.setText(e.getMessage());
				}
				
			}
			TRS.clients.add(c1);
			System.out.println(" you have added client succesfuly");
			errorMsgs.setText( "you have added client succesfuly");
		}
		
		//else {
		//	System.out.println(" you are not signed in");
		
		
		//}
		
			}
			catch (InputMismatchException exception){
				
	            System.out.println("your input is type mismatch, please check your input and try again. Press enter key to exit");
	            errorMsgs.setText("your input is type mismatch, please check your input and try again.");
//	            if (input.next().isEmpty()) {
//	                break;
//	            }
				
				
			}catch ( Exception e){
				
	            System.out.println(" you are not signed in, press enter to exist");
	            errorMsgs.setText(" you are not signed in, press enter to exist");
//	            if (input.next().isEmpty()) {
//	                break;
//	            }
	           
			}
		}
	}
	
	@FXML
	public void selectHome(ActionEvent event) throws IOException {
		m.changeScene("EmployeeMainHomeScene.fxml");
	}
	@FXML
	public void signOut() throws IOException {
		TRS.letEmployeeSignout(TRS.currentEmployee);
		m.changeScene("Home.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
