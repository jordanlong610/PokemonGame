package gui;

import static org.junit.Assert.*;
import javax.swing.JOptionPane;
import environment.Environment;
import evolution.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pokemon.Pokemon;

/**
 * Tests for the Battle View.
 * @author Josh Varone
 *
 */
public class TestBattleView {

	private PokemonController pc = new PokemonController();			//controller for the tests
	private static Environment model = Environment.getInstance();	//model for the tests
	
	/**
	 * Set player pokemon collections before each test
	 */
	@BeforeClass
	public static void setUpPlayers() {
		Pokemon[] pk1 = { new Bulbasaur("Bulbasaur", 25), new Ivysaur("Ivysaur", 30), new Venusaur("Venusaur", 35) };
		Pokemon[] pk2 = { new Charmander("Charmander", 25), new Charmeleon("Charmeleon", 30), new Charizard("Charizard", 35) };
		model.getCurrentPlayer().setPokemon(pk1);
		model.getCurrentPlayer().setCurrentPokemon(model.getCurrentPlayer().getPokemon()[0]);
		model.getOtherPlayer().setPokemon(pk2);
		model.getOtherPlayer().setCurrentPokemon(model.getOtherPlayer().getPokemon()[0]);
	}
	
	/**
	 * Clear environment after all tests in this class run
	 */
	@AfterClass
	public static void resetEnvironment() {
		model.reset();
	}
	
	/**
	 * Tests initialization of the battle view
	 */
	@Test
	public void testInitialization() {
		BattleView bv = new BattleView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		bv.showView();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display two Pokemon in battle mode.\nDoes it look right?"));
	}
	
	/**
	 * Tests that switching turns switches Pokemon position
	 */
	@Test
	public void testSwitchTurns() {
		BattleView bv = new BattleView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		bv.showView();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display the two Pokemon in battle mode.\nDoes it look right?"));
		model.changeTurn();
		bv.update(model.getCurrentPlayer(), model.getOtherPlayer());
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Pokemon should flip with turn change.\nDoes it look right?"));
	}
	
	/**
	 * Tests that the battle reflects a changed pokemon
	 */
	@Test
	public void testChangePokemon() {
		BattleView bv = new BattleView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		bv.showView();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Screen should display the two Pokemon in battle mode.\nDoes it look right?"));
		model.getCurrentPlayer().setCurrentPokemon(model.getCurrentPlayer().getPokemon()[2]);
		bv.update(model.getCurrentPlayer(), model.getOtherPlayer());
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Player's pokemon should change.\nDoes it look right?"));
	}
	
	/**
	 * Tests that the change button triggers the appropriate view
	 */
	@Test
	public void testChangeButton() {
		BattleView bv = new BattleView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		pc.setUpRestOfGame();
		bv.showView();
		bv.battleButton[1].doClick();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Button should trigger the change view.\nDoes it?"));
	}
	
	/**
	 * Tests that the attack button triggers the appropriate view
	 */
	@Test
	public void testAttackButton() {
		BattleView bv = new BattleView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		pc.setUpRestOfGame();
		bv.showView();
		bv.battleButton[0].doClick();
		assertEquals(JOptionPane.YES_OPTION, JOptionPane.showConfirmDialog(null, "Button should trigger the attack view.\nDoes it?"));
	}
	
	/**
	 * Tests that a dead Pokemon can't attack
	 */
	@Test
	public void testDeadCantAttack() {
		BattleView bv = new BattleView(pc, model.getCurrentPlayer(), model.getOtherPlayer());
		pc.setUpRestOfGame();
		bv.showView();
	}
	
	/**
	 * Tests that game ends when all Pokemon dead
	 */
	@Test
	public void gameCanEnd() {
		
	}

}
