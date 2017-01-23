package pokemonFactory;

import static org.junit.Assert.*;

import org.junit.Test;

import evolution.Blastoise;
import evolution.Bulbasaur;
import evolution.Caterpie;
import evolution.Charizard;
import evolution.Charmander;
import evolution.Charmeleon;
import evolution.Ivysaur;
import evolution.Poliwag;
import evolution.Squirtle;
import evolution.Venusaur;
import evolution.Vulpix;
import evolution.Wartortle;
/**
 * Tests the functionality of the PokemonFactory class
 * @author Jeff Titanich
 */
public class TestPokemonFactory
{
	/**
	 * The length of the pokemon array in each factory should be 12
	 */
	@Test
	public void testInitialization()
	{
		ConcretePokemonFactory factory = new ConcretePokemonFactory();
		assertEquals(12, factory.getPokemonLength());
	}
	
	/**
	 * Pokemon array should hold one of each possible Pokemon
	 */
	@Test
	public void testPokemonCreated()
	{
		ConcretePokemonFactory factory = new ConcretePokemonFactory();
		
		//	Bulbasaur
		Bulbasaur b = new Bulbasaur("Bulbasaur", 25);
		assertEquals(b.getName(), factory.getPokemon(0).getName());
		
		//	Ivysaur
		Ivysaur i = new Ivysaur("Ivysaur", 30);
		assertEquals(i.getName(), factory.getPokemon(1).getName());
		
		//	Venusaur
		Venusaur v = new Venusaur("Venusaur", 35);
		assertEquals(v.getName(), factory.getPokemon(2).getName());
		
		//	Caterpie
		Caterpie c = new Caterpie("Caterpie", 25);
		assertEquals(c.getName(), factory.getPokemon(3).getName());
		
		//	Charmander
		Charmander m = new Charmander("Charmander", 25);
		assertEquals(m.getName(), factory.getPokemon(4).getName());
		
		//	Charmeleon
		Charmeleon ch= new Charmeleon("Charmeleon", 30);
		assertEquals(ch.getName(), factory.getPokemon(5).getName());
		
		//	Charizard
		Charizard cha = new Charizard("Charizard", 35);
		assertEquals(cha.getName(), factory.getPokemon(6).getName());
		
		//	Vulpix
		Vulpix vu = new Vulpix("Vulpix", 25);
		assertEquals(vu.getName(), factory.getPokemon(7).getName());
		
		//	Squirtle
		Squirtle s = new Squirtle("Squirtle", 25);
		assertEquals(s.getName(), factory.getPokemon(8).getName());
		
		//	Wartortle
		Wartortle w = new Wartortle("Wartortle", 30);
		assertEquals(w.getName(), factory.getPokemon(9).getName());
		
		//	Blastoise
		Blastoise bl = new Blastoise("Blastoise", 35);
		assertEquals(bl.getName(), factory.getPokemon(10).getName());
		
		//	Poliwag
		Poliwag p = new Poliwag("Poliwag", 25);
		assertEquals(p.getName(), factory.getPokemon(11).getName());
	}
}