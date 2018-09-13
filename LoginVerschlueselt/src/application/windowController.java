package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class windowController {
	@FXML Button btnLogin;
	@FXML Button btnAbort;
	@FXML TextField txtUsername;
	@FXML PasswordField txtPassword;
	
	/*
	@FXML
	public void onEnter(ActionEvent ae){
	   login()
	}
	*/
	
	public void initialize() {
		btnLogin.setOnAction(e -> { login();});
		txtPassword.setOnAction(e -> { login();});
		txtUsername.setOnAction(e -> { login();});
		
		Datenbank.login();
	}
	

	
	
	public void login() {
		String username = txtUsername.getText();
		String password = txtPassword.getText();	
		
		if (username.length() > 0 && password.length() > 0)
		{
			Datenbank.checkUser(username, password);		
			
			
		}

		/*
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		
		System.out.println(username);
		System.out.println(password);
		*/
				
		
	}
}
