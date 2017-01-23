package pokemonFactory;

import pokemon.Pokemon;

/**
 * A concrete version of PokemonFactory that populates the Pokemon array it inherits
 * @author Jeff Titanich
 */
public class ConcretePokemonFactory extends PokemonFactory
{
	/**
	 * Constructor to instantiate the Pokemon array and populate it with the appropriate Pokemon
	 */
	public ConcretePokemonFactory()
	{
		pokemon = new Pokemon[12];
		createPokemon();
	}
}
