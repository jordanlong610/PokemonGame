package evolution;

import attack.Command;
import attack.Fire_FireFang;
import attack.Fire_FlareBlitz;
import attack.Fire_HeatWave;
import attack.Fire_Inferno;
import pokemonType.Fire;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Charizard extends Evolution
{
	/**
	 * Create the pokemon
	 * @param pokemon the pokemon's name
	 * @param life the pokemon's life points
	 */
	public Charizard(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Fire();
		attacks[0] = new Fire_FireFang();
		attacks[1] = new Fire_HeatWave();
		attacks[2] = new Fire_Inferno();
		attacks[3] = new Fire_FlareBlitz();
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