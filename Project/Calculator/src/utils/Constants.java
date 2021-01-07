package utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final int LEFT_ASSOC = 0;
	public static final int RIGHT_ASSOC = 1;
	public static DecimalFormat FORMAT_TWO = new DecimalFormat("#.##");
	public static final String PLUS_SIGN = "+";
	public static final String DIVISION_SIGN = "/";
	public static final String MINUS_SIGN = "-";
	public static final String MULTIPLICATION_SIGN = "*";
	public static final String SIN_SIGN = "sin";
	public static final String COS_SIGN = "cos";
	public static final String TAN_SIGN = "tan";
	public static final String RIGHT_SIDE_BRACKET = "(";
	public static final String LEFT_SIDE_BRACKET = ")";
	public static final String POWER_SIGN = "^";
	public static final String LOG_SIGN = "ln";
	public static final String NUMBER_ONE = "1";
	public static final String NUMBER_TWO = "2";
	public static final String NUMBER_THREE = "3";
	public static final String NUMBER_FOUR = "4";
	public static final String NUMBER_FIVE = "5";
	public static final String NUMBER_SIX = "6";
	public static final String NUMBER_SEVEN = "7";
	public static final String NUMBER_EIGHT = "8";
	public static final String NUMBER_NINE = "9";
	public static final String NUMBER_ZERO = "0";
	

	public static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();
	static {
		OPERATORS.put(PLUS_SIGN, new int[] {precedence(PLUS_SIGN), LEFT_ASSOC });
		OPERATORS.put(MINUS_SIGN, new int[] {precedence(MINUS_SIGN), LEFT_ASSOC });
		OPERATORS.put(SIN_SIGN, new int[] {precedence(SIN_SIGN), LEFT_ASSOC });
		OPERATORS.put(COS_SIGN, new int[] {precedence(COS_SIGN), LEFT_ASSOC });
		OPERATORS.put(TAN_SIGN, new int[] {precedence(TAN_SIGN), LEFT_ASSOC });
		OPERATORS.put(LOG_SIGN, new int[] {precedence(COS_SIGN), LEFT_ASSOC });
		OPERATORS.put(POWER_SIGN, new int[] {precedence(TAN_SIGN), LEFT_ASSOC });
		OPERATORS.put(MULTIPLICATION_SIGN, new int[] {precedence(MULTIPLICATION_SIGN), LEFT_ASSOC });
		OPERATORS.put(DIVISION_SIGN, new int[] {precedence(DIVISION_SIGN), LEFT_ASSOC });
	}
	
	public static int precedence(String c){
	        switch (c){
	            case PLUS_SIGN:
	            case MINUS_SIGN:
	                return 0;
	            case MULTIPLICATION_SIGN:
	            case DIVISION_SIGN:
	                return 5;
	            case POWER_SIGN:
	                return 3;
	            case SIN_SIGN:
	            case COS_SIGN:
	            case TAN_SIGN:
	            case LOG_SIGN:
	                return 6;
	        }
	        return -1;
	    }
}
