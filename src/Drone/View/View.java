package Drone.View;

import Drone.DroneController.Location;

/**
 * Interface for views of the application to adhere to. provides methods to: 
 * refresh/update the view
 * @author orpheus
 *
 */
public interface View 
{
	
	/**
	 * refreshes the view with the provided data
	 */
	public void refresh(Location loc);
}
