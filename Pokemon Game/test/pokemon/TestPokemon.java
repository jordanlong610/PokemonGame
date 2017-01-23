package pokemon;

import static org.junit.Assert.*;

import org.junit.Test;

import evolution.Squirtle;
/**
 * Test pokemon
 * @author Justin Woods
 */
public class TestPokemon {

	/**
	 * Test the creation of the pokemon
	 */
	@Test
	public void testInitialization() 
	{
		Pokemon pk = new Squirtle("Squirtle", 25);
		assertEquals(25, pk.getCurrentLifePts());
		pk.takeHit(10);
		assertEquals(15, pk.getCurrentLifePts());
		assertEquals(25, pk.getMaxLfPts());
		assertEquals("Water", pk.getType().getType());
		assertEquals("Squirtle", pk.getName());
		assertEquals(pk.getAliveState(), pk.updateState());
	}

}
