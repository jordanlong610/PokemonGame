package gui;

import static org.junit.Assert.*;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pokemon.Pokemon;
import environment.Environment;
import evolution.*;

/**
 * Tests for the Attack View.
 * @author Josh Varone
 *
 */
public class TestAttackView {

	private PokemonController pc = new PokemonController();			//controller for the tests
	private static Environment model = Environment.getInstance();	//model for the tests
	
	/**
	 * Set player pokemon collection before tests
	 */
	@Before
	public void setUpPlayers() {
		model = Environment.getInstance();
		Pokemon[] pk1 = { new Bulbasaur("Bulbasaur", 25), new Ivysaur("Ivysaur", 30), new Venusaur("Venusaur", 35) };
		Pokemon[] pk2 = { new Charizard("Charizard", 25), new Charmeleon("Charmeleon", 30), new Charmander("Charmander", 35) };
		model.getCurrentPlayer().setPokemon(pk1);
		model.getCurrentPlayer().setCurrentPokemon(model.getCurrentPlayer().getPokemon()[0]);
		model.getOtherPlayer().setPokemon(pk2);
		model.getOtherPlayer().setCurrentPokemon(model.getCurrentPlayer().getPokemon()[0]);
	}
	
	/**
	 * Clear environment after all tests in this class run
	 */
	@After
	public void resetEnvironment() {
		model.reset();
	}
	
	/**
	 * Test initialization attack view
	 */
	@Test
	public void testInitialization() {
		AttackView av = new AttackView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		av.showView();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display a grid of Pokemon attacks.\nDoes it look right?"));
	}
	
	/**
	 * Tests that an attack can be chosen
	 */
	@Test
	public void testChooseAttack() {
		AttackView av = new AttackView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		av.showView();
		av.attackButton[0].doClick();
		//player turn should change (current becomes other), and current player's pokemon should have less than full health
		assertTrue(model.getCurrentPlayer().getCurrentPokemon().getCurrentLifePts() < model.getCurrentPlayer().getCurrentPokemon().getMaxLfPts());
	}

}
