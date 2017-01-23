package attack;

import player.Player;
import pokemon.Pokemon;
import pokemonType.PokemonType;
import attack.Command;


/**
 * 
 * Pokémon Attack
 * 
 * Name:	Ember
 * Type:	Fire
 * Damage:	5
 * 
 * A fire type attack will do full damage to a fire type Pokémon, double damage to a grass type Pokémon, 
 * and half damage to a water type Pokémon.
 * 
 * @author Jordan Long
 */


public class Fire_Ember implements Command
{

	int attackStrength;
	String commandName;
	AttackType fire = new FireAttack();
	
	//Constructor for Fire_Ember.
	public Fire_Ember()
	{
		attackStrength = 5;
		commandName = "Ember";
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

		double damage = fire.calculateDamage(attackStrength, damageModifier);
		
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
		return fire.getAttackType();
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
