package utils;


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
}
