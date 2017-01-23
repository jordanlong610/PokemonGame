package evolution;
import static org.junit.Assert.*;
import org.junit.Test;
import attack.Command;
import pokemon.Pokemon;

/**
 * Test the pokemon
 * @author Justin Woods
 */
public class TestBlastoise {

	/**
	 * Test the pokemon is initialized correctly
	 */
	@Test
	public void testIntialation()
	{
		Pokemon pk = new Blastoise("Blastoise", 100);
	
		assertEquals("Blastoise", pk.getName());
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
		Pokemon pk = new Blastoise("Blastoise", 100);
		assertEquals("Blastoise", pk.getName());
		Command[] attacks = pk.getAttacks();
		assertEquals("WaterPulse", attacks[0].getAttackName());
		assertEquals("AquaTail", attacks[1].getAttackName());
		assertEquals("HydroPump", attacks[2].getAttackName());
		assertEquals("WaterSpout", attacks[3].getAttackName());
	}

}
