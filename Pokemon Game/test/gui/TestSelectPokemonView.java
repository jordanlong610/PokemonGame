package gui;

import static org.junit.Assert.*;
import javax.swing.JOptionPane;
import org.junit.AfterClass;
import org.junit.Test;
import environment.Environment;

/**
 * Tests for the Select Pokemon View.
 * @author Josh Varone
 *
 */
public class TestSelectPokemonView {

	private PokemonController pc = new PokemonController();			//controller for the tests
	private static Environment model = Environment.getInstance();	//model for the tests
	
	/**
	 * Clear environment after all tests in this class run
	 */
	@AfterClass
	public static void resetEnvironment() {
		model.reset();
	}
	
	/**
	 * Test initialization select view
	 */
	@Test
	public void testInitialization() {
		SelectPokemonView sv = new SelectPokemonView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		sv.showView();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display all available Pokemon.\nDoes it look right?"));
	}
	
	/**
	 * Test selection of Pokemon for player 1
	 */
	@Test
	public void testSelectPokemon1() {
		SelectPokemonView sv = new SelectPokemonView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		sv.showView();
		sv.selectButton[0].doClick();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Bulbasaur should now be grayed out.\nDoes it look right?"));
		sv.selectButton[1].doClick();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Ivysaur should now be grayed out.\nDoes it look right?"));
		sv.selectButton[2].doClick();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Venusaur should now be grayed out.\nDoes it look right?"));
		
		//player turn switched, previous CurrentPlayer is now OtherPlayer
		//player should have each of the previously selected Pokemon
		assertTrue(model.getOtherPlayer().getPokemon()[0].toString().contains("Bulbasaur"));
		assertTrue(model.getOtherPlayer().getPokemon()[1].toString().contains("Ivysaur"));
		assertTrue(model.getOtherPlayer().getPokemon()[2].toString().contains("Venusaur"));
		
		//Current pokemon should be the first selected one
		assertTrue(model.getOtherPlayer().getCurrentPokemon().toString().contains("Bulbasaur"));
	}

}
