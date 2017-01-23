package pokemonType;

/**
 * A Pokemon Type that does extra damage to Grass types and reduced damage to Water types
 * @author Jeff Titanich
 */
public class Fire extends PokemonType
{
	/**
	 * A constructor to give type a value
	 */
	public Fire()
	{
		type = "Fire";
	}
	
	/**
	 * Calculate the damage dealt to the enemy based on the damage of the attack
	 * and the PokemonType of the enemy
	 * @param enemy - the Pokemon that this Pokemon is targeting
	 * @return the damage modifier based on the enemy's Pokemontype
	 * Grass = 1.5
	 * Water = .5
	 * Fire = 1
	 */
	@Override
	public double calculateDamageModifier(PokemonType enemyType)
	{
		if(enemyType.getType() == "Grass")
		{
			return 2;
		}
		
		if(enemyType.getType() == "Water")
		{
			return .5;
		}
		
		return 1;	//	will only happen if the enemy is not a Grass or Water type
					//	so it has to be a Fire type
	}
	
}
