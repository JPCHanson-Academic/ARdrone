package Drone.DroneController.AutoPilot;
/**
 * This is the default state for the autopilot to go to, it decided which state 
 * needs to be transitioned too in order to complete the task.
 * @author orpheus
 *
 */
public class ThinkingState implements AutoPilotState 
{
	/** accuracy(Error) of adjustments **/
	private static final float accuracy = AutoPilot.ERROR;
	
	/**
	 * chose an appropriate state to transition too by comparing the target X,Y,Z
	 * coordinates to the drones current X,Y,Z, coordinates.
	 * @throws Exception 
	 */
	@Override
	public void adjustAction(AutoPilot autopilot)
	{
		/**
		 * check to see if the drones X-location is (within error bounds) matches
		 * the target X-location
		 */
		if (autopilot.location.getX() >= (autopilot.xTarget+accuracy) ||
			autopilot.location.getX() <= (autopilot.xTarget-accuracy))
		{
			autopilot.setState(new AdjustXState());
			System.out.println("adjust x");
			autopilot.state.adjustAction(autopilot);
		}
		/**
		 * check to see if the drones Y-location is (within error bounds) matches
		 * the target Y-location
		 */
		else if (autopilot.location.getY() >= (autopilot.yTarget+accuracy) ||
				autopilot.location.getY() <= (autopilot.yTarget-accuracy))
		{
			autopilot.setState(new AdjustYState());
			System.out.println("adjust y");
			autopilot.state.adjustAction(autopilot);
		}
		/**
		 * check to see if the drones Z-location is (within error bounds) matches
		 * the target Z-location
		 */
		else if (autopilot.location.getZ() >= (autopilot.zTarget+accuracy) ||
				autopilot.location.getZ() <= (autopilot.zTarget-accuracy))
		{
			autopilot.setState(new AdjustZState());
			System.out.println("adjust z");
			autopilot.state.adjustAction(autopilot);
		}
		
		else
		{
			System.out.println("Target Reached");
		}
	}
	
	/**
	 * return a string label with the state
	 * @return "Thinking...."
	 */
	@Override
	public String toString()
	{
		return "Thinking.....";
	}

}
