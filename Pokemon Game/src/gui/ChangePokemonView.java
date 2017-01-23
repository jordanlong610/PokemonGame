package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import player.*;

/**
 * Creates the GUI window for changing a Pokemon before battle.
 * @author Josh Varone
 *
 */
public class ChangePokemonView extends JFrame implements ActionListener, View {

	private PokemonController pc; 						//controller for information
	private Player current;					 			//player for the current view
	private JPanel[] changePanel = new JPanel[4];		//panel array for displays
	protected JButton[] changeButton = new JButton[3];	//buttons for panels
	private Color bCol = new Color(240, 240, 240);		//color for buttons
		
	/**
	 * Creates the Change Pokemon View instance
	 */
	public ChangePokemonView(PokemonController pc, Player current, Player other) {
		this.pc = pc;
		this.current = current;
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", please change your Pokemon.");
		
		setUpChange();
	}
	
	/**
	 * Helper method to handle actually setting up the view
	 */
	private void setUpChange() {
		setLayout(new GridLayout(4, 1));
		
		for(int i = 0; i < 3; i++) {
			 changePanel[i] = new JPanel(new BorderLayout());			 
			 changeButton[i] = new JButton();
			 changeButton[i].setLayout(new GridLayout(1, 3));
			 
			 BufferedImage pi;
			 JLabel pl;
			 String pk = current.getPokemon()[i].toString();
			 String img = pk.substring(pk.indexOf('.')+1, pk.indexOf('@'));
			 try {
				 pi = ImageIO.read(new File("pkimg/" + img + ".png"));
				 Image newimg1 = pi.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
				 pl = new JLabel(new ImageIcon(newimg1));
			 } catch (IOException e) {
				 pl = new JLabel("no img");
			 }
			 
			 if(current.getPokemon()[i].getType().getType().equals("Grass")) bCol = new Color(150, 250, 150);
			 else if(current.getPokemon()[i].getType().getType().equals("Fire")) bCol = new Color(250, 150, 150);
			 else bCol = new Color(200, 200, 250);
			 
			 changeButton[i].add(pl);
			 changeButton[i].add(new JLabel("<html><font face='courier new' size=6>" 
					 						+ img + "</font></html>"));		
			 changeButton[i].add(new JLabel("<html><font face='courier new' size=6>" 
					 						+ current.getPokemon()[i].getCurrentLifePts()
					 						+ " / " + current.getPokemon()[i].getMaxLfPts() + "</font></html>"));
			 changeButton[i].setBackground(bCol);
			 changeButton[i].addActionListener(this);
			 
			 if(current.getPokemon()[i].getCurrentLifePts() == 0) {
				changeButton[i].setBackground(Color.darkGray);
				changeButton[i].setEnabled(false);
			 }
			 
			 changePanel[i].add(changeButton[i]);
			 getContentPane().add(changeButton[i]);
		}
		
		changePanel[3] = new JPanel(new BorderLayout());
		JLabel instructions = new JLabel("<html><center><font face='courier new' size=5>"
				+ "Choose a Pokemon.<br /><br />"
				+ "<i>Blue Pokemon are water types.<br />"
				+ "Green Pokemon are grass types.<br />"
				+ "Red Pokemon are fire types.</i>"
				+ "</font></center></html>", SwingConstants.CENTER);
		changePanel[3].add(instructions);
		getContentPane().add(changePanel[3]);
		
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
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", please change your Pokemon.");
		changeView();
	}

	/**
	 * Change the view with the new information
	 */
	public void changeView() {
		getContentPane().removeAll();
		setUpChange();
		repaint();
		revalidate();
	}
	
	/**
	 * Action listener to perform appropriate action based on which
	 * button is clicked (choose new active Pokemon)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//track which button
		int i = -1;
		if(event.getSource() == changeButton[0]) i = 0;
		if(event.getSource() == changeButton[1]) i = 1;
		if(event.getSource() == changeButton[2]) i = 2;
				
		if (i != -1)
	    {
			System.out.println(current.toString() + " changed to " + current.getPokemon()[i]);
	        pc.change(current.getPokemon()[i]);
	        hideView();
	    }
	}
	
}
