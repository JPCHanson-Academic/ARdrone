package Drone.Hardware;

import java.util.List;

import workspace.ARDroneNavData.src.NavData;
import workspace.ARDroneNavData.src.controller.VisionTag;

/**
 * This is the class to use if you wish to get raw data from the sensors
 * @author orpheus
 *
 */
public class SensorManager extends NavData
{
	/**
	 * A reference to a NavData object,
	 * @TODO strip down NavData.java to bare essentials 
	 **/
	private NavData navData;
	
	/**
	 * initialise the sensor manager
	 * @throws Exception
	 */
	public SensorManager()
	{
		navData = new NavData();
		String[] args = {""};
		NavData.main(args);
	}
	
	/**
	 * retrieve the X velocity
	 * @return X velocity
	 */
	public static float getXvelocity()
	{
		return NavData.getVx();
	}
	
	/**
	 * retrieve the Y velocity
	 * @return Y velocity
	 */
	public static float getYvelocity()
	{
		//getLongitude() actually returns NavData.Vy
		return NavData.getLongitude();
	}
	/**
	 * retrieve the Z velocity
	 * @return Z velocity
	 */
	public static float getZvelocity()
	{
		return NavData.getVz();
	}
	
	/**
	 * Retrieve the Yaw value
	 * @return Yaw value
	 */
	public static float getYaw()
	{
		return NavData.getYaw();
	}
	
	/**
	 * Retrieve the pitch value
	 * @return pitch value
	 */
	public static float getPitch()
	{
		return NavData.getPitch();
	}
	
	/**
	 * retrieve the roll value
	 * @return roll value
	 */
	public static float getRoll()
	{
		return NavData.getRoll();
	}
	
	/**
	 * Retrieve the Altitude
	 * @return Altitude
	 */
	public static float getAltitude()
	{
		return NavData.getAltitude();
	}
	
	/**
	 * Retrieve a list of the vision tage
	 * @return List<VisionTag>
	 */
	public static List<VisionTag> getVisionTags()
	{
		return NavData.getVisionTags();
	}
	
	public SensorManager getInstance()
	{
		return this;
	}
}
