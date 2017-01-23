package pokemonFactory;

import pokemon.Pokemon;
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
 * Allows for easy creation of a Pokemon when a Player chooses
 * which Pokemon to use for the battle
 * @author Jeff Titanich
 */
public abstract class PokemonFactory
{
	protected Pokemon[] pokemon;	//	all Pokemon this factory can make
	
	/**
	 * Create all Pokemon and put them in pokemon
	 */
	public void createPokemon()
	{
		pokemon[0] = new Bulbasaur("Bulbasaur", 25);
		pokemon[1] = new Ivysaur("Ivysaur", 30);
		pokemon[2] = new Venusaur("Venusaur", 35);
		pokemon[3] = new Caterpie("Caterpie", 25);
		pokemon[4] = new Charmander("Charmander", 25);
		pokemon[5] = new Charmeleon("Charmeleon", 30);
		pokemon[6] = new Charizard("Charizard", 35);
		pokemon[7] = new Vulpix("Vulpix", 25);
		pokemon[8] = new Squirtle("Squirtle", 25);
		pokemon[9] = new Wartortle("Wartortle", 30);
		pokemon[10] = new Blastoise("Blastoise", 35);
		pokemon[11] = new Poliwag("Poliwag", 25);
	}
	
	/**
	 * Get a specified Pokemon from pokemon
	 * 0 = Bulbasaur
	 * 1 = Ivysaur
	 * 2 = Venusaur
	 * 3 = Caterpie
	 * 4 = Charmander
	 * 5 = Charmeleon
	 * 6 = Charizard
	 * 7 = Vulpix
	 * 8 = Squirtle
	 * 9 = Wartortle
	 * 10 = Blastoise
	 * 11 = Poliwag
	 * @param i - the index of the Pokemon
	 * @return the Pokemon at index i of pokemon
	 */
	public Pokemon getPokemon(int i)
	{
		return pokemon[i];
	}
	
	/**
	 * Helper method for testing purposes
	 * @return the length of the pokemon array
	 */
	public int getPokemonLength()
	{
		return pokemon.length;
	}
}
