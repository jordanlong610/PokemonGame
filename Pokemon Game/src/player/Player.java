package player;

import attack.Command;
import environment.Environment;
import pokemon.Pokemon;


/**
 * A class that holds all information about a player
 * @author Jeff Titanich
 * @author Josh Varone - some changes for state pattern, comments
 */
public abstract class Player implements IPlayer
{
	protected Environment e;		//environment for game
	private Pokemon[] pokemon;		//all available pokemon
	private Pokemon currentPokemon;	//current pokemon
	
	/**
	 * Sets a new current Pokemon
	 * @param newPokemon - the new Pokemon
	 */
	public void setCurrentPokemon(Pokemon newPokemon)
	{
		currentPokemon = newPokemon;
	}
	
	/**
	 * @return the currently selected Pokemon
	 */
	public Pokemon getCurrentPokemon()
	{
		return currentPokemon;
	}
	
	/**
	 * Sets Pokemon array
	 * @author Josh Varone
	 */
	public void setPokemon(Pokemon[] pk)
	{
		pokemon = pk;
	}
	
	/**
	 * Gets entire Pokemon array
	 * @author Josh Varone
	 */
	public Pokemon[] getPokemon()
	{
		return pokemon;
	}
	
	/**
	 * attack the enemy Player's currentPokemon with current Player's Pokemon using the selected attack
	 * @param attack - one of myPokemon's Attacks to use on the enemy
	 */
	public void attack(Command attack)
	{
		attack.execute(e.getOtherPlayer(), e.getCurrentPlayer().getCurrentPokemon());
	}

}
