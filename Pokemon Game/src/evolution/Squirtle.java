package evolution;

import attack.Command;
import attack.Water_AquaTail;
import attack.Water_Bubble;
import attack.Water_WaterGun;
import attack.Water_WaterPulse;
import pokemon.Pokemon;
import pokemonType.Water;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Squirtle  extends Evolution
{
	/**
	 * Create pokemon
	 * @param pokemon
	 */
	public Squirtle(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Water();
		attacks[0] = new Water_WaterGun();
		attacks[1] = new Water_Bubble();
		attacks[2] = new Water_WaterPulse();
		attacks[3] = new Water_AquaTail();
		
	}
	private Pokemon pk;
	private Command[] attacks = new Command[4];
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
		pk = new Wartortle("Wartortle", 30);
		return pk;
	}
}