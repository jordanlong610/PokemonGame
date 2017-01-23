package state;

import environment.Environment;
import pokemon.Pokemon;

public class PokemonAlive extends PokemonState
{
	public PokemonAlive(Environment en, Pokemon pk)
	{
		super(en, pk);
	}
	
	public void updateState()
	{
		if(pk.getCurrentLifePts() > 0)
		{
			pk.setCurrentState(pk.getAliveState());
		}else
		{
			pk.setCurrentState(pk.getDeadState());
		}
	}

}
