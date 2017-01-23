package evolution;

import attack.Command;
import attack.Grass_GigaDrain;
import attack.Grass_RazorLeaf;
import attack.Grass_SeedBomb;
import attack.Grass_SolarBeam;
import pokemon.Pokemon;
import pokemonType.Grass;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Ivysaur extends Evolution
{
	/**
	 * Create pokemon
	 * @param pokemon
	 */
	public Ivysaur(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Grass();
		attacks[0] = new Grass_RazorLeaf();
		attacks[1] = new Grass_GigaDrain();
		attacks[2] = new Grass_SeedBomb();
		attacks[3] = new Grass_SolarBeam();
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
		pk = new Venusaur("Venusaur", 35);
		return pk;
	}
}