package attack;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import evolution.Charizard;
import evolution.Ivysaur;
import evolution.Squirtle;
import evolution.Wartortle;
import player.Player1;
import player.Player2;


/**
 * Test cases for Water Attacks.
 * Water attacks will do full damage to another water pokemon, double damage to a fire pokemon and half damage to a grass pokemon.
 * @author Jordan Long
 *
 */

public class TestAttackWater
{

	Environment e = Environment.getInstance();
	
	/**
	 * Water attack on water will do full damage to the opponent pokemon.
	 * Should do 4pts of damage using the watergun attack.
	 */
	@Test
	public void TestAttackWateronWater() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Squirtle s  = new Squirtle("Squirtle", 25);			//Set Player1 Pokemon to water pokemon.
		player1.setCurrentPokemon(s);
		
		Wartortle w = new Wartortle("Wartortle", 30);		//Set Player2 Pokemon to water pokemon.
		player2.setCurrentPokemon(w);
		
		Command watergun = new Water_WaterGun();			//Create instance of command.
		
		watergun.execute(player2, s);						//Attack player2 with current pokemon using Water_WaterGun.		
		
		assertEquals(w.getCurrentLifePts(), 26);			//Check if pokemon took damage.
	}
	
	
	
	/**
	 * Water attack on fire will do double damage to the opponent pokemon.
	 * Should do 8pts of damage using the watergun attack.
	 */
	@Test
	public void TestAttackWateronFire() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Squirtle s  = new Squirtle("Squirtle", 25);			//Set Player1 Pokemon to water pokemon.
		player1.setCurrentPokemon(s);
		
		Charizard c = new Charizard("Charizard", 35);		//Set Player2 Pokemon to fire pokemon.
		player2.setCurrentPokemon(c);
		
		Command watergun = new Water_WaterGun();			//Create instance of command.
		
		watergun.execute(player2, s);						//Attack player2 with current pokemon using Water_WaterGun.			
		
		assertEquals(c.getCurrentLifePts(), 27);			//Check if pokemon took damage.
	}
	
	
	/**
	 * Water attack on grass will do half damage to the opponent pokemon.
	 * Should do 2pts of damage using the watergun attack.
	 */
	@Test
	public void TestAttackWateronGrass() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Squirtle s  = new Squirtle("Squirtle", 25);			//Set Player1 Pokemon to water pokemon.
		player1.setCurrentPokemon(s);
		
		Ivysaur i = new Ivysaur("Ivysaur", 30);				//Set Player2 Pokemon to grass pokemon.
		player2.setCurrentPokemon(i);
		
		Command watergun = new Water_WaterGun();			//Create instance of command.
		
		watergun.execute(player2, s);						//Attack player2 with current pokemon using Water_WaterGun.			
		
		assertEquals(i.getCurrentLifePts(), 28);			//Check if pokemon took damage.
	}

}
