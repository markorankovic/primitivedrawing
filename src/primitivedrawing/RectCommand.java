package primitivedrawing;

public class RectCommand extends DrawCommand {

	public RectCommand(CommandProcessor processor) {
		super(processor);
	}
	
	@Override
	public void execution() {
		if (!validNumberOfArguments(2)) {
			return;
		}
		DrawingContext dc = ((DrawingCommandProcessor) processor).dc;
		if (dc == null) {
			System.out.println("No drawing context");
			return;
		}
		try {
			dc.drawRect(Integer.parseInt(arguments.get(0)), Integer.parseInt(arguments.get(1)));
		} catch (Exception e) {
			System.out.println("Invalid argument(s)");
			return;
		}
	}
		
}
