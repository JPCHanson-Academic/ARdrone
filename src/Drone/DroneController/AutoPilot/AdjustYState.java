package Drone.DroneController.AutoPilot;
/**
 * The autopilot state in which the drone knows its Y coordinate is incorrect.
 * @author orpheus
 *
 */
public class AdjustYState implements AutoPilotState {

	/**
	 * Compares the current Y to the target Y and moves the drone in the
	 * appropriate direction.
	 * @throws Exception 
	 * 
	 */
	@Override
	public void adjustAction(AutoPilot autopilot)
	{
		/** check if too far forward 
		 * the if comparisons are switched around as the drone uses negative
		 * values for forward motion as the nose goes down.
		 */
		if (autopilot.location.getY() < autopilot.yTarget - AutoPilot.ERROR)
		{
			//move back
			autopilot.commandManager.backward(AutoPilot.ADJUST_INTERVAL);
		}
		/** check if too far back **/
		if (autopilot.location.getY() > autopilot.yTarget + AutoPilot.ERROR)
		{
			//move forward
			autopilot.commandManager.forward(AutoPilot.ADJUST_INTERVAL);
		}
		autopilot.setState(autopilot.defaultState);
		autopilot.state.adjustAction(autopilot);
	}
	
	/**
	 * get the string label belonging to the state
	 * @return "adjusting Y position"
	 */
	@Override
	public String toString()
	{
		return "adjusting Y position";
	}
}