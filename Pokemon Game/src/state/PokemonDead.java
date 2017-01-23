package state;

import environment.Environment;
import pokemon.Pokemon;

public class PokemonDead extends PokemonState
{
	
	public PokemonDead(Environment en, Pokemon pk) 
	{
		super(en, pk);
	}
	public void updateState()
	{
		if(pk.getCurrentLifePts() <= 0)
		{
			pk.setCurrentState(pk.getDeadState());
		}else
		{
			pk.setCurrentState(pk.getAliveState());
		} 
	}
}
