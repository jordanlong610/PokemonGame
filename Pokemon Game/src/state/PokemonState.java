package state;

import pokemon.Pokemon;
import environment.Environment;

public abstract class PokemonState 
{
	protected Environment e;
	protected Pokemon pk;
	abstract void updateState();
	public PokemonState(Environment en, Pokemon pokemon)
	{
		e = en;
		pk = pokemon;
	}
	
}
