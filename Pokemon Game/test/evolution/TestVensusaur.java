package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestVensusaur {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Venusaur("Venusaur", 100);
	
		assertEquals("Venusaur", pk.getName());
		assertEquals(100, pk.getMaxLfPts());
		assertEquals(100, pk.getCurrentLifePts());
		assertEquals(100, pk.getCurrentLifePts());
		assertEquals("Grass", pk.getType().getType());
	}
	/**
	 * Test that the attacks are assigned correctly
	 */
	@Test
	public void testAttacks()
	{
		Pokemon pk = new Venusaur("Venusaur", 100);
		assertEquals("Venusaur", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("GigaDrain", attacks[0].getAttackName());
		assertEquals("SeedBomb", attacks[1].getAttackName());
		assertEquals("SolarBeam", attacks[2].getAttackName());
		assertEquals("LeafStorm", attacks[3].getAttackName());
	}
}
