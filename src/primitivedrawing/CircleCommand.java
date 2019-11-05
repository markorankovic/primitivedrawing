package primitivedrawing;

public class CircleCommand extends DrawCommand {

	public CircleCommand(CommandProcessor processor) {
		super(processor);
		numberOfArguments = 1;
	}
	
	@Override
	public void execution() {
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
	
	@Override
	boolean validArgumentTypes() {
		try {
			Integer.parseInt(arguments.get(0));
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	boolean argumentsValid() {
		return validNumberOfArguments() && validArgumentTypes();
	}
	
}
