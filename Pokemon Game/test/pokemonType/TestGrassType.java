package pokemonType;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests the functionality of the Fire PokemonType class
 * @author Jeff Titanich
 */
public class TestGrassType
{
	/**
	 * The instance variable type should be set to "Grass"
	 */
	@Test
	public void testInitialization()
	{
		Grass grass = new Grass();
		assertEquals("Grass", grass.getType());
	}
	
	/**
	 * Grass types deal extra damage to Water types
	 */
	@Test
	public void testAgainstWater()
	{
		Grass grass = new Grass();
		Water water = new Water();
		assertEquals(2, grass.calculateDamageModifier(water), 0);
	}
	
	/**
	 * Grass types deal reduced damage to Fire types
	 */
	@Test
	public void testAgainstFire()
	{
		Grass grass = new Grass();
		Fire fire = new Fire();
		assertEquals(.5, grass.calculateDamageModifier(fire), 0);
	}
	
	/**
	 * Grass types deal normal damage to other Grass types
	 */
	@Test
	public void testAgainstGrass()
	{
		Grass grass1 = new Grass();
		Grass grass2 = new Grass();
		assertEquals(1, grass1.calculateDamageModifier(grass2), 0);
	}
}
