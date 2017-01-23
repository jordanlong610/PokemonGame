package attack;

import player.Player;
import pokemon.Pokemon;
import pokemonType.PokemonType;
import attack.Command;



/**
 * 
 * Pokémon Attack
 * 
 * Name:	Vine Whip
 * Type:	Grass
 * Damage:	4
 * 
 * A grass type attack will do same damage against a grass type, double damage against a water type, 
 * and half damage against a fire type.
 * 
 * @author Jordan Long
 */


public class Grass_VineWhip implements Command
{

	int attackStrength;
	String commandName;
	AttackType grass = new GrassAttack();
	
	//Constructor for Grass_VineWhip.
	public Grass_VineWhip()
	{
		attackStrength = 4;
		commandName = "VineWhip";
	}
	
	
	
	@Override
	public void execute(Player target, Pokemon myPokemon)
	{
		//1. Get enemy Pokemon, store locally.
		Pokemon targetPokemon = target.getCurrentPokemon();
		
		//2. Get both Pokemon types.
		PokemonType pokeType1 = myPokemon.getType();
		PokemonType pokeType2 = targetPokemon.getType();
		
		//3. Calculate damage based on both pokemon types.
		double damageModifier = pokeType1.calculateDamageModifier(pokeType2);
		
		//4.Defer damage calculation to strategy pattern.

		double damage = grass.calculateDamage(attackStrength, damageModifier);
		
		//5. Attack enemy.
		targetPokemon.takeHit(damage);
	
	}
	
	/**
	 * Returns the name of the Attack
	 * @return commandName The Name of the attack, in the form of a string.
	 * @author Jordan Long
	 */
	@Override
	public String getAttackName()
	{
		return commandName;
	}
	
	/**
	 * Returns the type of attack
	 * @return attack type
	 * @author Jordan Long
	 */
	@Override
	public String getAttackType()
	{
		return grass.getAttackType();
	}
	
	
	/**
	 * Returns the strength of the current attack.
	 * @return attackStrength The strength of the attack.
	 * @author Jordan Long
	 */
	@Override
	public int getAttackStrength()
	{
		return attackStrength;
	}
	
	
}