package unittest;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.sikuli.script.Screen;

import gui.Constants;
import gui.GameGUI;
import gui.TicTacToeGUI;

@TestMethodOrder(OrderAnnotation.class)
public class SikuliTest {

	Screen srn = new Screen();
	@Test
	@Order(1)
	//If player not select to play with "X" or "O"
	public void testPlayerNotSelected() {
		try {
			
			GameGUI gameGui = new GameGUI();
			gameGui.show();
			
			Thread.sleep(500);
			
			srn.click(System.getProperty("user.dir")+"\\images\\gridTextBox.png");
			
			Thread.sleep(500);
			
			srn.type("4");
			
			Thread.sleep(500);
			
			srn.click(System.getProperty("user.dir")+"\\images\\playGameButton.png");
			
			Assert.assertNotNull(srn.exists(System.getProperty("user.dir")+"\\images\\playerNotSelected.png"));
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
			gameGui.dispose();
		}catch(Exception e) {
			
		}
	}

	@Test
	@Order(2)
	//If grid size not given
	public void testGridSizeNotGiven() {
		try {
			GameGUI gameGui = new GameGUI();
			gameGui.show();
			
			Thread.sleep(500);
			
			srn.click(System.getProperty("user.dir")+"\\images\\gridTextBox.png");
			
			Thread.sleep(500);
			
			srn.type("");
			
			Thread.sleep(500);
			
			srn.click(System.getProperty("user.dir")+"\\images\\playGameButton.png");
			
			Assert.assertNotNull(srn.exists(System.getProperty("user.dir")+"\\images\\gridSizeNotGiven.png"));
			closeAllWindows();
			closeAllWindows();
			gameGui.dispose();
		}catch(Exception e) {
			
		}
	}

	private void closeAllWindows() {
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
	}

	@Test
	@Order(3)
	//If player win the game
	public void testWinGameLogic() {
		try {
			Constants.UNIT_TEST_PLAY = true;
			GameGUI gameGui = new GameGUI();
			gameGui.show();
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\gridTextBox.png");
			Thread.sleep(500);
			srn.type("3");
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\playerX.png");
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\playGameButton.png");
			Thread.sleep(500);
			TicTacToeGUI.unitTestWinPlay();
			boolean winOrDraw = false;
			
			if(Constants.GAME_WIN) {
				winOrDraw=true;
			}
			
			Assert.assertTrue(winOrDraw);
			closeAllWindows();
			for (Window window : Window.getWindows()) {
			    window.dispose();
			}
			gameGui.dispose();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	@Order(4)
	//If player draw the game
	public void testDrawGameLogic() {
		try {
			Constants.UNIT_TEST_PLAY = true;
			GameGUI gameGui = new GameGUI();
			gameGui.show();
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\gridTextBox.png");
			Thread.sleep(500);
			srn.type("3");
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\playerX.png");
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\playGameButton.png");
			Thread.sleep(500);
			TicTacToeGUI.unitTestDrawPlay();
			boolean winOrDraw = false;
			
			if(Constants.GAME_DRAW) {
				winOrDraw=true;
			}
			
			Assert.assertTrue(winOrDraw);
			closeAllWindows();
			for (Window window : Window.getWindows()) {
			    window.dispose();
			}

			gameGui.dispose();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	@Order(5)
	//It must be possible to dynamically select the size of the game grid (3x3, 4x4, 5x5).
	public void testGridSizeLogic() {
		try {
			Constants.UNIT_TEST_PLAY = true;
			GameGUI gameGui = new GameGUI();
			gameGui.show();
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\gridTextBox.png");
			Thread.sleep(500);
			srn.type("5");
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\playerX.png");
			Thread.sleep(500);
			srn.click(System.getProperty("user.dir")+"\\images\\playGameButton.png");
			Thread.sleep(500);
			TicTacToeGUI.unitTestWinPlay();
			boolean winOrDraw = false;
			
			if(Constants.GAME_WIN) {
				winOrDraw=true;
			}
			
			Assert.assertTrue(winOrDraw);
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

			gameGui.dispose();
		}catch(Exception e) {
			
		}
	}
}
