package unittest;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import calculator.CalculatorOperations;
import utils.Constants;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorJunit {
	static CalculatorOperations calculator;
	
	@BeforeAll
	public static void initDriver(){
		calculator = new CalculatorOperations();
	}
	
	@Test
	@Order(1)
	//TO verify add functionality
	public void testCaseOne(){
		 Double expectedResponse = 10d;
		 String expression =" 5 + 5 ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(actualResponse, expectedResponse);
	}
	
	@Test
	@Order(2)
	//TO verify subtract functionality
	public void testCaseTwo(){
		 String expectedResponse = "10";
		 String expression =" 15 - 5 ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(3)
	//TO verify multiplication functionality
	public void testCaseThree(){
		 String expectedResponse = "10";
		 String expression =" 2 * 5 ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(4)
	//TO verify division functionality
	public void testCaseFour(){
		 String expectedResponse = "10";
		 String expression =" 20 / 2 ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(5)
	//TO verify sin functionality
	public void testCaseFive(){
		 String expectedResponse = "0.89";
		 String expression =" sin ( 90 ) ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(6)
	//TO verify cos functionality
	public void testCaseSix(){
		 String expectedResponse = "-0.45";
		 String expression =" cos ( 90 ) ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(7)
	//TO verify tan functionality
	public void testCaseSeven(){
		 String expectedResponse = "0.32";
		 String expression =" tan ( 60 ) ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(8)
	//TO verify log functionality
	public void testCaseEight(){
		 String expectedResponse = "3.09";
		 String expression =" ln ( 22 ) ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(9)
	//TO verify power functionality
	public void testCaseNine(){
		 String expectedResponse = "16";
		 String expression =" 4 ^ 2 ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(10)
	//TO verify valid expression functionality
	public void testCaseTen(){
		 String expectedResponse = "87.89";
		 String expression =" 5 + 3 * ( 5 * 5 ) + sin ( 9 * 10 ) + 2 ^ 2 + ln ( 2 * 10 ) ";
		 String[] input = expression.split(" ");   
		 String[] output = calculator.convertInfixToRPN(input);
	     Double actualResponse = calculator.RPNtoDouble( output );
		 assertEquals(Constants.FORMAT_TWO.format(actualResponse), expectedResponse);
	}
	
	@Test
	@Order(11)
	//TO verify valid invalid expression functionality
	public void testCaseEleven(){
		 boolean expectedResponse = false;
		 String expression =" 5 + 3 * ( 5 * 5 ) + sin ( 9 * 10  + 2 ^ 2 + ln ( 2 * 10 ) ";
		 boolean actualResponse = calculator.validateExpression(expression);
		 assertEquals(actualResponse, expectedResponse);
	}
}
