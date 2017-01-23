package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestCharmeleon {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Charmeleon("Charmeleon", 100);
	
		assertEquals("Charmeleon", pk.getName());
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
		Pokemon pk = new Charmeleon("Charmeleon", 100);
		assertEquals("Charmeleon", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("Ember", attacks[0].getAttackName());
		assertEquals("FireFang", attacks[1].getAttackName());
		assertEquals("Inferno", attacks[2].getAttackName());
		assertEquals("FlareBlitz", attacks[3].getAttackName());
	}
	/**
	 * Test when the pokemon evolve
	 */
	@Test
	public void testEvolve()
	{
		Pokemon pk = new Charmeleon("Charmeleon", 100);
		assertEquals("Charmeleon", pk.getName());
		pk = pk.evolve();
		assertEquals("Charizard", pk.getName());
		assertEquals(35, pk.getCurrentLifePts());
	}


}
