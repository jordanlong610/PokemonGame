package attack;


import attack.Fire_Ember;
import attack.Fire_FireFang;
import attack.Fire_FireSpin;
import attack.Fire_Flamethrower;
import attack.Fire_FlareBlitz;
import attack.Fire_HeatWave;
import attack.Fire_Inferno;
import attack.Grass_GigaDrain;
import attack.Grass_LeafStorm;
import attack.Grass_RazorLeaf;
import attack.Grass_SeedBomb;
import attack.Grass_SolarBeam;
import attack.Grass_VineWhip;
import attack.Water_AquaTail;
import attack.Water_Bubble;
import attack.Water_BubbleBeam;
import attack.Water_HydroPump;
import attack.Water_WaterGun;
import attack.Water_WaterPulse;
import attack.Water_WaterSpout;

public class InvokerBuilder
{
/**
 * InvokerBuilder
 * @author Jordan Long
 */

	
	/**
	 * Constructor for Invoker Builder
	 * @author Jordan Long
	 */
	public InvokerBuilder()
	{
		Invoker.setCommand(0, new Fire_Ember());
		Invoker.setCommand(1, new Fire_FireFang());
		Invoker.setCommand(2, new Fire_FireSpin());
		Invoker.setCommand(3, new Fire_Flamethrower());
		Invoker.setCommand(4, new Fire_FlareBlitz());
		Invoker.setCommand(5, new Fire_HeatWave());
		Invoker.setCommand(6, new Fire_Inferno());
		
		Invoker.setCommand(7, new Grass_GigaDrain());
		Invoker.setCommand(8, new Grass_LeafStorm());
		Invoker.setCommand(9, new Grass_RazorLeaf());
		Invoker.setCommand(10, new Grass_SeedBomb());
		Invoker.setCommand(11, new Grass_SolarBeam());
		Invoker.setCommand(12, new Grass_VineWhip());
		
		Invoker.setCommand(13, new Water_AquaTail());
		Invoker.setCommand(14, new Water_Bubble());
		Invoker.setCommand(15, new Water_BubbleBeam());
		Invoker.setCommand(16, new Water_HydroPump());
		Invoker.setCommand(17, new Water_WaterGun());
		Invoker.setCommand(18, new Water_WaterPulse());
		Invoker.setCommand(19, new Water_WaterSpout());
		

		
		
	}
	

	
}