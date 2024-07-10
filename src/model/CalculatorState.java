package model;

public class CalculatorState {
  
	private Double number1;
	private Double number2;
	private String operation;
	
	/* State true indica que o valor digitado no textField
	 * será armazenado no atributo number2, state false
	 * significa que ele será armazenado no atributo number1
	 * */
	private Boolean state;
	
	public CalculatorState() {
	}
	
	public Double getNumber1() {
		return number1;
	}

	public void setNumber1(Double number1) {
		this.number1 = number1;
	}

	public Double getNumber2() {
		return number2;
	}

	public void setNumber2(Double number2) {
		this.number2 = number2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	/* Método responsável por setar o estado inicial da calculadora */
	public void setInicialState() {
		number1 = 0.0;
		number2 = 0.0;
		operation = null;
		state = false;
	}
	
	
	
	
	
	
}
