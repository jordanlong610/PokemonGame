package pokemonType;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests the functionality of the Water PokemonType class
 * @author Jeff Titanich
 */
public class TestWaterType
{
	/**
	 * The instance variable type should be set to "Water"
	 */
	@Test
	public void testInitialization()
	{
		Water water = new Water();
		assertEquals("Water", water.getType());
	}
	
	/**
	 * Water types deal extra damage to Fire types
	 */
	@Test
	public void testAgainstFire()
	{
		Water water = new Water();
		Fire fire = new Fire();
		assertEquals(2, water.calculateDamageModifier(fire), 0);
	}
	
	/**
	 * Water types deal reduced damage to Grass types
	 */
	@Test
	public void testAgainstGrass()
	{
		Water water = new Water();
		Grass grass = new Grass();
		assertEquals(.5, water.calculateDamageModifier(grass), 0);
	}
	
	/**
	 * Water types deal normal damage to other Grass types
	 */
	@Test
	public void testAgainstWater()
	{
		Water water1 = new Water();
		Water water2 = new Water();
		assertEquals(1, water1.calculateDamageModifier(water2), 0);
	}
}
