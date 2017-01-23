package gui;

/**
 * This is the interface all views implement, ensuring they can all
 * be updated in the same manner.
 * @author Josh Varone
 *
 */
public interface View extends MVCObserver {

	/**
	 * Method used to update the display of the views
	 */
	public void changeView();
	
	/**
	 * Shows the view to the user
	 */
	public void showView();
	
	/**
	 * Hides the view from user when done
	 */
	public void hideView();
	
}
