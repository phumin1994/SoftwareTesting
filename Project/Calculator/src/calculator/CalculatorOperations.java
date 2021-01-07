package calculator;

import java.util.ArrayList;
import java.util.Stack;
import utils.Constants;

public class CalculatorOperations {

	public String[] convertInfixToRPN(String[] inputTokens) {
		ArrayList<String> out = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();

		for (String token : inputTokens) {
			if (Constants.OPERATORS.containsKey(token)) {
				while (!stack.empty()
						&& Constants.OPERATORS.containsKey(stack.peek())) {
					if ((isAssoc(token, Constants.LEFT_ASSOC) && comparePrece(
							token, stack.peek()) <= 0)
							|| (isAssoc(token, Constants.RIGHT_ASSOC) && comparePrece(
									token, stack.peek()) < 0)) {
						out.add(stack.pop());
						continue;
					}
					break;
				}
				stack.push(token);
			} else if (token.equals(Constants.RIGHT_SIDE_BRACKET)) {
				stack.push(token);
			} else if (token.equals(Constants.LEFT_SIDE_BRACKET)) {
				while (!stack.empty()
						&& !stack.peek().equals(Constants.RIGHT_SIDE_BRACKET)) {
					out.add(stack.pop());
				}
				stack.pop();
			} else {
				out.add(token);
			}
		}
		while (!stack.empty()) {
			out.add(stack.pop());
		}
		String[] output = new String[out.size()];
		return out.toArray(output);
	}

	private boolean isAssoc(String token, int type) {
		if (!Constants.OPERATORS.containsKey(token)) {
			throw new IllegalArgumentException("Invalid token: " + token);
		}

		if (Constants.OPERATORS.get(token)[1] == type) {
			return true;
		}
		return false;
	}

	private final int comparePrece(String token1, String token2) {
		if (!Constants.OPERATORS.containsKey(token1)
				|| !Constants.OPERATORS.containsKey(token2)) {
			throw new IllegalArgumentException("Invalid tokens: " + token1
					+ " " + token2);
		}
		return Constants.OPERATORS.get(token1)[0]
				- Constants.OPERATORS.get(token2)[0];
	}

	public double RPNtoDouble(String[] expressionTokens) {
		Stack<String> calculations = new Stack<String>();
		for (String token : expressionTokens) {
			if (!Constants.OPERATORS.containsKey(token)) {
				calculations.push(token);
			} else {
				String num1, num2 = "0";
				Double dnum2, dnum1 = 0d;
				if (token.equalsIgnoreCase(Constants.LOG_SIGN)
						|| token.equalsIgnoreCase(Constants.SIN_SIGN)
						|| token.equalsIgnoreCase(Constants.COS_SIGN)
						|| token.equalsIgnoreCase(Constants.TAN_SIGN)) {
					num1 = calculations.pop();
					dnum2 = Double
							.valueOf((num1 != null && !num1.isEmpty()) ? num1
									: "0");
				} else {
					num1 = calculations.pop();
					num2 = calculations.pop();
					dnum2 = Double
							.valueOf((num1 != null && !num1.isEmpty()) ? num1
									: "0");
					dnum1 = Double
							.valueOf((num2 != null && !num2.isEmpty()) ? num2
									: "0");
				}
				Double result = calculateResult(token, dnum1, dnum2);
				calculations.push(String.valueOf(result));
			}
		}

		return Double.valueOf(calculations.pop());
	}

	private Double calculateResult(String operator, Double num1, Double num2) {
		Double result = 0d;

		switch (operator) {
		case Constants.PLUS_SIGN:
			result = num1 + num2;
			break;
		case Constants.MINUS_SIGN:
			result = num1 - num2;
			break;
		case Constants.MULTIPLICATION_SIGN:
			result = num1 * num2;
			break;
		case Constants.DIVISION_SIGN:
			result = num1 / num2;
			break;
		case Constants.SIN_SIGN:
			result = Math.sin(num2);
			break;
		case Constants.COS_SIGN:
			result = Math.cos(num2);
			break;
		case Constants.TAN_SIGN:
			result = Math.tan(num2);
			break;
		case Constants.POWER_SIGN:
			result = Math.pow(num1, num2);
			break;
		case Constants.LOG_SIGN:
			result = Math.log(num2);
			break;
		}

		return result;
	}

	public boolean validateExpression(String expression) {

		long rightBrackercount = expression.chars().filter(ch -> ch == '(')
				.count();
		long leftBrackercount = expression.chars().filter(ch -> ch == ')')
				.count();

		return rightBrackercount == leftBrackercount;

	}
}
