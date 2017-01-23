package pokemonType;

/**
 * A Pokemon Type that does extra damage to Fire types and reduced damage to Grass types
 * @author Jeff Titanich
 */
public class Water extends PokemonType
{
	/**
	 * A constructor to give type a value
	 */
	public Water()
	{
		type = "Water";
	}
	
	/**
	 * Calculate the damage dealt to the enemy based on the damage of the attack
	 * and the PokemonType of the enemy
	 * @param enemy - the Pokemon that this Pokemon is targeting
	 * @return the damage modifier based on the enemy's Pokemontype
	 * Fire = 1.5
	 * Grass = .5
	 * Water = 1
	 */
	@Override
	public double calculateDamageModifier(PokemonType enemyType)
	{
		if(enemyType.getType() == "Fire")
		{
			return 2;
		}
		
		if(enemyType.getType() == "Grass")
		{
			return .5;
		}
		
		return 1;	//	will only happen if the enemy is not a Fire or Grass type
					//	so it has to be a Grass type
	}
}
