package evolution;

import attack.Command;
import attack.Grass_GigaDrain;
import attack.Grass_RazorLeaf;
import attack.Grass_SeedBomb;
import attack.Grass_VineWhip;
import pokemon.Pokemon;
import pokemonType.Grass;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Bulbasaur extends Evolution
{
	/**
	 * Create the pokemon
	 * @param pokemon the pokemon's name
	 * @param life the life points of the pokemon
	 */
	public Bulbasaur(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Grass();
		attacks[0] = new Grass_VineWhip();
		attacks[1] = new Grass_RazorLeaf();
		attacks[2] = new Grass_GigaDrain();
		attacks[3] = new Grass_SeedBomb();
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
		pk = new Ivysaur("Ivysaur", 30);
		return pk;
	}
}