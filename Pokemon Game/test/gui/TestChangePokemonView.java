package gui;

import static org.junit.Assert.*;
import environment.Environment;
import evolution.*;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pokemon.Pokemon;

/**
 * Tests for the Change Pokemon View.
 * @author Josh Varone
 *
 */
public class TestChangePokemonView {

	private PokemonController pc = new PokemonController();			//controller for the tests
	private static Environment model = Environment.getInstance();	//model for the tests
	
	/**
	 * Set player pokemon collection before tests
	 */
	@Before
	public void setUpPlayers() {
		model = Environment.getInstance();
		Pokemon[] pk = { new Bulbasaur("Bulbasaur", 25), new Ivysaur("Ivysaur", 30), new Venusaur("Venusaur", 35) };
		model.getCurrentPlayer().setPokemon(pk);
		model.getCurrentPlayer().setCurrentPokemon(model.getCurrentPlayer().getPokemon()[0]);
	}
	
	/**
	 * Clear environment after all tests in this class run
	 */
	@After
	public void resetEnvironment() {
		model.reset();
	}
	
	/**
	 * Test initialization change view
	 */
	@Test
	public void testInitialization() {
		ChangePokemonView cv = new ChangePokemonView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		cv.showView();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display the player's Pokemon.\nDoes it look right?"));
	}
	
	/**
	 * Tests that a selection can be made
	 */
	@Test
	public void testChangePokemon() {
		ChangePokemonView cv = new ChangePokemonView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		cv.showView();
		assertEquals(model.getCurrentPlayer().getPokemon()[0], model.getCurrentPlayer().getCurrentPokemon());
		cv.changeButton[1].doClick();
		//turn automatically changes, current becomes other
		assertEquals(model.getOtherPlayer().getPokemon()[1], model.getOtherPlayer().getCurrentPokemon());
	}
	
	/**
	 * Tests that a pokemon with no health can't be selected
	 */
	@Test
	public void testNoDeadPokemon() {
		model.getCurrentPlayer().getPokemon()[1].setLifePoints(0);
		
		ChangePokemonView cv = new ChangePokemonView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		cv.showView();
		//should not be able to select Ivysaur because 0 life points
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display Ivysaur grayed out.\nDoes it look right?"));
	}

}
