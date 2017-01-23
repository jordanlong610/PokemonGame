package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestCaterpie {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Caterpie("Caterpie", 100);
	
		assertEquals("Caterpie", pk.getName());
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
		Pokemon pk = new Caterpie("Caterpie", 100);
		assertEquals("Caterpie", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("GigaDrain", attacks[0].getAttackName());
		assertEquals("RazorLeaf", attacks[1].getAttackName());
		assertEquals("VineWhip", attacks[2].getAttackName());
		assertEquals("LeafStorm", attacks[3].getAttackName());
	}

}
