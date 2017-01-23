package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestCharizard {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Charizard("Charizard", 100);
	
		assertEquals("Charizard", pk.getName());
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
		Pokemon pk = new Charizard("Charizard", 100);
		assertEquals("Charizard", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("FireFang", attacks[0].getAttackName());
		assertEquals("HeatWave", attacks[1].getAttackName());
		assertEquals("Inferno", attacks[2].getAttackName());
		assertEquals("FlareBlitz", attacks[3].getAttackName());
	}

}
