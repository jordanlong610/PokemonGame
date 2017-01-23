package evolution;

import attack.Command;
import pokemon.Pokemon;
/**
 * Create the pokemon
 * @author Justin Woods
 */
public abstract class Evolution extends Pokemon
{
	private Pokemon pk;
	/**
	 * Create the pokemon
	 * @param pokemon the pokemon name
	 * @param life the life points
	 */
	public Evolution(String pokemon, int life) 
	{
		super(pokemon, life);
		
	}

	/**
	 * Evolve the pokemon
	 */
	public Pokemon evolve()
	{
		return pk.evolve();
	}
	/**
	 * Get the pokemons attacks
	 */
	public Command[] getAttacks()
	{
		return pk.getAttacks();
		
	}
	
	
	

}
