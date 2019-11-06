package primitivedrawing.Commands;

import primitivedrawing.CommandProcessor;

// Command identified by the processor for executing the other Commands
public class RunCommand extends Command {

	public RunCommand(CommandProcessor processor) {
		super(processor);
		this.commandAsString = "run";
	}

}
