package attack;

public class WaterAttack implements AttackType
{

	/**
	 * Returns the type of attack
	 * @return "Fire"
	 * @author Jordan Long
	 */
	public String getAttackType()
	{
		return "Water";
	}
	
	
	/**
	 * Calculates the amount of damage the attack will do to the enemy pokemon.
	 * @param attackStrength The strength of the attack.
	 * @param damageModifier The modification of the attack strength based on the opponents pokemon type.
	 * @author Jordan Long
	 * @return damage The amount of damage the attack will do.
	 */
	public double calculateDamage(int attackStrength, double damageModifier)
	{
		double damage = attackStrength*damageModifier;
		return damage;
	}
	
	
	
	
	
	
	
}
