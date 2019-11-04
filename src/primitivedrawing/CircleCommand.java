package primitivedrawing;

public class CircleCommand extends DrawCommand {

	public CircleCommand(CommandProcessor processor) {
		super(processor);
	}
	
	@Override
	public void execution() {
		if (!validNumberOfArguments(1)) {
			return;
		}
		DrawingContext dc = ((DrawingCommandProcessor) processor).dc;
		if (dc == null) {
			System.out.println("No drawing context");
			return;
		}
		try {
			dc.drawCircle(Integer.parseInt(arguments.get(0)));
		} catch (Exception e) {
			System.out.println("Invalid argument(s)");
			return;
		}
	}
	
}
