package primitivedrawing;

public class DrawToCommand extends DrawCommand {

	public DrawToCommand(CommandProcessor processor) {
		super(processor);
		numberOfArguments = 2;
	}

	@Override
	public void execution() {
		DrawingContext dc = ((DrawingCommandProcessor) processor).dc;
		if (dc == null) {
			System.out.println("No drawing context");
			return;
		}
		try {
			dc.drawTo(Integer.parseInt(arguments.get(0)), Integer.parseInt(arguments.get(1)));
		} catch (Exception e) {
			System.out.println("Invalid argument(s)");
			return;
		}
	}
	
	@Override
	boolean argumentsValid() {
		return validNumberOfArguments() && validArgumentTypes();
	}
	
	@Override
	boolean validArgumentTypes() {
		try {
			Integer.parseInt(arguments.get(0));
			Integer.parseInt(arguments.get(1));
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
