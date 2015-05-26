package Drone.DroneCommands;
/**
 * The Command Interface, this is implemented to produce concrete commands.
 * @author orpheus
 *
 */
public interface ATCommand 
{
	/**
	 * Executes the appropriate code on the ATReciever. The sequence parameter is
	 * so that the invoker can keep track of the command sequence and pass it to 
	 * individual <ATCommand>'s, as they will need it to create thier respective
	 * commands.
	 * @param sequence
	 */
	public void execute(int sequence) throws Exception;
}
