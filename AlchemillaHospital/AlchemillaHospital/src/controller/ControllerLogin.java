package controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ControllerLogin {
	@FXML TextField loginField;
	@FXML TextField senhaField;
	
	@FXML public void onLoginClick() {
		if(loginField.getText().equals("Harry Mason") && senhaField.getText().equals("Cheryl")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/MainPane.fxml"));
				Main.getPalco().setScene(new Scene(root));
				Main.getPalco().setTitle("Alchemilla Hospital Pagina Principal");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else 
			this.alerta("Senha ou usuario incorreto");
	}
	private void alerta(String texto){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText(texto);
		alert.show();
	}
}
