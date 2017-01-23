package evolution;

import attack.Command;
import attack.Fire_Ember;
import attack.Fire_FireFang;
import attack.Fire_FireSpin;
import attack.Fire_Inferno;
import pokemon.Pokemon;
import pokemonType.Fire;
/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Charmander  extends Evolution 
{
	/**
	 * Create the pokemon
	 * @param pokemon name
	 * @param life lifepts
	 */
	public Charmander(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Fire();
		
		attacks[0] = new Fire_FireSpin();
		attacks[1] = new Fire_Ember();
		attacks[2] = new Fire_FireFang();
		attacks[3] = new Fire_Inferno();
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
		pk = new Charmeleon("Charmeleon", 30);
		return pk;
	}
}