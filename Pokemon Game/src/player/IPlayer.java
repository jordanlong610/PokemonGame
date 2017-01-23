package player;
import attack.Command;
import pokemon.Pokemon;


/**
 * Create the interface for the player
 * @author Justin Woods
 */
public interface  IPlayer 
{
	/**
	 * Sets a new current Pokemon
	 * @param newPokemon - the new Pokemon
	 */
	public void setCurrentPokemon(Pokemon newPokemon);
	
	/**
	 * @return the currently selected Pokemon
	 */
	public Pokemon getCurrentPokemon();
	
	/**
	 * Sets Pokemon array
	 */
	public void setPokemon(Pokemon[] pk);
	
	/**
	 * Gets entire Pokemon array
	 */
	public Pokemon[] getPokemon();
	
	/**
	 * attack the enemy Player's currentPokemon with current Player's Pokemon using the selected attack
	 * @param attack - one of myPokemon's Attacks to use on the enemy
	 */
	public void attack(Command attack);

	
}
