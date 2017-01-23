package evolution;

import attack.Command;
import attack.Fire_Ember;
import attack.Fire_FireSpin;
import attack.Fire_Flamethrower;
import attack.Fire_Inferno;
import pokemonType.Fire;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Vulpix extends Evolution
{
	/**
	 * Create pokemon
	 * @param pokemon
	 */
	public Vulpix(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Fire();
		attacks[0] = new Fire_FireSpin();
		attacks[1] = new Fire_Ember();
		attacks[2] = new Fire_Flamethrower();
		attacks[3] = new Fire_Inferno();
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
