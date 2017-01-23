package state;

import static org.junit.Assert.*;

import org.junit.Test;

import evolution.Blastoise;
import pokemon.Pokemon;
/**
 * Test pokemon alive state
 * @author Justin Woods
 */
public class TestPokemonAliveState 
{
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
