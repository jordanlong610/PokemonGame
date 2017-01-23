package evolution;

import attack.Command;
import attack.Fire_Ember;
import attack.Fire_FireFang;
import attack.Fire_FlareBlitz;
import attack.Fire_Inferno;
import pokemon.Pokemon;
import pokemonType.Fire;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Charmeleon extends Evolution
{
	/**
	 * Create pokemon
	 * @param pokemon
	 */
	public Charmeleon(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Fire();
		attacks[0] = new Fire_Ember();
		attacks[1] = new Fire_FireFang();
		attacks[2] = new Fire_Inferno();
		attacks[3] = new Fire_FlareBlitz();
	}
	
	private Command[] attacks = new Command[4];
	private Pokemon pk;
	/**
	 * Get the attacks
	 */
	public Command[] getAttacks()
	{
		return attacks;
	}

	/**
	 * Evolve the pokemon
	 */

	public Pokemon evolve()
	{ 
		pk = new Charizard("Charizard", 35);
		return pk;
	}
}
