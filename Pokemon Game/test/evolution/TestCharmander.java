package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestCharmander {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Charmander("Charmander", 100);
	
		assertEquals("Charmander", pk.getName());
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
		Pokemon pk = new Charmander("Charmander", 100);
		assertEquals("Charmander", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("FireSpin", attacks[0].getAttackName());
		assertEquals("Ember", attacks[1].getAttackName());
		assertEquals("FireFang", attacks[2].getAttackName());
		assertEquals("Inferno", attacks[3].getAttackName());
	}
	/**
	 * Test when the pokemon evolve
	 */
	@Test
	public void testEvolve()
	{
		Pokemon pk = new Charmander("Charmander", 100);
		assertEquals("Charmander", pk.getName());
		pk = pk.evolve();
		assertEquals("Charmeleon", pk.getName());
		assertEquals(30, pk.getCurrentLifePts());
	}

}
