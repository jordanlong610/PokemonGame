package gui;

import player.Player;

/**
 * The Observer interface for the MVC allows views to monitor
 * the model and change accordingly.
 * @author Josh Varone
 *
 */
public interface MVCObserver {

	/**
	 * Updates the information displayed in the view
	 */
	public void update(Player current, Player other);
	
}
