package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import player.Player;
import player.Player1;
import pokemon.Pokemon;

/**
 * Creates the GUI window for attack selection of a Pokemon.
 * @author Josh Varone
 *
 */
public class AttackView extends JFrame implements ActionListener, View {

	private PokemonController pc;						//controller for information
	private Player current;								//player for the current view
	private JPanel[] attackPanel = new JPanel[4];		//panel array for displays
	protected JButton[] attackButton = new JButton[4];	//buttons for panels
	private Color bCol = new Color(220, 220, 220);		//color for buttons
		
	/**
	 * Creates the Attack View instance
	 */
	public AttackView(PokemonController pc, Player current, Player other) {
		this.pc = pc;
		this.current = current;
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", please choose your attack.");

		setUpAttack();
	}
	
	/**
	 * Helper method to handle actually setting up the view
	 */
	private void setUpAttack() {
		setLayout(new GridLayout(2, 2));
		
		for(int i = 0; i < attackPanel.length; i++) {
			String attackName = current.getCurrentPokemon().getAttacks()[i].getAttackName();
			String attackType = current.getCurrentPokemon().getAttacks()[i].getAttackType();
			String attackStrength = current.getCurrentPokemon().getAttacks()[i].getAttackStrength() + "";
			
			attackPanel[i] = new JPanel(new BorderLayout());
			attackButton[i] = new JButton("<html><center>"
					+ "<font face='courier new' size=6><b>" + attackName + "</b></font><br /><br />"
					+ "<font face='courier new' size=5><i>" + attackType + "</i><br /><br />"
					+ attackStrength + "</font>"
					+ "</center></html>");
			
			if(attackType.equalsIgnoreCase("Fire")) bCol = new Color(250, 150, 150);
			else if(attackType.equalsIgnoreCase("Grass")) bCol = new Color(150, 250, 150);
			else bCol = new Color(200, 200, 250);
			
			attackButton[i].setBackground(bCol);
			attackButton[i].addActionListener(this);
			attackPanel[i].add(attackButton[i]);
			getContentPane().add(attackPanel[i]);
		}
		
		setSize(800, 600);
	}
	
	/**
	 * Show the view to user
	 */
	public void showView() {
		setVisible(true);
	}
	
	/**
	 * Hide the view from user
	 */
	public void hideView() {
		setVisible(false);
	}
	
	/**
	 * Update when a change is observed
	 */
	public void update(Player current, Player other) {
		this.current = current;
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", please choose your attack.");
		changeView();
	}

	/**
	 * Change the view with new information
	 */
	public void changeView() {
		getContentPane().removeAll();
		setUpAttack();
		repaint();
		revalidate();
	}
	
	/**
	 * Action listener to perform appropriate action based on which
	 * button is clicked (chooses attack)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//track which button
		int i = -1;
		if(event.getSource() == attackButton[0]) i = 0;
		if(event.getSource() == attackButton[1]) i = 1;
		if(event.getSource() == attackButton[2]) i = 2;
		if(event.getSource() == attackButton[3]) i = 3;
				
		if (i != -1)
	    {	        
	        System.out.println(current.toString() + " attacked with " + current.getCurrentPokemon().getAttacks()[i].toString());
	        pc.attack(current.getCurrentPokemon().getAttacks()[i]);
	        hideView();
	    }
	}
	
}
