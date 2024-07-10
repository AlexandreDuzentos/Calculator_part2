package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.CalculatorState;
import utils.Constraints;
import utils.Utils;

public class CalculatorViewController implements Initializable {
    
	/* 
	 * Criando uma dependência do meu controller com
	 * o CalculatorState.
	 * */
	private CalculatorState state;
	
	@FXML
	private TextField txtNumber;
	
	@FXML
	private Button zero;
	
	@FXML
	private Button one;
	
	@FXML
	private Button two;
	
	@FXML
	private Button three;
	
	@FXML
	private Button four;
	
	@FXML
	private Button five;
	
	@FXML
	private Button six;
	
	@FXML
	private Button seven;
	
	@FXML
	private Button eight;
	
	@FXML
	private Button nine;
	
	@FXML
	private Button plus;
	
	@FXML
	private Button minus;
	
	@FXML
	private Button div;
	
	@FXML
	private Button mult;
	
	@FXML
	private Button AC;
	
	@FXML
	private Button period;
	
	@FXML
	private Button equal;
	
	@FXML
    private void onBtZeroClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);	
    }
	
    @FXML
    private void onBtOneClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);	
    }
    
    @FXML
    private void onBtTwoClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtThreeClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtFourClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtFiveClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtSixClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtSevenClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtEightClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtNineClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtPlusClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addOperation(buttonValue);
    }
    
    @FXML
    private void onBtMinusClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addOperation(buttonValue);
    }
    
    @FXML
    private void onBtMultClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addOperation(buttonValue);
    }
    
    @FXML
    private void onBtDivClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addOperation(buttonValue);
    }
    
    @FXML
    private void onBtAcClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	clear();
    }
    
    @FXML
    private void onBtPeriodClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addDigit(buttonValue);
    }
    
    @FXML
    private void onBtEqualClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addOperation(buttonValue);
    }
    
    @FXML
    private void onBtPlusOrMinusClick(ActionEvent event) {
    	String buttonValue = ((Button)event.getSource()).getText();
    	addOperation(buttonValue);
    	System.out.println("Clicou");
    }
	
	/*
	 * Método responsável por injetar a dependência do
	 * CalculatorState.
	 * */
	public void setCalculatorState(CalculatorState state) {
		this.state = state;
	}

	/* Método executado quando o controller é instânciado, ele
	 * é comumente utilizado para iniciar o comportamento da 
	 * nossa view.
	 * */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setCalculatorState(new CalculatorState());
		
		Constraints.setTextFieldDouble(txtNumber);
		Constraints.setTextFieldMaxLength(txtNumber, 25);
		
		/* Setando o estado inicial da calculadora */
		state.setInicialState();
	}
	
	/* 
	 * Método responsável por adicionar números e
	 * ponto no TextField e também no estado da
	 * calculadora.
	 * */
	public void addDigit(String buttonValue) {
		 if(txtNumber.getText().equals("0")) {
			   txtNumber.setText(buttonValue);
		   } else {
			   txtNumber.setText(txtNumber.getText() + buttonValue);
		   } 
		   
		 if(!buttonValue.equals(".")) {
			 if(state.getState()) {
				   state.setNumber2(Utils.tryParseToDouble(txtNumber.getText()));
			   } else {
				   state.setNumber1(Utils.tryParseToDouble(txtNumber.getText()));
			   }
		 }   
	}
	
	/* 
	 * Método responsável por adicionar operações no estado 
	 * da calculadora, bem como mudar o valor da propriedade
	 * state dela.
	 * */
	public void addOperation(String buttonValue) {
		   
		   if(!buttonValue.equals("=")) {
			   txtNumber.setText("");
			   state.setOperation(buttonValue);
			   state.setState(true);
		   }
		    
		   double result = 0.0;
			if(buttonValue.equals("=")) {
				if(state.getOperation() == null) {
					Double defaultValue = 0.0;
					txtNumber.setText(String.valueOf(defaultValue));
					state.setNumber1(defaultValue);
					return;
				}
				switch(state.getOperation()) {
				   case "+":
					   result = state.getNumber1() + state.getNumber2();
					   txtNumber.setText(String.format("%.2f", result));
					   state.setInicialState();
					   state.setNumber1(result);
					   break;
				   case "-":
					   result = state.getNumber1() - state.getNumber2();
					   txtNumber.setText(String.format("%.2f", result));
					   state.setInicialState();
					   state.setNumber1(result);
					   break;
				   case "X":
					   result = state.getNumber1() * state.getNumber2();
					   txtNumber.setText(String.format("%.2f", result));
					   state.setInicialState();
					   state.setNumber1(result);
					   break;
				   case "/":
					   if(state.getNumber2() == 0) {
						   Utils.showAlert("Division by zero",null, "Impossible divide by zero", AlertType.ERROR);
						   return;
					   }
					   result = state.getNumber1() / state.getNumber2();
					   state.setInicialState();
					   
					   state.setNumber1(result);
					   break;
				   default:
					   System.out.println("Nenhuma operação");
				}
			}
	}
	
	/* Método responsável por voltar a calculadora ao estado
	 * inicial e por limpar o conteúdo do TextField.
	 **/
	public void clear() {
		txtNumber.setText("");
		state.setInicialState();
	}
}

