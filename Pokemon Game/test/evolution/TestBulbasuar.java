package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestBulbasuar {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Bulbasaur("Bulbasaur", 100);
	
		assertEquals("Bulbasaur", pk.getName());
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
		Pokemon pk = new Bulbasaur("Bulbasaur", 100);
		assertEquals("Bulbasaur", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("VineWhip", attacks[0].getAttackName());
		assertEquals("RazorLeaf", attacks[1].getAttackName());
		assertEquals("GigaDrain", attacks[2].getAttackName());
		assertEquals("SeedBomb", attacks[3].getAttackName());
	}
	/**
	 * Test when the pokemon evolve
	 */
	@Test
	public void testEvolve()
	{
		Pokemon pk = new Bulbasaur("Bulbasaur", 100);
		assertEquals("Bulbasaur", pk.getName());
		pk = pk.evolve();
		assertEquals("Ivysaur", pk.getName());
		assertEquals(30, pk.getCurrentLifePts());
	}

}
