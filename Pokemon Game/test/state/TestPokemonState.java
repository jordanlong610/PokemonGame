package state;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import evolution.Blastoise;
/**
 * Test pokemon state
 * @author Justin Woods
 */
public class TestPokemonState {

	/**
	 * Test when the pokemon has life points
	 */
	@Test
	public void testPokemonIsAlive() 
	{
		Pokemon pk = new Blastoise("Blastoise", 50);
		assertEquals(pk.getAliveState(), pk.updateState());
		
	}
	/**
	 * Test when the pokemon has no life points
	 */
	@Test
	public void testPokemonIsDead() 
	{
		Pokemon pk = new Blastoise("Blastoise", 0);
		assertEquals(pk.getDeadState(), pk.updateState());
		
	}
}
