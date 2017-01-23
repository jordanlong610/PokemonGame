package environment;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import player.*;

/**
 * Tests for the Environment.
 * @author Josh Varone
 *
 */
public class TestEnvironment {
	
	/**
	 * Clear environment after each test
	 */
	@After
	public void resetEnvironment() {
		Environment e = Environment.getInstance();
		e.reset();
	}
	
	/**
	 * Tests that an Environment can be created and has players
	 */
	@Test
	public void testInitialization() {
		Environment e = Environment.getInstance();
		assertNotNull(e);
		assertTrue(e.getCurrentPlayer() instanceof Player1);
		assertTrue(e.getOtherPlayer() instanceof Player2);
	}
	
	/**
	 * Tests that environment changes player turn correctly
	 */
	@Test
	public void testChangeTurn() {
		Environment e = Environment.getInstance();
		assertTrue(e.getCurrentPlayer() instanceof Player1);
		e.changeTurn();
		assertTrue(e.getCurrentPlayer() instanceof Player2);
	}
	
	/**
	 * Tests that environment returns correct Pokemon from factory
	 */
	@Test
	public void testGetPokemon() {
		Environment e = Environment.getInstance();
		//make sure all ints from 0-11 return a pokemon
		for(int i=0; i<12; i++) {
			assertNotNull(e.getPokemon(i));
		}
	}

}
