package evolution;

import attack.Command;
import attack.Water_Bubble;
import attack.Water_BubbleBeam;
import attack.Water_HydroPump;
import attack.Water_WaterGun;
import pokemonType.Water;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Poliwag extends Evolution
{
	public Poliwag(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Water();
		attacks[0] = new Water_WaterGun();
		attacks[1] = new Water_Bubble();
		attacks[2] = new Water_BubbleBeam();
		attacks[3] = new Water_HydroPump();
	}

	/**
	 * Create pokemon
	 * @param pokemon
	 */
	private Command[] attacks = new Command[4];

	
	public Command[] getAttacks()
	{
		return attacks;
	}
}

