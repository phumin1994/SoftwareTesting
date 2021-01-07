package gui;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class TicTacToeGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static JButton buttonArray[][];
	static JLabel selectPlayer;
	static boolean player1 = true;
	static boolean player2 = false;
	static boolean gameOver = false;
	static boolean gameDraw = false;
	String player = Constants.SELECTED_PLAYER;
	String computer = Constants.OPPONENT;
	int X = 10;
	int Y = 10;

	public TicTacToeGUI() {

		setBounds(10, 10,
				((Constants.SIZE *60)+50), (Constants.SIZE * (60))+90);
		JPanel panel = new JPanel();
		panel.setBounds(10, 40,
				((Constants.SIZE *60)), Constants.SIZE * (60));
		panel.setLayout(null);
		buttonArray = new JButton[Constants.SIZE][Constants.SIZE];
		selectPlayer = new JLabel("Selected Player: "+Constants.SELECTED_PLAYER);
		selectPlayer.setBounds(((Constants.SIZE *40))/2, 10, 150, 30);
		for (int i = 0; i < Constants.SIZE; i++) {
			for (int j = 0; j < Constants.SIZE; j++) {
				buttonArray[i][j] = new JButton();
				buttonArray[i][j].addActionListener(this);
				buttonArray[i][j].setBounds(X, Y, 50, 50);
				X += 60;
				if (j == Constants.SIZE - 1) {
					Y += 60;
					X = 10;
				}
				panel.add(buttonArray[i][j]);
			}
		}
		setLayout(null);
		setTitle("Tic Tac Toe");
		add(selectPlayer);
		add(panel);
	}

	public static void unitTestWinPlay() {
		gameOver = false;
		 gameDraw = false;
		if (Constants.UNIT_TEST_PLAY) {
			try {
				Thread.sleep(1000);
				Thread.sleep(500);
				setSymbol(buttonArray[0][0], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[1][0], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[0][1], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[2][0], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[0][2], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[1][0], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
			
//						int playerTurn[] = computerTurn();
//						setSymbol(buttonArray[playerTurn[0]][playerTurn[1]], Constants.SELECTED_PLAYER);
//						checkWin("Player " + Constants.SELECTED_PLAYER);
//						if(gameOver || gameDraw) {
//							break;
//						}
//						Thread.sleep(500);
//						int computerTurn[] = computerTurn();
//						setSymbol(buttonArray[computerTurn[0]][computerTurn[1]], Constants.OPPONENT);
//						checkWin("Player " + Constants.OPPONENT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    if (dialog.getContentPane().getComponentCount() == 1
                        && dialog.getContentPane().getComponent(0) instanceof JOptionPane){
                        dialog.dispose();
                    }
                }
            }
			if (gameOver) {
				Constants.GAME_WIN = true;
			}
		}
	}
	
	public static void unitTestDrawPlay() {
		 gameOver = false;
		 gameDraw = false;
		if (Constants.UNIT_TEST_PLAY) {
			try {
				Thread.sleep(1000);
				Thread.sleep(500);
				setSymbol(buttonArray[0][0], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[1][0], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[0][1], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[0][2], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[1][1], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[2][2], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[1][2], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[2][1], Constants.OPPONENT);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.OPPONENT);
				}
				Thread.sleep(500);
				setSymbol(buttonArray[2][0], Constants.SELECTED_PLAYER);
				if (!gameOver && !gameDraw) {
				checkWin("Player " + Constants.SELECTED_PLAYER);
				}
			
//						int playerTurn[] = computerTurn();
//						setSymbol(buttonArray[playerTurn[0]][playerTurn[1]], Constants.SELECTED_PLAYER);
//						checkWin("Player " + Constants.SELECTED_PLAYER);
//						if(gameOver || gameDraw) {
//							break;
//						}
//						Thread.sleep(500);
//						int computerTurn[] = computerTurn();
//						setSymbol(buttonArray[computerTurn[0]][computerTurn[1]], Constants.OPPONENT);
//						checkWin("Player " + Constants.OPPONENT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    if (dialog.getContentPane().getComponentCount() == 1
                        && dialog.getContentPane().getComponent(0) instanceof JOptionPane){
                        dialog.dispose();
                    }
                }
            }
			if (gameDraw) {
				Constants.GAME_DRAW = true;
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (gameOver == false) {
//			if (player1) {
//				player1 = false;
//				player2 = true;
//				setSymbol((JButton) e.getSource(), player, "Turn: Player "+Constants.OPPONENT);
//				checkWin("Player "+Constants.SELECTED_PLAYER);
//			} else {
//				player2 = false;
//				player1 = true;
//				setSymbol((JButton) e.getSource(), computer, "Turn: Player "+Constants.SELECTED_PLAYER);
//				checkWin("Player "+Constants.OPPONENT);
//			}
//			

			setSymbol((JButton) e.getSource(), player);
			checkWin("Player " + Constants.SELECTED_PLAYER);
			int randomValue[] = computerTurn();
			setSymbol(buttonArray[randomValue[0]][randomValue[1]], computer);
			checkWin("Player " + Constants.OPPONENT);
		}
	}

	private static int[] computerTurn() {
		Random rnd = new Random();
		int randomValue[] = new int[2];
		do {
			randomValue[0] = rnd.nextInt(Constants.SIZE);
			randomValue[1] = rnd.nextInt(Constants.SIZE);
		} while (!validMove(randomValue[0], randomValue[1]));
		return randomValue;
	}
	
	private static boolean validMove(int i, int j) {
		if (buttonArray[i][j].getText().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static void setSymbol(JButton button, String symbol) {
		button.setText(symbol);
		button.setEnabled(false);
	}

	public static boolean isValidForCheckingRow(int colIndex) {
		boolean isValid = true;

		if ((colIndex + (3- 1)) >(Constants.SIZE-1)) {
			isValid = false;
		}

		return isValid;
	}

	public static boolean isValidForCheckingDown(int rowIndex) {
		boolean isValid = true;

		if ((rowIndex + (3 - 1)) > (Constants.SIZE-1)) {
			isValid = false;
		}

		return isValid;
	}

	public static boolean isValidForCheckingRightDiagnols(int rowIndex,
			int colIndex) {
		boolean isValid = true;

		if ((rowIndex + (3 - 1)) > (Constants.SIZE-1) || (colIndex + (3 - 1)) > (Constants.SIZE-1)) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isValidForCheckingLeftDiagnols(int rowIndex,
			int colIndex) {
		boolean isValid = true;

		if ((rowIndex + (3 - 1)) > (Constants.SIZE-1) || (colIndex - (3 - 1)) > (Constants.SIZE-1)
				|| (colIndex - (3 - 1)) < 0) {
			isValid = false;
		}
		return isValid;
	}

	public static void checkWin(String currentPlayer) {

		for (int i = 0; i < Constants.SIZE; i++) {

			for (int j = 0; j < Constants.SIZE; j++) {

				if (isValidForCheckingRow(j)) {
					if (!buttonArray[i][j].getText().isEmpty()
							&& !buttonArray[i][j + 1].getText().isEmpty()
							&& !buttonArray[i][j + 2].getText().isEmpty()
							&& buttonArray[i][j].getText().equalsIgnoreCase(
									buttonArray[i][j + 1].getText())
							&& buttonArray[i][j + 1].getText()
									.equalsIgnoreCase(
											buttonArray[i][j + 2].getText())) {
						gameOver = true;
					}
				}

				if (isValidForCheckingRightDiagnols(i, j)) {
					if (!buttonArray[i][j].getText().isEmpty()
							&& !buttonArray[i + 1][j + 1].getText().isEmpty()
							&& !buttonArray[i + 2][j + 2].getText().isEmpty()
							&& buttonArray[i][j].getText().equalsIgnoreCase(
									buttonArray[i + 1][j + 1].getText())
							&& buttonArray[i + 1][j + 1]
									.getText()
									.equalsIgnoreCase(
											buttonArray[i + 2][j + 2].getText())) {
						gameOver = true;

					}
				}

				if (isValidForCheckingLeftDiagnols(i, j)) {
					if (!buttonArray[i][j].getText().isEmpty()
							&& !buttonArray[i + 1][j - 1].getText().isEmpty()
							&& !buttonArray[i + 2][j - 2].getText().isEmpty()
							&& buttonArray[i][j].getText().equalsIgnoreCase(
									buttonArray[i + 1][j - 1].getText())
							&& buttonArray[i + 1][j - 1]
									.getText()
									.equalsIgnoreCase(
											buttonArray[i + 2][j - 2].getText())) {
						gameOver = true;

					}
				}

				if (isValidForCheckingDown(i)) {
					if (!buttonArray[i][j].getText().isEmpty()
							&& !buttonArray[i + 1][j].getText().isEmpty()
							&& !buttonArray[i + 2][j].getText().isEmpty()
							&& buttonArray[i][j].getText().equalsIgnoreCase(
									buttonArray[i + 1][j].getText())
							&& buttonArray[i + 1][j].getText()
									.equalsIgnoreCase(
											buttonArray[i + 2][j].getText())) {
						gameOver = true;
					}
				}
			}
		}
		boolean isDrw = true;
		for (int i = 0; i < Constants.SIZE; i++) {

			for (int j = 0; j < Constants.SIZE; j++) {
				if (buttonArray[i][j].getText().isEmpty()) {
					isDrw = false;
				}
			}
		}
		gameDraw = isDrw;
		if (gameOver || gameDraw) {
			int result = -1;
		
			if (gameOver) {
				if(!Constants.UNIT_TEST_PLAY) {
				UIManager UI=new UIManager();
				  UI.put("OptionPane.background", new Color(138, 224, 73));
				result = JOptionPane.showConfirmDialog(null, currentPlayer
						+ " wins!!\nDo you want to play Again ?", "Game Over",
						JOptionPane.YES_NO_OPTION);
				}
				if(Constants.UNIT_TEST_PLAY) {
					showWinDialog(currentPlayer);
					result = 44;
					}
			//	gameDraw=true;
			} else {
				gameDraw=true;
				if(!Constants.UNIT_TEST_PLAY) {
				UIManager UI=new UIManager();
				  UI.put("OptionPane.background", new Color(3, 1, 244));
				result = JOptionPane.showConfirmDialog(null,
						"GAME DRAW\nDo you want to play Again ?", "Game Over",
						JOptionPane.YES_NO_OPTION);
				}
				if(Constants.UNIT_TEST_PLAY) {
					showDrawDialog(currentPlayer);
					result = 44;
				}
			}
			Constants.UNIT_TEST_PLAY = false;
			if (result == 0) {
				resetGame();
			} 
			else if (result == 44) {
				
			} 
			else {
				System.exit(0);
			}
		}
	}
	
	public static void showWinDialog(String currentPlayer) {
		final JOptionPane msg = new JOptionPane(currentPlayer
				+ " wins!!\nDo you want to play Again ?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        final JDialog dlg = msg.createDialog("Select Yes or No");
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                final Timer t = new Timer(2000,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dlg.setVisible(false);
                    }
                });
                t.start();
            }
        });
        dlg.setVisible(true);
	}
	
	public static void showDrawDialog(String currentPlayer) {
		final JOptionPane msg = new JOptionPane(currentPlayer
				+ " \"GAME DRAW\\nDo you want to play Again ?\", \"Game Over\"", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
        final JDialog dlg = msg.createDialog("Select Yes or No");
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                final Timer t = new Timer(2000,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dlg.setVisible(false);
                    }
                });
                t.start();
            }
        });
        dlg.setVisible(true);
	}

	public static void resetGame() {
		gameOver = false;
		gameDraw = false;
		for (int i = 0; i < Constants.SIZE; i++) {
			for (int j = 0; j < Constants.SIZE; j++) {
				buttonArray[i][j].setText("");
				buttonArray[i][j].setEnabled(true);
			}
		}
		selectPlayer.setText("Selected Player: "+Constants.SELECTED_PLAYER);
		player1 = true;
		player2 = false;
	}
}