package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import attack.Command;
import pokemon.Pokemon;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestWartortle {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Wartortle("Wartortle", 100);
	
		assertEquals("Wartortle", pk.getName());
		assertEquals(100, pk.getMaxLfPts());
		assertEquals(100, pk.getCurrentLifePts());
		assertEquals(100, pk.getCurrentLifePts());
		assertEquals("Water", pk.getType().getType());
	}
	/**
	 * Test that the attacks are assigned correctly
	 */
	@Test
	public void testAttacks()
	{
		Pokemon pk = new Wartortle("Wartortle", 100);
		assertEquals("Wartortle", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("Bubble", attacks[0].getAttackName());
		assertEquals("WaterPulse", attacks[1].getAttackName());
		assertEquals("AquaTail", attacks[2].getAttackName());
		assertEquals("HydroPump", attacks[3].getAttackName());
	}
	/**
	 * Test when the pokemon evolve
	 */
	@Test
	public void testEvolve()
	{
		Pokemon pk = new Wartortle("Wartortle", 100);
		assertEquals("Wartortle", pk.getName());
		pk = pk.evolve();
		assertEquals("Blastoise", pk.getName());
		assertEquals(35, pk.getCurrentLifePts());
	}

}
