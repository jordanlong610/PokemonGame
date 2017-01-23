package evolution;

import attack.Command;
import attack.Grass_GigaDrain;
import attack.Grass_LeafStorm;
import attack.Grass_RazorLeaf;
import attack.Grass_VineWhip;
import pokemonType.Grass;

/**
 * Create the pokemon and with it's type and attacks, and allows the pokemon to evolve
 * @author Justin Woods
 */
public class Caterpie extends Evolution
{
	/**
	 * Create the pokemon 
	 * @param pokemon the pokemon's name
	 * @param life the pokemons life points
	 */
	public Caterpie(String pokemon, int life) 
	{
		super(pokemon, life);
		type = new Grass();
		attacks[0] = new Grass_GigaDrain();
		attacks[1] = new Grass_RazorLeaf();
		attacks[2] = new Grass_VineWhip();
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