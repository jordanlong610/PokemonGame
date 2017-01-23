package pokemonType;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests the functionality of the Fire PokemonType class
 * @author Jeff Titanich
 */
public class TestFireType
{
	/**
	 * The instance variable type should be set to  "Fire"
	 */
	@Test
	public void testInitialization()
	{
		Fire fire = new Fire();
		assertEquals("Fire", fire.getType());
	}
	
	/**
	 * Fire types deal extra damage to Grass types
	 */
	@Test
	public void testAgainstGrass()
	{
		Fire fire = new Fire();
		Grass grass = new Grass();
		assertEquals(2, fire.calculateDamageModifier(grass), 0);
	}
	
	/**
	 * Fire types deal reduces damage to Water types
	 */
	@Test
	public void testAgainstWater()
	{
		Fire fire = new Fire();
		Water water = new Water();
		assertEquals(.5, fire.calculateDamageModifier(water), 0);
	}
	
	/**
	 * Fire types deal normal damage to other Fire types
	 */
	@Test
	public void testAgainstFire()
	{
		Fire fire1 = new Fire();
		Fire fire2 = new Fire();
		assertEquals(1, fire1.calculateDamageModifier(fire2), 0);
	}
}
