package attack;

import player.Player;
import pokemon.Pokemon;

/**
 * Command Interface
 * 
 * @author Jordan Long
 */

public interface Command
{	
	public void execute(Player target, Pokemon myPokemon);
	public String getAttackName();
	public String getAttackType();
	public int getAttackStrength();
}
