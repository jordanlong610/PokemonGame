package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import player.*;
import pokemon.Pokemon;

/**
 * Creates the GUI window for the selection of Pokemon to start the game.
 * @author Josh Varone
 *
 */
public class SelectPokemonView extends JFrame implements ActionListener, View {

	private PokemonController pc;						//controller for information
	private Player current;								//player for the current view
	private Pokemon[] pk = new Pokemon[3];				//holds selected Pokemon for Player
	private int numSelected = 0;						//number of Pokemon selected
	private JPanel[] selectPanel = new JPanel[4];		//panel array for displays
	protected JButton[] selectButton = new JButton[12];	//buttons for panels
	private Color bCol = new Color(240, 240, 240);		//color for buttons
		
	/**
	 * Creates the Select Pokemon View instance
	 */
	public SelectPokemonView(PokemonController pc, Player current, Player other) {
		this.pc = pc;
		this.current = current;		
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", please select your Pokemon.");
		
		setUpSelect();
	}
	
	/**
	 * Helper method to handle actually setting up the view
	 */
	private void setUpSelect() {
		setLayout(new GridLayout(2, 2));
		
		for(int i = 0; i < 3; i++) {
			selectPanel[i] = new JPanel(new GridLayout(4, 1));
			
			for(int j = 0; j < 4; j++) {
				selectButton[i*4+j] = new JButton();
				selectButton[i*4+j].setLayout(new BorderLayout());
				
				BufferedImage img;
				JLabel imgLabel;
				
				String pkName = pc.getPokemon(i*4+j).toString();
				String imgName = pkName.substring(pkName.indexOf('.')+1, pkName.indexOf('@'));
				
				if(pc.getPokemon(i*4+j).getType().getType().equals("Grass")) bCol = new Color(150, 250, 150);
				else if(pc.getPokemon(i*4+j).getType().getType().equals("Fire")) bCol = new Color(250, 150, 150);
				else bCol = new Color(200, 200, 250);
				
				try {
					img = ImageIO.read(new File("pkimg/" + imgName + ".png"));
					Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
					imgLabel = new JLabel(new ImageIcon(newimg));
				} catch (IOException e) {
					imgLabel = new JLabel("no img");
				}
				
				selectButton[i*4+j].add(imgLabel, BorderLayout.WEST);				
				selectButton[i*4+j].add(new JLabel("<html><font face='courier new' size=5 color=>"
													+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
													+ imgName + "</font></html>"), BorderLayout.CENTER);
				selectButton[i*4+j].setBackground(bCol);
				selectButton[i*4+j].addActionListener(this);
				selectPanel[i].add(selectButton[i*4+j]);
			}
			getContentPane().add(selectPanel[i]);
		}
		
		selectPanel[3] = new JPanel(new BorderLayout());
		JLabel instructions = new JLabel("<html><center><font face='courier new' size=5>"
				+ "Select your 3 Pokemon.<br /><br />"
				+ "<i>Green Pokemon are grass types.<br />"
				+ "Blue Pokemon are water types.<br />"
				+ "Red Pokemon are fire types.</i>"
				+ "</font></center></html>", SwingConstants.CENTER);
		selectPanel[3].add(instructions);
		getContentPane().add(selectPanel[3]);

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
	 * Update when changes are observed
	 */
	public void update(Player current, Player other) {
		this.current = current;
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", please select your Pokemon.");
		changeView();
	}

	/**
	 * Change the view with new information
	 */
	public void changeView() {
		numSelected = 0;
		getContentPane().removeAll();
		setUpSelect();
		repaint();
		revalidate();
	}
	
	/**
	 * Action listener to perform appropriate action based on which
	 * button is clicked (select initial Pokemon)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//track which button
		int i = -1;
		if(event.getSource() == selectButton[0]) i = 0;
		if(event.getSource() == selectButton[1]) i = 1;
		if(event.getSource() == selectButton[2]) i = 2;
		if(event.getSource() == selectButton[3]) i = 3;
		if(event.getSource() == selectButton[4]) i = 4;
		if(event.getSource() == selectButton[5]) i = 5;
		if(event.getSource() == selectButton[6]) i = 6;
		if(event.getSource() == selectButton[7]) i = 7;
		if(event.getSource() == selectButton[8]) i = 8;
		if(event.getSource() == selectButton[9]) i = 9;
		if(event.getSource() == selectButton[10]) i = 10;
		if(event.getSource() == selectButton[11]) i = 11;
		
		if (i != -1 && numSelected < 2)
	    {
			System.out.println(current.toString() + " selects " + pc.getPokemon(i));
			selectButton[i].setOpaque(true);
			selectButton[i].setBackground(Color.darkGray);
			selectButton[i].setEnabled(false);
			pk[numSelected] = pc.getPokemon(i);
			numSelected++;
	        repaint();
	    }
		else if(i != -1 && numSelected == 2) {
			System.out.println(current.toString() + " selects " + pc.getPokemon(i));
			selectButton[i].setOpaque(true);
			selectButton[i].setBackground(Color.darkGray);
			selectButton[i].setEnabled(false);
			pk[numSelected] = pc.getPokemon(i);
			
			//make new array and copy contents to it to avoid both players using same pokemon array
			Pokemon[] newPK = new Pokemon[3];
			System.arraycopy(pk, 0, newPK, 0, pk.length);
			
			System.out.println(current.toString() + "'s pokemon array address: " + newPK.toString());
			pc.select(newPK);
		}
	}
	
}
