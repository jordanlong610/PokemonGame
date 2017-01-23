package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import attack.Command;
import pokemon.Pokemon;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestSquirtle {


	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Squirtle("Squirtle", 100);
	
		assertEquals("Squirtle", pk.getName());
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
		Pokemon pk = new Squirtle("Squirtle", 100);
		assertEquals("Squirtle", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("WaterGun", attacks[0].getAttackName());
		assertEquals("Bubble", attacks[1].getAttackName());
		assertEquals("WaterPulse", attacks[2].getAttackName());
		assertEquals("AquaTail", attacks[3].getAttackName());
	}
	/**
	 * Test when the pokemon evolve
	 */
	@Test
	public void testEvolve()
	{
		Pokemon pk = new Squirtle("Squirtle", 100);
		assertEquals("Squirtle", pk.getName());
		pk = pk.evolve();
		assertEquals("Wartortle", pk.getName());
		assertEquals(30, pk.getCurrentLifePts());
	}

}
