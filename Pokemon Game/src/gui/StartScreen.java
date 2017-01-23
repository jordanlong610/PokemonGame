package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates the start screen for the game.
 * @author Josh Varone
 *
 */
public class StartScreen extends JFrame implements ActionListener {

	private JPanel[] startPanel = new JPanel[4];	//panel array for displays
	protected JButton startButton, exitButton;		//buttons for panels
	private Color bCol = new Color(220, 220, 220);	//color for buttons
	private PokemonController pc;					//PokemonController for game
	
	/**
	 * Runs the start screen to begin the game
	 */
	public static void main(String[] args) {
		StartScreen ss = new StartScreen();
	}
	
	/**
	 * Creates the Start Screen instance
	 */
	public StartScreen() {
		startPanel[0] = new JPanel(new GridLayout(3,1));
		startPanel[1] = new JPanel(new BorderLayout());
		startPanel[2] = new JPanel(new BorderLayout());
		startPanel[3] = new JPanel(new BorderLayout());
				
		startButton = new JButton("<html><center>"
					+ "<font face='courier new' size=5><b>START</b></font>"
					+ "</center></html>");
		exitButton = new JButton("<html><center>"
				+ "<font face='courier new' size=5><b>EXIT</b></font>"
				+ "</center></html>");
		startButton.setBackground(bCol);
		exitButton.setBackground(bCol);
		startButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		JLabel welcome = new JLabel("<html><center>"
					+ "<font face='courier new' size=6><b>Pokemon Simulator</b></font>"
					+ "</center></html>");
				
		//empty border to pad labels from the wall
		startPanel[1].setBorder(BorderFactory.createEmptyBorder(50,270,50,200));
		startPanel[2].setBorder(BorderFactory.createEmptyBorder(50,200,50,200));
		startPanel[3].setBorder(BorderFactory.createEmptyBorder(50,200,50,200));

		startPanel[1].add(welcome);
		startPanel[2].add(startButton);
		startPanel[3].add(exitButton);
		
		startPanel[0].add(startPanel[1]);
		startPanel[0].add(startPanel[2]);
		startPanel[0].add(startPanel[3]);
		
		add(startPanel[0]);
				
		setSize(800, 600);
		setVisible(true);
	}
	
	/**
	 * Gets the PokemonController for the game. Used for testing
	 */
	public PokemonController getPC() {
		return pc;
	}
	
	/**
	 * Action listener to perform appropriate action based on which
	 * button is clicked (either start or quit game)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//track which button
		int i = -1;
		if(event.getSource() == startButton) {
			System.out.println("START pressed.");
			pc = new PokemonController();
			pc.startGame();
			setVisible(false);
		}
		else if(event.getSource() == exitButton) {
			System.out.println("EXIT pressed.");
			System.exit(0);
		}
	}
	
}
