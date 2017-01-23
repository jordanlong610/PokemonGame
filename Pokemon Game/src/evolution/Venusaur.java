package evolution;

import attack.Command;
import attack.Grass_GigaDrain;
import attack.Grass_LeafStorm;
import attack.Grass_SeedBomb;
import attack.Grass_SolarBeam;
import pokemonType.Grass;
/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Venusaur extends Evolution
{
	/**
	 * Create pokemon
	 * @param pokemon
	 */
	public Venusaur(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Grass();
		attacks[0] = new Grass_GigaDrain();
		attacks[1] = new Grass_SeedBomb();
		attacks[2] = new Grass_SolarBeam();
		attacks[3] = new Grass_LeafStorm();
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
