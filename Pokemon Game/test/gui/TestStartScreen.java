package gui;

import static org.junit.Assert.*;
import javax.swing.JOptionPane;
import org.junit.Test;

/**
 * Tests for the Start Screen.
 * @author Josh Varone
 *
 */
public class TestStartScreen {

	/**
	 * Tests initialization of Start Screen
	 */
	@Test
	public void testInitializationStart() {
		StartScreen ss = new StartScreen();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should have two buttons, START and EXIT.\nDoes it look right?"));
	}
	
	/**
	 * Tests that clicking start starts the game
	 */
	@Test
	public void testStartGame() {
		StartScreen ss = new StartScreen();
		ss.startButton.doClick();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "START should trigger Pokemon Selection screen.\nDoes it look right?"));
	}
	
	/**
	 * Tests that clicking EXIT ends the program
	 */
	//TODO how to use expectedSystemExit
	@Test
	public void testExitGame() {
		StartScreen ss = new StartScreen();
		//ss.exitButton.doClick();
		//expectedsystemexit here
	}

}
