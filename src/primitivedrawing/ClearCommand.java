package primitivedrawing;

public class ClearCommand extends DrawCommand {

	public ClearCommand(CommandProcessor processor) {
		super(processor);
	}

	@Override
	public void execution() {
		if (!validNumberOfArguments(0)) {
			return;
		}
		DrawingContext dc = ((DrawingCommandProcessor) processor).dc;
		if (dc == null) {
			System.out.println("No drawing context");
			return;
		}
		try {
			dc.clear();
		} catch (Exception e) {
			System.out.println("Invalid argument(s)");
			return;
		}
	}
	
}
