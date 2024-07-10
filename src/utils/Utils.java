package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utils {
    
	public static Double tryParseToDouble(String number) {
		try {
			return Double.parseDouble(number);
		} catch(NumberFormatException e) {
			return null;
		}
	}
	
	public static Integer tryParseToInteger(String number) {
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException e) {
			return null;
		}
	}
	
	/* Método responsável por exibir uma Janela de diálogo genérica exibindo um alerta */
	public static void showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}
}
