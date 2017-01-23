package attack;

import player.Player;
import pokemon.Pokemon;
import pokemonType.PokemonType;
import attack.Command;



/**
 * 
 * Pokémon Attack
 * 
 * Name:	Bubble Beam
 * Type:	Water
 * Damage:	6
 * 
 * A water type attack will do same damage against a water type, double against a fire type, 
 * and half against a grass type.
 * 
 * @author Jordan Long
 */


public class Water_BubbleBeam implements Command
{

	int attackStrength;
	String commandName;
	AttackType water = new WaterAttack();
	
	//Constructor for Water_BubbleBeam.
	public Water_BubbleBeam()
	{
		attackStrength = 6;
		commandName = "BubbleBeam";
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

		double damage = water.calculateDamage(attackStrength, damageModifier);
		
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
		return water.getAttackType();
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