package Drone.DroneController;

import Drone.Hardware.SensorManager;
import Drone.Helpers.Coordinates;
/**
 * This class represents the drones percieved location of itself, it provides
 * a method to update its position, as well as accessor methods for the X,Y and Z
 * coordinate components.
 * @author orpheus
 *
 */
public class Location
{
	/** X zero position constant **/
	private static final float startX = 0f;
	/** Y zero position constant  **/
	private static final float startY = 0f;
	/** Z zero position constant **/
	private static final float startZ = 0f;
	/** Current Y position in meters **/
	private float currentY;
	/** Current X position in meters **/
	private float currentX;
	/** Current Z position in meters **/
	private float currentZ;
	/** Current Time **/
	private long  currentT;
	/** Current Y velocity **/
	private float currentYvel;
	/** Current X velocity **/
	private float currentXvel;
	/** Current Z velocity **/
	private float currentZvel;
	
	/**
	 * preliminary initialisation
	 */
	public Location()
	{
		currentYvel = 0;
		currentXvel = 0;
		currentZvel = 0;
		currentT	= System.currentTimeMillis()*1000;
	}
	
	/**
	 * center the drone on the current point
	 */
	public void centerWorld()
	{
		currentY = startY;
		currentX = startX;
		currentZ = startZ;
		currentT = System.currentTimeMillis()*1000;
	}
	
	/**
	 * update X, Y and Z positions
	 */
	public void updateLocation()
	{
		//set initial values
		float initialYvel = currentYvel;
		float initialXvel = currentXvel;
		float initialZvel = currentZvel;
		long  initialT	  = currentT;
		
		currentYvel = SensorManager.getYvelocity();
		currentXvel = SensorManager.getXvelocity();
		currentZvel = SensorManager.getYvelocity();
		currentT	= System.currentTimeMillis()*1000;
		
		//use SUVAT formulae
		currentX = currentX +
				((initialXvel + currentXvel)*(currentT-initialT)) / 2;
		currentY = currentY +
				((initialYvel + currentYvel)*(currentT-initialT)) / 2;
		currentZ = currentZ +
				((initialZvel + currentZvel)*(currentT-initialT)) / 2;
	}
	
	/**
	 * get X value for drone position
	 * @return
	 */
	public float getX()
	{
		return currentX;
	}
	
	/**
	 * retrieve Y value for drone position
	 * @return
	 */
	public float getY()
	{
		return currentY;
	}
	
	/**
	 * retrieve Z value for drone position
	 * @return
	 */
	public float getZ()
	{
		return currentZ;
	}
	
	/**
	 * return the x,y and z velocities as a coordinate set, each coord corresponds
	 * to its velocity i.e. the x component is the x velocity etc
	 * @return
	 */
	public Coordinates getXYZvelocities()
	{
		return new Coordinates(SensorManager.getXvelocity(), 
							   SensorManager.getYvelocity(), 
							   SensorManager.getZvelocity());
	}
}
