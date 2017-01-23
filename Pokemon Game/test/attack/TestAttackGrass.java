package attack;

import static org.junit.Assert.*;

import org.junit.Test;

import player.Player1;
import player.Player2;
import environment.Environment;
import evolution.Charmander;
import evolution.Ivysaur;
import evolution.Squirtle;
import evolution.Venusaur;


/**
 * Test cases for Grass Attacks.
 * Grass attacks will do full damage to another grass pokemon, double damage to a water pokemon and half damage to a fire pokemon.
 * @author Jordan Long
 *
 */

public class TestAttackGrass 
{

	Environment e = Environment.getInstance();
	
	/**
	 * Grass attack on grass will do full damage to the opponent pokemon.
	 * Should do 13pts of damage using the leafStorm attack.
	 */
	@Test
	public void TestAttackGrassonGrass() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Ivysaur i = new Ivysaur("Ivysaur", 30);				//Set Player1 Pokemon to grass pokemon.
		player1.setCurrentPokemon(i);
		
		Venusaur v = new Venusaur("Venusaur", 35);			//Set Player2 Pokemon to grass pokemon.
		player2.setCurrentPokemon(v);
		
		Command leafStorm = new Grass_LeafStorm();			//Create instance of command.
		
		leafStorm.execute(player2, i);						//Attack player2 with current pokemon using Grass_LeafStorm.		
		
		assertEquals(v.getCurrentLifePts(), 22);			//Check if pokemon took damage.
	}
	
	
	
	/**
	 * Grass attack on water will do double damage to the opponent pokemon.
	 * Should do 26pts of damage using the leafStorm attack, which kills this particular Pokemon.
	 * Checks that points do no drop below zero.
	 */
	@Test
	public void TestAttackGrassonWater() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Ivysaur i = new Ivysaur("Ivysaur", 30);				//Set Player1 Pokemon to grass pokemon.
		player1.setCurrentPokemon(i);
		
		Squirtle s = new Squirtle("Squirtle", 25);			//Set Player2 Pokemon to water pokemon.
		player2.setCurrentPokemon(s);
		
		Command leafStorm = new Grass_LeafStorm();			//Create instance of command.
		
		leafStorm.execute(player2, i);						//Attack player2 with current pokemon using Grass_LeafStorm.		
		
		assertEquals(s.getCurrentLifePts(), 0);			//Check if pokemon took damage.
	}
	
	
	/**
	 * Grass attack on fire will do half damage to the opponent pokemon.
	 * Should do 7.5pts of damage using the leafStorm attack.
	 * When they are applied, the life points are then rounded down to the nearest whole integer.
	 */
	@Test
	public void TestAttackGrassonFire() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Ivysaur i = new Ivysaur("Ivysaur", 30);				//Set Player1 Pokemon to grass pokemon.
		player1.setCurrentPokemon(i);
		
		Charmander c = new Charmander("Charmander", 25);	//Set Player2 Pokemon to fire pokemon.
		player2.setCurrentPokemon(c);
		
		Command leafStorm = new Grass_LeafStorm();			//Create instance of command.
		
		leafStorm.execute(player2, i);						//Attack player2 with current pokemon using Grass_LeafStorm.		
		
		assertEquals(c.getCurrentLifePts(), 18);			//Check if pokemon took damage.
	}

}
