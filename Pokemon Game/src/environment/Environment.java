package environment;

import java.util.ArrayList;
import player.*;
import pokemon.Pokemon;
import pokemonFactory.*;
import gui.*;

/**
 * The Environment houses the players for an instance of the Pokemon
 * game and contains methods relating to its MVC role as model.
 * @author Josh Varone
 *
 */
public class Environment implements MVCSubject {

	private static Environment uniqueWorld;		//unique instance of the world
	private ArrayList<MVCObserver> observers = new ArrayList<MVCObserver>(); //list of observers
	private Player player1, player2;			//players in the game (only 2)
	private Player currentPlayer;				//current player
	private PokemonFactory pokemonFactory;		//the Pokemon factory for use	
	
	/**
	 * Creates the environment with players.
	 */
	private Environment() {
		player1 = new Player1();
		player2 = new Player2();
		currentPlayer = player1;
		pokemonFactory = new ConcretePokemonFactory();
	}
	
	/**
	 * Singleton method. Creates an instance of Environment if none exists, 
	 * otherwise returns the currently existing instance.
	 * @return the instance of Environment
	 */
	public static Environment getInstance() {
		//check if an instance exists
		if(uniqueWorld == null)
			//if not, synchronize to prevent duplicate instantiation
			synchronized(Environment.class) {
				//if an instance still doesn't exits, make a new one
				if(uniqueWorld == null)
					uniqueWorld = new Environment();
			}
		//return the instance of Environment
		return uniqueWorld;
	}
	
	/**
	 * Gets the current player
	 * @return the current player
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Player getOtherPlayer() {
		if(currentPlayer == player1) return player2;
		return player1;
	}
	
	/**
	 * Gets specified Pokemon from factory
	 */
	public Pokemon getPokemon(int pk) {
		return pokemonFactory.getPokemon(pk);
	}
	
	/**
	 * Switches the current player to the opposing player
	 */
	public void changeTurn() {
		if(currentPlayer == player1) {
			currentPlayer = player2;
			notifyObserver(player2, player1);
		}
		else {
			currentPlayer = player1;
			notifyObserver(player1, player2);
		}
	}
	
	/**
	 * Adds an observer to the list for the Environment
	 */
	public void register(MVCObserver observer) {
		observers.add(observer);
	}
	
	/**
	 * Removes the specified observer from the list for the Environment
	 */
	public void remove(MVCObserver observer) {
		observers.remove(observer);
	}
	
	/**
	 * Notifies all observers to update their information.
	 */
	public void notifyObserver(Player current, Player other) {
		for (MVCObserver o: observers) {
			o.update(current, other);
		}
	}
	
	/**
	 * Resets the Environment
	 */
	public static void reset() {
		uniqueWorld = null;
	}
	
}
