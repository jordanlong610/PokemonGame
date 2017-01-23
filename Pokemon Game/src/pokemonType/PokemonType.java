package pokemonType;

/**
 * An interface that allows Pokemon to have a specific Type which will modify its damage
 * based on the Type of the opponent.
 * Fire > Grass
 * Grass > Water
 * Water > Fire
 * @author Jeff Titanich
 */
public abstract class PokemonType
{
	protected String type;	//	an easily comparable value to represent the PokemonType
	
	public abstract double calculateDamageModifier(PokemonType enemyType);
	
	/**
	 * @return the String value of the PokemonType
	 */
	public String getType()
	{
		return type;
	}
}