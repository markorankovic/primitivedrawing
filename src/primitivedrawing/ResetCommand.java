package primitivedrawing;

public class ResetCommand extends DrawCommand {

	public ResetCommand(CommandProcessor processor) {
		super(processor);
	}

	@Override
	public void execution() {
		DrawingContext dc = ((DrawingCommandProcessor) processor).dc;
		if (dc == null) {
			System.out.println("No drawing context");
			return;
		}
		try {
			dc.reset();
		} catch (Exception e) {
			System.out.println("Invalid argument(s)");
			return;
		}
	}
	
}
