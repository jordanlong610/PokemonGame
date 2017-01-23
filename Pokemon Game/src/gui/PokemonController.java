package gui;

import attack.Command;
import player.*;
import pokemon.Pokemon;
import environment.Environment;

/**
 * The PokemonController to manage communication between Views and Model.
 * @author Josh Varone
 *
 */
public class PokemonController {

	private Environment model;		//Hold everything in the game
	private View attackView;		//Holds the attack view for the game
	private View battleView;		//Holds the battle view for the game
	private View selectView;		//Holds the select view for the game
	private View changeView;		//Holds the change view for the game
	
	/**
	 * Constructor for a PokemonController
	 */
	public PokemonController() {
		//Pull the Singleton instance of Environment
		model = Environment.getInstance();
	}
	
	/**
	 * Creates the selection view for players to pick Pokemon
	 */
	public void startGame() {
		selectView = new SelectPokemonView(this, model.getCurrentPlayer(), model.getOtherPlayer());
		model.register(selectView);
		selectView.showView();	
	}
	
	/**
	 * Sets up game after Pokemon are selected
	 */
	public void setUpRestOfGame() {
		//create and show battle view
		battleView = new BattleView(this, model.getCurrentPlayer(), model.getOtherPlayer());
		model.register(battleView);
		battleView.showView();
		//create change pokemon view
		changeView = new ChangePokemonView(this, model.getCurrentPlayer(), model.getOtherPlayer());
		model.register(changeView);
		//create attack selection view
		attackView = new AttackView(this, model.getCurrentPlayer(), model.getOtherPlayer());
		model.register(attackView);
	}
	
	/**
	 * Allows the view to set player's pokemon selections
	 */
	public void select(Pokemon[] pokemon) {
		model.getCurrentPlayer().setPokemon(pokemon);
		model.getCurrentPlayer().setCurrentPokemon(pokemon[0]);
		model.changeTurn();
		if(model.getCurrentPlayer().getPokemon() != null) {
			selectView.hideView();
			setUpRestOfGame();	
		}
	}
	
	/**
	 * Creates a view for player to change pokemon
	 */
	public void showChange() {		
		changeView.showView();
	}
	
	/**
	 * Changes the player's currently selected Pokemon
	 */
	public void change(Pokemon pokemon) {
		model.getCurrentPlayer().setCurrentPokemon(pokemon);
		model.changeTurn();
	}
	
	/**
	 * Allows the user to select the attack to use.
	 */
	public void showAttack() {		
		attackView.showView();
	}
	
	/**
	 * Sets the selected Pokemon's current attack to use in battle
	 */
	public void attack(Command attack) {
		attack.execute(model.getOtherPlayer(), model.getCurrentPlayer().getCurrentPokemon());
		model.changeTurn();
	}
	
	/**
	 * Gets the specified Pokemon from factory
	 */
	public Pokemon getPokemon(int pk) {
		return model.getPokemon(pk);
	}
	
}
