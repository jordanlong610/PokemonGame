package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestVulpix {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Vulpix("Vulpix", 100);
	
		assertEquals("Vulpix", pk.getName());
		assertEquals(100, pk.getMaxLfPts());
		assertEquals(100, pk.getCurrentLifePts());
		assertEquals(100, pk.getCurrentLifePts());
		assertEquals("Fire", pk.getType().getType());
	}
	/**
	 * Test that the attacks are assigned correctly
	 */
	@Test
	public void testAttacks()
	{
		Pokemon pk = new Vulpix("Vulpix", 100);
		assertEquals("Vulpix", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("FireSpin", attacks[0].getAttackName());
		assertEquals("Ember", attacks[1].getAttackName());
		assertEquals("Flamethrower", attacks[2].getAttackName());
		assertEquals("Inferno", attacks[3].getAttackName());
	}
}
