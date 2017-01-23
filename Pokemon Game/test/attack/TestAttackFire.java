package attack;

import static org.junit.Assert.*;

import org.junit.Test;

import environment.Environment;
import evolution.Bulbasaur;
import evolution.Charmander;
import evolution.Squirtle;
import evolution.Vulpix;
import player.Player1;
import player.Player2;


/**
 * Test cases for Fire Attacks.
 * Fire attacks will do full damage to another fire pokemon, double damage to a grass pokemon and half damage to a water pokemon.
 * @author Jordan Long
 *
 */

public class TestAttackFire 
{

	Environment e = Environment.getInstance();
	
	/**
	 * Fire attack on fire will do full damage to the opponent pokemon.
	 * Should do 5pts of damage using the fireEmber attack.
	 */
	@Test
	public void TestAttackFireonFire() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();	

		
		Charmander c = new Charmander("Charmander", 25);	//Set Player1 Pokemon to fire pokemon.
		player1.setCurrentPokemon(c);
		
		Vulpix vu = new Vulpix("Vulpix", 25);				//Set Player2 Pokemon to fire pokemon.
		player2.setCurrentPokemon(vu);
		
		Command fireEmber = new Fire_Ember();				//Create instance of command.
		
		fireEmber.execute(player2, c);						//Attack player2 with current pokemon using Fire_Ember.		
		
		assertEquals(vu.getCurrentLifePts(), 20);			//Check if pokemon took damage.
	}

	
	/**
	 * Fire attack on grass will do double damage to the opponent pokemon.
	 * Should do 10 pts of damage using the fireEmber attack.
	 */
	@Test
	public void TestAttackFireonGrass() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Charmander c = new Charmander("Charmander", 25);	//Set Player1 Pokemon to fire pokemon.
		player1.setCurrentPokemon(c);
		
		Bulbasaur b = new Bulbasaur("Bulbasaur", 25);		//Set Player2 Pokemon to grass pokemon.
		player2.setCurrentPokemon(b);
		
		Command fireEmber = new Fire_Ember();				//Create instance of command.
		
		fireEmber.execute(player2, c);						//Attack player2 with current pokemon using Fire_Ember.		
		
		assertEquals(b.getCurrentLifePts(), 15);			//Check if pokemon took damage.
	}
	
	
	/**
	 * Fire attack on water will do half damage to the opponent pokemon.
	 * Should do 2.5 pts of damage using the fireEmber attack.
	 * When they are applied, the life points are then rounded down to the nearest whole integer.
	 */
	@Test
	public void TestAttackFireonWater() 
	{
		
		Player1 player1 = new Player1();						//Create players
		Player2 player2 = new Player2();
		
		Charmander c = new Charmander("Charmander", 25);	//Set Player1 Pokemon to fire pokemon.
		player1.setCurrentPokemon(c);
		
		Squirtle s = new Squirtle("Squirtle", 25);			//Set Player2 Pokemon to water pokemon.
		player2.setCurrentPokemon(s);
		
		Command fireEmber = new Fire_Ember();				//Create instance of command.

		fireEmber.execute(player2, c);						//Attack player2 with current pokemon using Fire_Ember.		
		
		assertEquals(s.getCurrentLifePts(), 22);			//Check if pokemon took damage.
	}
	
}
