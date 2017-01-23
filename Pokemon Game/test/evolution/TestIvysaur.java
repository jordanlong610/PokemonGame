package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestIvysaur {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Ivysaur("Ivysaur", 100);
	
		assertEquals("Ivysaur", pk.getName());
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
		Pokemon pk = new Ivysaur("Ivysaur", 100);
		assertEquals("Ivysaur", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("RazorLeaf", attacks[0].getAttackName());
		assertEquals("GigaDrain", attacks[1].getAttackName());
		assertEquals("SeedBomb", attacks[2].getAttackName());
		assertEquals("SolarBeam", attacks[3].getAttackName());
	}
	/**
	 * Test when the pokemon evolve
	 */
	@Test
	public void testEvolve()
	{
		Pokemon pk = new Ivysaur("Ivysaur", 100);
		assertEquals("Ivysaur", pk.getName());
		pk = pk.evolve();
		assertEquals("Venusaur", pk.getName());
		assertEquals(35, pk.getCurrentLifePts());
	}

}
