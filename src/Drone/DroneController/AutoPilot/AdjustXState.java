package Drone.DroneController.AutoPilot;
/**
 * The autopilot state in which the drone knows its X coordinate is incorrect.
 * @author orpheus
 *
 */
public class AdjustXState implements AutoPilotState {

	/**
	 * Compares the current X to the target X and moves the drone in the
	 * appropriate direction.
	 * @throws Exception 
	 * 
	 */
	@Override
	public void adjustAction(AutoPilot autopilot) 
	{
		/** check if too far right **/
		if (autopilot.location.getX() > autopilot.xTarget + AutoPilot.ERROR)
		{
			//move left
			System.out.println("adjust left");
			autopilot.commandManager.left(AutoPilot.ADJUST_INTERVAL);
			
		}
		/** check if too far left **/
		if (autopilot.location.getX() < autopilot.xTarget - AutoPilot.ERROR)
		{
			//move right
			System.out.println("adjust right");
			autopilot.commandManager.right(AutoPilot.ADJUST_INTERVAL);
		}
		autopilot.setState(autopilot.defaultState);
		autopilot.state.adjustAction(autopilot);
	}
	
	/**
	 * get the string label belonging to the state
	 * @return "adjusting X position"
	 */
	@Override
	public String toString()
	{
		return "adjusting X position";
	}
}
