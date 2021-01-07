package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
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
	public GameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGameName = new JLabel("Tic Tac Toe");
		lblGameName.setBounds(185, 27, 105, 14);
		panel.add(lblGameName);
		
		
		textField = new JTextField();
		textField.setBounds(200, 64, 113, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterGridSize = new JLabel("Enter Grid Size:");
		lblEnterGridSize.setBounds(85, 67, 105, 14);
		panel.add(lblEnterGridSize);
		
		JRadioButton rdbtnX = new JRadioButton("X");
		rdbtnX.setBounds(210, 96, 39, 23);
		panel.add(rdbtnX);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("O");
		rdbtnNewRadioButton.setBounds(262, 96, 39, 23);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblSelectPlayer = new JLabel("Select Player:");
		lblSelectPlayer.setBounds(85, 100, 105, 14);
		panel.add(lblSelectPlayer);
		
		Button button = new Button("Play Game");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()){
					UIManager UI=new UIManager();
					  UI.put("OptionPane.background", new Color(105, 165, 18));
					JOptionPane.showMessageDialog(new JFrame(), "Please Enter Grid Size", "Error",
					        JOptionPane.ERROR_MESSAGE);
				}
				if(!rdbtnX.isSelected() && !rdbtnNewRadioButton.isSelected() && !textField.getText().isEmpty()){
					UIManager UI=new UIManager();
					  UI.put("OptionPane.background", new Color(255, 0, 0));
					JOptionPane.showMessageDialog(new JFrame(), "Please Select Player", "Error",
					        JOptionPane.ERROR_MESSAGE);
				}
				if (!textField.getText().isEmpty()
						&& (rdbtnX.isSelected() || rdbtnNewRadioButton
								.isSelected())) {
					Constants.SIZE = Integer.parseInt(textField.getText());
					Constants.SELECTED_PLAYER = rdbtnX.isSelected() ? "X" : "O";
					Constants.OPPONENT = Constants.SELECTED_PLAYER
							.equalsIgnoreCase("X") ? "O" : "X";
					new TicTacToeGUI().setVisible(true);
					dispose();
				}
			}
		});
		button.setBounds(158, 144, 123, 33);
		panel.add(button);
	}
}
