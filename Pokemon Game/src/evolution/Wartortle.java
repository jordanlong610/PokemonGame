package evolution;

import attack.Command;
import attack.Water_AquaTail;
import attack.Water_Bubble;
import attack.Water_HydroPump;
import attack.Water_WaterPulse;
import pokemon.Pokemon;
import pokemonType.Water;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Wartortle extends Evolution
{
	/**
	 * Create the pokemon
	 * @param pokemon
	 */
	public Wartortle(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Water();
		attacks[0] = new Water_Bubble();
		attacks[1] = new Water_WaterPulse();
		attacks[2] = new Water_AquaTail();
		attacks[3] = new Water_HydroPump();
		
	}

	private Command[] attacks = new Command[4];
	private Pokemon pk;

	/**
	 * Get the array of attacks
	 */
	public Command[] getAttacks()
	{
		return attacks;
	}


	/**
	 * Evolve the pokemon
	 * @return the evolved pokemon
	 */
	public Pokemon evolve()
	{ 
		
		pk = new Blastoise("Blastoise", 35);
		return pk;
	}
	

}