package Drone.DroneController.AutoPilot;

import Drone.DroneCommands.AT_Command_Manager;
import Drone.DroneController.Location;
import Drone.DroneController.AutoPilot.AutoPilotState;
import Drone.DroneController.AutoPilot.ThinkingState;
import Drone.Helpers.Coordinates;

/**
 * The context class for the autopilot state pattern implementation, provides
 * users with the ability to move the drone to a set of coordinates using anobject
 * of thistype.
 * @author orpheus
 *
 */
public class AutoPilot 
{
	/** value for Error in measurements **/
	protected static final float ERROR = 0.1f;
	/** the amount of time, by which each adjustement is carried out **/
	protected static final int ADJUST_INTERVAL = 50;
	/** reference to the drones location object **/
	protected Location location;
	/** reference to the command manager **/
	protected AT_Command_Manager commandManager;
	/** internal reference to state object **/
	protected AutoPilotState state;
	protected AutoPilotState defaultState;
	/** target X-coord **/
	protected float xTarget;
	/** target Y-coord **/
	protected float yTarget;
	/** target Z-coord **/
	protected float zTarget;
	
	/**
	 * create an autopilot given a Lovation and an AT_Command_Manager
	 * @param loc the Location object
	 * @param cm the CommandManager
	 */
	public AutoPilot(Location loc, AT_Command_Manager cm)
	{
		location = loc;		
		state = null;
		commandManager = cm;
		defaultState = new ThinkingState();
	}
	
	/**
	 * Move the drone toward a target set of Cioordinates.
	 * @param target Coordinates object containing the X,Y,Z, components 
	 * @throws Exception 
	 */
	public void moveToTarget(Coordinates target)
	{
		xTarget = target.getX();
		yTarget = target.getY();
		zTarget = target.getZ();
		setState(defaultState);
		System.out.println("<<AUTOPILOT ENGAGED>>");
		state.adjustAction(this);
	}
	
	/**
	 * set  the state to the provided AutoPilotState
	 * @param aState
	 */
	protected void setState(AutoPilotState aState)
	{
		state = aState;
	}
	
	
}
