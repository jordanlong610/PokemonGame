package evolution;

import static org.junit.Assert.*;

import org.junit.Test;

import pokemon.Pokemon;
import attack.Command;
/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestPoliwag {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Poliwag("Poliwag", 100);
	
		assertEquals("Poliwag", pk.getName());
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
		Pokemon pk = new Poliwag("Poliwag", 100);
		assertEquals("Poliwag", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("WaterGun", attacks[0].getAttackName());
		assertEquals("Bubble", attacks[1].getAttackName());
		assertEquals("BubbleBeam", attacks[2].getAttackName());
		assertEquals("HydroPump", attacks[3].getAttackName());
	}
}
