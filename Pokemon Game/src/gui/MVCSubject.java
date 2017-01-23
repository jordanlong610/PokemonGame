package gui;

import player.Player;

/**
 * The Subject interface for the MVC allows the model to be observed
 * and cause observers to update
 * @author Josh Varone
 *
 */
public interface MVCSubject {

	/**
	 * Adds an observer to the subject
	 */
	public void register(MVCObserver observer);
	
	/**
	 * Removes the specified observer from the subject
	 */
	public void remove(MVCObserver observer);
	
	/**
	 * Sends notification to all observers that something changed
	 */
	public void notifyObserver(Player current, Player other);
	
}
