package Drone.DroneController.AutoPilot;
/**
 * The autopilot state in which the drone knows its Z coordinate is incorrect.
 * @author orpheus
 *
 */
public class AdjustZState implements AutoPilotState {

	/**
	 * Compares the current Z to the target Z and moves the drone in the
	 * appropriate direction.
	 * @throws Exception 
	 * 
	 */
	@Override
	public void adjustAction(AutoPilot autopilot)
	{
		/** check if too far up **/
		if (autopilot.location.getZ() > autopilot.zTarget + AutoPilot.ERROR)
		{
			//move down
			autopilot.commandManager.down(AutoPilot.ADJUST_INTERVAL);
		}
		/** check if too far down **/
		if (autopilot.location.getZ() < autopilot.zTarget - AutoPilot.ERROR)
		{
			//move up
			autopilot.commandManager.up(AutoPilot.ADJUST_INTERVAL);
		}
		autopilot.setState(autopilot.defaultState);
		autopilot.state.adjustAction(autopilot);
	}
	
	/**
	 * get the string label belonging to the state
	 * @return "adjusting Z position"
	 */
	@Override
	public String toString()
	{
		return "adjusting Z position";
	}
}