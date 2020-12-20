package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController{
	
	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;
	@FXML
	private TextField txtNumber3;
	@FXML
	private TextField txtNumber4;
	@FXML
	private Button btCheck;
	
	@FXML
	public void onBtCheckAction() {
		try {
			if (txtNumber1.getText().equals("")&& txtNumber2.getText().equals("") && txtNumber3.getText().equals("") && txtNumber4.getText().equals("")) {
				Alerts.showAlert("Invalid entry", null, "You cant leave empty fields", AlertType.ERROR);
			} else if (txtNumber3.getLength() < 8) {
				Alerts.showAlert("Password too short", null, "Please insert a password with 8 caracteres",
						AlertType.WARNING);
			} else if (txtNumber3.getText().contains(txtNumber1.getText())) {
				Alerts.showAlert("Password contains name", null, "Your password cannot contain your name",
						AlertType.WARNING);
			} else if (!(txtNumber3.getText()).matches("(.*[A-Z].*)")) {
				Alerts.showAlert("Invalid password", null, "Your password needs a least one upper case caractere",
						AlertType.WARNING);
			} else if (!(txtNumber3.getText()).matches("(.*[0-9].*)")) {
				Alerts.showAlert("Invalid password", null, "Your password needs a least one number", AlertType.WARNING);
			} else if (!(txtNumber3.getText())
					.matches("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")) {
				Alerts.showAlert("Invalid password", null, "Your password needs a least one special caractere",
						AlertType.WARNING);
			} else if (txtNumber3.getText() == txtNumber2.getText()) {
				Alerts.showAlert("Invalid password", null, "Your password cannot be the same as old password",
						AlertType.WARNING);
			} else if (!(txtNumber3.getText().matches(txtNumber4.getText()))) {
				Alerts.showAlert("Invalid password", null, "New passwords dont match", AlertType.WARNING);
			} else {
				Alerts.showAlert("Valid password", null, "Your password is valid", AlertType.CONFIRMATION);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
