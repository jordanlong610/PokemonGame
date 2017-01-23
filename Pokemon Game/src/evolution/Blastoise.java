package evolution;

import attack.Command;
import attack.Water_AquaTail;
import attack.Water_HydroPump;
import attack.Water_WaterPulse;
import attack.Water_WaterSpout;
import pokemonType.Water;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Blastoise extends Evolution
{
	/**
	 * Create the pokemon 
	 * @param pokemon the pokemon's name
	 * @param life pokemons life points
	 */
	public Blastoise(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Water();
		
		attacks[0] = new Water_WaterPulse();
		attacks[1] = new Water_AquaTail();
		attacks[2] = new Water_HydroPump();
		attacks[3] = new Water_WaterSpout();
		
		
	}
	
		private Command[] attacks = new Command[4];
		/**
		 * Get the attacks
		 */
		public Command[] getAttacks()
		{
			return attacks;
		}

	
		
	}