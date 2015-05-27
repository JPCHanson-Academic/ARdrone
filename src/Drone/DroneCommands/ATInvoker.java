package Drone.DroneCommands;

/**
 * This class is the invoker in a GOF Command patter, it holds a reference to a 
 * command passedto it as a method argument, and provides the functionality to 
 * execute the stored command. This particular implementation also keeps track of 
 * the Sequence number of the commands being given, so as to aid in their construction.
 * 
 * @author orpheus
 *
 */
public class ATInvoker
{
	/** reference to a concrete command **/
	private ATCommand command;
	/** the number of commands in the sequence **/
	private int sequenceNum;
	
	
	/**
	 * Default CTOR, initialise stuff
	 */
	public ATInvoker()
	{
		sequenceNum=1;
	}
	
	/**
	 * store a concrete command in the local <ATCommand> reference
	 * @param cmmnd the concrete command to be stored
	 */
	public void setCommand(ATCommand cmmnd)
	{
		command = cmmnd;
	}
	
	/**
	 * executes the concrete <ATCommand> currently stored in the local reference.
	 * @param sequence
	 * @throws Exception 
	 */
	public void execute()
	{
		try 
		{
			command.execute(sequenceNum);
		} 
		catch (Exception e) 
		{
			System.out.println("--AT_Command execute() error--");
		}
		++sequenceNum;
	}
}
