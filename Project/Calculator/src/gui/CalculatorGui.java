package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import calculator.CalculatorOperations;
import utils.Constants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGui frame = new CalculatorGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorGui() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 567, 374);
		contentPane.add(panel);
		panel.setLayout(null);
	
              try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         
          UIManager.put("TextField.inactiveBackground", new ColorUIResource(new Color(255, 255, 255)));
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(10, 11, 547, 55);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(468, 77, 89, 40);
		panel.add(btnNewButton);
		
		JButton button = new JButton(")");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.LEFT_SIDE_BRACKET));
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(355, 77, 105, 40);
		panel.add(button);
		
		JButton button_1 = new JButton("(");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.RIGHT_SIDE_BRACKET));
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(240, 77, 105, 40);
		panel.add(button_1);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.SIN_SIGN)+ " "+Constants.RIGHT_SIDE_BRACKET);
			}
		});
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSin.setBounds(125, 77, 105, 40);
		panel.add(btnSin);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.COS_SIGN)+ " "+Constants.RIGHT_SIDE_BRACKET);
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCos.setBounds(10, 77, 105, 40);
		panel.add(btnCos);
		
		JButton button_2 = new JButton("/");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.DIVISION_SIGN));
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBounds(10, 200, 105, 40);
		panel.add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.PLUS_SIGN));
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBounds(125, 200, 105, 40);
		panel.add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_FOUR));
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBounds(240, 200, 105, 40);
		panel.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_FIVE));
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBounds(355, 200, 105, 40);
		panel.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_SIX));
			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBounds(468, 200, 89, 40);
		panel.add(button_6);
		
		JButton button_7 = new JButton("-");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.MINUS_SIGN));
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_7.setBounds(10, 263, 105, 40);
		panel.add(button_7);
		
		JButton button_8 = new JButton("^");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.POWER_SIGN));
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_8.setBounds(125, 263, 105, 40);
		panel.add(button_8);
		
		JButton button_9 = new JButton("1");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_ONE));
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_9.setBounds(240, 263, 105, 40);
		panel.add(button_9);
		
		JButton button_10 = new JButton("2");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_TWO));
			}
		});
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_10.setBounds(355, 263, 105, 40);
		panel.add(button_10);
		
		JButton button_11 = new JButton("3");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_THREE));
			}
		});
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_11.setBounds(468, 263, 89, 40);
		panel.add(button_11);
		
		JButton btnLog = new JButton("ln");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.LOG_SIGN));
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLog.setBounds(10, 323, 105, 40);
		panel.add(btnLog);
		
		JButton button_14 = new JButton("0");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_ZERO));
			}
		});
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_14.setBounds(240, 323, 105, 40);
		panel.add(button_14);
		
		JButton button_15 = new JButton(".");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),"."));
			}
		});
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_15.setBounds(355, 323, 105, 40);
		panel.add(button_15);
		
		JButton button_16 = new JButton("=");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorOperations calOperations = new CalculatorOperations();
				if(!calOperations.validateExpression(textField.getText())){
					textField.setText("Invalid Expression");
				}
				else{
					String[] input = textField.getText().split(" ");   
				      
			        String[] output = calOperations.convertInfixToRPN(input);
			         for (String token : output) {
		            System.out.println(token + " ");
		        }
			        Double result = calOperations.RPNtoDouble( output );
			        textField.setText(Constants.FORMAT_TWO.format(result));
				}
			}
		});
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_16.setBounds(468, 323, 89, 40);
		panel.add(button_16);
		
		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.MULTIPLICATION_SIGN));
			}
		});
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnX.setBounds(10, 138, 105, 40);
		panel.add(btnX);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.TAN_SIGN)+ " "+Constants.RIGHT_SIDE_BRACKET+" ");
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTan.setBounds(125, 138, 105, 40);
		panel.add(btnTan);
		
		JButton button_19 = new JButton("7");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_SEVEN));
			}
		});
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_19.setBounds(240, 138, 105, 40);
		panel.add(button_19);
		
		JButton button_20 = new JButton("8");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_EIGHT));
			}
		});
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_20.setBounds(355, 138, 105, 40);
		panel.add(button_20);
		
		JButton button_21 = new JButton("9");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(generateString(textField.getText(),Constants.NUMBER_NINE));
			}
		});
		button_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_21.setBounds(468, 138, 89, 40);
		panel.add(button_21);
	}
	
	private String generateString(String expression,String operator){
		String newExpres = "";
		if(expression!=null && !expression.isEmpty()&& 
				((Character.isDigit(operator.charAt(0))&&Character.isDigit(expression.charAt(expression.length()-1)))||
				operator.equalsIgnoreCase(".") || new Character('.').equals(expression.charAt(expression.length()-1)))){
			newExpres =expression+operator ;
		}
		else{
			newExpres = expression+" "+operator;
		}
		return newExpres;
	}
}
