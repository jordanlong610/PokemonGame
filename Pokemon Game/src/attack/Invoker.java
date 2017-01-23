package attack;

import player.Player;
import pokemon.Pokemon;
import attack.Command;

public abstract class Invoker
{
/**
 * Invoker
 * When the attack button is pressed, the user attack the enemy's pokemon using the attack requested.
 * 
 * @author Jordan Long
 */
	
	/**
	 * Attack Identifiers
	 * 
	 * 0.Fire_Ember
	 * 1.Fire_FireFang
	 * 2.Fire_FireSpin
	 * 3.Fire_Flamethrower
	 * 4.Fire_FlareBlitz
	 * 5.Fire_HeatWave
	 * 6.Fire_Inferno
	 * 7.Grass_GigaDrain
	 * 8.Grass_LeafStorm
	 * 9.Grass_RazorLeaf
	 * 10.Grass_SeedBomb
	 * 11.Grass_SolarBeam
	 * 12.Grass_VineWhip
	 * 13.Water_AquaTail
	 * 14.Water_Bubble
	 * 15.Water_BubbleBeam
	 * 16.Water_HydroPump
	 * 17.Water_WaterGun
	 * 18.Water_WaterPulse
	 * 19.Water_WaterSpout
	 */
	
	/**
	 * Creates the array of attack commands.
	 */
	private static Command[] commands = new Command[19];
	
	
	/**
	 * Adds command to specified slot in command array.
	 * @param slot
	 * @param command
	 */
	public static  void setCommand(int slot, Command command)
	{
		commands[slot] = command;
	}
	
	
	/**
	 * Executes the command that is called 
	 */
	  public static void attack(Player target, Pokemon myPokemon, int attackIdentifier)
	  {
		  commands[attackIdentifier].execute(target, myPokemon);
	  }
	  
	  
}
