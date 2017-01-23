package pokemonType;

/**
 * A Pokemon Type that does extra damage to Water types and reduced damage to Fire types
 * @author Jeff Titanich
 */
public class Grass extends PokemonType
{
	/**
	 * A constructor to give type a value
	 */
	public Grass()
	{
		type = "Grass";
	}
	
	/**
	 * Calculate the damage dealt to the enemy based on the damage of the attack
	 * and the PokemonType of the enemy
	 * @param enemy - the Pokemon that this Pokemon is targeting
	 * @return the damage modifier based on the enemy's Pokemontype
	 * Water = 1.5
	 * Fire = .5
	 * Grass = 1
	 */
	@Override
	public double calculateDamageModifier(PokemonType enemyType)
	{
		if(enemyType.getType() == "Water")
		{
			return 2;
		}
		
		if(enemyType.getType() == "Fire")
		{
			return .5;
		}
		
		return 1;	//	will only happen if the enemy is not a Water or Fire type
					//	so it has to be a Grass type
	}
	
}
