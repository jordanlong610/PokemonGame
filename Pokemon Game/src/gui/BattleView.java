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
 * Creates the GUI window for the battle between two Pokemon.
 * @author Josh Varone
 *
 */
public class BattleView extends JFrame implements ActionListener, View {

	private PokemonController pc;						//controller for information
	private Player current, other;						//player for the current view
	private Pokemon p1, p2;								//current Pokemon in battle
	private JPanel[] battlePanel = new JPanel[3];		//panel array for displays
	protected JButton[] battleButton = new JButton[2];	//buttons for panels
	private Color bCol = new Color(220, 220, 220);		//color for buttons
	
	/**
	 * Creates the Battle View instance
	 */
	public BattleView(PokemonController pc, Player current, Player other) {
		this.pc = pc;
		this.current = current;
		this.other = other;
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", make your move.");
		p1 = current.getCurrentPokemon();
		p2 = other.getCurrentPokemon();
		
		setUpBattle();
	}
	
	/**
	 * Helper method to handle actually setting up the view
	 */
	private void setUpBattle() {
		//Sets up a 3 row structure
		setLayout(new GridLayout(3, 1));
		
		BufferedImage p1bi, p2bi;
		JLabel p1jl, p2jl;
		
		String img1Name = p1.getName();//.toString().substring(p1.toString().indexOf('.')+1, p1.toString().indexOf('@'));
		String img2Name = p2.getName();//.toString().substring(p2.toString().indexOf('.')+1, p2.toString().indexOf('@'));
		try {
			p1bi = ImageIO.read(new File("pkimg/" + img1Name + ".png"));
			p2bi = ImageIO.read(new File("pkimg/" + img2Name + ".png"));
			Image newimg1 = p1bi.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;
			Image newimg2 = p2bi.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;
			p1jl = new JLabel(new ImageIcon(newimg1));
			p2jl = new JLabel(new ImageIcon(newimg2));
		} catch (IOException e) {
			p1jl = new JLabel("no img");
			p2jl = new JLabel("no img");
		}
		
		//Row for opposing player's Pokemon
		battlePanel[0] = new JPanel(new BorderLayout());
		JLabel p2PK = new JLabel("<html><font face='courier new' size=6>"
								+ img2Name + "<br />"
								+ p2.getCurrentLifePts() + " / " + p2.getMaxLfPts()
								+ "</font></html>");
		p2PK.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
		p2jl.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
		battlePanel[0].add(p2PK, BorderLayout.CENTER);
		battlePanel[0].add(p2jl, BorderLayout.EAST);
		getContentPane().add(battlePanel[0]);
		
		//Row for current player's Pokemon
		battlePanel[1] = new JPanel(new BorderLayout());
		JLabel p1PK = new JLabel("<html><font face='courier new' size=6>"
								+ img1Name + "<br />"
								+ p1.getCurrentLifePts() + " / " + p1.getMaxLfPts()
								+ "</font></html>");
		p1PK.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
		p1jl.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
		battlePanel[1].add(p1PK, BorderLayout.CENTER);
		battlePanel[1].add(p1jl, BorderLayout.WEST);
		getContentPane().add(battlePanel[1]);

		//Row for buttons to attack or change Pokemon
		battlePanel[2] = new JPanel(new GridLayout(1, 2));
		//Attack button creation
		battleButton[0] = new JButton("<html><center><font face='courier new' size=5>"
									+ "ATTACK"
									+ "</font></center></html>");
		battleButton[0].setBackground(bCol);
		battleButton[0].addActionListener(this);
		
		//if Pokemon dead, can't attack
		if(current.getCurrentPokemon().getCurrentLifePts() <= 0) {
			battleButton[0].setOpaque(true);
			battleButton[0].setBackground(Color.darkGray);
			battleButton[0].setEnabled(false);
		}
		
		battlePanel[2].add(battleButton[0]);
		//Change Pokemon button creation
		battleButton[1] = new JButton("<html><center><font face='courier new' size=5>"
									+ "CHANGE POKEMON"
									+ "</font></center></html>");
		battleButton[1].setBackground(bCol);
		battleButton[1].addActionListener(this);
		battlePanel[2].add(battleButton[1]);
		battlePanel[2].setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
		//Add panel to this frame
		getContentPane().add(battlePanel[2]);
		
		setSize(800, 600);
		
		//handles end of game
		if(current.getPokemon()[0].getCurrentLifePts() <= 0 &&
		   current.getPokemon()[1].getCurrentLifePts() <= 0 &&
		   current.getPokemon()[2].getCurrentLifePts() <= 0) {
			JOptionPane.showMessageDialog(this, ((current instanceof Player1) ? "Player 2" : "Player 1") + " wins.");
			System.exit(0);
		}
		else if(other.getPokemon()[0].getCurrentLifePts() <= 0 &&
				other.getPokemon()[1].getCurrentLifePts() <= 0 &&
				other.getPokemon()[2].getCurrentLifePts() <= 0) {
			JOptionPane.showMessageDialog(this, ((other instanceof Player1) ? "Player 2" : "Player 1") + " wins.");
			System.exit(0);
		}
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
	 * Update view when a change is observed
	 */
	public void update(Player current, Player other) {
		this.current = current;
		this.other = other;
		p1 = current.getCurrentPokemon();
		p2 = other.getCurrentPokemon();
		setTitle(((current instanceof Player1) ? "Player 1" : "Player 2") + ", make your move.");
		changeView();
	}

	/**
	 * Change view with new information
	 */
	public void changeView() {
		getContentPane().removeAll();
		setUpBattle();
		repaint();
		revalidate();
	}
	
	/**
	 * Action listener to perform appropriate action based on which
	 * button is clicked (either attack or change Pokemon)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {		
		if (event.getSource() == battleButton[0])
	    {
			System.out.println(current.toString() + " clicked ATTACK.");
	        pc.showAttack();
	    }
		else if (event.getSource() == battleButton[1])
	    {
			System.out.println(current.toString() + " clicked CHANGE.");
			pc.showChange();
	    }
	}
	
}
