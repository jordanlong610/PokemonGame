package player;

import static org.junit.Assert.*;

import org.junit.Test;

import evolution.Blastoise;
import evolution.Bulbasaur;
import evolution.Caterpie;
import pokemon.Pokemon;
/**
 * Tests the functionality of the Player class
 * @author Jeff Titanich, Justin Woods
 */
public class TestPlayer
{
	/**
	 * Test Initializing player 1
	 */
	@Test
	public void testInitializationPlayer1()
	{
		Pokemon pk1 = new Blastoise("Blastoise", 25);
		Pokemon pk2 = new Bulbasaur("Bulbasaur", 20);
		Pokemon pk3 = new Caterpie("Caterpie", 30);
		Pokemon[] pokemon = {pk1, pk2, pk3};
		Player p = new Player1();
		p.setPokemon(pokemon);
		assertEquals(pokemon, p.getPokemon());
		//get the 1st pokemon
		p.setCurrentPokemon(pk1);
		assertEquals(pk1, p.getCurrentPokemon());
		//get the 2nd pokemon
		p.setCurrentPokemon(pk2);
		assertEquals(pk2, p.getCurrentPokemon());
		//get the 3rd pokemon
		p.setCurrentPokemon(pk3);
		assertEquals(pk3, p.getCurrentPokemon());
		
		
	}
	/**
	 * Test Initializing player 2
	 */
	@Test
	public void testInitializationPlayer2()
	{
		Pokemon pk1 = new Blastoise("Blastoise", 25);
		Pokemon pk2 = new Bulbasaur("Bulbasaur", 20);
		Pokemon pk3 = new Caterpie("Caterpie", 30);
		Pokemon[] pokemon = {pk1, pk2, pk3};
		Player p = new Player2();
		p.setPokemon(pokemon);
		assertEquals(pokemon, p.getPokemon());
		//get the 1st pokemon
		p.setCurrentPokemon(pk1);
		assertEquals(pk1, p.getCurrentPokemon());
		//get the 2nd pokemon
		p.setCurrentPokemon(pk2);
		assertEquals(pk2, p.getCurrentPokemon());
		//get the 3rd pokemon
		p.setCurrentPokemon(pk3);
		assertEquals(pk3, p.getCurrentPokemon());
		
		
	}
}
