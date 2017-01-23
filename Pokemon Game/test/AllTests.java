import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import attack.*;
import environment.*;
import evolution.*;
import gui.*;
import player.*;
import pokemon.*;
import pokemonFactory.*;
import pokemonType.*;
import state.*;

/**
 * Runs all tests in the project
 * @author Josh Varone
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses
({
	TestAttackFire.class,
	TestAttackGrass.class,
	TestAttackWater.class,
	TestEnvironment.class,
	TestAttackView.class,
	TestBattleView.class,
	TestChangePokemonView.class,
	TestSelectPokemonView.class,
	TestStartScreen.class,
	TestPlayer.class,
	TestPokemonFactory.class,
	TestFireType.class,
	TestGrassType.class,
	TestWaterType.class,
	TestBlastoise.class,
	TestBulbasuar.class,
	TestCaterpie.class,
	TestCharizard.class,
	TestCharmander.class,
	TestCharmeleon.class,
	TestEvolution.class,
	TestIvysaur.class,
	TestPoliwag.class,
	TestSquirtle.class,
	TestVensusaur.class,
	TestVulpix.class,
	TestWartortle.class,
	TestPokemonAliveState.class,
	TestPokemonDeadState.class,
	TestPokemonState.class,
	TestPokemon.class
})

public class AllTests {}
