package utils;

import javafx.scene.control.TextField;

public class Constraints {
	/* Método responsável por limitar a quantidade de dígitos de um
	 * TextField.
	 * */
	public static void setTextFieldMaxLength(TextField txt, int max) { 
		 txt.textProperty().addListener((obs, oldValue, newValue) -> { 
			 if (newValue != null && newValue.length() > max) { 
			     txt.setText(oldValue); 
			 } 
		 }); 
    } 
	
	/* Método responsável por restrigir outros tipos de
	 * de valores para o TextField diferente de Double.
	 * */
		public static void setTextFieldDouble(TextField txt) { 
			/* Aqui basicamente eu estou adicionando uma função que irá
			 * observar ou monitar modificações num objeto do tipo TextField
			 * e executar uma função lambda em resposta a essas alterações.
			 * 
			 * Essa função recebe três parâmetros, um obs(Observable) que é
			 * uma referência para o controle TextField, o oldValue que é uma
			 * referência para o valor que ele tinha antes de ser modificado, o
			 * newValue que é uma referência para o novo valor dele após a modificação.
			 * */
		    txt.textProperty().addListener((obs, oldValue, newValue) -> { 
		        if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) { 
		            txt.setText(oldValue); 
		        } 
		   }); 
		 } 
}
