package attack;

/**
 * Attack Type Interface
 * This is the interface that will allow the attack commands to check to see what type of damage the attack
 * will do to the enemy pokemon, based on it's type.
 * @author Jordan Long
 *
 */

public interface AttackType
{
	double calculateDamage(int attackStrength, double damageModifier);
	String getAttackType();
}
