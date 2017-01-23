package pokemon;

import attack.Command;
import pokemonType.PokemonType;
import state.PokemonState;
/**
 * Create pokemon
 * @author Justin Woods
 *
 */
public abstract class Pokemon 
{
	
	protected Pokemon pk;
	protected Command attack[];
	protected PokemonType type;
	
	private PokemonState pokemonDead;
	private PokemonState pokemonAlive;
	private PokemonState currentState;
	private int currentLfPts;
	private String name; 
	private int max;
	
	public Pokemon(String pokemon, int life)
	{
		name = pokemon;
		max = life;
		currentLfPts = life;
	}

	public void setAttack(Command attack)
	{

		pk.setAttack(attack);
	}
	public PokemonState updateState()
	{
		return currentState;
		
	}
	/**
	 * Set the current State
	 * @param state
	 */
	public void setCurrentState(PokemonState state)
	{
		currentState = state;
		
	}
	/**
	 * get the current life points of the pokemon
	 * @return currentLfPts
	 */
	public int getCurrentLifePts() {
		return currentLfPts;
	}
	/**
	 * get the dead state for the pokemon
	 * @return pokemonAlive
	 */
	public PokemonState getAliveState() 
	{
		return pokemonAlive;
	}
	/**
	 * get the dead state for the pokemon
	 * @return pokemonDead
	 */
	public PokemonState getDeadState() 
	{
		return pokemonDead;
	}
	
	/**
	 * Returns the Pokemon's type: fire, grass or water.
	 * @return type the PokemonType of this Pokemon
	 */
	public PokemonType getType()
	{
		return type;
	}

	public void setLifePoints(int life) 
	{
		currentLfPts = life;
	}

	
	/**
	 * Deducts life points based on how much damage the attack did.
	 * If LPts drops below zero, LPts stays at zero.
	 * @author Jordan Long
	 */
	public void takeHit(double damage)
	{
		currentLfPts -= damage;
		if (currentLfPts < 0)
		{
			currentLfPts = 0;
		}
			
	}
	/**
	 * Get the name of the Pokemon
	 * @return the name
	 * @author Justin Woods
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Get the max life poinys
	 * @return the max life points
	 */
	public int getMaxLfPts()
	{
		return max;
	}
	/**
	 * Evolve the pokemon
	 * @return the pokemon evolved
	 */
	public abstract Pokemon evolve();
	/**
	 * Get the attacks
	 */
	public Command[] getAttacks()
	{
		return pk.getAttacks();
	}
	
	
	
}
